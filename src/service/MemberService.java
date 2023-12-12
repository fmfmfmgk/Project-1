package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.MemberDao;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.OrdersVo;

public class MemberService {
	private static MemberService instance = null;

	private MemberService() {
	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
	MemberDao dao= MemberDao.getInstance();

	public boolean login(List<Object> param) {
		MemberVo mem = dao.login(param);
		//맴버값이랑 다르면
		if(mem !=null) {
			//로그인이 성공하면 세션에 로그인 맴버값을 적용
			MainController.sessionStorage.put("login", mem);
			
			//PROD 정보 불러오기
			
			return true;
		}
		//로그인 실패
		return false;
		
	}

	public boolean adminLogin(List<Object> param) {
		MemberVo mem = dao.adminLogin(param);
		//맴버값이랑 다르면
		if(mem !=null) {
			//로그인이 성공하면 세션에 로그인 맴버값을 적용
			MainController.sessionStorage.put("login", mem);
			return true;
		}
		//로그인 실패
		return false;
	
	}

	public List<FeedBackVo> feedbackList(String id) {
		return dao.feedbackList(id);
	}

	public List<EmpVo> ptList(String param) {
		return dao.ptList(param);
	}

	public void feedUpdate(List<Object> param, int no) {
		dao.feedUpdate(param, no);
		
	}

	public void feedDelete(int no) {
		dao.feedDelete(no);
		
	}

	public void userUpdate(List<Object> param, int sel) {
		dao.userUpdate(param, sel);
	}

	public List<MemberVo> userList(String id) {
		return dao.userList(id);
	}
	
	//공지사항 출력
	public List<NoticeVo> noticeList() {
		return dao.noticeList();
	}
	//피드백 생성
	public void feedInsert(List<Object> param, String id) {
		dao.userInsert(param, id);
	}

	public void cartin(List<Object> order) {
		dao.cartIn(order);
	}

	public OrdersVo cartList(String no) {
		
		return dao.cartList(no);
	}
	
	//전체 user리스트 출력
	public List<MemberVo> userList2() {
			return dao.userList2();
	}
	
	
}
