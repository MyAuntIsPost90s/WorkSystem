package worksystem.service;

import java.util.List;

import worksystem.base.model.Works;
import worksystem.uimodel.EUIPageList;
import worksystem.uimodel.EUITree;

public interface WorksService {

	EUIPageList<Works> getList(Long studentclassid, int type, long studentid, int page, int rows);

	List<EUITree> getTree(Works works);

	Works getSingle(Long workId);

	void add(Works works);

	void update(Works works);

	void batchDelete(List<Long> ids);

}
