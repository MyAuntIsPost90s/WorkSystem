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
import worksystem.base.model.Studentclass;
import worksystem.service.StudentClassesService;
import worksystem.uimodel.EUIPageList;

@Controller
@RequestMapping("studentClasses")
public class StudentClassesController {

	@Resource
	private StudentClassesService studentClassesService;

	/**
	 * 获取班级列表
	 * 
	 * @param request
	 * @param response
	 * @param studentclass
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("list")
	public void list(HttpServletRequest request, HttpServletResponse response, Studentclass studentclass, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Studentclass> list = studentClassesService.getList(studentclass, page, rows);
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
	public void single(HttpServletRequest request, HttpServletResponse response, Long studentClassId) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Studentclass studentclass = studentClassesService.getSingle(studentClassId);
			requestHolder.success(studentclass);
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
	public void add(HttpServletRequest request, HttpServletResponse response, Studentclass studentclass) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			studentClassesService.add(studentclass);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改班级信息
	 * 
	 * @param request
	 * @param response
	 * @param studentclass
	 */
	@ResponseBody
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response, Studentclass studentclass) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			studentClassesService.update(studentclass);
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
			studentClassesService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
