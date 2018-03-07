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
import worksystem.base.model.Works;
import worksystem.dto.UsersDto;
import worksystem.service.WorksService;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;

@Controller
@RequestMapping("works")
public class WorksController {

	@Resource
	private WorksService worksService;

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
	public void list(HttpServletRequest request, HttpServletResponse response, Long studentclassid, int type, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			// 当前用户为学生时另外处理
			long studentid = -1;
			UsersDto usersDto = (UsersDto) requestHolder.getClientUser();
			if (usersDto.getStudents() != null) {
				studentclassid = usersDto.getStudents().getStudentclassid();
				studentid = usersDto.getStudents().getStudentid();
			}
			EUIPageList<Works> list = worksService.getList(studentclassid, type, studentid, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取我布置的作业的树
	 * 
	 * @param request
	 * @param response
	 * @param works
	 */
	@ResponseBody
	@RequestMapping("tree")
	public void tree(HttpServletRequest request, HttpServletResponse response, Works works) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			UsersDto usersDto = (UsersDto) requestHolder.getClientUser();
			works.setTeacherid(usersDto.getTeachers().getTeacherid());
			List<EUITree> list = worksService.getTree(works);
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
	public void single(HttpServletRequest request, HttpServletResponse response, Long workId) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Works works = worksService.getSingle(workId);
			requestHolder.success(works);
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
	public void add(HttpServletRequest request, HttpServletResponse response, Works works) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			UsersDto user = (UsersDto) requestHolder.getClientUser();
			works.setTeacherid(user.getTeachers().getTeacherid());
			worksService.add(works);
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
	public void update(HttpServletRequest request, HttpServletResponse response, Works works) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			worksService.update(works);
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
			worksService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
