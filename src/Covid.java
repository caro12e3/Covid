import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
public class Covid extends Frame{
	
	Button button1,button2;
	Label l;
	//Frame g=new Frame();
	Button b=new Button();
	Covid(){
		
		setBackground(Color.pink);
		setBounds(100,100,600,400);
		setVisible(true);//to display picture on the screen
		setLayout(null);//when setting boundary give as null
		l=new Label("Covid Booking");
    	
		l.setBounds(225,100,100,30);
		button1=new Button("User");
		button2=new Button("Admin");
		
		button1.setBounds(200,200,50,30);
		button2.setBounds(300,200,50,30);
		setTitle("Covid booking");
		
		add(l);
		add(button1);
		add(button2);
	
		 button1.addActionListener(new ActionListener() {
		      
				@Override
				public void actionPerformed(ActionEvent e) {
					 Login a=new Login();
					
				}
		    	   
		       });
		 button2.addActionListener(new ActionListener() {
		      
				@Override
				public void actionPerformed(ActionEvent e) {
				   Loginadmin a=new Loginadmin();
					
					
				}
		    	   
		       });
    
	}

public static void main(String[] args) {  //throws SQLException{
    Covid a=new Covid();
    
}}
