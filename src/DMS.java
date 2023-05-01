import java.sql.*;

public class DMS {
	private Output output;
	
	public DMS() 
	{
		output = new Output();
	}
	//**************************************** Printing Functions ****************************************
	//Used in R_Profile to print all the database
	public void printPatient(String sql, Statement s) {
		
		ResultSet result;
		try {
			result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    String name = result.getString("Name");
			    String cnic = result.getString("CNIC");
			    String gender = result.getString("Gender");
			    int age = result.getInt("Age");
			    String prob = result.getString("Problem");
			    String diag = result.getString("Diagnosis");
			    String prescrip = result.getString("Prescription");
			    int medCost = result.getInt("MedCost");
			    int invCost = result.getInt("InvoiceTotal");
			    String labReport = result.getString("LabReport");
			    String medG = result.getString("Medicine_Guideline");
			    
			    String form = "Username: %s \n Name: %s \n CNIC: %s \n Age: %d \n Gender: %s \n Problem: %s \n Diagnosis: %s \n Prescription: %s \n MedCost %d \n Invoice Total: %d \n Lab Report: %s \n Medicine Guideline: %s";
			    
			    output.Output_GUI(String.format(form, user, name, cnic, age, gender, prob, diag, prescrip, medCost, invCost, labReport, medG));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void printDoctor(String sql, Statement s) {
			
			ResultSet result;
			try {
				result = s.executeQuery(sql);
				while (result.next()){
					
				    String user = result.getString("Username");
				    String name = result.getString("Name");
				    String cnic = result.getString("CNIC");
				    String gender = result.getString("Gender");
				    int age = result.getInt("Age");
				    String special = result.getString("Specialist");
				    String available = result.getString("Availability");
				    
				    String form = "Username:%s \n Name: %s \n CNIC: %s \n Gender: %s \n Age: %d \n Specialist: %s \n Availability: %s";
				    
				    output.Output_GUI(String.format(form, user, name, cnic , gender , age, special, available));
				    
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	public void printNurse(String sql, Statement s) {
		
		ResultSet result;
		try {
			result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    String name = result.getString("Name");
			    String cnic = result.getString("CNIC");
			    String gender = result.getString("Gender");
			    int age = result.getInt("Age");
			    
			    
			    
			    String form = "Username:%s \n Name: %s \n CNIC: %s \n Gender: %s \n Age: %d ";
			    
			    output.Output_GUI(String.format(form, user, name, cnic , gender, age));
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void printLabAssistant(String sql, Statement s) {
		
		ResultSet result;
		try {
			result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    String name = result.getString("Name");
			    String cnic = result.getString("CNIC");
			    String gender = result.getString("Gender");
			    int age = result.getInt("Age");
			    
			    
			    String form = "Username:%s \n Name: %s \n CNIC: %s \n Gender: %s \n Age: %d ";
			    
			    output.Output_GUI(String.format(form, user, name, cnic , gender, age));
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void printPharmacist(String sql, Statement s) {
		
		ResultSet result;
		try {
			result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    String name = result.getString("Name");
			    String cnic = result.getString("CNIC");
			    String gender = result.getString("Gender");
			    int age = result.getInt("Age");
			    
			    
			    String form = "Username:%s \n Name: %s \n CNIC: %s \n Gender: %s \n Age: %d ";
			    
			    output.Output_GUI(String.format(form, user, name, cnic , gender, age));
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//**************************************** Inserting Functions ****************************************
	//Used in the respective usecase for insertion of a new record
	public void insertPatientRow(Patient p, String sql,PreparedStatement s) throws SQLException{

			s.setString(1, p.username);
			s.setString(2, p.Name);
			s.setString(3, p.cnic);
			s.setInt(4, p.age);
			s.setString(5, p.gender);
			s.setString(6, p.problem);
			s.setString(7, p.diagnosis);
			s.setString(8, p.prescription);
			s.setInt(9, p.Medcost);
			s.setInt(10, p.InvoiceTotal);
			s.setString(11, p.labReport);
			s.setString(12, p.medicineGuideline);
			 
			int rows = s.executeUpdate();
			
			if (rows > 0) {
			    output.displayMsg("Inserted Successfully!");
			}
		
		
	}
	
	public void insertDoctorRow(Doctor d, String sql,PreparedStatement s) throws SQLException {
		
		s.setString(1, d.username);
		s.setString(2, d.Name);
		s.setString(3, d.cnic);
		s.setInt(4, d.age);
		s.setString(5, d.gender);
		s.setString(6, d.Specialist);
		s.setString(7,d.Availability);
		
		int rows = s.executeUpdate();
		
		if (rows > 0) {
		    output.displayMsg("Inserted Successfully!");
		}
		
	}
	
	public void insertPharmacistRow(Pharmacist p, String sql,PreparedStatement s) throws SQLException {
		
		s.setString(1, p.username);
		s.setString(2, p.Name);
		s.setString(3, p.cnic);
		s.setInt(4, p.age);
		s.setString(5, p.gender);
		
		 
		int rows = s.executeUpdate();
		
		if (rows > 0) {
		    output.displayMsg("Inserted Successfully!");
		}
		
	}
	
	public void insertLabAssistantRow(Lab_Assistant L, String sql,PreparedStatement s) throws SQLException {
		
		s.setString(1, L.username);
		s.setString(2, L.Name);
		s.setString(3, L.cnic);
		s.setInt(4, L.age);
		s.setString(5, L.gender);
		
		 
		int rows = s.executeUpdate();
		
		if (rows > 0) {
		    output.displayMsg("Inserted Successfully!");
		}
		
	}

	public void insertNurseRow(Nurse N, String sql,PreparedStatement s) throws SQLException {
		
		s.setString(1, N.username);
		s.setString(2, N.Name);
		s.setString(3, N.cnic);
		s.setInt(4, N.age);
		s.setString(5, N.gender);
		s.setString(6,N.Availability);
		 
		int rows = s.executeUpdate();
		
		if (rows > 0) {
		    output.displayMsg("Inserted Successfully!");
		}
		
	}

	public void insertUserPass(String user, String pass) throws SQLException {
		
		String dbURL = "jdbc:ucanaccess://HMS_DB.accdb";
		 
		try {
			Connection C = DriverManager.getConnection(dbURL);
			output.displayMsg("Connected to Database!");
			
			String sql = "INSERT INTO Login (username, password) VALUES (?, ?)";
			
			PreparedStatement s = C.prepareStatement(sql);
			
			s.setString(1, user);
			s.setString(2, pass);
			
			int rows = s.executeUpdate();
			
			if (rows > 0)
				output.displayMsg("Inserted Successfully!");
			
				C.close();
			} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkAvailableDoctor(String specialist, String sql, Statement s) //check on the bases of Doctor's Specialist Field
		{
			int A = 0;
			try {
				ResultSet result = s.executeQuery(sql);
				while (result.next()){
//					String user = result.getString("Username");
				    String special = result.getString("Specialist");
				    String available = result.getString("Availability");
				    if (specialist.equals(special) && available.equals("YES"))
				    {
					    String name = result.getString("Name");
					    String gender = result.getString("Gender");
					    int age = result.getInt("Age");
					    
					    String form = "Name: %s \n Age: %d \n Gender: %s \n Specialist: %s \n Availability: %s";
					    
					    output.Output_GUI(String.format(form , name,  age, gender, special, available));
					    A = 1;
				    }
				    
				}
				if(A == 0)
				{
					output.Output_GUI("No Doctor found of the given specialization at this time, Please try again later.");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	
	public boolean checkAvail(String name, Statement s) //Used here in bookAppointment Function
	{
			String sql = "SELECT * FROM Doctor";
			
			try {
				ResultSet result = s.executeQuery(sql);
				while (result.next())
				{		
					String n = result.getString("Name");
					String avail = result.getString("Availability");
				    if (name.equals(n) && avail.equals("YES"))
				    {
					    return true;
					    
				    }
				    
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
	public void bookAppointment(String name, String sql, Connection C) throws SQLException //Used in P_Profile to book Appointments
	{
			
			Statement s1 = C.createStatement();
			Statement s2;
			
			if (checkAvail(name,s1) == true) {
				
				
				String sql2 = "UPDATE Doctor SET Availability ='NO' WHERE Name LIKE '"+name+"'";
				ResultSet result = s1.executeQuery(sql);
			
			    while(result.next()) {
			        s2 = C.createStatement();
			        int rows = s2.executeUpdate(sql2);
					
					if (rows > 0) {
					    output.displayMsg("Inserted Successfully!");
					}
			    }
			    output.Output_GUI("Appointment Booked");
			}
			else {
				output.Output_GUI("Unable to Book Appointment. (You might have typed the doctor's name incorrectly OR He might be unavailable)");
			}
			
		}
		
	public void insertDiagnoses(String username,String diagnose, String sql1,String sql2 , Connection C) throws SQLException 
		{
			
			Statement s1 = C.createStatement();
			Statement s2;
			
			ResultSet result = s1.executeQuery(sql1);
		
		    while(result.next()) {
		        s2 = C.createStatement();
		        int rows = s2.executeUpdate(sql2);
				
				if (rows > 0) {
				    output.displayMsg("Inserted Successfully!");
				}
		    }
		}
		
	public void searchUser(String username, String sql, Statement s) {
		
		
		try {
			ResultSet result = s.executeQuery(sql);
			int check = 0;
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
			    	String name = result.getString("Name");
				    String cnic = result.getString("CNIC");
				    String gender = result.getString("Gender");
				    int age = result.getInt("Age");
				    
				    String form = "Name: Dr. %s \n CNIC: %s \n Gender: %s \n Age: %d";
				    
				    output.Output_GUI(String.format(form, name, cnic , gender , age));
				    check = 1;
				    break;
			    }   
			}
			if(check == 0)
				output.Output_GUI("Record NOT in Database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getName(String username, String sql, Statement s) {
		
		String name = " ";
		
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
			    	name = result.getString("Name");
			    	return name;
			    }
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public String getCNIC(String username, String sql, Statement s) 
	{
		String CNIC = " ";
		
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
			    	CNIC = result.getString("CNIC");
			    	return CNIC;
			    }
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CNIC;
	}
	
	public String getGender(String username, String sql, Statement s) 
	{
		String Gender = " ";
		
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
			    	Gender = result.getString("Gender");
			    	return Gender;
			    }
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Gender;
	}
	
	public int getAge(String username, String sql, Statement s) 
	{
		int Age = 0;
		
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
			    	Age = result.getInt("Age");
			    	return Age;
			    }
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Age;
	}
	
	//****************************** Patient Specific ************************************
	
	public String getPrescription(String username, String sql, Statement s){
		
		String prescrip= "-";
		
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
				    prescrip = result.getString("Prescription");
				    break;
				    
			    }
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prescrip;
	}
	
	public int getMedCost(String username, String sql, Statement s){
		
		int cost = 0;
		
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
				    cost = result.getInt("MedCost");
				    break;
				    
			    }
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cost;
	}
	
	public int getInvoiceTotal(String username, String sql, Statement s){
		
		int cost = 0;
		
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
				    cost = result.getInt("InvoiceTotal");
				    break;
				    
			    }
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cost;
	}
	
	public void insertPatientProblem(String username,String problem, String sql1,String sql2 , Connection C) throws SQLException{
			
		Statement s1 = C.createStatement();
		Statement s2;
		
		ResultSet result = s1.executeQuery(sql1);
	
	    while(result.next()) {
	        s2 = C.createStatement();
	        int rows = s2.executeUpdate(sql2);
			
			if (rows > 0) {
			    output.displayMsg("Inserted Successfully!");
			}
	    }
		
	}
	
	public String getLabReport(String username, String sql, Statement s) {
		
		String report = " ";
		
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
				    report = result.getString("LabReport");
				    
				    return report;
				    
			    }
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return report;
	}

	//***************************************** Doctor *******************************************
	
	public void searchPatient(String username, String sql, Statement s) {
		
		
		try {
			ResultSet result = s.executeQuery(sql);
			int check = 0;
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
			    	String name = result.getString("Name");
				    String cnic = result.getString("CNIC");
				    String gender = result.getString("Gender");
				    int age = result.getInt("Age");
				    String problem = result.getString("Problem");
				    
				    String form = "Name: %s \n CNIC: %s \n Gender: %s \n Age: %d \n Problem: %s";
				    
				  //  System.out.println(String.format(form, name, cnic , gender , age, problem));
				    output.Output_GUI(String.format(form, name, cnic , gender , age, problem));
				    check =1;
				    break;
			    }
			}
			if(check == 0)
				output.Output_GUI("Patient Record NOT in Database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void insertPatientPrescription(String username, String prescription, String sql1, String sql2, Connection C) throws SQLException 
	{
		//Connects to a specific Patient's Profile through username
		Statement s1 = C.createStatement();
		Statement s2;
		
		ResultSet result = s1.executeQuery(sql1);
	
	    while(result.next()) {
	        s2 = C.createStatement();
	        int rows = s2.executeUpdate(sql2);
			
			if (rows > 0) {
			    output.displayMsg("Inserted Successfully!");
			}
	    }
	}
	
	public void insertPatientInvoice(String username, int InvoiceTotal, String sql1, String sql2, Connection C) throws SQLException 
	{
		//Connects to a specific Patient's Profile through username
		Statement s1 = C.createStatement();
		Statement s2;
		
		ResultSet result = s1.executeQuery(sql1);
	
	    while(result.next()) {
	        s2 = C.createStatement();
	        int rows = s2.executeUpdate(sql2);
			
			if (rows > 0) {
			    output.displayMsg("Inserted Successfully!");
			}
	    }
	}
	
	public void insertPatientMedCost(String username, int M_cost, String sql1, String sql2, Connection C) throws SQLException 
	{
		//Connects to a specific Patient's Profile through username
		Statement s1 = C.createStatement();
		Statement s2;
		
		ResultSet result = s1.executeQuery(sql1);
	
	    while(result.next()) {
	        s2 = C.createStatement();
	        int rows = s2.executeUpdate(sql2);
			
			if (rows > 0) {
			    output.displayMsg("Inserted Successfully!");
			}
	    }
	}
	
	//***************************************** Nurse *******************************************
	
	public String checkDoctorAvailability(String username, String sql, Statement s) {
		
		String avail = " ";
		String Ret = " ";
		String Y = "YES";
		String N = "NO";
		String D_Name = getName(username, sql, s);
		try {
			ResultSet result = s.executeQuery(sql);
			while (result.next()){
				
			    String user = result.getString("Username");
			    if (username.equals(user))
			    {
				    avail = result.getString("Availability");
				    break;
			    }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Y.equals(avail))
		{
			Ret = "Dr. " +D_Name+ " is currently Available";
			
		}
		else if(N.equals(avail))
		{
			Ret = "Dr. " +D_Name+ " is currently NOT Available";
		}
		else
		{
			Ret = "N/A";
		}
		return Ret;
	}
	
	//**************************************** Lab Assistant ************************************
	public void insertPatientReport(String username, String report, Connection C) throws SQLException {
		//inserting Lab Report in a specific Patient
		String sql1 = "SELECT * FROM Patient";
		String sql2 ;
		
		Statement s1 = C.createStatement();
		Statement s2;
		
		String test = " ";
		
		ResultSet result = s1.executeQuery(sql1);
		int rows = 0;
	    while(result.next()) {
	    	String user = result.getString("Username");
	    	test = result.getString("LabReport");
	    	
	    	if (test.equals("-") && username.equals(user)) {
	    		
	    		sql2 = "UPDATE Patient SET LabReport ='"+report+"' WHERE Username LIKE '"+username+"'";
	    		s2 = C.createStatement();
		        rows = s2.executeUpdate(sql2);
	    	}
	    	else if(!test.equals("-") && username.equals(user))
	    	{
	    		report = test+","+ report;
	    		sql2 = "UPDATE Patient SET LabReport ='"+report+"' WHERE Username LIKE '"+username+"'";
	    		s2 = C.createStatement();
		        rows = s2.executeUpdate(sql2);
	    	}
			
			if (rows > 0) {
			    output.displayMsg("Inserted Successfully!");
			}
	    }
		
	}	//**************************************DELEING RECORD*************************************************

	//Called in deleteAccount
	public boolean checkAccount(String username, String sql, Statement s) throws SQLException {
			
			boolean check = false;
			
			try {
				ResultSet result = s.executeQuery(sql);
				while (result.next()){
					
				    String user = result.getString("Username");
				    if (username.equals(user))
				    {
				    	check = true; 
				    	return check;
				    }
				    
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
		}

	public boolean removeLoginInfo(String username, Connection C) throws SQLException {
			
			String sql1 = "SELECT * FROM Login";
			
			String sql2 = "DELETE FROM Login WHERE Username='"+username+"'";
					
			Statement s1 = C.createStatement();
			Statement s2;
			
			ResultSet result = s1.executeQuery(sql1);
			
		    while(result.next()) {
		        s2 = C.createStatement();
		        int rows = s2.executeUpdate(sql2);
				String user = result.getString("username"); //Change if required (check Login)
		        if (username.equals(user)) {
		        	
		        	if (rows > 0 ) {
					    output.displayMsg("Deleted Successfully from Login!");
					}
		        	return true;
		        }
		        
				
		    }
			
			
			return false;
		}
		
	public void deleteAccount(String username,String table,Connection C) throws SQLException {
			
			String sql1 = "SELECT * FROM "+table;
			
			String sql2 = "DELETE FROM "+table+" WHERE Username='"+username+"'";
			
			Statement s1 = C.createStatement();
			Statement s2;
			
			if (checkAccount(username, sql1, s1) == true)
			{
				ResultSet result = s1.executeQuery(sql1);
				
			    while(result.next()) {
			        s2 = C.createStatement();
			        int rows = s2.executeUpdate(sql2);
					
					if (rows > 0 && removeLoginInfo(username,C) == true) {
					    output.Output_GUI("Deleted Successfully!");
					}
			    }
			    
			}
			else
				output.Output_GUI("Account Does not Exist!");
			
			
		}
	
}
