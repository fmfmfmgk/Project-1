package dao;

import java.util.List;

import util.JDBCUtil;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.MemberVo;
import vo.NoticeVo;

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
	
	
	
}
