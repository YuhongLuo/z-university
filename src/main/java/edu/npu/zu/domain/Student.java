package edu.npu.zu.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	private long id;
	private Name name;
	private int age;
	
	@XmlElement(name = "enrollDate", required = true) 
	@XmlJavaTypeAdapter(DateXmlAdapter.class)
	private Date enrollDate;
	
	public Student() {
	}
	
	public Student(Student studToCopy) {
		this.id = studToCopy.id;
		this.name = studToCopy.name;
		this.age = studToCopy.age;
		this.enrollDate = studToCopy.enrollDate;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student[id: " + id + ", " + name + ", age: " + age + "]";
	}
	
	public boolean hasId(long id) {
		return this.id == id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	@Override
	public boolean equals(Object tstObj) {
		if (!(tstObj instanceof Student)) return false;
		Student tstStud = (Student) tstObj;
		
		if ((tstStud.id != id) || (name != null && !name.equals(tstStud.name)) || (tstStud.age != age)) {
			return false;
		}
		
		return true;
	}
	
}
