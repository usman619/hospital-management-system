import java.io.IOException;
import java.sql.*;
public class Lab_Assistant extends Person{
	//private Person P;
	protected String username;
	private Input input;
	private Output output;
	private DMS dms;
	
	public Lab_Assistant()
	{
		input = new Input();
		output = new Output();
		dms = new DMS();
		//Front Page Details Related to Lab Assistant
	}
	
	public Lab_Assistant(String username, String password) {
		
		this.username = username;
		
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
				
			    String user = result.getString("username");
			    String pass = result.getString("password");
			    

			    if (user.charAt(0) == 'L')
			    {
			    	if (username.equals(user)&& password.equals(pass)) {
				    	
				    	output.displayMsg("Login Successful!");
				    	
				    	check = true;
				    	
				    	break;
				    }
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
	public void registerL(Lab_Assistant obj, String n, String CNIC, int a, String g)
			{
				obj.Name = n;
				obj.cnic = CNIC;
				obj.age = a;
				obj.gender = g;
				
				String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
				 
				try {
					Connection C = DriverManager.getConnection(dbURL);
					output.displayMsg("Connected to Database!");
					
					String sql = "INSERT INTO LabAssistant (Username, Name, CNIC, Age, Gender) VALUES (?, ?, ?, ?, ?)";
					
					PreparedStatement s = C.prepareStatement(sql);
					
					dms.insertLabAssistantRow(obj, sql, s);
					
					
						C.close();
					} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

}
