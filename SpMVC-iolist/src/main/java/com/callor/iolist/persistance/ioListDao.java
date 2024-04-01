package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.iolist.models.ioListVO;


public interface ioListDao {

	
	@Select(" SELECT * FROM tbl_iolist ")
	public List<ioListVO> selectAll();
	
	
	public int insert(ioListVO vo);
	
	@Select (" SELECT * FROM tbl_iolist WHERE io_seq = #{ioSeq} ")
	public ioListVO findById(String seq);
	
	
	public int update(ioListVO ioListVO);
	
	
	public int delete(String seq);
	
}
