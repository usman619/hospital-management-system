import java.io.IOException;
import java.sql.*;
import javax.swing.*;
public class Doctor extends Person{
	//protected Person P;
	public String username;
	public String n;
	protected String Specialist;
	protected String Availability;
	private Input input;
	private Output output;
	private DMS dms;
	private int fees;
	
	public Doctor()
	{
		input = new Input();
		output = new Output();
		dms = new DMS();
		//Front Page details related to Doctor
	}
	public Doctor(String username, String password) {
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
			    

			    if (user.charAt(0) == 'D')
			    {
			    	if (username.equals(user)&& password.equals(pass)) {
				    	
			    		output.displayMsg("Login Successful!");
			    		//JOptionPane.showMessageDialog(null, "Login Successfull");
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
	public void registerD(Doctor obj, String n, String CNIC, int a, String g, String sp)
	{
		obj.Name = n;
		obj.cnic = CNIC;
		obj.age = a;
		obj.gender = g;
		obj.Specialist = sp;
		obj.Availability = "YES";

		
		//-------------------------INSERT RECORD TO DATABASE HERE-------------------------
		DMS d = new DMS();
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		 
		try {
			Connection C = DriverManager.getConnection(dbURL);
			output.displayMsg("Connected to Database!");
			
			String sql = "INSERT INTO Doctor (Username, Name, CNIC, Age, Gender, Specialist, Availability) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement s = C.prepareStatement(sql);
			
			d.insertDoctorRow(obj, sql, s);
			
			
				C.close();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}