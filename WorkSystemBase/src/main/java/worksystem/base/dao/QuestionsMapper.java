package worksystem.base.dao;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.mybaties.mapperextend.BaseMapper;
import worksystem.base.model.Questions;

public interface QuestionsMapper extends BaseMapper<Questions> {
	PageList<Questions> getListWithType(@Param("questions") Questions questions, @Param("type") int type,
			PageBounds pageBounds);
}