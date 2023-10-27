package com.myco.helloworld.backend.model;

public class RemoteGreeting {
	private String generalGreeting="Hello Everybody";
	//private String name;
	//private String designation;
	//private double salary;

	public RemoteGreeting() {
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getDesignation() {
//		return designation;
//	}
//
//	public void setDesignation(String designation) {
//		this.designation = designation;
//	}
//
//	public double getSalary() {
//		return salary;
//	}
//
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}

	public String getGeneralGreeting() {
		return generalGreeting;
	}

	public void setGeneralGreeting(String generalGreeting) {
		this.generalGreeting = generalGreeting;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generalGreeting == null) ? 0 : generalGreeting.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RemoteGreeting other = (RemoteGreeting) obj;
//		if (designation == null) {
//			if (other.designation != null)
//				return false;
//		} else if (!designation.equals(other.designation))
//			return false;
		if (generalGreeting == null) {
			if (other.generalGreeting != null)
				return false;
				} else if (!generalGreeting.equals(other.generalGreeting))
			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
//			return false;
		return true;
	}

}
