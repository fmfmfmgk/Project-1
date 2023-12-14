package service;

import java.util.List;
import java.util.Map;

import dao.HealthDao;
import vo.EmpVo;
import vo.TicketVo;

public class HealthService {
	private static HealthService instance = null;

	private HealthService() {
	}

	public static HealthService getInstance() {
		if (instance == null) {
			instance = new HealthService();
		}
		return instance;
	}
	HealthDao dao = HealthDao.getInstance();

	
	public List<TicketVo> tList() {
		return dao.yList();
	}
	
	public List<TicketVo> hList() {
		return dao.hList();
	}
	
	public List<TicketVo> pList(String emp) {
		return dao.pList(emp);
	}
	
	public List<EmpVo> ptnameList(String sel) {
		return dao.ptnameList(sel);
	}

	public List<Map<String, Object>> tktGetList(String id) {
	    return dao.tktGetList(id);
	 }
}
