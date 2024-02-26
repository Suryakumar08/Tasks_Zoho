package pojos;

public class Dependent {
	private int dependentId;
	private int dependentEmpId;
	private String name;
	private int age;
	private String relationship;

	public int getDependentId() {
		return dependentId;
	}

	public Dependent(int dependentId) {
		super();
		this.dependentId = dependentId;
	}
	
	public Dependent() {
		super();
		this.dependentId = -1;
	}

	public void setDependentId(int dependentId) {
		this.dependentId = dependentId;
	}

	public int getDependentEmpId() {
		return dependentEmpId;
	}

	public void setDependentEmpId(int dependentEmpId) {
		this.dependentEmpId = dependentEmpId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	public String toString() {
		return "Dependent [Dependent Id=" + dependentId + ", Dependent Employee Id=" + dependentEmpId + ", Name=" + name
				+ ", Age=" + age + ", Relationship=" + relationship + "]";
	}
}
