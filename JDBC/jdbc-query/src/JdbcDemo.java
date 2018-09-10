import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
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
			myRs = myStmt.executeQuery("select * from employees");
			while (myRs.next()) {
				// System.out.println(myRs.getString(2) + ", " +
				// myRs.getString(3));
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
