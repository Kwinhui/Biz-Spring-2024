package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.hello.models.ProductVO;

public interface ProductDao {

	@Select("SELECT * FROM tbl_product ORDER BY p_code DESC")
	public List<ProductVO> selectAll();
	
	@Select(" SELECT * FROM tbl_product WHERE p_code = #{pCode} ")
	public ProductVO findByPK(String pk);
	
	public int insert(ProductVO productVO);
	
	
	@Update(" UPDATE tbl_product SET  p_name = #{p_name}, p_item = #{p_item},"
			+ " p_price = #{p_price} WHERE p_code = #{p_code} " )
	public int update(ProductVO productVO);
	
	@Delete(" DELETE FROM tbl_product WHERE p_code = #{pCode} ")
	public int delete(String pk);
	
	
	
}
