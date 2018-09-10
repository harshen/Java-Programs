import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertDemo {
	public static void main(String[] args) throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";

		try {
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			myStmt = myConn.createStatement();
			System.out.println("Inserting a new employee to database\n");
			int rowsAffected = myStmt
					.executeUpdate("insert into employees "
							+ "(last_name, first_name, email, department, salary) "
							+ "values ('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)");

			myRs = myStmt
					.executeQuery("select * from employees order by last_name");
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", "
						+ myRs.getString("first_name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	}
}
