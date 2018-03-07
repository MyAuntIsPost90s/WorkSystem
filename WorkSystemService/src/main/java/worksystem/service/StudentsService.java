package worksystem.service;

import java.util.List;

import worksystem.base.model.Students;
import worksystem.uimodel.EUIPageList;

public interface StudentsService {

	/**
	 * 获取学生列表
	 * 
	 * @param students
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<Students> getList(Students students, int page, int rows);

	/**
	 * 获取单个学生
	 * 
	 * @param studentId
	 * @return
	 */
	Students getSingle(Long studentId);

	/**
	 * 添加学生
	 * 
	 * @param students
	 */
	void add(Students students) throws Exception;

	/**
	 * 修改学生
	 * 
	 * @param students
	 */
	void update(Students students);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void batchDelete(List<Long> ids);

	/**
	 * 是否已经存在
	 * 
	 * @param teachers
	 * @return
	 */
	public boolean exist(Students students);
}
