package worksystem.base.dao;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.mybaties.mapperextend.BaseMapper;
import worksystem.base.model.Works;

public interface WorksMapper extends BaseMapper<Works> {
	PageList<Works> getListWithType(@Param("type") int type, @Param("studentclassid") Long studentclassid,
			PageBounds pageBounds);
}