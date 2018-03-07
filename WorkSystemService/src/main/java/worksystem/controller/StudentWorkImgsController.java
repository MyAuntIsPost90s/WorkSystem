package worksystem.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import worksystem.service.StudentWorkImgsService;

@Controller
@RequestMapping("studentWorkImgs")
public class StudentWorkImgsController {

	@Resource
	private StudentWorkImgsService studentWorkImgsService;

	/**
	 * 删除图片接口
	 * 
	 * @param request
	 * @param response
	 * @param studentWorkImgId
	 */
	@ResponseBody
	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, long studentWorkImgId) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			studentWorkImgsService.delete(studentWorkImgId);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

}
