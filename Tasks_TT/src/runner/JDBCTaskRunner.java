package runner;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.CustomException;
import pojos.Dependent;
import pojos.Employee;
import tasks.JDBCTask;
import utility.CustomLogFormatter;
import utility.Utility;

public class JDBCTaskRunner {
	private static Logger logger = Logger.getLogger(JDBCTaskRunner.class.toString());
	

	public static void setLoggerOps() {
		logger.setLevel(Level.ALL);
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new CustomLogFormatter());
		logger.addHandler(consoleHandler);
		logger.setUseParentHandlers(false);
	}

	
	public static void main(String[] args) {
		setLoggerOps();
		JDBCTask task = new JDBCTask();
		try {
			task.enableConnection("IncubationDB");
			logger.info("Connection enabled!!!");
		} catch (CustomException e) {
			logger.log(Level.SEVERE, "Exception occurred : ", e);
		}
		boolean continueProgram = true;
		try (Scanner sc = new Scanner(System.in)) {
			while (continueProgram) {

				logger.info("Enter your choice : ");
				int choice = Utility.getIntInput();
				switch (choice) {
				case 1: {
					logger.info("Creating Employee Table...");
					boolean isCreated = task.createEmployeeStorage();
					if (isCreated) {
						logger.info("Employee table created successfully");
					} else {
						logger.info("Table not created...");
					}
					break;
				}
				case 2: {
					logger.info("Add record into table...");
					logger.info("Enter employee name : ");
					String name = sc.nextLine();
					logger.info("Enter employee mobile : ");
					String mobile = sc.nextLine();
					logger.info("Enter employee mail : ");
					String mail = sc.nextLine();
					logger.info("Enter employee department : ");
					String dept = sc.nextLine();

					Employee employee = new Employee();
					employee.setEmployeeName(name);
					employee.setEmployeeMobile(mobile);
					employee.setEmployeeEmail(mail);
					employee.setEmployeeDepartment(dept);
					boolean isAdded = task.addEmployee(employee);
					if (isAdded) {
						logger.info("Employee added successfully...");
						break;
					}
				}
				case 3: {
					logger.info("Enter employee name to get details : ");
					String name = sc.nextLine();
					List<Employee> employeeDetails = task.getEmployeeDetails(name);
					for (Employee details : employeeDetails) {
						logger.info(details.toString());
					}
					break;
				}
				case 4: {
					logger.info("Change email address...");
					logger.info("Enter Employee ID : ");
					int empId = Utility.getIntInput();
					logger.info("Enter modified Email : ");
					String newEmail = sc.nextLine();
					task.updateEmail(empId, newEmail);
					logger.info("Employee status updated successfully!");
					break;
				}
				case 5: {
					logger.info("Get first N employees...");
					logger.info("Enter no of employees");
					int noOfEmployees = Utility.getIntInput();
					List<Employee> employees = task.getNEmployeeDetails(noOfEmployees, 0);
					for (Employee employee : employees) {
						logger.info(employee.toString());
					}
					break;
				}
				case 6: {
					logger.info("Get first N employees...");
					logger.info("Enter no of employees");
					int noOfEmployees = Utility.getIntInput();
					List<Employee> employees = task.getNEmployeeDetails(noOfEmployees, 1);
					for (Employee employee : employees) {
						logger.info(employee.toString());
					}
					break;
				}
				case 7: {
					logger.info("Enter employeeId to delete employee");
					int empId = Utility.getIntInput();
					task.deleteEmployee(empId);
					logger.info("Employee data deleted successfully...");
					break;
				}
				case 8: {
					logger.info("Creating dependent table...");
					task.createDependent();
					logger.info("Dependent table created successfully!!!");
					break;
				}
				case 9: {
					logger.info("Insert dependent for employees...");
					logger.info("Enter employee Id : ");
					int empId = Utility.getIntInput();
					logger.info("Enter dependent name : ");
					String dependentName = sc.nextLine();
					logger.info("Enter dependent age : ");
					int age = Utility.getIntInput();
					logger.info("Enter dependent relationship with employee : ");
					String relationship = sc.nextLine();

					Dependent dependent = new Dependent();
					dependent.setDependentEmpId(empId);
					dependent.setName(dependentName);
					dependent.setAge(age);
					dependent.setRelationship(relationship);

					task.addDependent(dependent);
					logger.info("Dependent added successfully!!!");
					break;
				}
				case 10: {
					logger.info("Given employees dependent details...");
					logger.info("Enter employee id : ");
					int empId = Utility.getIntInput();
					Employee employee = task.getAllDependents(empId);
					logger.info("Employee Name : " + employee.getEmployeeName() + "\nEmployee Id : " + employee.getEmployeeId());
					for (Dependent dependent : employee.getDependents()) {
						logger.info(dependent.toString());
					}
					break;
				}
				case 11: {
					logger.info("Listing all dependents of N employees...");
					logger.info("Enter no Of employees...");
					int noOfEmployees = Utility.getIntInput();
					Map<Integer, List<Dependent>> allDependents = task.getDependentsOfNEmployees(noOfEmployees);
					for (Map.Entry<Integer, List<Dependent>> el : allDependents.entrySet()) {
						logger.info("Employee Id : " + el.getKey());
						for(Dependent dependent : el.getValue()) {
							logger.info(dependent.toString());
						}
					}
					break;
				}
				default: {
					continueProgram = false;
					task.disableConnection();
					logger.info("Connection disabled...");
					logger.info("Task Completed!!!");
					break;
				}
				}
			}
		} catch (CustomException ex) {
			ex.printStackTrace();
			continueProgram = false;
			logger.log(Level.WARNING, "Exception occurred : " + ex.getMessage() + " " + ex.getCause(), ex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			continueProgram = false;
			logger.log(Level.SEVERE, "Exception occurred : " + e.getMessage() + " " + e.getCause(), e.getMessage());
		}
	}
}
