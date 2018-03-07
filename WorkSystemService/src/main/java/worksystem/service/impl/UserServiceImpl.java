package worksystem.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import worksystem.base.model.Students;
import worksystem.base.model.Teachers;
import worksystem.dto.UsersDto;
import worksystem.service.StudentsService;
import worksystem.service.TeachersService;
import worksystem.service.UsersService;
import worksystem.uimodel.EUIPageList;

@Service
public class UserServiceImpl implements UsersService {

	@Resource
	private StudentsService studentsService;
	@Resource
	private TeachersService teachersService;

	@Override
	public UsersDto login(String idCard, String password, StringBuilder stringBuilder) {
		UsersDto usersDto = new UsersDto();
		//当管理员登陆时
		boolean pwdpassed = (idCard.equals("root")&&password.equals("63A9F0EA7BB98050796B649E85481845"));
		if(pwdpassed){
			usersDto.setRootpower(true);
			return usersDto;
		}
		
		usersDto.setRootpower(false);
		Students student = new Students();
		student.setStudentidcard(idCard);
		EUIPageList<Students> students = studentsService.getList(student, 1, 1);
		pwdpassed = (students != null && students.getTotal() == 1
				&& students.getRows().get(0).getStudentpwd().equals(password));
		if (pwdpassed) {
			usersDto.setStudents(students.getRows().get(0));
			return usersDto;
		}

		// 当学生登陆失败时尝试登陆教师
		Teachers teacher = new Teachers();
		teacher.setTeacheridcard(idCard);
		EUIPageList<Teachers> teachers = teachersService.getList(teacher, 1, 1);
		pwdpassed = (teachers != null && teachers.getTotal() == 1
				&& teachers.getRows().get(0).getTeacherpwd().equals(password));
		if (pwdpassed) {
			usersDto.setTeachers(teachers.getRows().get(0));
			return usersDto;
		}

		stringBuilder.append("用户名或密码错误");
		return null;
	}

}
