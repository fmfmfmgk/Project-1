package service;

import java.util.List;

import controller.MainController;
import dao.MemberDao;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.MemberVo;

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
}