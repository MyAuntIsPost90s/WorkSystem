package worksystem.service;

import java.util.List;

import worksystem.base.model.Teachers;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;

public interface TeachersService {

	/**
	 * 获取教师列表
	 * 
	 * @param teachers
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIPageList<Teachers> getList(Teachers teachers, int page, int rows);
	
	/**
	 * 获取教师树形列表
	 * 
	 * @param teachers
	 * @return
	 */
	List<EUITree> getTree(Teachers teachers);
	
	/**
	 * 获取单个教师
	 * 
	 * @param teacherId
	 * @return
	 */
	Teachers getSingle(Long teacherId);

	/**
	 * 添加教师
	 * 
	 * @param teachers
	 */
	void add(Teachers teachers) throws Exception;

	/**
	 * 修改信息
	 * 
	 * @param teachers
	 */
	void update(Teachers teachers);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	void batchDelete(List<Long> ids);
	
	/**
	 * 是否已经存在
	 * @param teachers
	 * @return
	 */
	boolean exist(Teachers teachers);
}
