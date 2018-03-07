package worksystem.base.dao;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.mybaties.mapperextend.BaseMapper;
import worksystem.base.model.Studentworks;

public interface StudentworksMapper extends BaseMapper<Studentworks> {
	PageList<Studentworks> getListWithType(@Param("studentworks") Studentworks studentworks, @Param("type") int type,
			PageBounds pageBounds);
}