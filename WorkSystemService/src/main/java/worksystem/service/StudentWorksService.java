package worksystem.service;

import java.util.List;

import worksystem.base.model.Studentworks;
import worksystem.base.model.dto.StudentWorksDto;
import worksystem.uimodel.EUIPageList;

public interface StudentWorksService {

	/**
	 * 获取学生提交作业列表
	 * 
	 * @param students
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<Studentworks> getList(Studentworks studentworks, int type, int page, int rows);

	/**
	 * 获取单个作业信息
	 * 
	 * @param studentId
	 * @return
	 */
	Studentworks getSingle(Long studentWorkId);
	
	/**
	 * 通过workId和studentId获取学生提交的作业
	 * 
	 * @param studentId
	 * @param workId
	 * @return
	 */
	Studentworks getSingleByWorkId(Long studentId,Long workId);

	/**
	 * 提交作业
	 * 
	 * @param students
	 */
	void add(StudentWorksDto studentWorksDto) throws Exception;

	/**
	 * 修改作业(包括修改照片)
	 * 
	 * @param students
	 */
	void updateWorkAndImg(StudentWorksDto studentWorksDto);
	
	/**
	 * 修改作业
	 * 
	 * @param students
	 */
	void update(StudentWorksDto studentWorksDto);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void batchDelete(List<Long> ids);

	/**
	 * 判断用户是否提交过作业
	 * 
	 * @param studentworks
	 * @return
	 */
	boolean exist(Studentworks studentworks);
}
