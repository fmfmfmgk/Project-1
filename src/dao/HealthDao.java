package dao;

import java.util.List;

import util.JDBCUtil;
import vo.TicketVo;

public class HealthDao {
	private static HealthDao instance = null;

	private HealthDao() {
	}

	public static HealthDao getInstance() {
		if (instance == null) {
			instance = new HealthDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	
	//요가 이용권 리스트
	public List<TicketVo> yList() {
		String sql = "SELECT TICKET_NO,\r\n" + 
				"           TKT_NAME,\r\n" + 
				"           TKT_PRICE\r\n" + 
				"      FROM TICKET\r\n" + 
				"     WHERE TKT_LGU = 'YOGA'";
		return jdbc.selectList(sql, TicketVo.class);
	}
	//헬스 이용권 리스트
	public List<TicketVo> hList() {
		String sql = "SELECT TICKET_NO,\r\n" + 
				"           TKT_NAME,\r\n" + 
				"           TKT_PRICE\r\n" + 
				"      FROM TICKET\r\n" + 
				"     WHERE TKT_LGU = 'HEALTH'";
		return jdbc.selectList(sql, TicketVo.class);
	}
	
}
