package Connect;
import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
	static Connection connection;
	
	public static Connection createConnection(){
		try{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/terrace_gardens", "root", "12345");
		System.out.println("finished");
		}catch (Exception e){
			System.out.println("error while connecting to DB: " + e);
		}
		return connection;
	}
	
	public static void closeConnection(){
		try{
			connection.close();
		}catch(Exception e){
			System.out.println("Error in DB connection" + e);
		}
	}
	
}
