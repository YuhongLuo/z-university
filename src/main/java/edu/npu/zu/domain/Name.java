package edu.npu.zu.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "name")
@XmlAccessorType(XmlAccessType.FIELD)
public class Name {
	private String lastName;
	private String firstName;
	
	public Name() {
	}
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "Name[" + "lastName: " + lastName + ", firstName: " + firstName + "]";
	}
	
	@Override
	public boolean equals(Object tstObj) {
		if (!(tstObj instanceof Name)) return false;
		Name tstName = (Name) tstObj;
		
		if ((firstName != null && !firstName.equals(tstName.firstName)) || (lastName != null && !lastName.equals(tstName.lastName))) {
			return false;
		}
		
		return true;
	}

}
