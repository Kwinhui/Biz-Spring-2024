package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.iolist.models.ioListVO;

public interface ioListDao {

	public List<ioListVO> selectAll();
	
	
	public int insert(ioListVO vo);

	@Select(" SELECT * FROM tbl_iolist WHERE io_seq = #{ioSeq} ")
	public ioListVO findById(String seq);

	
	public int update(ioListVO ioListVO);
	
	@Delete(" DELETE FROM tbl_iolist WHERE io_seq = #{iSeq} ")
	public int delete(String seq);

}
