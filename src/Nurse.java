import java.sql.*;

public class Nurse extends Person{
//	private Person P;
	protected String username;
	protected String Availability;
	private Input input;
	private Output output;
	private DMS dms;
	private int fees;
	
	public Nurse()
	{
		input = new Input();
		output = new Output();
		dms = new DMS();
		//Front Page details related to Nurse
	}
	
	public Nurse(String username, String password) {
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
			    

			    if (user.charAt(0) == 'N')
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
	
	public void registerN(Nurse obj,  String n, String CNIC, int a, String g)
	{
		obj.Name = n;
		obj.cnic = CNIC;
		obj.age = a;
		obj.gender = g;
		
		obj.Availability = "YES";
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		 
		try {
			Connection C = DriverManager.getConnection(dbURL);
			output.displayMsg("Connected to Database!");
			
			String sql = "INSERT INTO Nurse (Username, Name, CNIC, Age, Gender, Availability) VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement s = C.prepareStatement(sql);
			
			dms.insertNurseRow(obj, sql, s);
			
			
				C.close();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}