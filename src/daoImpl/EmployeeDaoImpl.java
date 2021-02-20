package daoImpl;

import dao.IEmployeeDao;
import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
public class EmployeeDaoImpl implements IEmployeeDao{

	Connection conn=null;
	public EmployeeDaoImpl()
	{
		conn=JDBCConnection.getDBConnection();
	}
	public Employee checkLogin(String userId, String password) {
		Employee emp=new Employee();
		
		try {
			String query="select * from Employee where userId=? and password=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, userId);
			pst.setString(2, password);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEmployeeId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setEmail(rst.getString(4));
					emp.setUserId(rst.getString(5));
					emp.setPassword(rst.getString(6));
					emp.setRole(rst.getString(7));
					emp.setGender(rst.getString(8));
					emp.setActive(rst.getString(9));
				}
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return emp;
	}
	public List<Employee> getAllEmployees() {
		List<Employee> empList =new ArrayList<Employee>();
		try
		{
			String query="select *from Employee";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(query);
			if(rst!=null) 
			{ 
				
				while(rst.next())
				{
					Employee emp=new Employee();
					emp.setEmployeeId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setEmail(rst.getString(4));
					emp.setUserId(rst.getString(5));
					emp.setPassword(rst.getString(6));
					emp.setRole(rst.getString(7));
					emp.setGender(rst.getString(8));
					emp.setActive(rst.getString(9));
					empList.add(emp);
				}
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return empList;
	}

	
	public void addEmployee(Employee e) {
		try {
			String query="insert into Employee(FirstName,LastName,Email,UserID,Password,Role,Gender,Active) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1,e.getFirstName());
			pst.setString(2,e.getLastName());
			pst.setString(3,e.getEmail());
			pst.setString(4,e.getUserId());
			pst.setString(5,e.getPassword());
			pst.setString(6,e.getRole());
			pst.setString(7,e.getGender());
			pst.setString(8,e.getActive());
			int i=pst.executeUpdate();
			if(i==1)
			{
				System.out.println("1.Record Inserted...");
			}
			else
			{
				System.out.println("Insertion Failed...");
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		
	}

	
	public Employee getEmployeeByID(int id) {
		Employee emp=new Employee();
		try
		{
			String query="select *from Employee where EmployeeID=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) 
			{
				
				if(rst.next())
				{
					emp.setEmployeeId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setEmail(rst.getString(4));
					emp.setUserId(rst.getString(5));
					emp.setPassword(rst.getString(6));
					emp.setRole(rst.getString(7));
					emp.setGender(rst.getString(8));
					emp.setActive(rst.getString(9));
				}
			}
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return emp;
	}

	
	public void updateEmployee(Employee e) {
		try {
			String query = "UPDATE Employee SET password=?, email=? WHERE EmployeeId=?";
		
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, e.getPassword());
			statement.setString(2, e.getEmail());
			statement.setInt(3,e.getEmployeeId());		 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}
			else {
				System.out.println("updation failed...");
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		
		
	}

	
	public void deactivateEmployee(Employee e) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where EmployeeId=?");
			pst.setString(1, "Deactive");
			pst.setInt(2, e.getEmployeeId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deactivated...");
			}
			else {
				System.out.println("Deactivation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
		
	}
	public void activateEmployee(Employee e) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where EmployeeId=?");
			pst.setString(1, "Active");
			pst.setInt(2, e.getEmployeeId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee Activated...");
			}
			else {
				System.out.println("Activation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
		
	}


	
	public void deleteEmployee(int id) {
		
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from Employee where EmployeeId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("Employee deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
	
}


