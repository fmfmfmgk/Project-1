package dao;

import java.util.List;

import util.JDBCUtil;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.OrdersVo;
import vo.Tkt_buyVo;

public class MemberDao {
	private static MemberDao instance = null;

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//일반회원 로그인 쿼리
	public MemberVo login(List<Object> param) {
		String sql = "   SELECT * \r\n" + 
				"       FROM USERS\r\n" + 
				"      WHERE USERS_ID = ?\r\n" + 
				"        AND USERS_PASS = ?";
	
	return jdbc.selectOne(sql, param, MemberVo.class);
		
	}
	
	//관리자 로그인 쿼리
	public MemberVo adminLogin(List<Object> param) {
		String sql = "SELECT * \r\n" + 
				"       FROM BOOK_ADMIN\r\n" + 
				"      WHERE ID   = ?\r\n" + 
				"        AND PASS = ?";
	
	return jdbc.selectOne(sql, param, MemberVo.class);
		
	}
	
	//////피드백 게시판 
	public List<FeedBackVo> feedbackList(String id) {
		String sql = "SELECT FEEDBACK_NO,\r\n" + 
				"            FEEDBACK_TIL,\r\n" + 
				"            FEEDBACK_CON,\r\n" + 
				"            TO_CHAR(FEEDBACK_DATE,'YY/MM/DD') FEEDBACK_DATE,\r\n" +
				"            FEEDBACK_YN" +
				"       FROM FEEDBACK A, USERS B\r\n" + 
				"      WHERE A.USERS_NO=B.USERS_NO\r\n" + 
				"        AND A.DEL_YN = 'N'" +
				"        AND B.USERS_ID = '"+id+"'";
	
		return jdbc.selectList(sql, FeedBackVo.class);
	}
	
	public void feedUpdate(List<Object> param, int no) {
		String sql = " UPDATE FEEDBACK\r\n" + 
				"         SET FEEDBACK_TIL = ?,\r\n" + 
				"             FEEDBACK_CON = ?\r\n" + 
				"       WHERE FEEDBACK_NO = "+no;
		jdbc.update(sql, param);
	}

	public void feedDelete(int no) {
		String sql = "  UPDATE FEEDBACK\r\n" +
				"          SET DEL_YN = 'Y'\r\n" +
				"        WHERE FEEDBACK_NO = "+no;
		
		jdbc.update(sql);
	}
	
	
	//pt트레이너 전체 조회 쿼리
	public List<EmpVo> ptList(String param) {
		String sql = " SELECT EMPLOYEE_NO,\r\n" + 
				"           EMP_NAME,\r\n" + 
				"           EMP_TEL,\r\n" + 
				"           CAREER \r\n" + 
				"      FROM EMPLOYEES \r\n" + 
				"     WHERE EMP_LGU = 'PT'\r\n" + 
				"       AND DEL_YN = 'N'";
		return jdbc.selectList(sql, EmpVo.class);
	}
	
	//회원정보 수정
	public void userUpdate(List<Object> param, int sel) {
		String front = "UPDATE USERS \r\n" + 
		       	 "     SET ";
		String temp  = "";
		 if(sel == 1) {
			 temp=  "          USERS_NIC =  ?\r\n" + 
			 		"    WHERE USERS_ID = ?";
		 }
		 if(sel == 2) {
			 temp=  "          USERS_TEL =  ? \r\n"+  
			 		"    WHERE USERS_ID = ?";
		 }
		 if(sel == 3) {
			 temp=  "          USERS_PASS =  ?\r\n "+  
			 		"    WHERE USERS_ID = ?";
		 }
		 String sql = front + temp;
		 jdbc.update(sql, param);
	}

	public List<MemberVo> userList(String id) {
		String sql = "SELECT USERS_NO,\r\n" + 
				"       USERS_ID,\r\n" + 
				"       USERS_PASS,\r\n" + 
				"       USERS_NIC,\r\n" + 
				"       USERS_NAME,\r\n" + 
				"       USERS_TEL\r\n" + 
				"  FROM USERS \r\n" + 
				" WHERE USERS_ID = '"+id+"'";
		return jdbc.selectList(sql, MemberVo.class);
	}

	public List<NoticeVo> noticeList() {
		String sql = "SELECT NOTICE_NO,\r\n" + 
				"	         NOTICE_TITLE,\r\n" + 
				"            NOTICE_CONTENT,\r\n" + 
				"            TO_CHAR(NOTICE_DATE,'YY/MM/DD') NOTICE_DATE\r\n" + 
				"       FROM NOTICE A, ADMIN B\r\n" + 
				"      WHERE A.ADMIN_NO=B.ADMIN_NO\r\n" + 
				"        AND A.NOTICE_DEL = 'N'";
		return jdbc.selectList(sql, NoticeVo.class);
	}

	public void userInsert(List<Object> param, String id) {
		String sql = "INSERT INTO FEEDBACK \r\n" + 
				"			(FEEDBACK_NO, FEEDBACK_TIL, FEEDBACK_CON, USERS_NO)\r\n" + 
				"      VALUES(FEEDBACK_SEQ.NEXTVAL,?,?,"+"'"+id+"')";
		jdbc.update(sql, param);
	}
	
	//주문 테이블 생성쿼리
	public void cartIn(List<Object> order) {
		String sql = "INSERT INTO ORDERS \r\n" + 
				" 		(ORDER_NO,USERS_NO)\r\n" + 
				"      VALUES(FN_CREATE_ORDERS_NO(SYSDATE,1),?)";
		jdbc.update(sql, order);
	}

	public OrdersVo cartList(String no) {
		String sql = "SELECT ORDER_NO,\r\n" + 
				"              ORDER_PAY,\r\n" + 
				"              TO_CHAR(ORDER_DATE,'YY/MM/DD') ORDER_DATE,\r\n" + 
				"              USERS_NO\r\n" + 
				"         FROM ORDERS \r\n" + 
				"        WHERE ORDER_NO = (SELECT MAX(ORDER_NO) \r\n" + 
				"                            FROM ORDERS)\r\n" + 
				"          AND USERS_NO = '"+no+"'";
		return jdbc.selectOne(sql, OrdersVo.class);
	}
	
	public List<MemberVo> userList2() {
		String sql = "SELECT USERS_NO,\r\n" + 
				"       USERS_ID,\r\n" + 
				"       USERS_PASS,\r\n" + 
				"       USERS_NIC,\r\n" + 
				"       USERS_NAME,\r\n" + 
				"       USERS_TEL\r\n" + 
				"  FROM USERS \r\n" +
				"       WHERE DEL_YN='N' \r\n"  ;
		return jdbc.selectList(sql, MemberVo.class);
	}

	public void init(List<Object> param) {
		String sql = "INSERT INTO USERS "
				+ "          (USERS_NO, USERS_NAME, USERS_ID, USERS_PASS, USERS_NIC, USERS_TEL)\r\n" + 
				"      VALUES(FN_CREATE_USERS_NO,?,?,?,?,?)";
		jdbc.update(sql, param);
	}

	public List<MemberVo> u_id() {
		String sql = " SELECT *\r\n" + 
				"      FROM USERS";
		return jdbc.selectList(sql, MemberVo.class);
	}

	//성경 수정, 티켓 cartIn (티켓주문번호 생성쿼리)
	public void tktcartIn(List<Object> order) {
		String sql = "INSERT INTO TKT_BUY \r\n" + 
				" 		(TKTBUY_NO,USERS_NO)\r\n" + 
				"      VALUES(FN_CREATE_TKTBUY_NO(SYSDATE,1),?)";
		jdbc.update(sql, order);

	}


	//성경 수정, 티켓 cartList (티켓담아둔 장바구니 리스트)
	public Tkt_buyVo tktcartList(String no) {
		String sql = "SELECT TKTBUY_NO,\r\n" + 
				"       TKT_PAY,\r\n" + 
				"       TO_CHAR(TKTBUY_DATE,'YY/MM/DD') TKTBUY_DATE,\r\n" + 
				"       USERS_NO\r\n" + 
				"  FROM TKT_BUY\r\n" + 
				" WHERE TKTBUY_NO = (SELECT MAX(TKTBUY_NO)\r\n" + 
				"                    FROM TKT_BUY)\r\n" + 
				"   AND USERS_NO =  '"+no+"'";
		return jdbc.selectOne(sql, Tkt_buyVo.class);
	}

	public List<EmpVo> ptempList(String empno) {
		String sql = " SELECT EMPLOYEE_NO,\r\n" + 
				"           EMP_NAME,\r\n" + 
				"           EMP_TEL,\r\n" + 
				"           CAREER \r\n" + 
				"      FROM EMPLOYEES \r\n" + 
				"     WHERE DEL_YN = 'N'"
				+ "     AND EMPLOYEE_NO = '"+empno+"'";
		return jdbc.selectList(sql, EmpVo.class);
	}
	
}
