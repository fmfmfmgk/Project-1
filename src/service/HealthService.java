package service;

import dao.HealthDao;

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
	
	
}
