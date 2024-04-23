package com.callor.gallery.dao;

import com.callor.gallery.models.GalleryVO;

//public interface GenericDao<VO, PK>
//genericDao 상속받아
//GenericDao 의 VO를 GalleryVO로, GenericDao 의 PK를 String으로 사용하겠다
public interface GalleryDao extends GenericDao<GalleryVO, String>{
	

	public void create_table(String dumy);
	
//	public List<GalleryVO> selectAll();
//	
//	public GalleryVO fineById(String pk);
//	public int insert(GalleryVO vo);
//	public int update(GalleryVO vo);
//	public int delete(String pk);
	
}
