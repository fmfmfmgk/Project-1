package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.EmpVo;
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

	//pt 이용권 리스트 (성경)
	public List<TicketVo> pList(String emp) {
		String sql = "SELECT TICKET_NO,\r\n" + 
				"           TKT_NAME,\r\n" + 
				"           TKT_PRICE\r\n" +
				"      FROM TICKET\r\n" + 
				"     WHERE EMPLOYEE_NO = '"+emp+"'";
		return jdbc.selectList(sql, TicketVo.class);
	}
	
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

	public List<EmpVo> ptnameList(String sel) {
		   String sql = "SELECT EMPLOYEE_NO,\r\n" + 
		            "            EMP_NAME,\r\n" + 
		            "            EMP_TEL,\r\n" + 
		            "            CAREER \r\n" + 
		            "       FROM EMPLOYEES \r\n" + 
		            "      WHERE EMP_NAME LIKE '%"+sel+"%'";
		      return jdbc.selectList(sql, EmpVo.class);
	}

	public List<Map<String, Object>> tktGetList(String id) {
	      String sql = "SELECT A.USERS_NO,\r\n" + 
	            "           A.TKTBUY_NO,\r\n" + 
	            "           C.TKT_NAME,\r\n" + 
	            "           TKT_START,\r\n" + 
	            "           TKT_END,\r\n" + 
	            "           ROUND(B.TKT_END-SYSDATE) \r\n" + 
	            "      FROM TKT_BUY A, TKT_DETAIL B, TICKET C\r\n" + 
	            "     WHERE A.USERS_NO = '"+id+"'" +
	            "       AND A.TKTBUY_NO=B.TKTBUY_NO\r\n" + 
	            "       AND B.TICKET_NO=C.TICKET_NO\r\n" + 
	            "       AND SYSDATE < B.TKT_END\r\n" + 
	            "       AND SYSDATE > B.TKT_START";
	      return jdbc.selectList(sql);
		      
		   }
	}
	
