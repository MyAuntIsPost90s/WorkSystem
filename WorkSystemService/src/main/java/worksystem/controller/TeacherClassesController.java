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
import worksystem.base.model.Teacherclasses;
import worksystem.base.model.dto.TeacherClassesDto;
import worksystem.dto.UsersDto;
import worksystem.service.TeacherClassesService;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;

@Controller
@RequestMapping("teacherClasses")
public class TeacherClassesController {
	@Resource
	private TeacherClassesService teacherClassesService;

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
	public void list(HttpServletRequest request, HttpServletResponse response, Teacherclasses teacherclasses, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<TeacherClassesDto> list = teacherClassesService.getList(teacherclasses, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取我的教学班级树形
	 * 
	 * @param request
	 * @param response
	 * @param teacherclasses
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("tree")
	public void tree(HttpServletRequest request, HttpServletResponse response, Teacherclasses teacherclasses) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			UsersDto usersDto = (UsersDto)requestHolder.getClientUser();
			teacherclasses.setTeacherid(usersDto.getTeachers().getTeacherid());	
			List<EUITree> list = teacherClassesService.getTree(teacherclasses);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加班级
	 * 
	 * @param request
	 * @param response
	 * @param studentclass
	 */
	@ResponseBody
	@RequestMapping("add")
	public void add(HttpServletRequest request, HttpServletResponse response, Teacherclasses teacherclasses) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			teacherClassesService.add(teacherclasses);
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
	public void batchDelete(HttpServletRequest request, HttpServletResponse response, @RequestBody List<String> ids) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			teacherClassesService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
