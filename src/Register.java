import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
public class Register extends Frame implements ActionListener{
	TextField t1,t2,t3,t4;
	Label l,l1,l2,l3,l4;
	//String aa,bb,cc,dd,ee,ff,gg;
	int d1=0,d2=0,d3=0,d4=0;
	int c=0;
	Button b,b3;
    Register(){
    	l=new Label("User Details");
    	setBackground(Color.pink);
		setBounds(100,100,600,400);
		setVisible(true);//to display picture on the screen
		setLayout(null);//when setting boundary give as null
		l1=new Label("Name");
    	l1.setBounds(50,100,150,30);
    	t1=new TextField();
		t1.setBounds(250,100,150,30);
    	l2=new Label("Mail:");
    	l2.setBounds(50,150,150,30);
    	t2=new TextField();
    	t2.setBounds(250,150,150,30);
    	l3=new Label("Password:");
    	l3.setBounds(50,200,150,30);
    	t3=new TextField();
    	t3.setBounds(250,200,150,30);
    	l4=new Label("Confirm password:");
    	l4.setBounds(50,250,150,30);
    	t4=new TextField();
		t4.setBounds(250,250,150,30);
    	
    	b=new Button("Submit");
    	b.setBounds(250,290,150,30);
    	add(l1);
    	add(t1);
    	add(l2);
    	add(t2);
    	add(l3);
    	add(t3);
    	add(l4);
    	add(t4);
    	
    	add(b);
    	l.setBounds(150,70,100,30);
    	add(l);
    	t3.setEchoChar('.');
    	t4.setEchoChar('.');
    	addWindowListener(new WindowAdapter() {//to close the frame class object of window adapter class
			public void windowClosing(WindowEvent we) {//invoked when window is in process of closing
				System.exit(0);
			}
		});
    
    	t1.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=t1.getText();
				if(t1.getText().trim().isEmpty()) {
					new Messagee("enter the name");
				}
				else{
					String re="[A-Za-z]{5,15}";
					Pattern pattern=Pattern.compile(re);
					Matcher matcher=pattern.matcher(name);
					if(matcher.matches()==false) {
						new Messagee("invalid");
					}
					else {
						d1++;
						c++;
						new Messagee("success");
						
						
					}
				}
				
			}
			
		});
    	
    	
    	t2.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=t2.getText();
				if(t2.getText().trim().isEmpty()) {
					new Messagee("enter the email");
				}
				else{
					String re="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
					Pattern pattern=Pattern.compile(re);
					Matcher matcher=pattern.matcher(name);
					if(matcher.matches()==false) {
						new Messagee("invalid");
					}
					else {
						d2++;
						c++;
						new Messagee("success");
						
						
					}
				}
				
			}
			
		});
    	t3.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=t3.getText();
				if(t3.getText().trim().isEmpty()) {
					new Messagee("enter the password");
				}
				else{
					String re="[0-9]{4}";
					Pattern pattern=Pattern.compile(re);
					Matcher matcher=pattern.matcher(name);
					if(matcher.matches()==false) {
						new Messagee("invalid");
					}
					else {
						d3++;
						c++;
						new Messagee("success");
						
						
					}
				}
				
			}
			
		});
    	t4.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=t4.getText();
				if(t4.getText().trim().isEmpty()) {
					new Messagee("Incorrect");
				}
				else{
					String re="[0-9]{4}";
					Pattern pattern=Pattern.compile(re);
					Matcher matcher=pattern.matcher(name);
					if(matcher.matches()==false) {
						new Messagee("invalid");
					}
					else {
						if(t4.getText().equals(t3.getText())) {
						d4++;
						c++;
						new Messagee("success");}
						else {
							new Messagee("invalid");
						}
						
					}
				}
				
			}
			
		});
    	b.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {
				if(c==4) {
					try {
				 		  Class.forName("com.mysql.cj.jdbc.Driver");
				 		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid","root","1234");
				 		  Statement stat=con.createStatement();//interface
				 		 PreparedStatement stmt=con.prepareStatement("insert into user values(?,?,?,?)");  
				 		stmt.setString(1,t1.getText());//1 specifies the first parameter in the query  
				 		stmt.setString(2,t2.getText());
				 		stmt.setString(3,t3.getText());
				 		stmt.setString(4,t4.getText());
				 		
						  int r=stmt.executeUpdate();
				 		  System.out.print("Record inserted successfully! "+r);
				 		 con.close();
				 	  }
				     catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Login c=new Login();
					c.setVisible(true);
					dispose();
					
				}
				if(d1==0||d2==0||d3==0||d4==0) {
					new Messagee("invalid");
				}
				
				}				
		});			
    }
	public static void main(String[] args) {  //throws SQLException{
		// TODO Auto-generated method stub
      new Register();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
