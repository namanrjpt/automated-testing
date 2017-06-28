/*
 * @author Anjali
 * @since 2016-06-28
 * This class maintains all the constants required to start a DB connection.
 */
package PageObjectModel;

public class databaseConstants
{
	//JDBC Driver
	public static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
	//DB username
	public static String dbUsername = "root";
	
	//DB password
	public static String dbPassword = "";
	
	//DB connection URL eg="jdbc:msql://ip:post_no/DBname"
	public static String connectionURL="jdbc:mysql://localhost:3306/firstaide";
	
}
