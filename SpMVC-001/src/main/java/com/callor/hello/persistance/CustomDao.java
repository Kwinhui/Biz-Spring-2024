package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CustomVO;

public interface CustomDao {
	@Select(" SELECT * FROM tbl_customer "
			+ " ORDER BY c_code DESC ")
	public List<CustomVO> selectAll();
	
	// vo값만 넘겨주면 custom-mapper.xml 에서 처리해줌
	public int insert(CustomVO vo);
}
