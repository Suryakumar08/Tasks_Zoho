package pojos;

public class Customer {
	private String customerName;
	private int customerNumber;
	
	
	public Customer() {
		
	}
	
	public Customer(String customerName, int customerNumber) {
		setCustomerName(customerName);
		setCustomerNumber(customerNumber);
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerNumber=" + customerNumber + "]";
	}
	
	
	
}
