import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loginadmin extends Frame implements ActionListener {
	int d=0;
    String f,f1;
	TextField t1,t2;
	
	Button b4;
	//Frame g=new Frame();
	
	Loginadmin(){
		
		setBackground(Color.pink);
		setBounds(100,100,600,400);
		setVisible(true);
		setLayout(null);
		Label l1=new Label("Username:");
		Label l2=new Label("Password:");
		t1=new TextField();
		t2=new TextField();
		b4=new Button("login");
		
		t1.setBounds(150,100,150,30);
		l1.setBounds(50,100,150,30);
		t2.setBounds(150,200,150,30);
		l2.setBounds(50,200,150,30);
		b4.setBounds(250,300,50,30);
	
		setTitle("Adminpage");
		add(t1);
		add(l1);
		add(t2);
		add(l2);
		//f.add(t);
		add(b4);

		t2.setEchoChar('.');
		 t1.addActionListener(new ActionListener() {
		      
				@Override
				public void actionPerformed(ActionEvent e) {
					f=t1.getText();
					if(f.equals("admin")) {
						new Messagee("success");
					}
					else {
						d++;
						new Messagee("invalid");
					}
					
					
				}
		    	   
		       });
		 t2.addActionListener(new ActionListener() {
		      
				@Override
				public void actionPerformed(ActionEvent e) {
					f1=t2.getText();
					if(f1.equals("123")) {
						new Messagee("success");
					}
					else {
						d++;
						new Messagee("invalid");
					}
					
					
				}
		    	   
		       });
		b4.addActionListener(new ActionListener() {
         
			@Override
			public void actionPerformed(ActionEvent e) {
				if(d==0) {
				   
				    new Login();
				}
				else{
					new Messagee("invalid");
			     }
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


