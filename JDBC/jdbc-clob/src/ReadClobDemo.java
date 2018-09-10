import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadClobDemo {
	public static void main(String[] args) throws SQLException, IOException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		Reader input = null;
		FileWriter output = null;
		try {
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "student", "student");
			myStmt = myConn.createStatement();
			String sql = "select resume from employees where email='mary.public@foo.com'";
			myRs = myStmt.executeQuery(sql);
			File theFile = new File("resume_from_db.txt");
			output = new FileWriter(theFile);
			while (myRs.next()) {
				input = myRs.getCharacterStream("resume");
				System.out.println("Reading resume from database...");
				System.out.println(sql);
				int theChar;
				while ((theChar = input.read()) > 0) {
					output.write(theChar);
				}
				System.out.println("\nSaved to file: "
						+ theFile.getAbsolutePath());
				System.out.println("\nCompleted successfully!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}

			if (output != null) {
				output.close();
			}

			close(myConn, myStmt);
		}
	}

	private static void close(Connection myConn, Statement myStmt)
			throws SQLException {

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
}
