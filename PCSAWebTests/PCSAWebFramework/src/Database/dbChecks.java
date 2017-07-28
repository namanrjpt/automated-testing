/*
 * @author Anjali
 * @since 2016-06-28
 * This class runs various SQL queries for database checks.
 */
package Database;

import Logs.log4j;

import java.sql.ResultSet;
import java.sql.SQLException;

public class dbChecks 
{
	static ResultSet rs = null;
	private static String tableName;
	private static String SQLquery;
	/*
	 * @param email and password for querying the DB
	 */
	public static boolean isLoginDataPresent(String email)
	{
		//Table name for login users
		tableName = "users";
		
		//query for getting username for passed email and password
		SQLquery = "SELECT username FROM "+tableName+ " WHERE email= '"+email+ "'";
		System.out.println("the query is- "+SQLquery);
		try 
		{
			System.out.println("inside query");
			rs=connectToDB.stmt.executeQuery(SQLquery);
			
			//if username is the return true
			if((rs!=null)&& rs.next())
			{
				System.out.println("inside result set");
				System.out.println("data- "+rs.getString(1).toString());
				return true;
			}
			
			//username not present
			else
				return false;
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}

		return false;

	}


	public static boolean isComradeDataPresent(String exampleNumber)
	{
		SQLquery = "SELECT EXISTS(SELECT comrade_details FROM comrades WHERE comrade_details='"+exampleNumber+"')";
		System.out.println("the query is- "+SQLquery);
		try
		{
			System.out.println("inside query");
			rs=connectToDB.stmt.executeQuery(SQLquery);
			//if number is the return true
			if((rs!=null) && rs.next())
			{
				System.out.println("inside result set");
				System.out.println("data- " + rs.getString(1).toString());
				return true;
			}

			//number not present
			else
				return false;
		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}

		return false;
	}


}
