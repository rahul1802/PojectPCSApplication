package model;

public class EmpJob {
private int ejId;
private int employeeId;
private int jobId;
private String recruited ;
//default constructor
public EmpJob() {
	super();
	// TODO Auto-generated constructor stub
}
//prameterized constructor with field
public EmpJob(int ejId, int employeeId, int jobId, String recruited) {
	super();
	this.ejId = ejId;
	this.employeeId = employeeId;
	this.jobId = jobId;
	this.recruited = recruited;
}
//parameterized constructor without ejId
public EmpJob(int employeeId, int jobId, String recruited) {
	super();
	this.employeeId = employeeId;
	this.jobId = jobId;
	this.recruited = recruited;
}
public int getEjId() {
	return ejId;
}
public void setEjId(int ejId) {
	this.ejId = ejId;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getRecruited() {
	return recruited;
}
public void setRecruited(String recruited) {
	this.recruited = recruited;
}
@Override
public String toString() {
	return "EmpJob [ejId=" + ejId + ", employeeId=" + employeeId + ", jobId=" + jobId + ", recruited=" + recruited
			+ "]";
}


}
