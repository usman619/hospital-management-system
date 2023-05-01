import java.io.IOException;
import java.sql.*;

public class Patient extends Person{
	
	
	protected String username;
	protected int appID;
	protected String prescription;
	protected String problem;
	protected String diagnosis;
	protected int Medcost;
	protected int InvoiceTotal;
	protected String labReport;
	protected String medicineGuideline;
	protected String testResult;
	
	private Output output;
	private Input input;
	private DMS dms;
	
	public Patient() 
	{
		output = new Output();
		input = new Input();
		dms = new DMS();
		//Front Page Details Related to patient
	}
	
	public Patient(String username, String password) {
		
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
			    

			    if (user.charAt(0) == 'P')
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
	
	public void registerP(Patient obj, String n, String CNIC, int a, String g)
	{
		obj.Name = n;
		obj.cnic = CNIC;
		obj.age = a;
		obj.gender = g;
		
		obj.appID = 0;
		obj.prescription = "-";
		obj.problem = "-";
		obj.diagnosis = "-";
		obj.testResult = "-";
		obj.Medcost = 0;
		obj.InvoiceTotal = 0;
		obj.labReport = "-";
		obj.medicineGuideline = "-";
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		 
		try {
			Connection C = DriverManager.getConnection(dbURL);
			output.displayMsg("Connected to Database!");
			
			String sql = "INSERT INTO Patient (Username, Name, CNIC, Age, Gender, Problem , Diagnosis,Prescription, MedCost, InvoiceTotal, LabReport, Medicine_Guideline) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement s = C.prepareStatement(sql);
			
			dms.insertPatientRow(obj, sql, s);
			
			
				C.close();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

