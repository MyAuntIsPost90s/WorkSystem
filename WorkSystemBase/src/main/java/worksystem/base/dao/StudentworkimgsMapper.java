package worksystem.base.dao;

import java.util.List;

import lingshi.mybaties.mapperextend.BaseMapper;
import worksystem.base.model.Studentworkimgs;

public interface StudentworkimgsMapper extends BaseMapper<Studentworkimgs> {
	List<Studentworkimgs> getListByWorkID(Long studentworkid);
	void deleteByStudentWorkId(Long studentworkid);
}