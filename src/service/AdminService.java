package service;

import java.util.List;

import dao.AdminDao;
import vo.AdminVo;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.TicketVo;

public class AdminService {
	public static AdminService instance = null;

	private AdminService() {

	}

	public static AdminService getInstance() {
		if (instance == null) {
			instance = new AdminService();
		}
		return instance;
	}

	AdminDao dao = AdminDao.getInstance();

	public boolean login(List<Object> param) {
		AdminVo admin = dao.login(param);
		if (admin != null) {
			controller.MainController.sessionStorage.put("adminLogin", admin);
			return true;
		}
		return false;
	}

	
	//직원출력
	public List<EmpVo> empList() {
		return dao.empList();
	}

	//회원삭제
	public void userDelete(List<Object> param) {
		dao.userDelete(param);
	}

	//직원수정
	public void empUpdate(List<Object> param, int select) {
		dao.empUpdate(param, select);
	}

	//직원삭제
	public void empDelete(List<Object> param) {
		dao.empDelete(param);
		
	}
	


}