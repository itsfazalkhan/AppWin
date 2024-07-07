import javax.swing.*;
import java.awt.event.*;
public class messageBox extends JFrame implements ActionListener
{
        JFrame f;  
        messageBox(String s){  
            f=new JFrame();  
            JOptionPane.showMessageDialog(f,s,"Alert",JOptionPane.WARNING_MESSAGE); 
        } 
        public void actionPerformed(ActionEvent e)
        {
            
        }

        public static void main(String[] args) {  
            new messageBox("Test");  
        }  
}  

