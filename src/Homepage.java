
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
//import banking.connectiondb;
public class Homepage extends Frame implements ActionListener{
	TextField t1,t2;
	Label l,l1,l2;
	String aa,bb;
	int d1=0,d2=0;
	int count=0;
	int transfer=0;
	int receive=0;
	Button b;
	String p="";
    public Homepage(String h){
    	l=new Label("Transaction of amount");
    	setBackground(Color.pink);
		setBounds(100,100,600,400);
		setVisible(true);//to display picture on the screen
		setLayout(null);//when setting boundary give as null
		l1=new Label("Pay To:");
    	l1.setBounds(50,100,150,30);
    	t1=new TextField();
		t1.setBounds(250,100,150,30);
    	l2=new Label("amount to transfer");
    	l2.setBounds(50,150,150,30);
    	t2=new TextField();
    	t2.setBounds(250,150,150,30);
    	b=new Button("Pay");
    	b.setBounds(220,200,150,30);
    	add(l1);
    	add(t1);
    	add(l2);
    	add(t2);
    	add(b);
    	l.setBounds(250,50,200,50);
    	add(l);
    	addWindowListener(new WindowAdapter() {//to close the frame class object of window adapter class
			public void windowClosing(WindowEvent we) {//invoked when window is in process of closing
				System.exit(0);
			}
		});
    	t1.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=t1.getText();
				p=name;
				int w=0;
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/form","root","1234");
			 		Statement stat=con.createStatement();
			 		 String q = "select * from acctdetails";
			 		  ResultSet rs = stat.executeQuery(q);
			 	      while (rs.next()) {
			 		     if(rs.getString("acct_no").equals(name)) {
			 		    	 receive=rs.getInt("amount");
			 		    	 w=1;
			 		    	 count++;
			 		    	 break;
			 		    	 
			 		     }}
			 	     con.close();
			 	     if(w==1) {
			 	    	
			 	     }
			 	     if(w==0) {
			 	    	
			 	     }
			 	  }
			     catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
			
		});
    	t2.addActionListener(new ActionListener() {//any enter event
            
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=t2.getText();
				int r1=Integer.parseInt(name);
				int w2=0;
				try {
			 		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/form","root","1234");
			 		Statement stat=con.createStatement();
			 		String q = "select * from acctdetails;";
			 		ResultSet rs = stat.executeQuery(q);
			 		while(rs.next()) {
			 			 if(rs.getString("acct_no").equals(h) && rs.getInt("amount")>r1) {
			 				 transfer=rs.getInt("amount")-r1;
			 				 receive+=r1;
			 		    	 w2=1;
			 		    	 count++;
			 		     }
			 	    
			 	  }
			 		 con.close();}
			     catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(w2==1 && count==2) {
		 	    	
		 	     }
		 		  else {
		 			
		 			  
		 		  }
				}
		});
    	b.addActionListener(new ActionListener() {//any enter event

			@Override
			public void actionPerformed(ActionEvent e) {
				 if(count==2) {
					 try {
						 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/form","root","1234");
					 	Statement stat=con.createStatement();
				 		 int y=Integer.parseInt(t2.getText());
	
				 		 String q = "update acctdetails set amount=? where acct_no=?";
				 		 PreparedStatement sm=con.prepareStatement(q);
				 		 sm.setInt(1, transfer);
				 		 sm.setString(2,h);
				 		 sm.executeUpdate();
				 		String q1="update acctdetails set amount=? where acct_no=?";
				 		 PreparedStatement sm1=con.prepareStatement(q);
				 		 sm1.setInt(1,receive);
				 		 sm1.setString(2,p);
				 		 sm1.executeUpdate();
				 		 con.close();
				 		  }
					 
					 catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					  
					 
				 	  }
				 else {
					
				 }}			
		});			
    }
	public static void main(String[] args) {  //throws SQLException{
		// TODO Auto-generated method stub
        //homepage d=new homepage("hai");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}