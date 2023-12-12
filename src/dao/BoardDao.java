package dao;

import java.util.List;

import util.JDBCUtil;
import vo.FeedBackVo;

public class BoardDao {
	public static BoardDao instance = null;

	private BoardDao() {

	}

	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//공지사항 입력
		public void noticeInsert(List<Object> param,String id) {
			String sql = "INSERT INTO NOTICE \r\n"+
					" (NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, ADMIN_NO)\r\n" +
					" VALUES(NOTICE_SEQ.NEXTVAL,?,?,"+"'"+id+"')";
			jdbc.update(sql,param);
		}

		//공지사항 수정
		public void noticeUpdate(List<Object> param, int no) {
			String sql = " UPDATE NOTICE\r\n" + 
					"         SET NOTICE_TITLE = ?,\r\n" + 
					"             NOTICE_CONTENT = ?\r\n" + 
					"       WHERE NOTICE_NO = "+no;
			jdbc.update(sql, param);
			
		}


		public void noticeDelete(int no) {
			String sql = "  UPDATE NOTICE\r\n" +
					"          SET NOTICE_DEL = 'Y'\r\n" +
					"        WHERE NOTICE_NO = "+no;
			
			jdbc.update(sql);
		}
		//피드백 확인여부'Y'와 'N' 모두 출력
		public List<FeedBackVo> FeedbackList() {
			String sql = "  SELECT FEEDBACK_NO,\r\n" + 
					"           FEEDBACK_TIL,\r\n" + 
					"           FEEDBACK_CON,\r\n" + 
					"            TO_CHAR(FEEDBACK_DATE,'YY/MM/DD') FEEDBACK_DATE,\r\n" + 
					"           FEEDBACK_YN\r\n," +
					" 		    USERS_NO"+ 
					"      FROM FEEDBACK\r\n";
			return jdbc.selectList(sql, FeedBackVo.class);
		}
		
		public List<FeedBackVo> FeedbackListN() {
			String sql = "  SELECT FEEDBACK_NO,\r\n" + 
					"           FEEDBACK_TIL,\r\n" + 
					"           FEEDBACK_CON,\r\n" + 
					"            TO_CHAR(FEEDBACK_DATE,'YY/MM/DD') FEEDBACK_DATE,\r\n" + 
					"           FEEDBACK_YN\r\n," +
					" 		    USERS_NO"+ 
					"      FROM FEEDBACK\r\n"+
					"      WHERE FEEDBACK_YN='N'";
			return jdbc.selectList(sql, FeedBackVo.class);
		}

		public void feedbackChk(int no) {
			String sql = "  UPDATE FEEDBACK\r\n" +
						"   SET FEEDBACK_YN = 'Y'\r\n" +
						"   WHERE FEEDBACK_NO = "+no;
			jdbc.update(sql);
		}
}