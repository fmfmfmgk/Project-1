package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
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


public class MainController extends Print{
	static public Map<String, Object> sessionStorage = new HashMap<>();
	ProdService prodService = ProdService.getInstance();
	MemberService memService = MemberService.getInstance();
	HealthService healthService = HealthService.getInstance();

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
			case USER_MENU:
				view = userMenu();
				break;
			case USER_UPDATE:
				view = userUpdate();
				break;
				
				
				
				
			case TICKET:
				view = ticket();
				break;
			case TICKET_BUY:
				view = ticketBuy();
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
				
				
			case PT_MENU:
				view = ptMenu();
				break;
			case PT_LIST:
				view = ptList();
				break;
			case YOGA_BUY:
				view = yogaBuy();
				break;
			case HEALTH_BUY:
				view = healthBuy();
				break;
				
				
			case PROD:
				view = prod();
				break;
			case PROD_FOOD:
				view = prodFood();
				break;
			case PROD_SUPPLIES:
				view = prodSuppies();
				break;
			case CART_LIST:
				view = cartList();
				break;
			case CART_BUY:
				view = cartBuy();
				break;
			case CART_UPDATE:
				view = cartUpdate();
				break;
				
				

			
			default:
				view = home();
				break;
			}
		}
	}

	

	private View healthBuy() {
		
		return null;
	}

	private View yogaBuy() {
		
		return null;
	}

	private View ptMenu() {
		System.out.println("PT선택 메뉴");
		
		System.out.println("1. 전체 리스트");
		System.out.println("2. 이름 검색");
		System.out.println("3. 돌아가기");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.PT_LIST_DETAIL;
		case 2:
			return View.PT_SEARCH;
		case 3:
			return View.TICKET;
		default:
			return View.PT_MENU;
		}
	}
	
	private View ptList() {
		System.out.println("[pt 선생님 전체 리스트 출력] ");
		
		String param = "PT";
		List<EmpVo> list = memService.ptList(param);
		ptList(list);
		
//		for (int i = 0; i < list.size(); i++) {
//	          String numberedData = (i + 1) + ". " + list.get(i); // 번호와 데이터를 결합하여 새로운 문자열 생성
//	          System.out.println(numberedData); // 번호가 붙은 데이터를 콘솔에 출력
//	    }
		System.out.println("해당 트레이너 번호선택 : ");
		System.out.println("선택후 이용권 구매 화면으로 전환");
		int sel = ScanUtil.nextInt("번호 선택 : ");
		switch (sel) {
		case 1:
			return View.PT_LIST;
		case 2:
			return View.YOGA_BUY;
		case 3:
			return View.HEALTH_BUY;
		default:
			return View.TICKET;
		}
		
	}

	private View ticketBuy() {
		System.out.println("이용권구매 페이지");
		
		return null;
	}

	private View ticket() {
		System.out.println("----이용권판매 페이지----");
		
		System.out.println("[장바구니 리스트출력]");
		
		ticket1();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.PT_LIST;
		case 2:
			return View.YOGA_BUY;
		case 3:
			return View.HEALTH_BUY;
		default:
			return View.TICKET;
		}
	}

	private View cartBuy() {
		System.out.println("[장바구니 리스트 보여주고 구입]");
		String sel = ScanUtil.nextLine("구매하시겠습니까?(Y/N)");
		if(sel.equals("Y")) {
			System.out.println("구입진행 후 메인메뉴로");
			return View.USER_MENU;
		}else if(sel.equals("N")) {
			System.out.println("상품구매 페이지로");
			return View.PROD;
		}
		return View.CART_BUY;
	}
	
	private View cartUpdate() {
		System.out.println("[장바구니 리스트 출력]");
		
		System.out.println("1.상품 취소");
		System.out.println("2.상품 수량 수정");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.CART_CANCEL_ONE;
		case 2:
			return View.CART_UPDATE_QTY;
		default:
			return View.CART_LIST;
		}
	}

	private View cartList() {
		System.out.println("[장바구니 리스트출력]");
		
		
		cartList1();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.CART_BUY;
		case 2:
			return View.PROD_SUPPLIES;
		case 3:
			return View.CART_CANCEL;
		default:
			return View.CART_LIST;
		}
	}

	private View prodSuppies() {
		System.out.println("[운동용품 리스트 출력]");
		
		String param = "P201";
		List<ProdVo> list = prodService.prodList(param);
		prodlist(list);
		
		System.out.println("1.구입");
		System.out.println("2.뒤로가기");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		System.out.println("");
		switch (sel) {
		case 1:
			System.out.println("번호 선택 후 장바구니(Y/N)");
			return View.PROD_SUPPLIES;
		case 2:
			return View.PROD;
		default:
			return View.PROD;
		}
	}

	private View prodFood() {
		System.out.println("[음식 리스트 출력]");

		String param = "P101";
		List<ProdVo> list = prodService.prodList(param);
		prodlist(list);
		System.out.println("1.메뉴 구입");
		System.out.println("1.뒤로가기");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			System.out.println("제품번호를 선택하세요: ");
			return View.PROD_FOOD;
		case 2:
			return View.PROD;
		default:
			return View.PROD;
		}
		
	}

	private View prod() {
		System.out.println("----상품구매----");
		
		prod1();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.PROD_FOOD;
		case 2:
			return View.PROD_SUPPLIES;
		case 3:
			return View.CART_LIST;
		case 4:
			return View.USER_MENU;
		default:
			return View.PROD;
		}
	}
	
	private View feedback() {
		System.out.println("---피드백 게시판---");
		
		//로그인 정보에서 id불러와서 동일 아이디가 작성한 피드백만 불러오기
		MemberVo login = (MemberVo)MainController.sessionStorage.get("login");
		String id = (String) login.getUsers_id();
		List<FeedBackVo> list = memService.feedbackList(id);
		
		feedbackList1(list);
		System.out.println("1. 게시판 작성");
		System.out.println("2. 게시판 수정");
		System.out.println("3. 게시판 삭제");
		System.out.println("4. 돌아가기");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
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
		MemberVo login = (MemberVo)sessionStorage.get("login");
		String id = login.getUsers_no();
		
		List<Object> param = new ArrayList();
		String name = ScanUtil.nextLine("제목입력 : ");
		String content = ScanUtil.nextLine("내용입력 : ");
		
		param.add(name);
		param.add(content);
		
		memService.feedInsert(param, id);
		
		return View.FEEDBACK;
	}
	
	private View feedUpdate() {
		int no = ScanUtil.nextInt("수정할 게시글 번호 선택 : ");
		
		List<Object> param = new ArrayList();
		
		
		String name = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		
		param.add(name);
		param.add(content);
		
		memService.feedUpdate(param, no);
		System.out.println("게시글 수정이 완료되었습니다.");
		System.out.println(" ");
		
		return View.FEEDBACK;
	}
	
	private View feedDelete() {
		
		int no = ScanUtil.nextInt("삭제할 게시글 번호 선택 : ");
		
		memService.feedDelete(no);
		
		System.out.println("게시글 삭제가 완료되었습니다.");
		return View.FEEDBACK;
	}
	
	private View userMenu() {
		List<NoticeVo> list = memService.noticeList();
		
		noticeList1(list);
		
		System.out.println("[보유 이용권 현황 출력]");
		
		
		userMenu1();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.PROD;
		case 2:
			return View.TICKET;
		case 3:
			return View.USER_UPDATE;
		case 4:
			return View.FEEDBACK;
		case 5:
			return View.LOGOUT;
		default:
			return View.USER_MENU;
		}
	
	}
	
	private View userUpdate() {
		MemberVo login = (MemberVo)MainController.sessionStorage.get("login");
		String id = login.getUsers_id();
		
		List<MemberVo> list = memService.userList(id);
		userList(list);
		userUpdate1();
		int sel = ScanUtil.nextInt("번호입력: ");
		switch (sel) {
		case 1:
			List<Object> param = new ArrayList();
			String name = ScanUtil.nextLine("변경할 닉네임 입력: ");
			
			param.add(name);
			param.add(id);
			
			memService.userUpdate(param, sel);
			return View.USER_UPDATE;
		case 2:
			List<Object> param1 = new ArrayList();
			String tel = ScanUtil.nextLine("변경할 전화번호 입력: ");
			
			param1.add(tel);
			param1.add(id);
			
			memService.userUpdate(param1, sel);
			return View.USER_UPDATE;
		case 3:
			List<Object> param2 = new ArrayList();
			String pass = ScanUtil.nextLine("변경할 비밀번호 입력: ");
			
			param2.add(pass);
			param2.add(id);
			
			memService.userUpdate(param2, sel);
			return View.USER_UPDATE;
		case 4:
			return View.USER_MENU;
			
		default:
			return View.USER_MENU;
		}
	}
	
	private View adminLogin() {
		
		System.out.println("-----------관리자로그인-----------");
		String id =ScanUtil.nextLine("ID>>");
		String pass =ScanUtil.nextLine("PASS>>");
		
		List<Object> list = new ArrayList();
		list.add(id);
		list.add(pass);
		
		
		boolean login = memService.adminLogin(list);
		MemberVo admin = (MemberVo)sessionStorage.get("adminLogin");
		System.out.println("*"+admin.getUsers_name()+"*관리자님 환영합니다.");
		
		return View.ADMIN;
	}

	private View userLogin() {
		System.out.println("-------로그인 --------");
		String id   = ScanUtil.nextLine("ID>>");
		String pass = ScanUtil.nextLine("PASS>>");
		
		List<Object> list = new ArrayList();
		list.add(id);
		list.add(pass);
		
		boolean login = memService.login(list);
		if(!login) {
			System.out.println("1. 다시 로그인");
			System.out.println("2. 회원 가입");
			System.out.println("3. 홈");
			int sel = ScanUtil.nextInt("메뉴 선택 : ");
			switch (sel) {
			case 1:
				return View.LOGIN;
			case 2:
				return View.SIGNUP;
			case 3:
				return View.HOME;
			default:
				return View.LOGIN;
			}
		}
		MemberVo member = (MemberVo) sessionStorage.get("login");
		System.out.println(member.getUsers_name()+"님 환영합니다.");
		String no = member.getUsers_no();
		
		
		//주문번호를 세션 스토리지에 저장
		OrdersVo cart_no = (OrdersVo)memService.cartList(no);
		MainController.sessionStorage.put("cart", cart_no);
		//주문번호 확인 출력
		OrdersVo cart = (OrdersVo)sessionStorage.get("cart");
		System.out.println(cart.getOrder_no());
		
		return View.USER_MENU;
	}
	
	private View home() {
		printHome();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.USER_LOGIN;
		case 2:
			return View.ADMIN_LOGIN;
		case 3:
			return View.SIGNUP;
		default:
			return View.HOME;
		}
	}
}
