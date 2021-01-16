package view;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.*;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import controller.EmployeeController;
import model.Employee;


public class PMEViewFrame  extends JFrame{
	Container container;
	JLabel lFirstname,lLastname,lEmail,lUsername,lPassword,lRole,lGender;
	JTextField tFirstname,tLastname,tEmail,tUsername,tRole,tGender;
	JPasswordField tPassword;
	EmployeeController empController=null;
	Connection conn=null;
	public PMEViewFrame()
	{
		DefaultTableModel model = new DefaultTableModel();
	    container = getContentPane();
	    JTable jtbl = new JTable(model);
	    container.setLayout(new FlowLayout(FlowLayout.CENTER));
	    	model.addColumn("EmployeeID");
	        model.addColumn("FirstName");
	        model.addColumn("LastName");
	        model.addColumn("Email");
	        model.addColumn("Username");
	        model.addColumn("Password");
	        model.addColumn("Role");
	        model.addColumn("Gender");
	        model.addColumn("Active");
	        List<Employee> empList=new EmployeeController().getAllEmployees();
	      
	        for(Employee emp:empList) {
	        	if(emp.getRole().equals("PME"))
	        	{
	        		model.addRow(new Object[]{emp.getEmployeeId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getUserId(),emp.getPassword(),emp.getRole(),emp.getGender(),emp.getActive()});
	        	}
	        }
	    	
	        JScrollPane pg = new JScrollPane(jtbl);
	        container.add(pg);
	        this.pack();
	        this.setTitle("View Details");
	        this.setSize(900, 300);
	        //setLocationRelativeTo(null);
	        setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
		
	

}



