package worksystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import worksystem.base.dao.StudentsMapper;
import worksystem.base.model.Students;
import worksystem.base.model.Teachers;
import worksystem.service.StudentsService;
import worksystem.service.TeachersService;
import worksystem.uimodel.EUIPageList;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Resource
	private StudentsMapper studentsMapper;
	@Resource
	private TeachersService teachersService;

	@Override
	public EUIPageList<Students> getList(Students students, int page, int rows) {
		PageList<Students> pageList = studentsMapper.getListWithPage(students, new PageBounds(page, rows));
		return new EUIPageList<Students>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public Students getSingle(Long studentId) {
		return studentsMapper.getSingle(studentId);
	}

	@Override
	public void add(Students students) throws Exception {
		Teachers teachers = new Teachers();
		teachers.setTeacheridcard(students.getStudentidcard());
		Students condition = new Students();
		condition.setStudentidcard(students.getStudentidcard());
		boolean exist = (exist(condition) || teachersService.exist(teachers));
		if (exist) {
			throw new Exception("证件号已经存在");
		}
		studentsMapper.insert(students);
	}

	@Override
	public void update(Students students) {
		studentsMapper.update(students);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		studentsMapper.batchDelete(ids);
	}

	@Override
	public boolean exist(Students students) {
		return studentsMapper.count(students) > 0;
	}

}
