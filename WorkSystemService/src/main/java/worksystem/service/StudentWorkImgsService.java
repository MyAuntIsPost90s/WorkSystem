package worksystem.service;

import java.util.List;

import worksystem.base.model.Studentworkimgs;

public interface StudentWorkImgsService {

	List<Studentworkimgs> getList(Studentworkimgs studentworkimgs);
	
	void add(Studentworkimgs studentworkimgs);
	
	void deleteByStudentWorkId(Long studentWorkId);
	
	void delete(long studentWorkImgId);
}
