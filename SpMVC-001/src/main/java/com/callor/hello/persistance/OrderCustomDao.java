package com.callor.hello.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.models.OrderCustomVO;
import com.callor.hello.sql.TableSQL;

public interface OrderCustomDao {
	
	
	// table을 불러올때 TableSQL은 반드시 final 로 돼있어야함
//	@Select(TableSQL.ORDER_CUSTOM)
	public List<OrderCustomVO> selectAll();
	
	
}
