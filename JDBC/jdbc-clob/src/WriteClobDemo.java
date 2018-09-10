import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteClobDemo {
	public static void main(String[] args) throws SQLException, IOException {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		FileReader input = null;

		try {
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "student", "student");
			String sql = "update employees set resume = ? where email='mary.public@foo.com'";
			myStmt = myConn.prepareStatement(sql);
			File theFile = new File("sample_resume.txt");
			input = new FileReader(theFile);
			myStmt.setCharacterStream(1, input);
			System.out.println("Reading input file: "
					+ theFile.getAbsolutePath());
			System.out.println("\nStoring resume in database: " + theFile);
			System.out.println(sql);
			myStmt.executeUpdate();
			System.out.println("\nCompleted successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
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
