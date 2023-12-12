package service;

import java.util.List;

import dao.BoardDao;
import vo.FeedBackVo;
import vo.TicketVo;

public class BoardService {
	public static BoardService instance = null;

	private BoardService() {

	}

	public static BoardService getInstance() {
		if (instance == null) {
			instance = new BoardService();
		}
		return instance;
	}
	
	  BoardDao dao= BoardDao.getInstance();
	
		//공지사항 입력
		public void noticeInsert(List<Object> param, String id) {
			dao.noticeInsert(param,id);		
		}
		
		//공지사항 수정
		public void noticeUpdate(List<Object> param, int no) {
			dao.noticeUpdate(param, no);
		}
		
		//공지사항 삭제
		public void noticeDelete(int no) {
			dao.noticeDelete(no);
			
		}
		
		//피드백 확인여부 'Y'와'N' 모두 리스트출력
		public List<FeedBackVo> FeedbackList() {
			return dao.FeedbackList();
		}

		public void feedbackChk(int no) {
			dao.feedbackChk(no);
		}

		//피드백 확인여부 'N'인 리스트 출력
		public List<FeedBackVo> FeedbackListN() {
			return dao.FeedbackListN();
		}
}