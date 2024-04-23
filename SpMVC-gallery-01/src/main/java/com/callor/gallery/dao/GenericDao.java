package com.callor.gallery.dao;

import java.util.List;

import com.callor.gallery.models.BBsVO;
// <> : Generic type
public interface GenericDao<VO, PK> {
	// VO를 요소로하는 List type
	public List<VO> selectAll();
	public VO findById(PK pk);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
	

}
