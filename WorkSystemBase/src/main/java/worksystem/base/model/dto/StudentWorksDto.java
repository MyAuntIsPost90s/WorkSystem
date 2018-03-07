package worksystem.base.model.dto;

import java.util.List;

import worksystem.base.model.Students;
import worksystem.base.model.Studentworkimgs;
import worksystem.base.model.Studentworks;
import worksystem.base.model.Teachers;

public class StudentWorksDto extends Studentworks {
	private Students students;
	private Teachers teachers;
	private List<Studentworkimgs> studentworkimgs;

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public List<Studentworkimgs> getStudentworkimgs() {
		return studentworkimgs;
	}

	public void setStudentworkimgs(List<Studentworkimgs> studentworkimgs) {
		this.studentworkimgs = studentworkimgs;
	}

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

}
