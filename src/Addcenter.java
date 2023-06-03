import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
public class Addcenter extends Frame implements ActionListener{
	TextField t2,t3,t4,t5;
	Label l,l1,l2,l3,l4;
	String data="";
	
	Button b;
    Addcenter(){
    	l=new Label("Add Vaccination Details");
    	setBackground(Color.pink);
		setBounds(100,100,600,400);
		setVisible(true);//to display picture on the screen
		setLayout(null);//when setting boundary give as null
	       l1=new Label("City:");  
	       l1.setBounds(50,100,150,30);
         Choice t1 =new Choice(); 
         t1.add("Trichy");    
         t1.add("Salem");    
         t1.add("Coimbatore");    
         t1.add("Madurai");   
		t1.setBounds(250,100,150,30);
		
    	l2=new Label("Location:");
    	l2.setBounds(50,150,150,30);
    	t2=new TextField();
    	t2.setBounds(250,150,150,30);
    	l3=new Label("Center:");
    	l3.setBounds(50,200,150,30);
    	t3=new TextField();
    	t3.setBounds(250,200,150,30);
    	l4=new Label("Dosage:");
    	l4.setBounds(50,250,150,30);
    	t4=new TextField();
		t4.setBounds(250,250,150,30);
		Label l5=new Label("Working hours:");
    	l5.setBounds(50,300,150,30);
    	t5=new TextField();
		t5.setBounds(250,300,150,30);
    	b=new Button("Submit");
    	b.setBounds(250,350,150,30);
    	add(l1);
    	add(t1);
    	add(l2);
    	add(t2);
    	add(l3);
    	add(t3);
    	add(l4);
    	add(t4);
    	add(l5);
    	add(t5);
    	
    	add(b);
    	l.setBounds(150,70,200,50);
    	add(l);
    	
    	addWindowListener(new WindowAdapter() {//to close the frame class object of window adapter class
			public void windowClosing(WindowEvent we) {//invoked when window is in process of closing
				System.exit(0);
			}
		});
      
    	t1.addItemListener((ItemListener) new ActionListener() {    
            public void actionPerformed(ActionEvent e) {         
             data+=t1.getItem(t1.getSelectedIndex());    
             l1.setText(data);    
             }    
            });            
    	
    	b.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {

					try {
				 		  Class.forName("com.mysql.cj.jdbc.Driver");
				 		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid","root","1234");
				 		  Statement stat=con.createStatement();//interface
				 		 PreparedStatement stmt=con.prepareStatement("insert into vaccinecenter values(?,?,?,?,?)");  
				 		stmt.setString(1,data);//1 specifies the first parameter in the query  
				 		stmt.setString(2,t2.getText());
				 		stmt.setString(3,t3.getText());
				 		stmt.setString(4,t4.getText());
				 		stmt.setString(5,t5.getText());
				 		
				 		
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
				
							
		});			
    }
	public static void main(String[] args) {  //throws SQLException{
		// TODO Auto-generated method stub
      new Addcenter();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}}
