package com.callor.gallery.dao;

import com.callor.gallery.models.ImagesVO;

public interface ImagesDao  extends genericDao<ImagesVO, String>{

	

	public void create_table(String dumy);

}
