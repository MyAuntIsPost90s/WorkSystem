package worksystem.base.model.dto;

import worksystem.base.model.Teachers;
import worksystem.base.model.Works;

public class WorksDto extends Works {
	private Teachers teachers;

	public Teachers getTeachers() {
		return teachers;
	}

	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}
}
