package tasks;

import java.util.List;

import exception.CustomException;
import pojos.Employee;

public interface Persistence {
	public boolean createEmployeeStorage()throws CustomException;
	public boolean addEmployee(Employee employee)throws CustomException;
	public List<Employee> getEmployeeDetails(String employeeName)throws CustomException;
	public boolean updateEmployee(String empId, String newEmail)throws CustomException;
	public List<Employee> getNEmployeeDetails(int number, int order)throws CustomException;  //0 -> any order.. 1 -> asc..  2 -> desc
	public boolean deleteEmployee(String empId)throws CustomException;
}
