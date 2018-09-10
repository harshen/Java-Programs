import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class GreetTheDepartment {
	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		CallableStatement myStmt = null;
		try {
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "student", "student");

			String theDepartment = "Engineering";
			myStmt = myConn.prepareCall("{call greet_the_department(?)}");
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, theDepartment);
			System.out
					.println("Calling stored procedure.  greet_the_department('"
							+ theDepartment + "')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			String theResult = myStmt.getString(1);
			System.out.println("\nThe result = " + theResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
