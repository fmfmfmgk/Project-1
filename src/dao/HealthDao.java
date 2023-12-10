package dao;

import util.JDBCUtil;

public class HealthDao {
	private static HealthDao instance = null;

	private HealthDao() {
	}

	public static HealthDao getInstance() {
		if (instance == null) {
			instance = new HealthDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
}
