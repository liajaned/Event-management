package in.co.online.Utility;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {

	private static JDBCDataSource jds = null;

	private JDBCDataSource() {

	}

	private static ComboPooledDataSource cpds = null;

	public static JDBCDataSource getInstance() {
		if (jds == null) {
			ResourceBundle rb = ResourceBundle.getBundle("system");
			jds = new JDBCDataSource();
			jds.cpds = new ComboPooledDataSource();

			try {
				jds.cpds.setDriverClass(rb.getString("driver"));
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			jds.cpds.setJdbcUrl(rb.getString("url"));
			jds.cpds.setUser(rb.getString("username"));
			jds.cpds.setPassword(rb.getString("password"));
			jds.cpds.setInitialPoolSize(new Integer((String) rb.getString("initialPoolSize")));
			jds.cpds.setAcquireIncrement(new Integer((String) rb.getString("acquireIncrement")));
			jds.cpds.setMaxPoolSize(new Integer((String) rb.getString("maxPoolSize")));
			jds.cpds.setMaxIdleTime(new Integer((String) rb.getString("timeout")));
			jds.cpds.setMinPoolSize(new Integer((String) rb.getString("minPoolSize")));

		}
		return jds;
	}

	public static Connection getconnection() throws Exception {
		return getInstance().cpds.getConnection();
	}

	public static void closeconnection(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
		}
	}

	public static void trnRollback(Connection conn) throws Exception {
		if (conn != null) {
			conn.rollback();
		}
	}
}
