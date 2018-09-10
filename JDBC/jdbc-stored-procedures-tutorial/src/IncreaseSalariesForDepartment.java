import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IncreaseSalariesForDepartment {
	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		CallableStatement myStmt = null;
		try {
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "student", "student");
			String theDepartment = "Engineering";
			int theIncreaseAmount = 10000;
			System.out.println("Salaries BEFORE\n");
			showSalaries(myConn, theDepartment);
			myStmt = myConn
					.prepareCall("{call increase_salaries_for_department(?, ?)}");
			myStmt.setString(1, theDepartment);
			myStmt.setDouble(2, theIncreaseAmount);
			System.out
					.println("\n\nCalling stored procedure.  increase_salaries_for_department('"
							+ theDepartment + "', " + theIncreaseAmount + ")");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			System.out.println("\n\nSalaries AFTER\n");
			showSalaries(myConn, theDepartment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, null);
		}

	}

	private static void showSalaries(Connection myConn, String theDepartment)
			throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			myStmt = myConn
					.prepareStatement("select * from employees where department = ?");
			myStmt.setString(1, theDepartment);
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName,
						department, salary);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}
	}

	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		close(null, myStmt, myRs);
	}
}
