import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;
public class SearchView extends JFrame
{
    private String id;
    private String name;
    private String age;
    private String gender;
    private String position;
    private String salary;
    String db[][]= new String[50][6];
    Scanner sc;
    public SearchView(String key[])
    {
        setTitle("Employee Details");
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

        for(int i=0;i<50;i++)
        {
            if(db[i][0]!=null)
            {
                if(db[i][0].equals(key[0]) ||db[i][1].equals(key[1]) ||db[i][2].equals(key[2]) ||db[i][3].equals(key[3]) ||db[i][4].equals(key[4]) ||db[i][5].equals(key[5]))
                {
                    Object [] details={db[i][0],db[i][1],db[i][2],db[i][3],db[i][4],"₹ "+db[i][5]};
                    tableModel.addRow(details);
                }
            }
        }

        JScrollPane scrollPane = new JScrollPane(EmpTable);

        // Adding the scroll pane and input panel to the JFrame
        add(scrollPane, BorderLayout.CENTER);
        setSize(450, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    void getData()throws IOException,NullPointerException
    {
        sc= new Scanner(new File("EmpDB.csv"));
        sc.useDelimiter(",");
        for(int i=0;sc.hasNext();i++)
        {
            db[i]=sc.nextLine().split(",");
        }
    }
    void close()
    {
        dispose();
    }
    public static void main(String[] args) 
    {
        //new SearchEmployee(test);
    }
}