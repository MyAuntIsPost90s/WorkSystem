package worksystem.service;

import worksystem.dto.UsersDto;

public interface UsersService {
	
	 UsersDto login(String idCard,String password,StringBuilder stringBuilder);
	 
}
