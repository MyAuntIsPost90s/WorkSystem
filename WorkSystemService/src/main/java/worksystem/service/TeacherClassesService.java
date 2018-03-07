package worksystem.service;

import java.util.List;

import worksystem.base.model.Teacherclasses;
import worksystem.base.model.dto.TeacherClassesDto;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;

public interface TeacherClassesService {
	
	List<EUITree> getTree(Teacherclasses teacherclasses);

	EUIPageList<TeacherClassesDto> getList(Teacherclasses teacherclasses,int page,int rows);
	
	void add(Teacherclasses teacherclasses) throws Exception ;
	
	void batchDelete(List<String> ids);
}
