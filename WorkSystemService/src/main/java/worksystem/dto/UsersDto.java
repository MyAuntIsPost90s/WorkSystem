package worksystem.dto;

import worksystem.base.model.Students;
import worksystem.base.model.Teachers;

public class UsersDto {

	private Students students;
	private Teachers teachers;
	private Boolean rootpower;

	public Students getStudents() {
		return students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}

	public Boolean getRootpower() {
		return rootpower;
	}

	public void setRootpower(Boolean rootpower) {
		this.rootpower = rootpower;
	}
}
