package dao;

import java.util.List;

import util.JDBCUtil;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.MemberVo;

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
	
	//피드백 게시판 쿼리
	public List<FeedBackVo> feedbackList(String id) {
		String sql = "SELECT FEEDBACK_NO,\r\n" + 
				"           FEEDBACK_TIL,\r\n" + 
				"           FEEDBACK_CON,\r\n" + 
				"           B.USERS_NO,\r\n" + 
				"           TO_CHAR(FEEDBACK_DATE,'YY/MM/DD') FEEDBACK_DATE\r\n" + 
				"      FROM FEEDBACK A, USERS B\r\n" + 
				"     WHERE A.USERS_NO=B.USERS_NO\r\n" + 
				"       AND B.USERS_ID = '"+id+"'";
	
		return jdbc.selectList(sql, FeedBackVo.class);
	}
	
	//pt트레이너 전체 조회 쿼리
	public List<EmpVo> ptList(String param) {
		String sql = "SELECT * \r\n" +
				"       FROM EMPLOYEES \r\n" + 
				"      WHERE EMP_LGU = '"+param+"'";
		return jdbc.selectList(sql, EmpVo.class);
	}
	
}
