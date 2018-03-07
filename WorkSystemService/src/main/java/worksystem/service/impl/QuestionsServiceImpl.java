package worksystem.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.valid.StringValid;
import worksystem.base.dao.QuestionsMapper;
import worksystem.base.model.Questions;
import worksystem.service.QuestionsService;
import worksystem.uimodel.EUIPageList;

@Service
public class QuestionsServiceImpl implements QuestionsService {

	@Resource
	private QuestionsMapper questionsMapper;

	@Override
	public EUIPageList<Questions> getList(Questions questions, int type, int page, int rows) {
		PageList<Questions> pageList = questionsMapper.getListWithType(questions, type, new PageBounds(page, rows));
		return new EUIPageList<Questions>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public Questions getSingle(Long questionId) {
		return questionsMapper.getSingle(questionId);
	}

	@Override
	public void add(Questions questions) {
		questions.setQuestiontime(new Date());
		questionsMapper.insert(questions);
	}

	@Override
	public void update(Questions questions) {
		if (!StringValid.isNullOrEmpty(questions.getQuestionanswer())) {
			questions.setAnswertime(new Date());
		}
		questionsMapper.update(questions);
	}

	@Override
	public void batchDelete(List<Long> ids) {
		questionsMapper.batchDelete(ids);
	}

}
