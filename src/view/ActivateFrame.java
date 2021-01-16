package view;

import java.awt.Container;

import javax.swing.JFrame;

public class ActivateFrame extends JFrame {
	Container container;
	public ActivateFrame() {
container=getContentPane();
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("ACTIVATE EMPLOYEE");
		this.setVisible(true);
		this.setBounds(10, 10, 500, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); // fixed size frame
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		
	}
	
	public void addComponentsToContainer() {
		
	}
	
	public void callDispose() {
		this.dispose();
	}

}

