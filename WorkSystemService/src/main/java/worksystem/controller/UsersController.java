package worksystem.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import worksystem.dto.UsersDto;
import worksystem.service.UsersService;

@Controller
@RequestMapping("users")
public class UsersController {

	@Resource
	private UsersService usersService;

	/**
	 * 登陆接口
	 * 
	 * @param request
	 * @param response
	 * @param idCard
	 * @param password
	 */
	@ResponseBody
	@RequestMapping("loginer")
	public void loginer(HttpServletRequest request, HttpServletResponse response, String idCard, String password) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			StringBuilder stringBuilder = new StringBuilder();
			UsersDto usersDto = usersService.login(idCard, password, stringBuilder);
			if (usersDto == null) {
				requestHolder.fail(stringBuilder.toString());
				return;
			}
			requestHolder.setClientUser(usersDto);
			requestHolder.success(usersDto);
		} catch (Exception e) {
			requestHolder.err("登陆失败", e);
		}
	}

	/**
	 * 获取当前登陆用户
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("nowUser")
	public void nowUser(HttpServletRequest request, HttpServletResponse response) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		UsersDto usersDto = (UsersDto) requestHolder.getClientUser();
		requestHolder.success(usersDto);
	}
}
