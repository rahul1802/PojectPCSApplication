package view;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.EmployeeController;
import model.Employee;


public class EmpViewFrame  extends JFrame{
	Container container;
	 JButton hButton;
	EmployeeController empController=null;
	Connection conn=null;
	public EmpViewFrame()
	{
		DefaultTableModel model = new DefaultTableModel();
	    container = getContentPane();
	    JTable jtbl = new JTable(model);
	    hButton=new JButton("EmpHomeFrame");
	    hButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callDispose();
				new EmpHomeFrame();
				
			}
		});
	    container.setLayout(new BorderLayout());
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
	        	if(emp.getRole().equals("EMP"))
	        	{
	        		model.addRow(new Object[]{emp.getEmployeeId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getUserId(),emp.getPassword(),emp.getRole(),emp.getGender(),emp.getActive()});
	        	}
	        }
	    	
	        JScrollPane pg = new JScrollPane(jtbl);
	        container.add(pg,BorderLayout.CENTER);
	        container.add(hButton,BorderLayout.SOUTH);
	        this.pack();
	        this.setTitle("View Details");
	        this.setSize(900, 300);
	        //setLocationRelativeTo(null);
	        setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
		
	public void callDispose() {
		this.dispose();
	}

}



