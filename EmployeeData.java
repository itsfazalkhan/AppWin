import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class EmployeeData extends JFrame implements ActionListener
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
    private JButton submitButton;
    int id;
    String name;
    int age;
    String gender;
    String position;
    double salary;

    public EmployeeData() 
    {
        // set window title
        setTitle("Employee Data Entry");

        // create labels
        idLabel = new JLabel(" ID:");
        nameLabel = new JLabel(" Name:");
        ageLabel = new JLabel(" Age:");
        genderLabel = new JLabel(" Gender:");
        positionLabel = new JLabel(" Position:");
        salaryLabel = new JLabel(" Salary:");

        // create text fields and combo box
        idField = new JTextField(20);
        nameField = new JTextField(20);
        ageField = new JTextField(20);
        genderBox = new JComboBox<>(new String[] {null,"Male", "Female", "Other"});
        positionField = new JTextField(20);
        salaryField = new JTextField(20);

        // create submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

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
        add(submitButton);

        // set layout
        setLayout(new GridLayout(7, 2));

        // set frame size and visibility
        setSize(450, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        // check if submit button is clicked
        if (e.getSource() == submitButton) 
        {
            // get employee data
            id=Integer.parseInt(idField.getText());
            name = nameField.getText();
            age = Integer.parseInt(ageField.getText());
            gender = (String) genderBox.getSelectedItem();
            position = positionField.getText();
            salary = Double.parseDouble(salaryField.getText());
            try
            {
                store( id,name,age,gender,position,salary);
                dispose();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            new ViewEmployee();
        }
    }

    void store(int id,String name,int age,String gender,String position,double salary)throws IOException
    {
        //back-up storage
        FileWriter fw = new FileWriter("EmpDB.csv",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.append(Integer.toString(id));
        bw.append(",");
        bw.append(name);
        bw.append(",");
        bw.append(Integer.toString(age));
        bw.append(",");
        bw.append(gender);
        bw.append(",");
        bw.append(position);
        bw.append(",");
        bw.append(Double.toString(salary));
        bw.append(",");
        bw.append("\n");
        bw.close();
        //main storage
        FileWriter fw2 = new FileWriter("Emp.csv",true);
        BufferedWriter bw2 = new BufferedWriter(fw2);
        bw2.append(Integer.toString(id));
        bw2.append(",");
        bw2.append(name);
        bw2.append(",");
        bw2.append(Integer.toString(age));
        bw2.append(",");
        bw2.append(gender);
        bw2.append(",");
        bw2.append(position);
        bw2.append(",");
        bw2.append(Double.toString(salary));
        bw2.append(",");
        bw2.append("\n");
        bw2.close();
    }

    public static void main(String[] args)
    {
        // create employee data entry window
        new EmployeeData();
    }
}

