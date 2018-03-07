package worksystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import worksystem.base.dao.WorksMapper;
import worksystem.base.model.Studentworks;
import worksystem.base.model.Works;
import worksystem.base.model.dto.WorksDto;
import worksystem.dto.WorksTeacherDto;
import worksystem.service.StudentWorksService;
import worksystem.service.WorksService;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;

@Service
public class WorkServiceImpl implements WorksService {

	@Resource
	private WorksMapper worksMapper;
	@Resource
	private StudentWorksService studentWorksService;

	@Override
	public EUIPageList<Works> getList(Long studentclassid, int type, long studentid, int page, int rows) {
		PageList<Works> pageList = worksMapper.getListWithType(type, studentclassid, new PageBounds(page, rows));
		// 给一个标志判断是否交过作业
		PageList<Works> result = new PageList<Works>(pageList.getPaginator());
		for (Works works : pageList) {
			WorksTeacherDto worksTeacherDto = new WorksTeacherDto();
			worksTeacherDto.setStudentclassid(works.getStudentclassid());
			worksTeacherDto.setTeacherid(works.getTeacherid());
			worksTeacherDto.setTeachers(((WorksDto) works).getTeachers());
			worksTeacherDto.setWorkcommittime(works.getWorkcommittime());
			worksTeacherDto.setWorkcreatetime(works.getWorkcreatetime());
			worksTeacherDto.setWorkdesc(works.getWorkdesc());
			worksTeacherDto.setWorkid(works.getWorkid());
			worksTeacherDto.setWorkurl(works.getWorkurl());

			Studentworks studentworks = studentWorksService.getSingleByWorkId(studentid, works.getWorkid());
			worksTeacherDto.setSubmited(false);
			worksTeacherDto.setRevised(false);
			if (studentworks != null) {
				worksTeacherDto.setSubmited(true);
			}
			if (studentworks != null && studentworks.getWorkscore() != null) {
				worksTeacherDto.setRevised(true);
			}
			result.add(worksTeacherDto);
		}

		return new EUIPageList<Works>(result.getPaginator().getTotalCount(), result);
	}

	@Override
	public List<EUITree> getTree(Works works) {
		List<Works> list = worksMapper.getList(works);
		EUITree root = new EUITree();
		root.setId("-1");
		root.setText("作业");
		root.setChildren(new ArrayList<EUITree>());

		for (Works item : list) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(item.getWorkcommittime());
			int weeknum = calendar.get(Calendar.DAY_OF_WEEK) - 1;
			String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
			String text = String.format("%s(%s)", format.format(item.getWorkcommittime()), weekDays[weeknum]); // 组成格式
																												// （年月日(星期)）
			root.getChildren().add(new EUITree(item.getWorkid().toString(), text));
		}

		List<EUITree> trees = new ArrayList<EUITree>();
		trees.add(root);
		return trees;
	}

	@Override
	public Works getSingle(Long workId) {
		return worksMapper.getSingle(workId);
	}

	@Override
	public void add(Works works) {
		works.setWorkcreatetime(new Date());
		worksMapper.insert(works);
	}

	@Override
	public void update(Works works) {
		worksMapper.update(works);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		worksMapper.batchDelete(ids);
	}
}
