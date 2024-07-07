import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class home extends JFrame implements ActionListener
{

    JButton Add;
    JButton Del;
    JButton Search;
    JButton View;
    public home() {
        // set window title
        setTitle("Employee Management System");

        Add = new JButton("Add new Employee");
        Add.addActionListener(this);
        Del = new JButton("Remove an Employee");
        Del.addActionListener(this);
        Search = new JButton("Search Employee Details");
        Search.addActionListener(this);
        View = new JButton("View Employee Details");
        View.addActionListener(this);

        Panel p = new Panel();
        
        p.add(Add);
        p.add(Del);
        p.add(Search);
        p.add(View);
        add(p);
        p.setLayout(null);
        Add.setBounds(100,100,400,60);
        Del.setBounds(100,200,400,60);
        Search.setBounds(100,300,400,60);
        View.setBounds(100,400,400,60);

        // set frame size and visibility
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == Add){
            new EmployeeData();
        }
        if (e.getSource() == View){
            new ViewEmployee();
        }
        if (e.getSource() == Search){
            new EmpSearch();
        }
        if (e.getSource() == Del){
            new RemoveEmployee();
        }
        
    }
    public static void main(String[] args) {
        
        // create employee data entry window
        new home();
    }
}