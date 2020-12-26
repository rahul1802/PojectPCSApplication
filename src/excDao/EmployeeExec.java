package excDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.EmployeeController;
import model.Employee;

public class EmployeeExec {
	EmployeeController empController=null;
	public EmployeeExec()
	{
		empController=new EmployeeController();
	}
	public void getAllEmployees()
	{
		List<Employee> empList=empController.getAllEmployees();
		for(Employee emp:empList)
		{
			System.out.println(emp);
		}
	}
	public void getEmployeesById()
	{
		int id=0;
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the Employee Id whose record you want to view");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empController.getEmployeeByID(id);
			System.out.println(emp);
		}
		catch(IOException ex)
		{
			System.out.println(ex);
		}
		
		
	}

public void addEmployee()
{
	Employee emp=new Employee();
	try
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Employee Details:");
		System.out.println("First Name");
		emp.setFirstName(reader.readLine());
		System.out.println("Last Name:");
		emp.setLastName(reader.readLine());
		System.out.println("Email:");
		emp.setEmail(reader.readLine());
		System.out.println("User Id:");
		emp.setUserId(reader.readLine());
		System.out.println("Password:");
		emp.setPassword(reader.readLine());
		System.out.println("Role:");
		String role=reader.readLine();
		emp.setRole(role);
		System.out.println("Gender:");
		emp.setGender(reader.readLine());
		if(role.equals("HRA"))
		{
			emp.setActive("Active");
		}
		else
		{
			emp.setActive("Deactive");
		}
	}
	catch(IOException ex)
	{
		System.out.println(ex);
	}
	empController.addEmployee(emp);
}
public void updateEmployee() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		String email, password, confirmpassword;
		System.out.println("Enter EmployeeId whose record you want to update:");
		id=Integer.parseInt(reader.readLine());
		Employee emp=empController.getEmployeeByID(id);
		System.out.println("Enter your new email:");
		email=reader.readLine();
		System.out.println("Enter your new password:");
		password=reader.readLine();
		System.out.println("Re-enter same password to confirm:");
		confirmpassword=reader.readLine();
		if(password.equals(confirmpassword)) {
			emp.setPassword(password);
			emp.setEmail(email);
			emp.setEmployeeId(id);
			empController.updateEmployee(emp);
		}
		else {
			System.out.println("Sorry! you have entered different password!");
		}
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deactiveEmployee() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmployeeId whose record you want to deactivate:");
		id=Integer.parseInt(reader.readLine());
		Employee emp=empController.getEmployeeByID(id);
		empController.deactivateEmployee(emp);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void activeEmployee() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmployeeId whose record you want to activate:");
		id=Integer.parseInt(reader.readLine());
		Employee emp=empController.getEmployeeByID(id);
		empController.activateEmployee(emp);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deleteEmployee() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmployeeId whose record you want to delete:");
		id=Integer.parseInt(reader.readLine());
		empController.deleteEmployee(id);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
}
