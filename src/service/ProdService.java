package service;

import java.util.List;

import dao.ProdDao;
import vo.ProdVo;

public class ProdService {
	private static ProdService instance = null;

	private ProdService() {
	}

	public static ProdService getInstance() {
		if (instance == null) {
			instance = new ProdService();
		}
		return instance;
	}
	ProdDao dao = ProdDao.getInstance();

	
	
	
	public void prodInsert(List<Object> param) {
		dao.prodInsert(param);
	}

	public ProdVo prodDetail(int no) {
		
		return dao.prodDetail(no);
	}
	
	

	public void prodUpdate(List<Object> param, int no) {
		
		dao.prodUpdate(param, no);
	}

	public void prodDelete(int no) {
		dao.prodDelete(no);
	}

	public List<ProdVo> prodSchName(String name) {
		return dao.prodSchName(name);
	}

	public List<ProdVo> prodSchCode(String code) {
		return dao.prodSchCode(code);
	}
	
	
	public List<ProdVo> prodList(String param) {
		return dao.prodList(param);
	}

	public void prodBuy(List<Object> list, int qty) {
		dao.prodBuy(list, qty);
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
