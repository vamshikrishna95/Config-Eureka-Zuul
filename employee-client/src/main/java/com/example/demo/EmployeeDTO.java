package com.example.demo;

public class EmployeeDTO {

	private String name;
	private String empID;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", empID=" + empID + "]";
	}

	public EmployeeDTO(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

}
