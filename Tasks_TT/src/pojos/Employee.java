package pojos;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String employeeMobile;
	private String employeeEmail;
	private String employeeDepartment;
	private List<Dependent> dependents = new ArrayList<>();

	public Employee(int employeeId) {
		super();
		this.employeeId = employeeId;
	}
	
	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public Employee() {
		super();
	}

	

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	@Override
	public String toString() {
		return "Employee [Employee Id=" + employeeId + ", Employee Name=" + employeeName + ", Employee Mobile ="
				+ employeeMobile + ", Employee email=" + employeeEmail + ", Employee Department=" + employeeDepartment
				+ "]\n";
	}

}
