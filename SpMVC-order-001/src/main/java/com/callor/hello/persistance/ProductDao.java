package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.ProductVO;

public interface ProductDao {

	@Select("SELECT * FROM tbl_product ORDER BY p_code DESC")
	public List<ProductVO> selectAll();
	
	
	@Insert(" INSERT INTO tbl_product "
			+ " (p_code, p_name, p_item, p_price) "
			+ " VALUES (#{p_code}, #{p_name}, #{p_item}, #{p_price} ) " )
	public int insert(ProductVO productVO);
	
	@Select(" SELECT * FROM tbl_product WHERE p_code = #{pCode} ")
	public ProductVO findByPK(String pk);
	
	public int update(ProductVO productVO);
	
	public int delete(String pk);
	
	
	
}
