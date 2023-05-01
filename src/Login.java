import java.io.IOException;
import java.sql.*;

public class Login 
{
	private String username;
	private String password;
	private Output output;
	private Input input;
	private DMS dms;
	private int A;
	
//	public Login(String username, String password) {
//		this.username = username;
//		this.password = password;
//		output = new Output();
//		input = new Input();
//		dms = new DMS();
//		A = 0;
//	}
	public Login() throws SQLException
	{
		output = new Output();
		input = new Input();
		dms = new DMS();
		A = 0;
	}
	
	public int front_page(String U) throws IOException
	{
		char ask = U.charAt(0);
		int X = 0;
		
		if(ask == 'P')
		{
			//Patient
			X = 1;
		}
		else if(ask == 'D')
		{
			//Doctor
			X = 2;
		}
		else if(ask == 'L')
		{
			//Lab Assistant
			X = 3;
		}
		else if(ask == 'H')
		{
			//Pharmacist
			X = 4;
		}
		else if(ask == 'N')
		{
			//Nurse
			X = 5;
		}
		else if(ask == 'R')
		{
			//Admin OR Receptionist
			X = 6;
		}
		return X;
	}
	
	public int Authorization(String U_T, String P_T) 
	{
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb"; //Connecting to Database
		
		try {
			Connection C = DriverManager.getConnection(dbURL);
			String sql = "select * from Login";
			
			Statement S = C.createStatement();
			
			ResultSet result = S.executeQuery(sql);
			
			boolean check = false;
			
			while (result.next()){
				
			    String user = result.getString("username");
			    String pass = result.getString("password");

			    if (U_T.equals(user)&& P_T.equals(pass)) 
			    {
			    	
			    	check = true;
			    	A = 1;

			    }
			}
				
			  	if (check == false) 
			   {
			  	A = 0;
				C.close();				
			   } 
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return A;
		
	}


}