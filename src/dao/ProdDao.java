package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.CartVo;
import vo.ProdVo;

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
				"	 VALUES((SELECT MAX(NO)+1 FROM PROD),?,?,?,?,?)";
		jdbc.update(sql, param);
	}

	public ProdVo prodDetail(int no) {
		String sql = "SELECT *\r\n" + 
				"       FROM PROD\r\n" + 
				"      WHERE DEL_YN = 'N'" +
				"        AND NO = "+no;
		return jdbc.selectOne(sql, ProdVo.class);
	}

	public void prodUpdate(List<Object> param, int no) {
		String sql = "UPDATE PROD\r\n" + 
				"        SET NAME = ?,\r\n" + 
				"            CONTENT = ?,\r\n" + 
				"            PRICE = ?,\r\n" + 
				"            COUNT = ?,\r\n" + 
				"            TYPE = ?\r\n" + 
				"      WHERE NO = "+no;
		
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
				"     FROM PROD\r\n" + 
				"    WHERE CONTENT LIKE '%"+name+"%'";
		
		return jdbc.selectList(sql, ProdVo.class);
	}

	public List<ProdVo> prodSchCode(String code) {
		String sql = "SELECT *\r\n" + 
				"     FROM PROD\r\n" + 
				"    WHERE TYPE = '"+code+"'";
		return jdbc.selectList(sql, ProdVo.class);
	}

	//상품 리스트 출력 (음식,용품)
	public List<ProdVo> prodList(String param) {
		String sql = "SELECT *\r\n" + 
				"       FROM PROD\r\n" + 
				"      WHERE CATEGORY_NO = '"+param+"'";
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
	
	public List<Object> prodPrice(String code) {
		String sql = "SELECT PROD_PRICE\r\n" + 
				"      FROM PROD\r\n" + 
				"     WHERE PROD_NO = '"+code+"'";
		return jdbc.selectOne(code);
	}
	
	
	
}
