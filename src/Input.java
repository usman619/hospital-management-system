import java.io.IOException;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Input extends JFrame{

	public Scanner input; 
	
	public Input()
	{
		input = new Scanner( System.in );
	} 
	
	public int getInt()
	{
		return input.nextInt(); 
	}
	
	public String getString()
	{
		return input.next();
	}
	
	public String getLongString() throws IOException 
	{
		
		int i ;
		
		String str ="";
		
		while ((i = System.in.read())!= 13)
		{
			str = str +(char)i;
		}
		
		return str;
	}
	
	public boolean getBool() {
		return input.nextBoolean();
	}
	
	public char getChar()
	{
		return input.next().charAt(0);
		
	}
	
	public String Input_GUI(String ask)
	{
		return JOptionPane.showInputDialog(ask);
	}
	
	public int Input_INT_GUI(String ask)
	{
		String X = JOptionPane.showInputDialog(ask);
		return Integer.parseInt(X);
	}
}