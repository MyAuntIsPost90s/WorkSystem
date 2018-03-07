package worksystem.service;

import java.util.List;

import worksystem.base.model.Questions;
import worksystem.uimodel.EUIPageList;

public interface QuestionsService {
	
	EUIPageList<Questions> getList(Questions questions,int type, int page, int rows);
	
	Questions getSingle(Long questionId);
	
	void add(Questions questions);
	
	void update(Questions questions);
	
	void batchDelete(List<Long> ids);
}
