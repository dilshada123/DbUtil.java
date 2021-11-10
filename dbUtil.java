
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtil {
	private static Connection dbConnection = null;

	public static Connection getConnection() {
		if (dbConnection != null) {
			return dbConnection;
		} else {
			try {
				InputStream inputStream = DbUtil.class.getClassLoader()
						.getResourceAsStream("db.properties");
				Properties properties = new Properties();
				if (properties != null) {
					properties.load(inputStream);

					String dbDriver = properties.getProperty("dbDriver");
					String connectionUrl = properties
							.getProperty("connectionUrl");
					String first_name = properties.getProperty("userName");
					String last_name = properties.getProperty("userName");
					String date_of_birth = properties.getProperty("password");
          String email_ID = properties.getProperty("password");
          String contact_number = properties.getProperty("password");

					Class.forName(dbDriver).newInstance();
					dbConnection = DriverManager.getConnection(connectionUrl,
							userName, password);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbConnection;
		}
	}
}
