package worksystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import worksystem.base.dao.StudentworksMapper;
import worksystem.base.model.Studentworkimgs;
import worksystem.base.model.Studentworks;
import worksystem.base.model.dto.StudentWorksDto;
import worksystem.service.StudentWorkImgsService;
import worksystem.service.StudentWorksService;
import worksystem.uimodel.EUIPageList;

@Service
public class StudentWorksServiceImpl implements StudentWorksService {

	@Resource
	private StudentworksMapper studentworksMapper;
	@Resource
	private StudentWorkImgsService studentWorkImgsService;

	@Override
	public EUIPageList<Studentworks> getList(Studentworks studentworks, int type, int page, int rows) {
		PageList<Studentworks> pageList = studentworksMapper.getListWithType(studentworks, type,
				new PageBounds(page, rows));
		return new EUIPageList<Studentworks>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public Studentworks getSingle(Long studentWorkId) {
		StudentWorksDto studentworks = (StudentWorksDto) studentworksMapper.getSingle(studentWorkId);
		// 获取图片
		Studentworkimgs studentworkimgs = new Studentworkimgs();
		studentworkimgs.setStudentworkid(studentWorkId);
		List<Studentworkimgs> list = studentWorkImgsService.getList(studentworkimgs);
		studentworks.setStudentworkimgs(list);
		return studentworks;
	}

	@Override
	public Studentworks getSingleByWorkId(Long studentId, Long workId) {
		Studentworks studentWork = new Studentworks();
		studentWork.setStudentid(studentId);
		studentWork.setWorkid(workId);
		List<Studentworks> list = studentworksMapper.getListWithPage(studentWork, new PageBounds(1, 1));
		if (list == null || list.isEmpty()) {
			return null;
		}

		StudentWorksDto studentworks = (StudentWorksDto) list.get(0);
		// 获取图片
		Studentworkimgs studentworkimgs = new Studentworkimgs();
		studentworkimgs.setStudentworkid(studentworks.getStudentworkid());
		List<Studentworkimgs> imgs = studentWorkImgsService.getList(studentworkimgs);
		studentworks.setStudentworkimgs(imgs);
		return studentworks;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void add(StudentWorksDto studentWorksDto) throws Exception {
		studentworksMapper.insert(studentWorksDto);
		saveStudentWorkImgs(studentWorksDto);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void update(StudentWorksDto studentWorksDto) {
		studentworksMapper.update(studentWorksDto);
	}
	
	@Override
	public void updateWorkAndImg(StudentWorksDto studentWorksDto) {
		saveStudentWorkImgs(studentWorksDto);
		studentworksMapper.update(studentWorksDto);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		studentworksMapper.batchDelete(ids);
	}

	private void saveStudentWorkImgs(StudentWorksDto studentWorksDto) {
		// 保存图片记录
		studentWorkImgsService.deleteByStudentWorkId(studentWorksDto.getStudentworkid());
		for (Studentworkimgs studentworkimgs : studentWorksDto.getStudentworkimgs()) {
			studentworkimgs.setStudentworkid(studentWorksDto.getStudentworkid());
			studentWorkImgsService.add(studentworkimgs);
		}
	}

	@Override
	public boolean exist(Studentworks studentworks) {
		return studentworksMapper.count(studentworks) > 0;
	}
}
