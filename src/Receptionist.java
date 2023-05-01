import java.sql.*;

public class Receptionist {
	protected String username;
	protected String password;
	
	private Input input;
	private Output output;
	private DMS dms;
	public int TotalAmount;
	
	public Receptionist()
	{
		output = new Output();
		input = new Input();
		dms = new DMS();
	}
	public Receptionist(String user, String pass) {
		
		username = user;
		password = pass;
		
		output = new Output();
		input = new Input();
		dms = new DMS();
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb"; //Connecting to Database
		
		try {
			Connection C = DriverManager.getConnection(dbURL);
			output.displayMsg("Connected to Database!");
			
			String sql = "select * from Login";
			
			Statement S = C.createStatement();
			
			ResultSet result = S.executeQuery(sql);
			
			boolean check = false;
			
			while (result.next()){
				
			    user = result.getString("username");
			    pass = result.getString("password");
			    

			    
			    if (username.equals(user)&& password.equals(pass)) {
				    	
				    output.displayMsg("Login Successful!");
				    	
				    check = true;
				    	
			    	break;
			    }
			    
			}
			
				if(check == false)
					output.displayMsg("Incorrect username or password!");
				
				C.close();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
