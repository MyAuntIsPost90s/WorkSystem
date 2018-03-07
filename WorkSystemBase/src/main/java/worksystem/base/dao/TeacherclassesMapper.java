package worksystem.base.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.mybaties.mapperextend.BaseMapper;
import worksystem.base.model.Teacherclasses;
import worksystem.base.model.dto.TeacherClassesDto;

public interface TeacherclassesMapper extends BaseMapper<Teacherclasses> {
	PageList<TeacherClassesDto> getTeacherclasses(Teacherclasses teacherclasses, PageBounds pageBounds);
}