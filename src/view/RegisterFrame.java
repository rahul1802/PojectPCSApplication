package view;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.EmployeeController;
import model.Employee;

public class RegisterFrame extends JFrame{
	Container container;
	
	JLabel lFirstname,lLastname,lEmail,lUsername,lPassword,lRole,lGender;
	JTextField tFirstname,tLastname,tEmail,tUsername,tRole,tGender;
	JPasswordField tPassword;
	JButton bRegister;
	EmployeeController empController=null;
	public RegisterFrame() 
	{
		container=getContentPane();
		lFirstname=new JLabel("FirstName");
		lLastname=new JLabel("Lastname");
		lEmail=new JLabel("Email");
		lUsername=new JLabel("UserName");
		lPassword=new JLabel("Password");
		lRole=new JLabel("Role");
		lGender=new JLabel("Gender");
		tFirstname=new JTextField();
		tLastname=new JTextField();
		tEmail=new JTextField();
		tUsername=new JTextField();
		tPassword=new JPasswordField();
		tRole=new JTextField();
		tGender=new JTextField();
		bRegister=new JButton("Register");
		empController=new EmployeeController();
		bRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Firstname,Lastname,Email,Username,Password,Role,Gender;
				Firstname=tFirstname.getText();
				Lastname=tLastname.getText();
				Email=tEmail.getText();
				Username=tUsername.getText();
				Password=new String(tPassword.getPassword());
				Role=tRole.getText();
				Gender=tGender.getText();
			Employee emp=new Employee();
			emp.setFirstName(Firstname);
			emp.setLastName(Lastname);
			emp.setEmail(Email);
			emp.setUserId(Username);
			emp.setPassword(Password);
			emp.setRole(Role);
			emp.setGender(Gender);
			if(Role.equals("HRA"))
			{
				emp.setActive("Active");
			}
			else
			{
				emp.setActive("Deactive");
			}
			empController.addEmployee(emp);
				callDispose();
				new LoginFrame();
			}
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Registeration Form");
		this.setVisible(true);
		this.setSize(500,350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		
	}
	public void setLayoutManager()
	{
		container.setLayout(null);
		
	}
	public void setLocationAndSize()
	{
		lFirstname.setBounds(150, 10, 80, 30);
		lLastname.setBounds(150, 40, 80, 30);
		lEmail.setBounds(150, 70, 80, 30);
		lUsername.setBounds(150, 100, 80, 30);
		lPassword.setBounds(150, 140, 80, 30);
		lRole.setBounds(150, 170, 80, 30);
		lGender.setBounds(150, 200, 80, 30);
		tFirstname.setBounds(250, 10, 150, 20);
		tLastname.setBounds(250, 40, 150, 20);
		tEmail.setBounds(250, 70, 150, 20);
		tUsername.setBounds(250, 100, 150, 20);
		tPassword.setBounds(250, 140, 150, 20);
		tRole.setBounds(250, 170, 150, 20);
		tGender.setBounds(250, 200, 150, 20);
		bRegister.setBounds(200, 240, 100, 20);
	}
 public void addComponentsToContainer()
 {
	
	 container.add(lFirstname);
	 container.add(lLastname);
	 container.add(lEmail);
	 container.add(lUsername);
	 container.add(lPassword);
	 container.add(lRole);
	 container.add(lGender);
	 container.add(tFirstname);
	 container.add(tLastname);
	 container.add(tEmail);
	 container.add(tUsername);
	 container.add(tPassword);
	 container.add(tRole);
	 container.add(tGender);
	 container.add(bRegister);
	
	
	
	 
 }
 public void callDispose()
 {
	 this.dispose();
 }

	
}
