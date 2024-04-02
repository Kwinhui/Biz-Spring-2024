package com.callor.iolist.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.iolist.models.IoListVO;

public interface IoListDao {
	
	
	@Select(" SELECT * FROM tbl_iolist ORDER BY io_date DESC, io_time DESC ")
	public List<IoListVO> selectAll();
	
	@Select(" SELECT * FROM tbl_iolist WHERE io_seq = #{io_seq} ")
	public IoListVO findBySeq(Long seq);
	
	
	public int insert(IoListVO vo);
	public int update(IoListVO vo);
	public int delete(Long seq);
	
	
	public void create_iolist_table(String dumy);
	
}
