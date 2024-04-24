package com.callor.gallery.dao;

import java.util.List;

public interface genericDao<VO, PK> {

	public List<VO> selectAll();
	public VO findByID(PK pk);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
	
}
