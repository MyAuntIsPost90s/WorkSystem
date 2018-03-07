package worksystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import worksystem.base.dao.TeachersMapper;
import worksystem.base.model.Students;
import worksystem.base.model.Teachers;
import worksystem.service.StudentsService;
import worksystem.service.TeachersService;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;

@Service
public class TeachersServiceImpl implements TeachersService {

	@Resource
	private TeachersMapper teachersMapper;
	@Resource
	private StudentsService studentsService;

	@Override
	public EUIPageList<Teachers> getList(Teachers teachers, int page, int rows) {
		PageList<Teachers> pageList = teachersMapper.getListWithPage(teachers, new PageBounds(page, rows));
		return new EUIPageList<Teachers>(pageList.getPaginator().getTotalCount(), pageList);
	}
	
	@Override
	public List<EUITree> getTree(Teachers teachers) {
		List<Teachers> list = teachersMapper.getList(teachers);
		EUITree root = new EUITree();
		root.setId("-1");
		root.setText("我的老师");
		root.setChildren(new ArrayList<EUITree>());

		for (Teachers item : list) {
			root.getChildren().add(new EUITree(item.getTeacherid().toString(),item.getTeachername()));
		}

		List<EUITree> trees = new ArrayList<EUITree>();
		trees.add(root);
		return trees;
	}

	@Override
	public Teachers getSingle(Long teacherId) {
		return teachersMapper.getSingle(teacherId);
	}

	@Override
	public void add(Teachers teachers) throws Exception {
		Teachers condition = new Teachers();
		condition.setTeacheridcard(teachers.getTeacheridcard());
		Students students = new Students();
		students.setStudentidcard(teachers.getTeacheridcard());
		boolean exist = (exist(condition) || studentsService.exist(students));
		if (exist) {
			throw new Exception("证件号已经存在");
		}
		teachersMapper.insert(teachers);
	}

	@Override
	public void update(Teachers teachers) {
		teachersMapper.update(teachers);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		teachersMapper.batchDelete(ids);
	}

	@Override
	public boolean exist(Teachers teachers) {
		Teachers condition = new Teachers();
		condition.setTeacheridcard(teachers.getTeacheridcard());
		return teachersMapper.count(condition) > 0;
	}
}
