package controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import print.Print;
import service.AdminService;
import service.BoardService;
import service.HealthService;
import service.MemberService;
import service.ProdService;
import util.ScanUtil;
import util.View;
import vo.AdminVo;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.OrdersVo;
import vo.ProdVo;
import vo.TicketVo;
import vo.Tkt_buyVo;



public class MainController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	ProdService prodService = ProdService.getInstance();
	MemberService memService = MemberService.getInstance();
	HealthService healthService = HealthService.getInstance();
	AdminService adService = AdminService.getInstance();
	BoardService boardService = BoardService.getInstance();
	AdminController ad = new AdminController();
	
	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case USER_LOGIN:
				view = userLogin();
				break;
			case SESSION:
				view = session();
				break;
			case USER_MENU:
				view = userMenu();
				break;
			case USER_UPDATE:
				view = userUpdate();
				break;
			case FEEDBACK:
				view = feedback();
				break;
			case FEEDBACK_INSERT:
				view = feedInsert();
				break;
			case FEEDBACK_UPDATE:
				view = feedUpdate();
				break;
			case FEEDBACK_DELETE:
				view = feedDelete();
				break;
			case TKTGETLIST:
				view = tktGetList();
				break;

			case PT_MENU:
				view = ptMenu();
				break;
			case YOGA_LIST:
				view = yogaList();
				break;
			case HEALTH_LIST:
				view = healthList();
				break;

			case PROD:
				view = prod();
				break;
			case PROD_FOOD:
				view = prodFood();
				break;
			case PROD_CART:
				view = prodCart2();
				break;
			case PROD_SUPPLIES:
				view = prodSuppies();
				break;

			case CART_LIST:
				view = cartList();
				break;
			case CART_BUY_LIST:
				view = cartBuyList();
				break;
			case CART_BUY:
				view = cartBuy();
				break;
			case CART_UPDATE:
				view = cartUpdate();
				break;

				
				
			// 관리자
			case ADMIN_LOGIN:
				view = ad.adminLogin();
				break;
			case ADMIN_MENU:
				view = ad.adminMenu();
				break;
			case ADMIN_USER:
				view = ad.adminUser();
				break;
			case USER_LIST:
				view = ad.userList();
				break;
			case USER_DELETE:
				view = ad.userDelete();
				break;
			case ADMIN_PROD:
				view = ad.adminProd();
				break;
			case ADMIN_PRODLIST:
				view = ad.adminProdList();
				break;
			case ADMIN_PROD_FOOD:
				view = ad.adminProdFood();
				break;
			case FOOD_UPDATE:
				view = ad.foodUpdate();
				break;
			case FOOD_DELETE:
				view = ad.foodDelete();
				break;
			case ADMIN_PROD_SUPPLY:
				view = ad.adminProdSupply();
				break;
			case SUPPLY_UPDATE:
				view = ad.supplyUpdate();
				break;
			case SUPPLY_DELETE:
				view = ad.supplyDelete();
				break;
			case PROD_INSERT:
				view = ad.prodInsert();
				break;
			case ADMIN_BOARD:
				view = ad.adminBoard();
				break;
			case EMP_LIST:
				view = ad.empList();
				break;
			case EMP_UPDATE:
				view = ad.empUpdate();
				break;
			case EMP_DELETE:
				view = ad.empDelete();
				break;

			case NOTICE:
				view = ad.noticeList();
				break;
			case NOTICE_INSERT:
				view = ad.noticeInsert();
				break;
			case NOTICE_UPDATE:
				view = ad.noticeUpdate();
				break;
			case NOTICE_DELETE:
				view = ad.noticeDelete();
				break;

			case FEEDBACK_LIST:
				view = ad.feedbackList();
				break;
			case FEEDBACK_CHK:
				view = ad.feedbackChk();
				break;
			case ADMIN_TICKET:
				view = ad.adminTkt();
				break;

			case TICKET_INSERT:
				view = ad.tktInsert();
				break;
			case TICKET_UPDATE:
				view = ad.tktUpdate();
				break;
			case TICKET_DELETE:
				view = ad.tktDelete();
				break;

			case TKTSESSION:
				view = tktsession();
				break;
			case TICKET: // 위에서 가져옴
				view = ticket();
				break;
			case TICKET_CART: // 위에서 가져옴
				view = tktCart2();
				break;
			case TKT_CART_LIST:
				view = tktcartList();
				break;
			case TKT_CART_BUY:
				view = tktcartBuy();
				break;
			case TKT_CART_BUY_LIST:
				view = tktcartBuyList();
				break;
			case TKT_CART_DELETE:
				view = tktcartList();
				break;
			case PT_TICKET_CART:
				view = pttktCart2();
				break;

			case PT_LIST_ALL:
				view = ptListAll();
				break;
			case PT_LIST:
				view = ptList();
				break;
			case PT_SEARCH:
				view = ptnameList();
				break;

			default:
				view = home();
				break;
			}
		}
	}

	private void pt_tktCart1() { // 회원-PT이용권 카트담기1
		Tkt_buyVo cart = (Tkt_buyVo) sessionStorage.get("tktcart");
		// 장바구니(DETAIL)에 추가하는거
		// 주문번호를 불러오는거!
		MemberVo mem = (MemberVo) sessionStorage.get("login");
		// 쓸모없을수도 있음
		String tktno = (String) sessionStorage.get("tktno"); // 이용권번호 미리 받아온거

		List<Object> list = new ArrayList();
		String cart_no = cart.getTktbuy_no();

		list.add(cart_no);
		list.add(tktno);

		prodService.ptticketBuy(list); // DB DETAIL테이블에 이용권번호/주문번호/시작일자 저장

	}

	private View pttktCart2() { // 회원-PT이용권 카트담기2
		while (true) {
			pt_tktCart1();
			cartinprint();
			int sel = ScanUtil.nextInt("선택>> ");
			switch (sel) {
			case 1:
				return View.TICKET;
			case 2:
				return View.TKT_CART_LIST;
			default:
				return View.TICKET;
			}
		}
	}

	private void tktCart1() { // 회원-기간 작성 필요한 이용권(요가,헬스) 카트 담기1
		Tkt_buyVo cart = (Tkt_buyVo) sessionStorage.get("tktcart");
		// 장바구니(DETAIL)에 추가하는거
		// 주문번호를 불러오는거!
		MemberVo mem = (MemberVo) sessionStorage.get("login");
		// 쓸모없을수도 있음

		List<Object> list = new ArrayList();
		String code = ScanUtil.nextLine("이용권번호를 입력해주세요 :");
		String cart_no = cart.getTktbuy_no();

		// 날짜 입력받기
		Calendar cal = Calendar.getInstance();
		tktalarm();
		int year = ScanUtil.nextInt("연도를 입력해주세요 :");
		int month = ScanUtil.nextInt("월을 입력해주세요 :") - 1;
		int date = ScanUtil.nextInt("일을 입력해주세요 :");

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE, date);
		Date startdate = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		list.add(cart_no);
		list.add(code);
		list.add(sdf.format(startdate));
		prodService.ticketBuy(list); // DB DETAIL테이블에 이용권번호/주문번호/시작일자 저장

	}

	private View tktCart2() { // 회원-기간 작성 필요한 이용권(요가,헬스) 카트 담기2
		while (true) {
			tktCart1();
			cartinprint();
			int sel = ScanUtil.nextInt("선택>> ");
			switch (sel) {
			case 1:
				return View.TICKET;
			case 2:
				return View.TKT_CART_LIST;
			default:
				return View.TICKET;
			}
		}
	}

	private View tktcartBuyList() { // 회원-이용권 구매내역 리스트
		MemberVo id = (MemberVo) sessionStorage.get("login");
		String u_id = id.getUsers_no();
		List<Tkt_buyVo> list = prodService.tktcartBuyList(u_id);
		tlist2(list);
		back();
		int sel = ScanUtil.nextInt("메뉴선택: ");
		switch (sel) {
		case 1:
			return View.USER_MENU;
		default:
			return View.USER_MENU;
		}
	}

	private View tktGetList() {// 회원-이용권 보유 현황 
		MemberVo login = (MemberVo) sessionStorage.get("login");
		String id = login.getUsers_no();

		List<Map<String, Object>> list = healthService.tktGetList(id);
		tktGetList1(list);
		back();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.USER_MENU;
		default:
			return View.USER_MENU;
		}
	}

	private View tktcartBuy() { // 회원-이용권 장바구니 결제 화면

		System.out.println("");
		String sel = ScanUtil.nextLine("결제하시겠습니까?(Y/N) :");

		if (sel.equalsIgnoreCase("y")) {

			int sum = (int) sessionStorage.get("tktsum");

			Tkt_buyVo cart = (Tkt_buyVo) sessionStorage.get("tktcart");
			String no = cart.getTktbuy_no();

			List<Object> param = new ArrayList();
			param.add(no);
			prodService.tktcartBuy(param, sum);

			// DB ORDERS 테이블에 데이터 저장완료
			buycomplete();
			sessionStorage.remove("tktsum");
			return View.TKT_CART_BUY_LIST;

		} else if (sel.equalsIgnoreCase("n")) {
			buycancle();
			return View.TICKET;
		}
		return View.TICKET;
	}

	private View tktcartList() { // 이용권 장바구니 리스트
		// 장바구니 리스트
		MainController.sessionStorage.put("tktsum", 0);
		Tkt_buyVo cart = (Tkt_buyVo) sessionStorage.get("tktcart");
		String param = cart.getTktbuy_no();
		List<Map<String, Object>> list = prodService.tktcartList(param);
		if (list != null) {
			System.out.println(" =================================== 장바구니 내역 ================================== ");
			System.out.println("   장바구니 번호\t\t이용권번호\t\t단가");
			System.out.println(" ================================================================================  ");
			int s = (int) sessionStorage.get("tktsum");
			for (Map<String, Object> vo : list) {
				String tkt_cart_no = (String) vo.get("TKTBUY_NO");
				String tkt_no = (String) vo.get("TICKET_NO");
				BigDecimal price = (BigDecimal) vo.get("TKT_PRICE");
				int price1 = price.intValue();
				System.out.println("  " + tkt_cart_no + "\t" + tkt_no + "\t\t" + price1);
				s += price1;
				sessionStorage.put("tktsum", s);
			}
			System.out.println(" --------------------------------------------------------------------------------  ");
			System.out.println("   총합계: " + sessionStorage.get("tktsum") + "원");
			System.out.println(" ================================================================================  ");
			cartListPrint();
			int sel = ScanUtil.nextInt("선택>>  ");
			switch (sel) {
			case 1:
				return View.TKT_CART_BUY;
			case 2:
				tktcartupdate();
				int sel2 = ScanUtil.nextInt("선택>>  ");
				switch (sel2) {
				case 1:
					List<Object> para1 = new ArrayList();
					String no1 = ScanUtil.nextLine("취소할 이용권 번호를 입력해주세요: ");
					para1.add(param); // 티켓주문번호
					para1.add(no1); // 티켓번호

					prodService.tktcartDelete(para1);// DB DETAIL테이블에서 해당 상품 내역 삭제
					cartcancleprint();
					return View.TKT_CART_LIST;
				case 2:
					return View.TICKET;
				default:
					return View.TKT_CART_LIST;
				}
			case 3:
				return View.TICKET;
			default:
				return View.TKT_CART_LIST;
			}
		} else {
			cartnoprint();
		}
		return View.TICKET;
	}

	private View ticket() { // 회원-이용권구매화면
		ticket1();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.PT_MENU;
		case 2:
			return View.YOGA_LIST;
		case 3:
			return View.HEALTH_LIST;
		case 4:
			return View.TKT_CART_LIST;
		case 5:
			return View.TKT_CART_BUY_LIST;
		case 6:
			warning();
			String yn = ScanUtil.nextLine("홈으로 이동하시겠습니까?(Y/N) :");

			if (yn.equalsIgnoreCase("Y")) {
				return View.USER_MENU;
			} else if (yn.equalsIgnoreCase("N")) {
				return View.TICKET;
			} else {
				System.out.println("잘못 입력 되었습니다");
			}
			return View.TICKET;
		default:
			return View.TICKET;
		}
	}

	
	private View ptMenu() {//회원-이용권구매-PT이용권
		ptticket();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.PT_LIST_ALL;
		case 2:
			return View.PT_SEARCH;
		case 3:
			return View.TICKET;
		default:
			return View.PT_MENU;
		}
	}

	private View ptListAll() {//회원-이용권구매-PT이용권-트레이너전체리스트
		String param = "PT";
		List<EmpVo> list = memService.ptList(param);
		ptList(list);

		ptselect();
		int sel1 = ScanUtil.nextInt("선택>> ");
		switch (sel1) {
		case 1:
			String empno = ScanUtil.nextLine("직원 번호를 입력해주세요 : ");
			MainController.sessionStorage.put("empno", empno);

			List<EmpVo> list2 = memService.ptempList(empno);
			ptList(list2);
			ptselect2();

			int sel2 = ScanUtil.nextInt("번호 선택 : ");
			switch (sel2) {
			case 1:
				return View.PT_LIST;
			case 2:
				return View.PT_MENU;
			default:
				return View.PT_MENU;
			}
		case 2:
			return View.PT_MENU;
		default:
			return View.PT_MENU;
		}
	}

	private View ptList() {//회원-이용권구매-PT이용권-직원선택한 상태에서 구매화면
		String emp = (String) sessionStorage.get("empno");

		List<TicketVo> list = healthService.pList(emp);
		tktlist(list);
		ptbuy();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			String tktno = ScanUtil.nextLine("구매하실 이용권 번호를 입력해주세요 :");
			MainController.sessionStorage.put("tktno", tktno);
			return View.PT_TICKET_CART;
		case 2:
			return View.PT_LIST;
		default:
			return View.TICKET;
		}
	}

	private View ptnameList() {//회원-이용권구매-PT이용권-트레이너검색
		String name = ScanUtil.nextLine("트레이너 이름을 입력하세요 :");
		List<EmpVo> list = healthService.ptnameList(name);
		ptList(list);

		String empno = ScanUtil.nextLine("트레이너 번호를 입력하세요 :");
		MainController.sessionStorage.put("empno", empno);
		ptselect2();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.PT_LIST;
		case 2:
			return View.TICKET;
		default:
			return View.TICKET;
		}
	}

	private View yogaList() {
		List<TicketVo> list = healthService.tList();
		tktlist(list);
		ptbuy();
		int sel = ScanUtil.nextInt("선택>> ");
		switch (sel) {
		case 1:
			return View.TICKET_CART;
		case 2:
			return View.TICKET;
		default:
			return View.TICKET;
		}
	}

	private View healthList() {
		List<TicketVo> list = healthService.hList();
		tktlist(list);
		ptbuy();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.TICKET_CART;
		case 2:
			return View.TICKET;
		default:
			return View.TICKET;
		}
	}

	private View cartUpdate() {
		OrdersVo cart = (OrdersVo) sessionStorage.get("cart");
		String param = cart.getOrder_no();

		List<Map<String, Object>> list = prodService.cartList(param);
		if (list != null) {
			cartList2(list);
		}
		cartupdate();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			// 상품 취소
			List<Object> para1 = new ArrayList();
			String no1 = ScanUtil.nextLine("상품코드를 입력해주세요 : ");
			para1.add(param);
			para1.add(no1);

			prodService.cartDelete(para1);
			return View.CART_LIST;
		case 2:
			// 상품 수량수정
			List<Object> para = new ArrayList();
			String no = ScanUtil.nextLine("수량 변경할 상품코드를 입력해주세요 : ");
			int qty = ScanUtil.nextInt("변경할 수량을 입력해주세요 : ");
			para.add(param);
			para.add(no);

			prodService.cartUpdate(para, qty);
			return View.CART_LIST;
		case 3:
			return View.PROD;
		default:
			return View.CART_LIST;
		}
	}

	private View cartBuy() {

		System.out.println("");
		printVar();
		String sel = ScanUtil.nextLine("결제 하시겠습니까? (Y/N):");
		if (sel.equalsIgnoreCase("y")) {

			int sum = (int) sessionStorage.get("ssum");
			OrdersVo cart = (OrdersVo) sessionStorage.get("cart");
			String no = cart.getOrder_no();

			List<Object> param = new ArrayList();
			param.add(no);
			prodService.cartBuy(param, sum);

			buycomplete();
			sessionStorage.remove("sum");
			return View.CART_BUY_LIST;
		} else if (sel.equalsIgnoreCase("n")) {
			buycancle();
			return View.PROD;
		}
		return View.CART_BUY;
	}

	private View cartBuyList() {

		MemberVo id = (MemberVo) sessionStorage.get("login");
		String u_id = id.getUsers_no();
		List<OrdersVo> list = prodService.cartBuyList(u_id);

		cartBuyList1(list);

		back();
		int sel = ScanUtil.nextInt("선택>> ");
		switch (sel) {
		case 1:
			return View.USER_MENU;
		default:
			return View.PROD;
		}
	}

	private View cartList() {
		// 장바구니 리스트
		MainController.sessionStorage.put("ssum", 0);
		OrdersVo cart = (OrdersVo) sessionStorage.get("cart");
		String param = cart.getOrder_no();

		List<Map<String, Object>> list = prodService.cartList(param);
		if (list != null) {
			System.out.println(" =================================== 장바구니 내역 ================================== ");
			System.out.println("   장바구니 번호\t\t상품코드\t\t수량\t단가\t합계");
			System.out.println(" ================================================================================  ");
			int s = (int) sessionStorage.get("ssum");

			for (Map<String, Object> vo : list) {
				String cart_no = (String) vo.get("ORDER_NO");
				String prod_no = (String) vo.get("PROD_NO");
				BigDecimal qty = (BigDecimal) vo.get("DETAIL_QTY");
				BigDecimal price = (BigDecimal) vo.get("PROD_PRICE");
				int qty1 = qty.intValue();
				int price1 = price.intValue();
				System.out.println(
						"  " + cart_no + "\t\t" + prod_no + "\t" + qty + "\t" + price + "\t" + (qty1 * price1));

				int sum = qty1 * price1;
				s = s + sum;
				sessionStorage.put("ssum", s);
			}
			System.out.println(" ================================================================================  ");
			cartListPrint();
			int sel = ScanUtil.nextInt("선택>>  ");
			switch (sel) {
			case 1:
				return View.CART_BUY;
			case 2:
				return View.CART_UPDATE;
			case 3:
				return View.PROD;
			default:
				return View.CART_LIST;
			}
		} else {
			cartnoprint();
			return View.PROD;
		}
	}

	private View prodSuppies() {
		String param = "P201";
		List<ProdVo> list = prodService.prodList(param);
		prodlist(list);

		prodbuyprint();
		int sel = ScanUtil.nextInt("선택>>  ");
		System.out.println("");
		switch (sel) {
		case 1:
			return View.PROD_CART;
		case 2:
			return View.PROD;
		default:
			return View.PROD;
		}
	}

	private View prodFood() {
		String param = "P101";
		List<ProdVo> food = prodService.prodList(param);
		prodlist(food);

		prodbuyprint();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.PROD_CART;
		case 2:
			return View.PROD;
		default:
			return View.PROD;
		}
	}

	private void prodCart1() {
		OrdersVo cart = (OrdersVo) sessionStorage.get("cart");
		MemberVo mem = (MemberVo) sessionStorage.get("login");

		List<Object> list = new ArrayList();

		String code = ScanUtil.nextLine("상품코드를 입력해주세요 : ");
		int qty = ScanUtil.nextInt("수량을 입력해주세요 : ");
		String cart_no = cart.getOrder_no();

		list.add(cart_no);
		list.add(code);

		prodService.prodBuy(list, qty);

	}

	private View prodCart2() {
		while (true) {
			prodCart1();

			cartinprint();
			int sel = ScanUtil.nextInt("선택>>  ");
			switch (sel) {
			case 1:
				return View.PROD;
			case 2:
				return View.CART_LIST;
			default:
				return View.PROD;
			}
		}
	}

	private View prod() {

		prod1();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.PROD_FOOD;
		case 2:
			return View.PROD_SUPPLIES;
		case 3:
			return View.CART_LIST;
		case 4:
			return View.CART_BUY_LIST;
		case 5:
			warning();
			String yn = ScanUtil.nextLine("홈으로 이동하시겠습니까?(Y/N) :");

			if (yn.equalsIgnoreCase("Y")) {
				return View.USER_MENU;
			} else if (yn.equalsIgnoreCase("N")) {
				return View.PROD;
			} else {
				System.out.println("잘못입력 되었습니다.");
			}
			return View.PROD;
		default:
			return View.PROD;
		}
	}

	private View feedback() {
		// 로그인 정보에서 id불러와서 동일 아이디가 작성한 피드백만 불러오기
		MemberVo login = (MemberVo) MainController.sessionStorage.get("login");
		String id = (String) login.getUsers_id();
		List<FeedBackVo> list = memService.feedbackList(id);
		feedbackList1(list);
		feedbacksel();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.FEEDBACK_INSERT;
		case 2:
			return View.FEEDBACK_UPDATE;
		case 3:
			return View.FEEDBACK_DELETE;
		case 4:
			return View.USER_MENU;
		default:
			return View.USER_MENU;
		}
	}

	private View feedInsert() {
		MemberVo login = (MemberVo) sessionStorage.get("login");
		String id = login.getUsers_no();

		List<Object> param = new ArrayList();
		String name = ScanUtil.nextLine("제목을 입력해주세요 :");
		String content = ScanUtil.nextLine("내용을 입력해주세요 :");

		param.add(name);
		param.add(content);

		memService.feedInsert(param, id);
		feedcomplete();

		return View.FEEDBACK;
	}

	private View feedUpdate() {
		int no = ScanUtil.nextInt("수정할 게시글 번호를 입력해주세요 :");
		List<Object> param = new ArrayList();
		String name = ScanUtil.nextLine("제목을 입력해주세요 :");
		String content = ScanUtil.nextLine("내용을 입력해주세요 :");
		param.add(name);
		param.add(content);
		memService.feedUpdate(param, no);
		feedcomplete2();
		return View.FEEDBACK;
	}

	private View feedDelete() {

		int no = ScanUtil.nextInt("삭제할 게시글 번호를 입력해주세요 :");
		memService.feedDelete(no);
		feedcomplete3();
		return View.FEEDBACK;
	}

	private View userMenu() {

		userMenu1();
		int sel = ScanUtil.nextInt("선택>> ");
		switch (sel) {
		case 1:
			return View.SESSION;
		case 2:
			return View.TKTSESSION;
		case 3:
			return View.USER_UPDATE;
		case 4:
			return View.FEEDBACK;
		case 5:
			return View.TKTGETLIST;
		case 6:
			String yn = ScanUtil.nextLine("로그아웃하시겠습니까?(Y/N) :");
			if (yn.equalsIgnoreCase("Y")) {
				sessionStorage.remove("login");
				sessionStorage.remove("cart");
				sessionStorage.remove("sum");
				logoutprint();
				return View.HOME;
			} else if (yn.equalsIgnoreCase("N")) {
				return View.USER_MENU;
			} else {
				return View.USER_MENU;
			}
		default:
			return View.USER_MENU;
		}

	}

	private View userUpdate() {
		MemberVo login = (MemberVo) MainController.sessionStorage.get("login");
		String id = login.getUsers_id();
		List<MemberVo> uid = memService.u_id();
		List<MemberVo> list = memService.userList(id);
		userList(list);
		userUpdate1();

		List<Object> param = new ArrayList();

		int sel = ScanUtil.nextInt("선택>> ");
		switch (sel) {
		case 1:
			while (true) {
				String nic = ScanUtil.nextLine("변경할 닉네임을 입력해주세요 :");
				if (!Pattern.matches("^[a-zA-Z0-9가-힣]{2,10}$", nic)) {
					System.out.println("닉네임 형식이 잘못되었습니다. 다시 입력해주세요.");
					continue;
				}

				boolean flag = true;
				for (MemberVo vo : uid) {
					if (vo.getUsers_nic().equals(nic)) {
						flag = false;
						System.out.println("중복된 닉네임입니다.");
						break;
					}
				}
				if (flag) {
					param.add(nic);
					break;
				}
			}
			param.add(id);
			memService.userUpdate(param, sel);
			return View.USER_UPDATE;
		case 2:
			while (true) {
				String tel = ScanUtil.nextLine("변경할 전화번호 입력해주세요 :");
				if (!Pattern.matches("^01[0|1|6|7|8|9]-[0-9]{4}-[0-9]{4}$", tel)) {
					System.out.println("전화번호 형식이 잘못되었습니다. 다시 입력해주세요.");
					continue;
				}

				boolean flag = true;
				for (MemberVo vo : uid) {
					if (vo.getUsers_tel().equals(tel)) {
						flag = false;
						System.out.println("이미 존재하는 전화번호입니다.");
						break;
					}
				}
				if (flag) {
					param.add(tel);
					break;
				}
			}
			param.add(id);
			memService.userUpdate(param, sel);
			return View.USER_UPDATE;
		case 3:
			String pass = ScanUtil.nextLine("변경할 비밀번호 입력해주세요 :");
			param.add(pass);
			param.add(id);
			memService.userUpdate(param, sel);
			return View.USER_UPDATE;
		case 4:
			return View.USER_MENU;
		default:
			return View.USER_MENU;
		}
	}

	

	private View userLogin() { // 회원 로그인
		System.out.println("===================================== 회원 로그인 ===================================\r\n");
		String id = ScanUtil.nextLine("아이디>> ");
		String pass = ScanUtil.nextLine("패스워드>> ");
		List<Object> list = new ArrayList();
		list.add(id);
		list.add(pass);
		boolean login = memService.login(list);
		if (!login) {
			loginfail();
			int sel = ScanUtil.nextInt("선택>> ");
			switch (sel) {
			case 1:
				return View.USER_LOGIN;
			case 2:
				return View.SIGNUP;
			case 3:
				return View.HOME;
			default:
				return View.LOGIN;
			}
		}
		MemberVo member = (MemberVo) sessionStorage.get("login");
		treeprint();
		System.out.println("\t\t" + member.getUsers_name() + "님 환영합니다!" + " \r\n");
		String no = member.getUsers_no();
		List<NoticeVo> list2 = memService.noticeList();
		noticeList1(list2);
		return View.USER_MENU;
	}

	private View tktsession() {// 이용권 세션(이용권 주문번호 생성)
		MemberVo mem = (MemberVo) sessionStorage.get("login");

		// (티켓)주문번호 생성
		List<Object> tktbuy = new ArrayList();
		String no = mem.getUsers_no();
		tktbuy.add(no);
		memService.tktcartin(tktbuy);

		// (상품)주문번호 세션스토리지 저장
		Tkt_buyVo tktcart_no = (Tkt_buyVo) memService.tktcartList(no);
		MainController.sessionStorage.put("tktcart", tktcart_no);

		// 주문번호
		Tkt_buyVo tktcart = (Tkt_buyVo) sessionStorage.get("tktcart");
//		System.out.println(cart.getOrder_no());

		// (이용권)주문번호 세션스토리지 저장
		// (이용권)주문번호 생성
//		order.add(no);
//		memService.cartin(order);

		return View.TICKET;
	}

	private View session() {// 상품 세션(상품 주문번호 생성)
		MemberVo mem = (MemberVo) sessionStorage.get("login");

		// (상품)주문번호 생성
		List<Object> order = new ArrayList();
		String no = mem.getUsers_no();
		order.add(no);
		memService.cartin(order);

		// (상품)주문번호 세션스토리지 저장
		OrdersVo cart_no = (OrdersVo) memService.cartList(no);
		MainController.sessionStorage.put("cart", cart_no);

		// 주문번호 확인 출력
		OrdersVo cart = (OrdersVo) sessionStorage.get("cart");
//		System.out.println(cart.getOrder_no());

		return View.PROD;
	}

	private View home() {
		pic();
		printHome();
		int sel = ScanUtil.nextInt("선택>> ");
		switch (sel) {
		case 1:
			return View.USER_LOGIN;
		case 2:
			return View.ADMIN_LOGIN;
		case 3:
			signup();
			return View.HOME;
		default:
			return View.HOME;
		}
	}

	private View signup() {
		join();
		List<MemberVo> uid = memService.u_id();
		List<Object> param = new ArrayList();

		// 이름 생성
		String name;
		while (true) {
			name = ScanUtil.nextLine("이름 입력(2~6자까지 가능) : ");
			if (Pattern.matches("^[가-힣]{2,6}$", name)) {
				param.add(name);
				break;
			}
			System.out.println("이름 형식이 잘못되었습니다. 다시 입력해주세요.");
		}

		// 아이디 생성
		String id;
		while (true) {
			id = ScanUtil.nextLine("아이디 입력(영문+숫자 6~10자 가능) : ");
			if (!Pattern.matches("^[a-zA-Z0-9]{6,10}$", id)) {
				System.out.println("아이디 형식이 잘못되었습니다. 다시 입력해주세요.");
				continue;
			}

			boolean flag = true;
			for (MemberVo vo : uid) {
				if (vo.getUsers_id().equals(id)) {
					flag = false;
					System.out.println("중복된 아이디입니다.");
					break;
				}
			}
			if (flag) {
				param.add(id);
				break;
			}
		}

		// 비밀번호
		while (true) {
			String pass = ScanUtil.nextLine("비밀번호 입력(영문+숫자 6~10자 가능) : ");
			if (Pattern.matches("^[a-zA-Z0-9]{6,12}$", pass)) {
				param.add(pass);
				break;
			}
			System.out.println("비밀번호 형식이 잘못되었습니다. 다시 입력해주세요.");
		}

		// 닉네임 생성
		String nic;
		while (true) {
			nic = ScanUtil.nextLine("닉네임 입력(2~10자 가능) : ");
			if (!Pattern.matches("^[a-zA-Z0-9가-힣]{2,10}$", nic)) {
				System.out.println("닉네임 형식이 잘못되었습니다. 다시 입력해주세요.");
				continue;
			}

			boolean flag = true;
			for (MemberVo vo : uid) {
				if (vo.getUsers_nic().equals(nic)) {
					flag = false;
					System.out.println("중복된 닉네임입니다.");
					break;
				}
			}
			if (flag) {
				param.add(nic);
				break;
			}
		}

		// 전화번호 생성
		String tel;
		while (true) {
			tel = ScanUtil.nextLine("전화번호 입력(000-0000-0000 형식) : ");
			if (!Pattern.matches("^01[0|1|6|7|8|9]-[0-9]{4}-[0-9]{4}$", tel)) {
				System.out.println("전화번호 형식이 잘못되었습니다. 다시 입력해주세요.");
				continue;
			}

			boolean flag = true;
			for (MemberVo vo : uid) {
				if (vo.getUsers_tel().equals(tel)) {
					flag = false;
					System.out.println("이미 존재하는 전화번호입니다.");
					break;
				}
			}
			if (flag) {
				param.add(tel);
				break;
			}
		}
		memService.init(param);
		System.out.print("　 " + "\r\n"
				+ "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + "┃     "
				+ name
				+ "님 가입을 환영합니다! 다시 로그인해주세요                                                                                ┃\r\n"
				+ "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n");
		return View.HOME;
	}

}


