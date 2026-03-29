package edu.npu.zu.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "studentList")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "student")
	@JsonProperty("student")
	private List<Student> studentList;

	public StudentList() {
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public int numEntries() {
		if (studentList == null) return 0;
		return studentList.size();
	}
	
	public Student getStudent(int idx) {
		return studentList.get(idx);
	}
	
	@Override
	public String toString() {
		if (studentList == null) return "StudentList{empty}";
		StringBuilder listStr = new StringBuilder("StudentList{");
		for (Student entry: studentList) {
			listStr.append("\n\t").append(entry);
		}
		listStr.append("\n}");
		return listStr.toString();
	}
}