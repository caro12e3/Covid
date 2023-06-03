import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class Adminpage extends Frame implements ActionListener {
	
		Button Button1,Button2,Button3;
		//Frame g=new Frame();
		Button b=new Button();
	    Adminpage(){
			
			setBackground(Color.pink);
			setBounds(100,100,600,400);
			setVisible(true);//to display picture on the screen
			setLayout(null);//when setting boundary give as null
			Label l=new Label("Admin Page");
			l.setBounds(250,70,100,30);
	    	add(l);
			
			
			Button1=new Button("Add Vaccination Centres");
			Button2=new Button("Get dosage details");
			Button3=new Button("Remove centres");
			
			Button1.setBounds(60,200,150,30);
		    Button2.setBounds(220,200,150,30);
		    Button3.setBounds(380,200,150,30);
		
			setTitle("Adminpage");
			//setResizable(false);//we can move the console....
			
			 /*b.addActionListener(new ActionListener(){  
				    public void actionPerformed(ActionEvent e){  
				            t.setText("Welcome to Javatpoint.");  
				    }  
				    });  */
			
			//f.add(t);
			add(Button1);
			add(Button2);
			add(Button3);
			addWindowListener(new WindowAdapter() {//to close the frame class object of window adapter class
				public void windowClosing(WindowEvent we) {//invoked when window is in process of closing
					System.exit(0);
				}
			});
		
			Button1.addActionListener(new ActionListener() {
	         
				@Override
				public void actionPerformed(ActionEvent e) {
					new Addcenter();
				}
			});
			Button2.addActionListener(new ActionListener() {
		         
				@Override
				public void actionPerformed(ActionEvent e) {
					 new Getdosagedetail();
				}
			});
			Button3.addActionListener(new ActionListener() {
		         
				@Override
				public void actionPerformed(ActionEvent e) {
					new Removecenter();
				}
			});
			
	    }
			
		
		public static void main(String[] args) {
			new Adminpage();

		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}


