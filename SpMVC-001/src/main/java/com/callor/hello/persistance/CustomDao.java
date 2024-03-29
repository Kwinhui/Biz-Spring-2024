package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.CustomVO;

public interface CustomDao {
	@Select(" SELECT * FROM tbl_customer "
			+ " ORDER BY c_code DESC ")
	public List<CustomVO> selectAll();
	
	// vo값만 넘겨주면 custom-mapper.xml 에서 처리해줌
	public int insert(CustomVO vo);

	
	@Select(" SELECT * FROM tbl_customer "
			+ " WHERE c_code = #{cCode} ")
	public CustomVO findById(String cCode);

	public int update(CustomVO customVO);

	@Delete(" DELETE FROM tbl_customer"
			+ " WHERE c_code = #{cCode} ")
	public int delete(String cCode);
}
