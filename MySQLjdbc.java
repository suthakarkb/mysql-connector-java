import java.sql.*;    
public class MySQLjdbc
{  
  final static String DB_URL = "jdbc:mysql://localhost:3306/project";  
  //final static String DB_DRIVER = "com.mysql.jdbc.Driver"; 
  final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
  static String uName = "root";  
  static String psd = "root1234";   

  public static void main(String args[])  {   
	Connection conn = null;
	String query = null; 
	Statement stmt = null; 
	ResultSet resultSet = null; 
	try  {   

		Class.forName(DB_DRIVER);    
		conn = DriverManager.getConnection(DB_URL, uName, psd);  
		System.out.println("Database connection established "+conn);  
		query = "select * from users";  
		System.out.println("query  "+query);  
		stmt = conn.createStatement();    
		System.out.println("stmt   "+stmt); 
		resultSet = stmt.executeQuery(query); 
		System.out.println("resultSet   "+resultSet);   
		while(resultSet.next() )    
			{  

				int id  = resultSet.getInt("id");  
				String firstName = resultSet.getString("first_name"); 
				String lastName = resultSet.getString("second_name"); 
				String email = resultSet.getString("email_id"); 

				// printing the values  
				System.out.print("  ID: " + id);  
				System.out.print(", Name: " + firstName+" "+lastName);  
				System.out.print(", email: " + email);  
				System.out.println("");
			}  
		}  
	catch(SQLException sqlExp)   {   
			sqlExp.printStackTrace();  }  
	catch(Exception e)  {  
			e.printStackTrace();   }  
	finally   {  
		try   {  
			resultSet.close();  
			stmt.close();  
			conn.close();  
			System.out.println("The Connection is closed.");   }  
		catch(SQLException sqlExp)   {  
			sqlExp.printStackTrace();   }  
		}  
	}  
}