package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.OrdersVo;
import vo.ProdVo;
import vo.TicketVo;

public class ProdDao {
	private static ProdDao instance = null;

	private ProdDao() {
	}

	public static ProdDao getInstance() {
		if (instance == null) {
			instance = new ProdDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();



	public void prodInsert(List<Object>param) {
		String sql = "INSERT INTO PROD\r\n" + 
				"	        (NO, NAME, CONTENT, PRICE, COUNT, TYPE)\r\n" + 
				"	  VALUES((SELECT MAX(NO)+1 FROM PROD),?,?,?,?,?)";
		jdbc.update(sql, param);
	}

	public ProdVo prodDetail(int no) {
		String sql = "SELECT *\r\n" + 
				"       FROM PROD\r\n" + 
				"      WHERE DEL_YN = 'N'" +
				"        AND NO = "+no;
		return jdbc.selectOne(sql, ProdVo.class);
	}

	public void prodUpdate(List<Object> param, int select) {
		String front = "UPDATE PROD\r\n"+
	               " SET  ";
		String temp = "";
		if(select ==1) {
		temp =	"   PROD_NM = ?,\r\n" +
				"   PROD_CONTENT = ?,\r\n" + 
				"   PROD_PRICE = ?\r\n" + 
				"WHERE PROD_NO = ?";
		}
		if(select ==2) {
		temp =	"   PROD_NM = ?" +
				" WHERE PROD_NO = ?";
		}
		if(select ==3) {
		temp =	"   PROD_CONTENT = ?" + 
				" WHERE PROD_NO = ?";
		}
		if(select ==4) {
		temp =	"   PROD_PRICE = ?" + 
				" WHERE PROD_NO = ?";
		}
		String sql = front + temp;
		jdbc.update(sql, param);
	}

	public void prodDelete(int no) {
		String sql = "UPDATE PROD\r\n" + 
				"        SET DEL_YN = 'Y'\r\n" + 
				"      WHERE NO = "+no;
		
		jdbc.update(sql);
	}

	public List<ProdVo> prodSchName(String name) {
		String sql = "SELECT *\r\n" + 
				"       FROM PROD\r\n" + 
				"      WHERE CONTENT LIKE '%"+name+"%'";
		
		return jdbc.selectList(sql, ProdVo.class);
	}

	public List<ProdVo> prodSchCode(String code) {
		String sql = "SELECT *\r\n" + 
				"       FROM PROD\r\n" + 
				"      WHERE TYPE = '"+code+"'";
		return jdbc.selectList(sql, ProdVo.class);
	}

	//상품 리스트 출력 (음식,용품)
	public List<ProdVo> prodList(String param) {
		String sql = "SELECT *\r\n" + 
				"       FROM PROD\r\n" + 
				"      WHERE PROD_DEL = 'N' " +
				"      AND CATEGORY_NO = '"+param+"'";
		return jdbc.selectList(sql, ProdVo.class);
	}

	public void prodBuy(List<Object> list, int qty) {
		String sql = "INSERT INTO DETAIL\r\n" + 
				"        (ORDER_NO, PROD_NO, DETAIL_QTY)\r\n" + 
				"        VALUES (?, ?,"+qty+")";
		jdbc.update(sql, list);
	}

	public List<Map<String, Object>> cartList(String param) {
		String sql = " SELECT ORDER_NO,\r\n" + 
				"             A.PROD_NO,\r\n" + 
				"             DETAIL_QTY,\r\n" + 
				"             B.PROD_PRICE,\r\n" + 
				"             (A.DETAIL_QTY*B.PROD_PRICE)\r\n" + 
				"        FROM DETAIL A, PROD B\r\n" + 
				"       WHERE ORDER_NO = '"+param+"'"+ 
				"         AND A.PROD_NO=B.PROD_NO";
		
		return jdbc.selectList(sql);
	}
	
	public ProdVo prodPrice(String code) {
		String sql = "SELECT PROD_PRICE\r\n" + 
				"      FROM PROD\r\n" + 
				"     WHERE PROD_NO = '"+code+"'";
		return jdbc.selectOne(sql, ProdVo.class);
	}



	public void cartBuy(List<Object> param, int sum) {
		String sql = "UPDATE ORDERS\r\n" + 
				"        SET ORDER_PAY = "+sum+"\r\n" + 
				"      WHERE ORDER_NO = ?";
		
		jdbc.update(sql, param);
	}

	public List<OrdersVo> cartBuyList(String no) {
		String sql = "SELECT *\r\n" + 
				"      FROM ORDERS\r\n" + 
				"     WHERE USERS_NO ='"+no+"'";
		
		return jdbc.selectList(sql, OrdersVo.class);
	}
	
		//상품(음식)추가
		public void foodInsert(List<Object>param) {
			String sql = "INSERT INTO PROD (PROD_NO, CATEGORY_NO, PROD_NM, PROD_CONTENT,PROD_PRICE,PROD_DEL)\r\n" + 
					"VALUES (FN_CREATE_PROD_NO(?), ?, ?, ?, ?,'N' )\r\n" ;
			jdbc.update(sql, param);
		}
		
		//상품 삭제 (음식,용품)
		public void prodDelete(List<Object> param) {
			String sql = "  UPDATE PROD\r\n" + 
					"SET PROD_DEL = 'Y'\r\n" + 
					"WHERE PROD_NO = ?" ;
				jdbc.update(sql, param);
			
		}

		//이용권 리스트 출력
		public List<TicketVo> tktList() {
			String sql = "SELECT TICKET_NO, "
						+ "TKT_NAME, TKT_LGU, "
						+ "TKT_PRICE, EMPLOYEE_NO, "
						+ "TKT_TIME\r\n" + 
						"  FROM  TICKET\r\n" + 
						" WHERE DEL_YN = 'N'" ;
			return jdbc.selectList(sql, TicketVo.class);
			}
		// 이용권 생성
		public void tktInsert(List<Object> param) {
//			System.out.println("여기는 ProdDao의 tktInsert메소드..FN_CREATE_TKT_NO생성하기 힘두러서 일단 그냥 티켓번호를 받기로했다..");
			
			String sql = "INSERT INTO TICKET (TICKET_NO, TKT_NAME, TKT_LGU, TKT_PRICE, EMPLOYEE_NO, TKT_TIME)\r\n" + 
					 	 " VALUES (?, ?, ?, ?, ?, ?)" ;
			jdbc.update(sql, param);
			}

		// 이용권 수정
		public void tktUpdate(List<Object> param, int select) {
			String front = "UPDATE TICKET\r\n"+
			               " SET  ";
			String temp = "";
			if(select ==1) {
				temp =	"   TKT_NAME = ?,\r\n" +
						"   TKT_LGU = ?,\r\n" + 
						"   TKT_PRICE = ?\r\n" + 
						"   TKT_TIME = ?\r\n" + 
						"WHERE TICKET_NO = ?";
			}
			if(select ==2) {
				temp =	"   TKT_NAME = ?" +
						" WHERE TICKET_NO = ?";			
			}
			if(select ==3) {
				temp =	"   TKT_LGU = ?" + 
						" WHERE TICKET_NO = ?";
			}
			if(select ==4) {
				temp =	"   TKT_PRICE = ?" + 
						" WHERE TICKET_NO = ?";
			}
			if(select ==4) {
				temp =	"   TKT_TIME = ?" + 
						" WHERE TICKET_NO = ?";
			}
			String sql = front + temp;
			jdbc.update(sql, param);

			}

		public void tktDelete(List<Object> param) {
			String sql = "  UPDATE TICKET\r\n" + 
					"SET DEL_YN = 'Y'\r\n" + 
					"WHERE TICKET_NO = ?" ;
				jdbc.update(sql, param);
		}

		public void cartUpdate(List<Object> para, int qty) {
			String sql = "UPDATE DETAIL\r\n" + 
					"       SET DETAIL_QTY ="+qty+ 
					"     WHERE ORDER_NO = ?\r\n" + 
					"       AND PROD_NO = ?";
			jdbc.update(sql, para);
		}

		public void cartDelete(List<Object> para1) {
			String sql = "DELETE\r\n" + 
					"       FROM DETAIL\r\n" + 
					"      WHERE ORDER_NO = ?\r\n" + 
					"        AND PROD_NO = ?";
			jdbc.update(sql, para1);
		}
	
}
