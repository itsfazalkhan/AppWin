import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;
public class ViewEmployee extends JFrame
{
    private String id;
    private String name;
    private String age;
    private String gender;
    private String position;
    private String salary;
    String db[][]= new String[50][6];
    Scanner sc;
    public ViewEmployee()
    {
        //set Title
        setTitle("Display Details");
        //create table
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Position");
        tableModel.addColumn("Salary");
        JTable EmpTable = new JTable(tableModel);
        try
        {
            getData();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        for(String row[]:db)
        {
            if(row[0]!=null)
            {
                Object [] details={row[0],row[1],row[2],row[3],row[4],"₹ "+row[5]};
                tableModel.addRow(details);
            }
        }
        JScrollPane scrollPane = new JScrollPane(EmpTable);

        // Adding the scroll pane and input panel to the JFrame
        add(scrollPane, BorderLayout.CENTER);
        setSize(640, 720);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    void getData()throws IOException
    {
        File f =new File("Emp.csv");
        sc= new Scanner(f);
        sc.useDelimiter(",");
        for(int i=0;sc.hasNext();i++)
        {
            db[i]=sc.nextLine().split(",");
        }
    }

    public static void main(String[] args) 
    {
        // create employee data entry window
        new ViewEmployee();
    }
}