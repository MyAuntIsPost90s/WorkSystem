package worksystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import worksystem.base.dao.TeacherclassesMapper;
import worksystem.base.model.Teacherclasses;
import worksystem.base.model.dto.TeacherClassesDto;
import worksystem.service.TeacherClassesService;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;
import worksystem.util.RandomNum;

@Service
public class TeacherClassesServiceImpl implements TeacherClassesService {

	@Resource
	private TeacherclassesMapper teacherClassesMapper;

	@Override
	public EUIPageList<TeacherClassesDto> getList(Teacherclasses teacherclasses, int page, int rows) {
		PageList<TeacherClassesDto> pageList = teacherClassesMapper.getTeacherclasses(teacherclasses,
				new PageBounds(page, rows));
		return new EUIPageList<TeacherClassesDto>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Teacherclasses teacherclasses) throws Exception {
		if (teacherClassesMapper.count(teacherclasses) > 0) {
			return;
		}
		teacherclasses.setTeacherclassid(RandomNum.getLGID());
		teacherClassesMapper.insert(teacherclasses);
	}

	@Override
	public void batchDelete(List<String> ids) {
		teacherClassesMapper.batchDelete(ids);
	}

	@Override
	public List<EUITree> getTree(Teacherclasses teacherclasses) {
		PageList<TeacherClassesDto> list = teacherClassesMapper.getTeacherclasses(teacherclasses,
				new PageBounds(1, 9999));
		EUITree root = new EUITree();
		root.setId("-1");
		root.setText("我的班级");
		root.setChildren(new ArrayList<EUITree>());

		for (TeacherClassesDto teacherClassesDto : list) {
			if (teacherClassesDto.getStudentclass() == null) {
				continue;
			}
			root.getChildren().add(new EUITree(teacherClassesDto.getStudentclass().getStudentclassid().toString(),
					teacherClassesDto.getStudentclass().getStudentclassname()));
		}

		List<EUITree> trees = new ArrayList<EUITree>();
		trees.add(root);
		return trees;
	}

}
