package worksystem.base.model.dto;

import worksystem.base.model.Studentclass;
import worksystem.base.model.Teacherclasses;

public class TeacherClassesDto extends Teacherclasses {

	private Studentclass studentclass;

	public Studentclass getStudentclass() {
		return studentclass;
	}

	public void setStudentclass(Studentclass studentclass) {
		this.studentclass = studentclass;
	}
}
