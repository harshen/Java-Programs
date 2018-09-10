import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class GetCountForDepartment {
	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "student", "student");

			String theDepartment = "Engineering";
			myStmt = myConn
					.prepareCall("{call get_count_for_department(?, ?)}");
			myStmt.setString(1, theDepartment);
			myStmt.registerOutParameter(2, Types.INTEGER);
			System.out
					.println("Calling stored procedure.  get_count_for_department('"
							+ theDepartment + "', ?)");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			int theCount = myStmt.getInt(2);
			System.out.println("\nThe count = " + theCount);
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
