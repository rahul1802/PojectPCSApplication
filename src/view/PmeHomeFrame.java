package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PmeHomeFrame extends JFrame {
	Container container;
	JButton bLogout,bActivate,bViewAllEmployee,bAddSkill;
	public PmeHomeFrame() {
		container=getContentPane();
		bLogout=new JButton("LOGOUT");
		bLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callDispose();
				new LoginFrame();
				
			}
		});
		bActivate=new JButton("ACTIVATE USERS");
		bActivate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callDispose();
				new ActivateFrame();
				
			}
		});
		bViewAllEmployee=new JButton("VIEW ALL EMPLOYEES");
		bViewAllEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callDispose();
				new PMEViewFrame();
				
			}
		});
		bAddSkill=new JButton("ADD SKILL");
		bAddSkill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("PME HOME");
		this.setVisible(true);
		this.setBounds(10, 10, 500, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // fixed size frame
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		bActivate.setBounds(100, 100, 300, 30);
		bViewAllEmployee.setBounds(100, 140, 300, 30);
		bAddSkill.setBounds(100,180 , 300, 30);
		bLogout.setBounds(100, 220, 300, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(bActivate);
		container.add(bViewAllEmployee);
		container.add(bAddSkill);
		container.add(bLogout);
	}
	
	public void callDispose() {
		this.dispose();
	}
}
