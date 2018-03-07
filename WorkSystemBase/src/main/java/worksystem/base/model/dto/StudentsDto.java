package worksystem.base.model.dto;

import worksystem.base.model.Students;

public class StudentsDto extends Students {
	private String studentclassname;

	public String getStudentclassname() {
		return studentclassname;
	}

	public void setStudentclassname(String studentclassname) {
		this.studentclassname = studentclassname;
	}
}
