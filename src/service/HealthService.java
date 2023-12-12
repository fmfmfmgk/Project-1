package service;

import java.util.List;

import dao.HealthDao;
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
	
	
}
