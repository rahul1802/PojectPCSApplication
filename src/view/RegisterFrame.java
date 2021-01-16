package view;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class RegisterFrame extends JFrame{
	Container container;
	
	JLabel lFirstname,lLastname,lEmail,lUsername,lPassword,lRole,lGender;
	JTextField tFirstname,tLastname,tEmail,tUsername,tRole,tGender;
	JPasswordField tPassword;
	JButton bRegister;

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
		//setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Registeration Form");
		this.setVisible(true);
		this.setSize(900,900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		
	}
	public void setLayoutManager()
	{
		container.setLayout(null);
		
	}
	public void setLocationAndSize()
	{
		lFirstname.setBounds(50, 300, 100, 30);
		lLastname.setBounds(50, 350, 100, 30);
		lEmail.setBounds(50, 350, 100, 30);
		lUsername.setBounds(50, 450, 100, 30);
		lPassword.setBounds(50, 550, 100, 30);
		lRole.setBounds(50, 650, 100, 30);
		lGender.setBounds(50, 750, 100, 30);
		tFirstname.setBounds(250, 150, 150, 30);
		tLastname.setBounds(250, 250, 150, 30);
		tEmail.setBounds(250, 350, 150, 30);
		tUsername.setBounds(250, 450, 150, 30);
		tPassword.setBounds(250, 550, 150, 30);
		tRole.setBounds(250, 650, 150, 30);
		tGender.setBounds(520, 750, 150, 30);
		bRegister.setBounds(50, 800, 200, 50);
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
