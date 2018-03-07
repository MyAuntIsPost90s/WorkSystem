package worksystem.base.model.dto;

import worksystem.base.model.Questions;
import worksystem.base.model.Students;
import worksystem.base.model.Teachers;

public class QuestionsDto extends Questions {
	private Students students;
	private Teachers teachers;

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
}
