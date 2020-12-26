package excDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import controller.EmpJobController;
import model.EmpJob;



public class EmpJobExec {
	EmpJobController jobController=null;
	public EmpJobExec()
	{
		jobController=new EmpJobController();
	}
	public void getAllEmpJob()
	{
		List<EmpJob> jobList=jobController.getAllEmployeesJob();
		for(EmpJob s:jobList)
		{
			System.out.println(s);
		}
	}
	public void getEmpJobById()
	{
		int id=0;
		try
		{
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the EmpJob Id whose record you want to view");
			id=Integer.parseInt(reader.readLine());
		}
		catch(IOException ex)
		{
			System.out.println(ex);
		}
		EmpJob s=jobController.getEmployeeJobByID(id);
		System.out.println(s);
	}

public void addEmpJob()
{
	EmpJob s=new EmpJob();
	try
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter EmpJob Details:");
		System.out.println("EmployeeId:");
		s.setEmployeeId(Integer.parseInt(reader.readLine()));
		System.out.println("JobID:");
		s.setJobId(Integer.parseInt(reader.readLine()));
		System.out.println("Recruited:");
		s.setRecruited(reader.readLine());
	}
	catch(IOException ex)
	{
		System.out.println(ex);
	}
	jobController.addEmployeeJob(s);
}
public void updateEmpJob() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id,jobid;
		String  rec,confirmrec;
		System.out.println("Enter EmployeeJobId whose record you want to update:");
		id=Integer.parseInt(reader.readLine());
		EmpJob job=jobController.getEmployeeJobByID(id);
		System.out.println("Enter new JobId:");
		jobid=Integer.parseInt(reader.readLine());
		System.out.println("Enter new Recruited:");
		rec=reader.readLine();
		System.out.println("Re-enter same Recruited to confirm:");
		confirmrec=reader.readLine();
		if(rec.equals(confirmrec)) {
			job.setJobId(jobid);
			job.setRecruited(rec);
			job.setEjId(id);
			jobController.updateEmployeeJob(job);
			
		}
		else {
			System.out.println("Sorry! you have entered different Name!");
		}
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deleteEmpJob() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmpJobId whose record you want to delete:");
		id=Integer.parseInt(reader.readLine());
		jobController.deleteEmployeeJob(id);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
}
