package service;

import java.util.List;
import java.util.Map;

import dao.ProdDao;
import vo.OrdersVo;
import vo.ProdVo;
import vo.TicketVo;

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

	public  List<Map<String, Object>> cartList(String param) {
		return dao.cartList(param);
		
	}


	public ProdVo prodprice(String code) {
		return dao.prodPrice(code);
	}


	public void cartBuy(List<Object> param, int sum) {
		dao.cartBuy(param, sum);
		
	}

	public List<OrdersVo> cartBuyList(String no) {
		return dao.cartBuyList(no);
	}

	
	public void foodDelete(List<Object> param) {
		dao.prodDelete(param);
	}

	public void supplyDelete(List<Object> param) {
		dao.prodDelete(param);
		
	}
	public void foodInsert(List<Object> param) {
		dao.foodInsert(param);
	}
	
	//이용권 리스트 출력
	public List<TicketVo> tktList() {
		return dao.tktList();
			
	}
			
	//이용권 등록
	public void tktInsert(List<Object> param) {
		dao.tktInsert(param);
	}

	public void tktUpdate(List<Object> param, int select) {
		dao.tktUpdate(param, select);
	}

	public void tktDelete(List<Object> param) {
		dao.tktDelete(param);
	}
	
	
	
	
	
	
	
	
	
	
}
