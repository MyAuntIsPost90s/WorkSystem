package worksystem.service;

import java.util.List;

import worksystem.base.model.Studentclass;
import worksystem.uimodel.EUIPageList;

public interface StudentClassesService {
	
	EUIPageList<Studentclass> getList(Studentclass studentclass, int page, int rows);
	
	Studentclass getSingle(Long studentClassId);
	
	void add(Studentclass studentclass);
	
	void update(Studentclass studentclass);
	
	void batchDelete(List<Long> ids);
	
}
