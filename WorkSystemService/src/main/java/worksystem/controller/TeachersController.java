package worksystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import worksystem.base.model.Teachers;
import worksystem.dto.UsersDto;
import worksystem.service.TeachersService;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;

@Controller
@RequestMapping("teachers")
public class TeachersController {

	@Resource
	private TeachersService teachersService;

	/**
	 * 获取列表
	 * 
	 * @param request
	 * @param response
	 * @param studentclass
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, Teachers teachers, int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Teachers> list = teachersService.getList(teachers, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
	
	/**
	 * 获取树形教师列表
	 * 
	 * @param request
	 * @param response
	 * @param teachers
	 */
	@ResponseBody
	@RequestMapping("tree")
	public void tree(HttpServletRequest request, HttpServletResponse response, Teachers teachers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			List<EUITree> list = teachersService.getTree(teachers);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取单条信息
	 * 
	 * @param request
	 * @param response
	 * @param studentclass
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("single")
	public void single(HttpServletRequest request, HttpServletResponse response, Long teacherId) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Teachers teachers = teachersService.getSingle(teacherId);
			requestHolder.success(teachers);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param response
	 * @param studentclass
	 */
	@ResponseBody
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, Teachers teachers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			teachersService.add(teachers);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改信息
	 * 
	 * @param request
	 * @param response
	 * @param studentclass
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, Teachers teachers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			teachersService.update(teachers);

			// 当修改对象为当前账号时考虑刷新缓存
			UsersDto nowUser = (UsersDto) requestHolder.getClientUser();
			boolean nowUsered = nowUser.getTeachers() != null
					&& nowUser.getTeachers().getTeacherid().equals(teachers.getTeacherid());
			if (nowUsered) {
				nowUser.setTeachers(teachersService.getSingle(teachers.getTeacherid()));
			}
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param request
	 * @param response
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping("batchDelete")
	public void batchDelete(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Long> ids) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			teachersService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
