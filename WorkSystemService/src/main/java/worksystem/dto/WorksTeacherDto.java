package worksystem.dto;

import worksystem.base.model.dto.WorksDto;

public class WorksTeacherDto extends WorksDto {
	private Boolean submited;
	private Boolean revised;

	public Boolean getSubmited() {
		return submited;
	}

	public void setSubmited(Boolean submited) {
		this.submited = submited;
	}

	public Boolean getRevised() {
		return revised;
	}

	public void setRevised(Boolean revised) {
		this.revised = revised;
	}
}
