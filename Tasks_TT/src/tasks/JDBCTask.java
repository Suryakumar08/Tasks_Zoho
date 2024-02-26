package tasks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.CustomException;
import helper.JDBCTaskHelper;
import pojos.Dependent;
import pojos.Employee;
import validators.Validators;

public class JDBCTask {

	public void enableConnection(String dbName) throws CustomException {
		JDBCTaskHelper.enableConnection(dbName);
	}

	public boolean createEmployeeStorage() throws CustomException {
		Connection connection = JDBCTaskHelper.getSqlConnection();
		try (Statement statement = connection.createStatement()) {
			String query = "create table if not exists Employee (employeeId int auto_increment, name varchar(45) NOT NULL, mobile varchar(20) NOT NULL, email varchar(45) NOT NULL, department varchar(20) NOT NULL, PRIMARY KEY (employeeId))";
			int noOfRowsAffected = statement.executeUpdate(query);
			return noOfRowsAffected == 0;
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public boolean addEmployee(Employee employee) throws CustomException {
		Validators.isNullInput(employee);
		try {
			Connection connection = JDBCTaskHelper.getSqlConnection();
			String statement = "insert into Employee(name, mobile, email, department) values(?,?,?,?)";
			try (PreparedStatement query = connection.prepareStatement(statement)) {
				query.setString(1, employee.getEmployeeName());
				query.setString(2, employee.getEmployeeMobile());
				query.setString(3, employee.getEmployeeEmail());
				query.setString(4, employee.getEmployeeDepartment());

				int isAdded = query.executeUpdate();
				return isAdded == 1;
			}
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public Employee getEmployeeFromId(int empId) throws CustomException {
		try {
			Connection connection = JDBCTaskHelper.getSqlConnection();
			Employee employee = null;
			String query = "select * from Employee where employeeId = ?";

			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, empId);
				try (ResultSet employeeSet = statement.executeQuery()) {
					if (employeeSet.next()) {
						employee = new Employee(employeeSet.getInt(1));
						employee.setEmployeeName(employeeSet.getString(2));
						employee.setEmployeeEmail(employeeSet.getString(3));
						employee.setEmployeeMobile(employeeSet.getString(4));
						employee.setEmployeeDepartment(employeeSet.getString(5));
					}
					return employee;
				}
			}
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public List<Employee> getEmployeeDetails(String employeeName) throws CustomException {
		try {
			List<Employee> employeeDetails = new ArrayList<>();
			Connection connection = JDBCTaskHelper.getSqlConnection();
			String query = "select * from Employee where name = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, employeeName);
				try (ResultSet employeeSet = statement.executeQuery()) {
					while (employeeSet.next()) {
						Employee currEmployee = new Employee(employeeSet.getInt(1));
						currEmployee.setEmployeeName(employeeSet.getString(2));
						currEmployee.setEmployeeEmail(employeeSet.getString(3));
						currEmployee.setEmployeeMobile(employeeSet.getString(4));
						currEmployee.setEmployeeDepartment(employeeSet.getString(5));
						employeeDetails.add(currEmployee);
					}
					return employeeDetails;
				}
			}
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public boolean updateEmail(int empId, String newEmail) throws CustomException {
		return updateEmployee(empId, "email", newEmail);
	}

	public boolean updateEmployee(int empId, String fieldToUpdate, String updation) throws CustomException {
		Connection connection = JDBCTaskHelper.getSqlConnection();
		String query = "update Employee set " + fieldToUpdate + " = ? where employeeId = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, updation);
			statement.setInt(2, empId);
			int isUpdated = statement.executeUpdate();
			return isUpdated == 1;
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public List<Employee> getNEmployeeDetails(int number, int order) throws CustomException {
		try {
			List<Employee> employeeDetails = new ArrayList<>();
			Connection connection = JDBCTaskHelper.getSqlConnection();
			String query;
			if (order == 0) {
				query = "select * from Employee limit ?";
			} else if (order == 1) {
				query = "select * from Employee order by name limit ?";
			} else {
				query = "select * from Employee  order by name DESC limit ?";
			}
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, number);
				try (ResultSet employeeSet = statement.executeQuery()) {
					while (employeeSet.next()) {
						Employee currEmployee = new Employee(employeeSet.getInt(1));
						currEmployee.setEmployeeName(employeeSet.getString(2));
						currEmployee.setEmployeeEmail(employeeSet.getString(3));
						currEmployee.setEmployeeMobile(employeeSet.getString(4));
						currEmployee.setEmployeeDepartment(employeeSet.getString(5));
						employeeDetails.add(currEmployee);
					}
					return employeeDetails;
				}
			}
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public boolean deleteEmployee(int empId) throws CustomException {
		Connection connection = JDBCTaskHelper.getSqlConnection();
		String query = "delete from Employee where employeeId = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, empId);
			int isDeleted = statement.executeUpdate();
			return isDeleted == 1;
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public boolean createDependent() throws CustomException {
		Connection connection = JDBCTaskHelper.getSqlConnection();
		try (Statement statement = connection.createStatement()) {
			String query = "create table if not exists Dependent (dependentId int auto_increment, dependentEmpId int NOT NULL, name varchar(45) NOT NULL, age int NOT NULL, relationship varchar(20) NOT NULL, PRIMARY KEY (dependentId), FOREIGN KEY (dependentEmpId) REFERENCES Employee(employeeId) ON UPDATE CASCADE ON DELETE CASCADE)";
			int noOfRowsAffected = statement.executeUpdate(query);
			return noOfRowsAffected == 0;
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public boolean addDependent(Dependent dependent) throws CustomException {
		Validators.isNullInput(dependent);
		try {
			Connection connection = JDBCTaskHelper.getSqlConnection();
			String query = "insert into Dependent(dependentEmpId, name, age, relationship) values(?,?,?,?)";
			if (connection == null) {
				throw new CustomException(CustomException.NULL_MESSAGE);
			}
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, dependent.getDependentEmpId());
				statement.setString(2, dependent.getName());
				statement.setInt(3, dependent.getAge());
				statement.setString(4, dependent.getRelationship());

				int isAdded = statement.executeUpdate();
				return isAdded == 1;
			}
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public Employee getAllDependents(int empId) throws CustomException {
		try {
			Connection connection = JDBCTaskHelper.getSqlConnection();
			String query = "select e.employeeId, e.name, e.mobile, e.email, e.department, d.dependentId, d.name, d.age, d.relationship from Employee e left join Dependent d on e.employeeId = d.dependentEmpId where e.employeeId = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, empId);
				try (ResultSet dependentSet = statement.executeQuery()) {
					Employee employee = null;

					while (dependentSet.next()) {

						int employeeId = dependentSet.getInt(1);

						if (employee == null) {

							String employeeName = dependentSet.getString(2);
							String employeeMobile = dependentSet.getString(3);
							String employeeEmail = dependentSet.getString(4);
							String department = dependentSet.getString(5);

							employee = new Employee(employeeId);
							employee.setEmployeeName(employeeName);
							employee.setEmployeeMobile(employeeMobile);
							employee.setEmployeeEmail(employeeEmail);
							employee.setEmployeeDepartment(department);
						}

						int dependentId = dependentSet.getInt(6);
						String dependentName = dependentSet.getString(7);
						int dependentAge = dependentSet.getInt(8);
						String relationship = dependentSet.getString(9);

						Dependent currDependent = new Dependent(dependentId);
						currDependent.setDependentEmpId(empId);
						currDependent.setName(dependentName);
						currDependent.setAge(dependentAge);
						currDependent.setRelationship(relationship);

						employee.getDependents().add(currDependent);
					}
					return employee;
				}
			}
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public StringBuilder getEmployeeIds(int limit) throws CustomException {
		StringBuilder ids = new StringBuilder();
		Connection connection = JDBCTaskHelper.getSqlConnection();
		String query = "select employeeId from Employee limit ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, limit);
			try (ResultSet idSet = statement.executeQuery()) {
				ids.append('(');
				while (idSet.next()) {
					ids.append(idSet.getInt(1));
					ids.append(',');
				}
				ids.deleteCharAt(ids.length() - 1);
				ids.append(')');
				return ids;
			}
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public Map<Integer, List<Dependent>> getDependentsOfNEmployees(int noOfEmployees) throws CustomException {
		try {
			Map<Integer, List<Dependent>> dependentMap = new HashMap<>();
			Connection connection = JDBCTaskHelper.getSqlConnection();
			StringBuilder empIds = getEmployeeIds(noOfEmployees);
			String query = "select d.dependentEmpId, d.dependentId, d.name, d.age, d.relationship from Dependent d where d.dependentEmpId in "
					+ empIds + " order by d.name";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet resultSet = statement.executeQuery(query)) {
					while (resultSet.next()) {

						int empId = resultSet.getInt(1);
						int dependentId = resultSet.getInt(2);
						String name = resultSet.getString(3);
						int age = resultSet.getInt(4);
						String relationship = resultSet.getString(5);
						List<Dependent> temp = dependentMap.get(empId);
						if (temp == null) {
							temp = new ArrayList<Dependent>();
							dependentMap.put(empId, temp);
						}

						Dependent currDependent = new Dependent(dependentId);
						currDependent.setDependentEmpId(empId);
						currDependent.setName(name);
						currDependent.setAge(age);
						currDependent.setRelationship(relationship);

						temp.add(currDependent);
					}
					return dependentMap;
				}
			}
		} catch (SQLException e) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
		}
	}

	public void disableConnection() throws CustomException {
		JDBCTaskHelper.disableConnection();
	}

}
