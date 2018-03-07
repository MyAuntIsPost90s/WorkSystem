package worksystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import worksystem.base.dao.StudentworkimgsMapper;
import worksystem.base.model.Studentworkimgs;
import worksystem.service.StudentWorkImgsService;

@Service
public class StudentWorkImgsServiceImpl implements StudentWorkImgsService {
	
	@Resource
	private StudentworkimgsMapper studentworkimgsMapper;

	@Override
	public List<Studentworkimgs> getList(Studentworkimgs studentworkimgs) {
		return studentworkimgsMapper.getList(studentworkimgs);
	}

	@Override
	public void add(Studentworkimgs studentworkimgs) {
		studentworkimgsMapper.insert(studentworkimgs);
	}

	@Override
	public void deleteByStudentWorkId(Long studentWorkId) {
		studentworkimgsMapper.deleteByStudentWorkId(studentWorkId);
	}

	@Override
	public void delete(long studentWorkImgId) {
		List<Long> ids=new ArrayList<Long>();
		ids.add(studentWorkImgId);
		studentworkimgsMapper.batchDelete(ids);
	}
	
}
