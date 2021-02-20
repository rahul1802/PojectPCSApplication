package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.EmployeeController;
import model.Employee;

public class ActivateEmpFrame extends JFrame{
	Container container;
	JLabel lEmployeeID;
	JTextField tEmployeeID;
	JButton bActivate;
	EmployeeController empController =null;
	public ActivateEmpFrame() {
		container=getContentPane();
		lEmployeeID=new JLabel("EmployeeID");
		tEmployeeID=new JTextField();
		bActivate=new JButton("Activate");
		empController=new EmployeeController();
		bActivate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int EmployeeId;
				Employee emp=new Employee();
				EmployeeId=Integer.parseInt(tEmployeeID.getText());
				emp.setEmployeeId(EmployeeId);
				empController.activateEmployee(emp);
				callDispose();
				new EmpHomeFrame();
			}
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("ACTIVATE EMPLOYEE");
		this.setVisible(true);
		this.setSize(500,180);
		//this.setBounds(10, 10, 500, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // fixed size frame
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		lEmployeeID.setBounds(50, 60, 150, 30);
		tEmployeeID.setBounds(250,60,150,30);
		bActivate.setBounds(200,100,100,30);
	}
	
	public void addComponentsToContainer() {
		container.add(lEmployeeID);
		container.add(tEmployeeID);
		container.add(bActivate);
	}
	
	public void callDispose() {
		this.dispose();
	}
}
