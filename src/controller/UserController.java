package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import print.Print;
import service.BoardService;
import service.HealthService;
import service.MemberService;
import service.ProdService;
import util.ScanUtil;
import util.View;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.OrdersVo;
import vo.ProdVo;
import vo.TicketVo;
import vo.Tkt_buyVo;

public class UserController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	ProdService prodService = ProdService.getInstance();
	MemberService memService = MemberService.getInstance();
	HealthService healthService = HealthService.getInstance();
	BoardService boardService = BoardService.getInstance();	

	
	View ptMenu() {//pt메뉴
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

	View ptListAll() {//직원번호 선택
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

	View ptList() {//이용권 구입
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

	View ptnameList() {//pt트레이너 리스트
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

	View yogaList() {//요가 리스트
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

	View healthList() {//헬스 리스트
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

	View cartUpdate() {//상품 수량 수정
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

	View cartBuy() {//상품결제

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

	View cartBuyList() {//상품 구입내역 리스트

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

	View cartList() {//장바구니 리스트
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

	View prodSuppies() {//상품(운동용품)선택
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

	View prodFood() {//상품(음식)선택
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

	void prodCart1() {//상품구입1
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

	View prodCart2() {//상품구입2
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

	View prod() {//상품메뉴

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

	View feedback() {//유저 피드백 게시판 
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

	View feedInsert() {//유저 피드백 게시판 작성
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

	View feedUpdate() {//유저 피드백 게시판 수정
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

	View feedDelete() {//유저 피드백 게시판 삭제

		int no = ScanUtil.nextInt("삭제할 게시글 번호를 입력해주세요 :");
		memService.feedDelete(no);
		feedcomplete3();
		return View.FEEDBACK;
	}

	View userMenu() {//유저 메인메뉴

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

	View userUpdate() {//회원정보 수정
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

	View userLogin() { // 회원 로그인
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

	View tktsession() {// 이용권 세션(이용권 주문번호 생성)
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

	View session() {// 상품 세션(상품 주문번호 생성)
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
	
	
}
