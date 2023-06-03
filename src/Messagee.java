import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Messagee extends Frame {
    Label ll;
    Button bb;
    public Messagee(String m) {
       setBounds(500,400,250,150);
       setLayout(null);
       setVisible(true);
       bb=new Button("done");
       bb.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();//to  close the tab
		}
       });
       bb.setBounds(100,100,40,20);
       ll=new Label();
      
       ll.setText(m);
    
      
       
       ll.setBounds(75,50,100,30);
       add(ll);
       add(bb);
    }
	
	


	public static void main(String[] args) {
		

	}

}