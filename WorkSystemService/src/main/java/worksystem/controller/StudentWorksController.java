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
import worksystem.base.model.Studentworks;
import worksystem.base.model.dto.StudentWorksDto;
import worksystem.dto.UsersDto;
import worksystem.service.StudentWorksService;
import worksystem.uimodel.EUIPageList;

@Controller
@RequestMapping("studentWorks")
public class StudentWorksController {

	@Resource
	private StudentWorksService studentWorksService;

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
	public void list(HttpServletRequest request, HttpServletResponse response, Studentworks studentworks, int page,
			int rows, int type) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Studentworks> list = studentWorksService.getList(studentworks, type, page, rows);
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
	public void single(HttpServletRequest request, HttpServletResponse response, Long studentworkId) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Studentworks studentworks = studentWorksService.getSingle(studentworkId);

			requestHolder.success(studentworks);
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
	@RequestMapping("single4workId")
	public void single4workId(HttpServletRequest request, HttpServletResponse response, Long workId) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			UsersDto usersDto = (UsersDto) requestHolder.getClientUser();
			Studentworks studentworks = studentWorksService.getSingleByWorkId(usersDto.getStudents().getStudentid(),
					workId);
			requestHolder.success(studentworks);
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
	public void add(HttpServletRequest request, HttpServletResponse response,
			@RequestBody StudentWorksDto studentWorksDto) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			UsersDto usersDto = (UsersDto) requestHolder.getClientUser();
			studentWorksDto.setStudentid(usersDto.getStudents().getStudentid());
			studentWorksService.add(studentWorksDto);
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
	@RequestMapping("update4student")
	public void update4student(HttpServletRequest request, HttpServletResponse response,
			@RequestBody StudentWorksDto studentWorksDto) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			studentWorksService.updateWorkAndImg(studentWorksDto);
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
	@RequestMapping("update4teacher")
	public void update4teacher(HttpServletRequest request, HttpServletResponse response,
			StudentWorksDto studentWorksDto) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			studentWorksService.update(studentWorksDto);
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
			studentWorksService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

}
