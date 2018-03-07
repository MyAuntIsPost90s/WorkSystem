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
import worksystem.base.model.Questions;
import worksystem.dto.UsersDto;
import worksystem.service.QuestionsService;
import worksystem.uimodel.EUIPageList;

@Controller
@RequestMapping("questions")
public class QuestionsController {

	@Resource
	private QuestionsService questionsService;

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
	public void list(HttpServletRequest request, HttpServletResponse response, Questions questions, int type, int page,
			int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			UsersDto usersDto = (UsersDto) requestHolder.getClientUser();
			if (usersDto.getTeachers() != null) { // 当账号为老师时
				questions.setTeacherid(usersDto.getTeachers().getTeacherid());
			}
			if (usersDto.getStudents() != null) { // 当账号为学生时
				questions.setStudentid(usersDto.getStudents().getStudentid());
			}
			EUIPageList<Questions> list = questionsService.getList(questions, type, page, rows);
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
	public void single(HttpServletRequest request, HttpServletResponse response, Long questionId) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Questions questions = questionsService.getSingle(questionId);
			requestHolder.success(questions);
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
	public void add(HttpServletRequest request, HttpServletResponse response, Questions questions) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			UsersDto usersDto = (UsersDto) requestHolder.getClientUser();
			questions.setStudentid(usersDto.getStudents().getStudentid());
			questionsService.add(questions);
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
	public void update(HttpServletRequest request, HttpServletResponse response, Questions questions) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			questionsService.update(questions);
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
			questionsService.batchDelete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

}
