
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends Frame implements ActionListener {
	int d=0;
	int d1=0;
	int c=0;
	TextField t1,t2,t3;
	String f,f1;
	Button b4,g;
	//Frame g=new Frame();
	Button b=new Button();
	Login(){
		
		setBackground(Color.pink);
		setBounds(100,100,600,400);
		setVisible(true);//to display picture on the screen
		setLayout(null);//when setting boundary give as null
		Label l1=new Label("Username:");
		Label l2=new Label("Password:");
		t1=new TextField();
		t2=new TextField();
		b4=new Button("login");
		g=new Button("Register");
		t1.setBounds(150,100,150,30);
		l1.setBounds(50,100,150,30);
		t2.setBounds(150,200,150,30);
		l2.setBounds(50,200,150,30);
		b4.setBounds(250,300,50,30);
		g.setBounds(150,300,50,30);
		setTitle("login");
		//setResizable(false);//we can move the console....
		
		 /*b.addActionListener(new ActionListener(){  
			    public void actionPerformed(ActionEvent e){  
			            t.setText("Welcome to Javatpoint.");  
			    }  
			    });  */
		add(t1);
		add(l1);
		add(t2);
		add(l2);
		//f.add(t);
		add(b4);
		add(g);
		t2.setEchoChar('.');
		 t1.addActionListener(new ActionListener() {
		      
				@Override
				public void actionPerformed(ActionEvent e) {
					f=t1.getText();
					
					
				}
		    	   
		       });
		 t2.addActionListener(new ActionListener() {
		      
				@Override
				public void actionPerformed(ActionEvent e) {
					f1=t2.getText();
					
					
					
				}
		    	   
		       });
		b4.addActionListener(new ActionListener() {
         
			@Override
			public void actionPerformed(ActionEvent e) {
				int count=0;
				try {
			 		  Class.forName("com.mysql.cj.jdbc.Driver");
			 		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid","root","1234");
			 		  Statement stat=con.createStatement();//interface
			 		  String q = "select * from user";
			 		 ResultSet rs = stat.executeQuery(q);
			 	      while (rs.next()) { 
			 		     if(rs.getString("name").equals(f) && rs.getString("password").equals(f1)) {
			 		    	 count++;
			 		     }}
			 		 con.close();
			 	  }
			     catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(count==1) {
				   Homepage r=new Homepage(f);
				   r.setVisible(true);
				//dispose();
				}
				else{
					new Messagee("invalid");
			     }
				}
			
		});
		g.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {
				Register c=new Register();
				c.setVisible(true);
				}
		});

    	addWindowListener(new WindowAdapter() {//to close the frame class object of window adapter class
			public void windowClosing(WindowEvent we) {//invoked when window is in process of closing
				System.exit(0);
			}
		});
    }
	public static void main(String[] args) {
		new Login();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


