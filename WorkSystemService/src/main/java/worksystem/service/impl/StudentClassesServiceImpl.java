package worksystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import worksystem.base.dao.StudentclassMapper;
import worksystem.base.model.Studentclass;
import worksystem.service.StudentClassesService;
import worksystem.uimodel.EUIPageList;

@Service
public class StudentClassesServiceImpl implements StudentClassesService {

	@Resource
	private StudentclassMapper studentclassMapper;
	
	@Override
	public EUIPageList<Studentclass> getList(Studentclass studentclass, int page, int rows) {
		PageList<Studentclass> pageList = studentclassMapper.getListWithPage(studentclass, new PageBounds(page,rows));
		return new EUIPageList<Studentclass>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public Studentclass getSingle(Long studentClassId) {
		return studentclassMapper.getSingle(studentClassId);
	}

	@Override
	public void add(Studentclass studentclass) {
		studentclassMapper.insert(studentclass);
	}

	@Override
	public void update(Studentclass studentclass) {
		studentclassMapper.update(studentclass);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		studentclassMapper.batchDelete(ids);
	}

}
