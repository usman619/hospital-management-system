import javax.swing.*;
public class Output extends JFrame{

	public void displayMsg(String message)
	{
		System.out.println( message );
	}

	public void displayLine_INT(String message, int value)
	{
			System.out.printf(message, value);
	} 
	
	public void displayLine(String m1, String m2)
	{
			System.out.printf(m1, m2);
	}
	
	public void displayNOline(String m1)
	{
			System.out.print(m1);
	}
	
	public void displayLine_Char(String m1, char m2)
	{
			System.out.printf(m1, m2);
	}
	public void Output_GUI(String s)
	{
		JOptionPane.showMessageDialog(null, s);
	}
}
