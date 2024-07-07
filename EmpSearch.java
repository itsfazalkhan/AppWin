import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class EmpSearch extends JFrame implements ActionListener
{
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JLabel positionLabel;
    private JLabel salaryLabel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> genderBox;
    private JTextField positionField;
    private JTextField salaryField;
    private JButton searchButton;
    String id;
    String name;
    String age;
    String gender;
    String position;
    String salary;
    String db[][]=new String[50][6];
    String key[]=new String[6];
    Scanner sc;
    public EmpSearch() 
    {
        // set window title

        setTitle("Search Employee");

        // create labels
        idLabel = new JLabel("  ID:");
        nameLabel = new JLabel("  Name:");
        ageLabel = new JLabel("  Age:");
        genderLabel = new JLabel("  Gender:");
        positionLabel = new JLabel("  Position:");
        salaryLabel = new JLabel("  Salary:");

        // create text fields and combo box
        idField = new JTextField(20);
        nameField = new JTextField(20);
        ageField = new JTextField(20);
        genderBox = new JComboBox<>(new String[] {null,"Male", "Female", "Other"});
        positionField = new JTextField(20);
        salaryField = new JTextField(20);

        // create submit button
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        // add components to frame
        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(genderLabel);
        add(genderBox);
        add(positionLabel);
        add(positionField);
        add(salaryLabel);
        add(salaryField);
        add(new JLabel(""));
        add(searchButton);

        // set layout
        setLayout(new GridLayout(7, 2));

        // set frame size and visibility
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        // check if submit button is clicked
        if (e.getSource() == searchButton) {
            // get employee data
            key[0]= idField.getText();
            key[1] = nameField.getText();
            key[2] = ageField.getText();
            key[3] = (String) genderBox.getSelectedItem();
            key[4] = positionField.getText();
            key[5] = salaryField.getText();
            boolean sw =true;
            SearchView A =new SearchView(key);
            for (String emp[]:A.db)
            {
                if(emp[0]!=null){

                    if(emp[0].equals(key[0]) ||emp[1].equals(key[1]) ||emp[2].equals(key[2]) ||emp[3].equals(key[3]) ||emp[4].equals(key[4]) ||emp[5].equals(key[5]))
                        {
                          sw=false; 
                          new messageBox("Record Found!");
                        }       

                }
            }
            if(sw)
            {
                new messageBox("Not Found!!");
                A.dispose();
            }

        }
    }

    public static void main(String[] args)
    {
        // create employee data entry window
        new EmpSearch();
    }
}

