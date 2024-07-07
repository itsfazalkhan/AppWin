import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class RemoveEmployee extends JFrame implements ActionListener
{
    JTextField idField;
    JTextField nameField;
    JTextField ageField;
    JComboBox<String> genderBox;
    JTextField positionField;
    JTextField salaryField;
    JButton removeButton;
    String db[][]=new String[50][6];
    String store[][]=new String[50][6];
    String remove[][]=new String[50][6];
    String key[]=new String[6];
    Scanner sc;

    RemoveEmployee()
    {
        JLabel idLabel = new JLabel(" Id:");
        JLabel nameLabel = new JLabel(" Name:");
        JLabel ageLabel = new JLabel(" Age:");
        JLabel genderLabel = new JLabel(" Gender:");
        JLabel positionLabel = new JLabel(" Position:");
        JLabel salaryLabel = new JLabel(" Salary:");

        idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();
        JComboBox<String> genderBox= new JComboBox<>(new String[] {null,"Male", "Female", "Other"});
        positionField = new JTextField();
        salaryField = new JTextField();
        removeButton=new JButton("Remove");
        removeButton.addActionListener(this);

        add(idLabel);
        add(idField);
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        //add(genderLabel);
        //add(genderBox);
        add(positionLabel);
        add(positionField);
        add(salaryLabel);
        add(salaryField);
        add(new JLabel());
        add(removeButton);

        // set layout
        setLayout(new GridLayout(6, 2));
        setTitle("Remove an Employee");
        // set frame size and visibility
        setSize(450, 300);
        setLocationRelativeTo(null);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==removeButton)
        {
            key[0] = idField.getText();
            key[1] = nameField.getText();
            key[2] = ageField.getText();
            //key[3] = (String) genderBox.getSelectedItem();
            key[4] = positionField.getText();
            key[5] = salaryField.getText();
            try
            {
                getData();
                storeData();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            boolean sw =false;
            for(String x[]:remove) 
            {
                if(x[0]!=null)
                {
                    sw=true;
                    break;
                }
            }  
            if(sw)
            {   new messageBox("Removed Successfully!");
                new SearchView(key);
            }
            else new messageBox("Not such user found");
        }

    }

    void getData()throws IOException
    {
        String x[];
        sc= new Scanner(new File("Emp.csv"));
        sc.useDelimiter(",");
        for(int i=0;sc.hasNext();i++)
        {
            x=sc.nextLine().split(",");
            if(x[0]!=null)
            {    
                if(x[0].equals(key[0])||x[1].equals(key[1])||x[2].equals(key[2])||x[3].equals(key[3])||x[4].equals(key[4])||x[5].equals(key[5]))
                {
                    remove[i]=x;
                }else store[i]=x;
            }
        }
    }

    void storeData()throws IOException
    {
        FileWriter orig=new FileWriter("Emp.csv",false);
        BufferedWriter borig = new BufferedWriter(orig);
        FileWriter rem= new FileWriter("Rem.csv",false);
        BufferedWriter brem = new BufferedWriter(rem);
        for(int i =0;i<50;i++)
        {
            if(remove[i][0]!=null)
            {
                for(String s:remove[i])
                    brem.append(s+",");
                brem.append("\n");
            }        
            if(store[i][0]!=null)
            {
                for(String s:store[i])

                    borig.append(s+",");
                borig.append("\n");
            }
        }
        borig.close();
        orig.close();
        brem.close();
        rem.close();
    }

    public static void main(String args[])
    {
        new RemoveEmployee();
    }

}