import java.sql.*;
public class Pharmacist extends Person {
	//private Person P;
	protected String username;
	private Input input;
	private Output output;
	private DMS dms;
	private int M_Cost;
	
	public Pharmacist()
	{
		input = new Input();
		output = new Output();
		dms = new DMS();
		//Front Page Details Related to Pharmacist
	}
	public Pharmacist(String username, String password) {
		
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
			    

			    if (user.charAt(0) == 'H')
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
	public void registerH(Pharmacist obj, String n, String CNIC, int a, String g)
	{
		obj.Name = n;
		obj.cnic = CNIC;
		obj.age = a;
		obj.gender = g;
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		 
		try {
			Connection C = DriverManager.getConnection(dbURL);
			output.displayMsg("Connected to Database!");
			
			String sql = "INSERT INTO Pharmacist (Username, Name, CNIC, Age, Gender) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement s = C.prepareStatement(sql);
			
			dms.insertPharmacistRow(obj, sql, s);
			
			
				C.close();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
