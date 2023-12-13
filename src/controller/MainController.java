package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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


public class MainController extends Print{
	static public Map<String, Object> sessionStorage = new HashMap<>();
	ProdService prodService = ProdService.getInstance();
	MemberService memService = MemberService.getInstance();
	HealthService healthService = HealthService.getInstance();
	AdminService adService = AdminService.getInstance();
	BoardService boardService = BoardService.getInstance();
	
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

			
				
				
				
				
				//관리자
			case ADMIN_LOGIN:
				view = adminLogin();
				break;
			case ADMIN_MENU:
				view = adminMenu();
				break;
			case ADMIN_USER:
				view = adminUser();
				break;	
			case USER_LIST:
				view = userList();
				break;	
			case USER_DELETE:
				view = userDelete();
				break;	
			case ADMIN_PROD:
				view = adminProd();
				break;	
			case ADMIN_PRODLIST:
				view = adminProdList();
				break;	
			case ADMIN_PROD_FOOD:
				view = adminProdFood();
				break;	
			case FOOD_UPDATE:
				view = foodUpdate();
				break;	
			case FOOD_DELETE:
				view = foodDelete();
				break;	
			case ADMIN_PROD_SUPPLY:
				view = adminProdSupply();
				break;	
			case SUPPLY_UPDATE:
				view = supplyUpdate();
				break;	
			case SUPPLY_DELETE:
				view = supplyDelete();
				break;	
			case PROD_INSERT:
				view = prodInsert();
				break;
			case ADMIN_BOARD:
				view = adminBoard();
				break;	
			case EMP_LIST:
				view = empList();
				break;	
			case EMP_UPDATE:
				view = empUpdate();
				break;	
			case EMP_DELETE:
				view = empDelete();
				break;	
				
			case NOTICE:
				view = noticeList();
				break;	
			case NOTICE_INSERT:
				view = noticeInsert();
				break;	
			case NOTICE_UPDATE:
				view = noticeUpdate();
				break;	
			case NOTICE_DELETE:
				view = noticeDelete();
				break;	
				
			case FEEDBACK_LIST:
				view = feedbackList();
				break;	
			case FEEDBACK_CHK:
				view = feedbackChk();
				break;	
			case ADMIN_TICKET:
				view = adminTkt();
				break;	
				
			case TICKET_INSERT:
				view = tktInsert();
				break;	
			case TICKET_UPDATE:
				view = tktUpdate();
				break;	
			case TICKET_DELETE:
				view = tktDelete();
				break;		
			
				
				
			default:
				view = home();
				break;
			}
		}
	}
	
	



	private View tktDelete() {
		String select = ScanUtil.nextLine("삭제할 이용권 번호를 입력하세요.");
		List<Object> param = new ArrayList();
		param.add(select);
		prodService.tktDelete(param);
		System.out.println(param+"번 이용권이 삭제되었습니다.");
		return View.ADMIN_TICKET;
	}

	private View tktUpdate() {
		List<TicketVo> list = prodService.tktList();
		tktlist(list);

		String tktno = ScanUtil.nextLine("수정할 이용권번호를 입력하세요.");
		System.out.println("-------------------이용권 수정---------------------");
		System.out.println("수정할 정보를 선택하세요 :");
		System.out.println("1. 전체정보");
		System.out.println("2. 이용권이름");
		System.out.println("3. 이용권종류");
		System.out.println("4. 이용권가격");
		System.out.println("5. 이용권기간");
		System.out.println("----------------------------------------------");
		
		int menu = ScanUtil.nextInt("메뉴 선택 : ");
		List<Object> param = new ArrayList();
		String name;
		String lgu;
		int price;
		int time;
		
		if(menu ==1 || menu ==2) {
			name = ScanUtil.nextLine("이용권이름 : ");
			param.add(name);
		}
		if(menu ==1 || menu ==3) {
			lgu = ScanUtil.nextLine("이용권종류 : ");
			param.add(lgu);
		}
		if(menu ==1 || menu ==4) {
			price = ScanUtil.nextInt("이용권가격 : ");
			param.add(price);
		}
		if(menu ==1 || menu ==5) {
			time = ScanUtil.nextInt("이용권기간 : ");
			param.add(time);
		}
		if(menu ==6) {
			return View.ADMIN_TICKET;
		}
		param.add(tktno);
		prodService.tktUpdate(param,menu);
		
		return View.ADMIN_TICKET;
	}

	private View tktInsert() {
		List<Object> param = new ArrayList();
		
		String no = ScanUtil.nextLine("상품번호 :");
		String name = ScanUtil.nextLine("상품이름 :");
		String lgu = ScanUtil.nextLine("상품종류:");
		int price = ScanUtil.nextInt("상품가격 :");
		String emp = ScanUtil.nextLine("담당직원 :");
		int time = ScanUtil.nextInt("이용권기간 :");
		
		param.add(no);
		param.add(name);
		param.add(lgu);
		param.add(price);
		param.add(emp);
		param.add(time);
		
		System.out.println("이용권 등록이 완료되었습니다");
		prodService.tktInsert(param);
		
		return View.ADMIN_TICKET;
	}

	private View adminTkt() {
		List<TicketVo> list = prodService.tktList();
		tktlist(list);
		System.out.println("1.추가하기");
		System.out.println("2.수정하기");
		System.out.println("3.삭제하기");
		System.out.println("4.뒤로가기");
		int select = ScanUtil.nextInt("메뉴 선택 : ");
		switch (select) {
		case 1:
			return View.TICKET_INSERT;
		case 2:
			return View.TICKET_UPDATE;
		case 3:
			return View.TICKET_DELETE;
		case 4:
			return View.ADMIN_MENU;
		default:
			return View.ADMIN_MENU;
		}
	}

	private View feedbackChk() {
		List<FeedBackVo> list = boardService.FeedbackListN();
		feedbackList2(list); //피드백 확인필요 사항 출력
		int no = ScanUtil.nextInt("피드백 게시글 번호를 입력해주세요 : ");
		String yn = ScanUtil.nextLine("해당 게시글을 확인완료 처리 하시겠습니까?(y/n) : ");
		if (yn.equalsIgnoreCase("y")) {
			boardService.feedbackChk(no);
			System.out.println("해당 피드백이 완료처리 되었습니다.");
			
		}else {
			return View.ADMIN_BOARD;
		}
		return View.FEEDBACK_LIST;
	}

	private View feedbackList() { //이용권 후에 다시 하기
		List<FeedBackVo> list = boardService.FeedbackList();
		feedbackList2(list); //피드백 확인필요 사항 출력
		System.out.println("1. 피드백 확인");
		System.out.println("2. 뒤로가기");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.FEEDBACK_CHK;
		case 2:
			return View.ADMIN_BOARD;
		default:
			return View.ADMIN_MENU;	
		}
	}
	
	private View noticeDelete() {
		int no = ScanUtil.nextInt("삭제할 게시글 번호 선택 : ");
		boardService.noticeDelete(no);
		
		System.out.println("게시글 삭제가 완료되었습니다.");
		return View.NOTICE;
	}

	private View noticeUpdate() {
		List<NoticeVo> list = memService.noticeList();
		noticeList1(list);
		int no = ScanUtil.nextInt("수정할 공지사항 번호 선택 : ");
		List<Object> param = new ArrayList();
		
		String title = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		
		param.add(title);
		param.add(content);
		
		boardService.noticeUpdate(param, no);
		System.out.println("공지사항 수정이 완료되었습니다.");
		System.out.println(" ");
		
		return View.NOTICE;
	}

	private View noticeInsert() {
		  AdminVo login = (AdminVo)sessionStorage.get("adminLogin");
	      String id = login.getAdmin_no();
	      
	      List<Object> param = new ArrayList();
	      String name = ScanUtil.nextLine("제목입력 : ");
	      String content = ScanUtil.nextLine("내용입력 : ");
	      
	      param.add(name);
	      param.add(content);
	      
	      boardService.noticeInsert(param,id);
	      System.out.println("공지사항 입력이 완료되었습니다.");
	      
	      return View.NOTICE;
	}

	private View noticeList() {
		List<NoticeVo> list = memService.noticeList();
		noticeList1(list);
		
		System.out.println("1. 공지사항 작성");
		System.out.println("2. 공지사항 수정");
		System.out.println("3. 공지사항 삭제");
		System.out.println("4. 뒤로가기");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.NOTICE_INSERT;
		case 2:
			return View.NOTICE_UPDATE;
		case 3:
			return View.NOTICE_DELETE;
		case 4:
			return View.ADMIN_BOARD;
		default:
			return View.ADMIN_MENU;	
		}
	}
	
	private View adminBoard() {
		adminboard();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.NOTICE;
		case 2:
			return View.FEEDBACK_LIST;
		case 3:
			return View.ADMIN_MENU;
		default:
			return View.ADMIN_MENU;	
		}
	}
	
	private View empDelete() {
		List<EmpVo> list = adService.empList();
		empList(list);
		
		String select = ScanUtil.nextLine("삭제할 직원 번호를 입력하세요.");
		List<Object> param = new ArrayList();
		param.add(select);
		adService.empDelete(param);
		System.out.println(param+" 직원이 되었습니다.");
	
		return View.EMP_LIST;
	}
	
	private View empUpdate() {
		List<EmpVo> list = adService.empList();
		empList(list);

		String empno = ScanUtil.nextLine("수정할 직원 번호를 입력하세요.");
		System.out.println("-------------------상품 수정---------------------");
		System.out.println("수정할 정보를 선택하세요 :");
		System.out.println("1. 전체정보");
		System.out.println("2. 연락처");
		System.out.println("3. 담당업무");
		System.out.println("4. 평가");
		System.out.println("5. 뒤로가기");
		System.out.println("----------------------------------------------");
		
		int menu = ScanUtil.nextInt("메뉴 선택 : ");
		List<Object> param = new ArrayList();
		String emp_tel;
		String emp_lgu;
		String emp_eva;
		
		if(menu ==1 || menu ==2) {
			emp_tel = ScanUtil.nextLine("연락처 : ");
			param.add(emp_tel);
		}
		if(menu ==1 || menu ==3) {
			emp_lgu = ScanUtil.nextLine("담당업무 : ");
			param.add(emp_lgu);
		}
		if(menu ==1 || menu ==4) {
			emp_eva = ScanUtil.nextLine("평가 : ");
			param.add(emp_eva);
		}
		if(menu ==5) {
			return View.EMP_LIST;
		}
		param.add(empno);
		adService.empUpdate(param,menu);
		
		return View.EMP_LIST;
	}
	
	private View empList() {
		List<EmpVo> list = adService.empList();
		empList(list);
		System.out.println("1.뒤로가기");
		System.out.println("2.수정하기");
		System.out.println("3.삭제하기");
		int select = ScanUtil.nextInt("메뉴 선택 : ");
		switch (select) {
		case 1:
			return View.ADMIN_MENU;
		case 2:
			return View.EMP_UPDATE;
		case 3:
			return View.EMP_DELETE;
		default:
			return View.HOME;
		}
	}

	private View supplyDelete() {
		String select = ScanUtil.nextLine("삭제할 상품(운동용품) 번호를 입력하세요.");
		List<Object> param = new ArrayList();
		param.add(select);
		prodService.supplyDelete(param);
		System.out.println(param+"번 상품(운동용품)이 폐기되었습니다.");
		return View.ADMIN_PROD_SUPPLY;
	}
	
	private View supplyUpdate() {
		String param = "P201";
		List<ProdVo> list = prodService.prodList(param);
		
		String prodno = ScanUtil.nextLine("수정할 상품(운동용품) 번호를 입력하세요.");
		System.out.println("-------------------상품 수정---------------------");
		System.out.println("수정할 정보를 선택하세요 :");
		System.out.println("1. 상품(운동용품)전체정보");
		System.out.println("2. 상품(운동용품)이름");
		System.out.println("3. 상품(운동용품)내용");
		System.out.println("4. 상품(운동용품)가격");
		System.out.println("5. 뒤로가기");
		System.out.println("----------------------------------------------");
		
		int menu = ScanUtil.nextInt("메뉴 선택 : ");
		List<Object> param2 = new ArrayList();
		String name;
		String content;
		int price;
		
		if(menu ==1 || menu ==2) {
			name = ScanUtil.nextLine("상품(운동용품)이름 : ");
			param2.add(name);
		}
		if(menu ==1 || menu ==3) {
			content = ScanUtil.nextLine("상품(운동용품)내용 : ");
			param2.add(content);
		}
		if(menu ==1 || menu ==4) {
			price = ScanUtil.nextInt("상품(운동용품)가격 : ");
			param2.add(price);
		}
		if(menu ==5) {
			return View.ADMIN_PROD_SUPPLY;
		}
		param2.add(prodno);
		prodService.prodUpdate(param2,menu);
		
		return View.ADMIN_PROD_SUPPLY;
	}
	
	private View adminProdSupply() {
		System.out.println("[운동용품 리스트 출력]");

		String param = "P201";
		List<ProdVo> list = prodService.prodList(param);
		prodlist(list);
		System.out.println("1. 수정하기");
		System.out.println("2. 삭제하기");
		System.out.println("3. 뒤로가기");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.SUPPLY_UPDATE;
		case 2:
			return View.SUPPLY_DELETE;
		case 3:
			return View.ADMIN_PRODLIST;
		default:
			return View.ADMIN_PROD_SUPPLY;
		}
	}
	
	private View foodDelete() {
		String select = ScanUtil.nextLine("삭제할 상품(음식) 번호를 입력하세요.");
		List<Object> param = new ArrayList();
		param.add(select);
		prodService.foodDelete(param);
		System.out.println(param+"번 상품(음식)이 폐기되었습니다.");
		return View.ADMIN_PROD_FOOD;
	}

	private View foodUpdate() {
		
		String param = "P101";
		List<ProdVo> list = prodService.prodList(param);

//		번호로 선택하는거 만들다가 중단
//		int select = ScanUtil.nextInt("수정할 상품 번호를 입력하세요.");
//		int i=1;           
//		for(ProdVo prod : list) {
//			System.out.println(i++);
//			System.out.println(prod);
//		}
//		
		String prodno = ScanUtil.nextLine("수정할 상품 번호를 입력하세요.");
		System.out.println("-------------------상품 수정---------------------");
		System.out.println("수정할 정보를 선택하세요 :");
		System.out.println("1. 상품(음식)전체정보");
		System.out.println("2. 상품(음식)이름");
		System.out.println("3. 상품(음식)내용");
		System.out.println("4. 상품(음식)가격");
		System.out.println("5. 뒤로가기");
		System.out.println("----------------------------------------------");
		
		int menu = ScanUtil.nextInt("메뉴 선택 : ");
		List<Object> param2 = new ArrayList();
		String name;
		String content;
		int price;
		
		if(menu ==1 || menu ==2) {
			name = ScanUtil.nextLine("상품이름 : ");
			param2.add(name);
		}
		if(menu ==1 || menu ==3) {
			content = ScanUtil.nextLine("상품내용 : ");
			param2.add(content);
		}
		if(menu ==1 || menu ==4) {
			price = ScanUtil.nextInt("상품가격 : ");
			param2.add(price);
		}
		if(menu ==5) {
			return View.ADMIN_PROD_FOOD;
		}
		param2.add(prodno);
		prodService.prodUpdate(param2,menu);
		
		return View.ADMIN_PROD_FOOD;
	}

	private View adminProdFood() {
		System.out.println("[음식 리스트 출력]");
		String param = "P101";
		List<ProdVo> list = prodService.prodList(param);
		prodlist(list);
		System.out.println("1. 수정하기");
		System.out.println("2. 삭제하기");
		System.out.println("3. 뒤로가기");
		
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.FOOD_UPDATE;
		case 2:
			return View.FOOD_DELETE;
		case 3:
			return View.ADMIN_PRODLIST;
		default:
			return View.ADMIN_PROD_FOOD;
		}
	}
	
	private View prodInsert() {
		List<Object> param = new ArrayList();
		String prodNo = ScanUtil.nextLine("상품종류:");
		String prodnm = ScanUtil.nextLine("상품이름 :");
		String prodcon = ScanUtil.nextLine("상품내용 :");
		int prodprice = ScanUtil.nextInt("상품가격 :");
		
		param.add(prodNo);
		param.add(prodNo);
		param.add(prodnm);
		param.add(prodcon);
		param.add(prodprice);
		System.out.println("상품등록이 완료되었습니다");
		prodService.foodInsert(param);
		
		return View.ADMIN_PRODLIST;
	}

	private View adminProdList() {
		adminprod2();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.ADMIN_PROD_FOOD;
		case 2:
			return View.ADMIN_PROD_SUPPLY;
		case 3:
			return View.ADMIN_MENU;
		default:
			return View.ADMIN_PROD;	
		}
	}

	private View adminProd() {
		System.out.println("----상품관리----");
		
		adminprod();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.ADMIN_PRODLIST;
		case 2:
			return View.PROD_INSERT;
		case 3:
			return View.ADMIN_MENU;
		default:
			return View.ADMIN_PROD;	
		}
	}

	private View adminUser() {
		System.out.println("----회원관리----");
		
		adminuser();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.USER_LIST;
		case 2:
			return View.USER_DELETE;
		case 3:
			return View.ADMIN_MENU;
		default:
			return View.USER;
		}
	}
	
	private View adminMenu() {
		
		adminMenu1();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.ADMIN_USER;
		case 2:
			return View.ADMIN_PROD;
		case 3:
			return View.ADMIN_BOARD;
		case 4:
			return View.EMP_LIST;
		case 5:
			return View.ADMIN_TICKET;
		case 6:
			AdminVo admin = (AdminVo) sessionStorage.remove("adminLogin"); // 로그아웃- 데이터가 없어짐..?
			System.out.println(admin.getAdmin_nm() + "님 로그아웃 되셨습니다.");
			return View.LOGIN;
		default:
			return View.LOGIN;
		}
	
	}
	
	private View userDelete() {
		List<MemberVo> list = memService.userList2();
		userList(list);
		
		String select = ScanUtil.nextLine("삭제할 회원 번호 입력 : ");
		List<Object> param = new ArrayList();
		param.add(select);
		adService.userDelete(param);
		System.out.println("회원 삭제가 완료되었습니다.");
		return View.USER_LIST;
	}
	// 관리자
	private View userList() {
		List<MemberVo> list = memService.userList2();
		userList(list);

		System.out.println("1.뒤로가기");
		int select = ScanUtil.nextInt("메뉴 선택 : ");
		switch (select) {
		case 1:
			return View.ADMIN_USER;
		default:
			return View.HOME;
		}
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
		
		ticket1();
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.PT_LIST;
		case 2:
			return View.YOGA_LIST;
		case 3:
			return View.HEALTH_LIST;
		default:
			return View.TICKET;
		}
	}
	
	private View yogaList() {
		
		System.out.println("이용권 출력");
		List<TicketVo> list = healthService.tList();
		tlist(list);
		
		int sel = ScanUtil.nextInt("이용권 선택 : ");
		
		return View.TICKET;
	}
	
	private View healthList() {
		
		System.out.println("이용권 출력");
		List<TicketVo> list = healthService.hList();
		tlist(list);
		
		int sel = ScanUtil.nextInt("이용권 선택 : ");
		
		return View.TICKET;
	}
	
	private View cartUpdate() {
		OrdersVo cart = (OrdersVo)sessionStorage.get("cart");
		String param = cart.getOrder_no();
		
		List<Map<String, Object>> list = prodService.cartList(param);
		if(list != null) {
		cartList2(list);
		}
		System.out.println("1.상품 취소");
		System.out.println("2.상품 수량 수정");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
		switch (sel) {
		case 1:
			//상품 취소
			List<Object> para1 = new ArrayList();
			String no1 = ScanUtil.nextLine("상품번호 입력: ");
			para1.add(param);
			para1.add(no1);
			
			prodService.cartDelete(para1);
			return View.CART_LIST;
		case 2:
			//상품 수량수정
			List<Object> para = new ArrayList();
			String no = ScanUtil.nextLine("상품번호 입력: ");
			int qty = ScanUtil.nextInt("수량 입력: ");
			para.add(param);
			para.add(no);
			
			prodService.cartUpdate(para, qty);
			return View.CART_LIST;
		default:
			return View.CART_LIST;
		}
	}
	
	private View cartBuy() {
		
		System.out.println("");
		String sel = ScanUtil.nextLine("구매하시겠습니까?(Y/N)");
		
		if(sel.equalsIgnoreCase("y")) {
			
			int sum = (int)sessionStorage.get("ssum");
			OrdersVo cart = (OrdersVo)sessionStorage.get("cart");
			String no = cart.getOrder_no();
			
			List<Object> param = new ArrayList();
			param.add(no);
			prodService.cartBuy(param, sum);
			
			System.out.println("구입이 완료되었습니다.");
			sessionStorage.remove("sum");
			return View.USER_MENU;
		}else if(sel.equalsIgnoreCase("n")) {
			System.out.println("상품구매 페이지로");
			return View.PROD;
		}
		return View.CART_BUY;
	}

	private View cartBuyList() {
		System.out.println("------구매내역 리스트-------");
		
		
		MemberVo id = (MemberVo)sessionStorage.get("login");
		String u_id = id.getUsers_no();
		List<OrdersVo> list = prodService.cartBuyList(u_id);
		
		System.out.println("1.돌아가기");
		int sel = ScanUtil.nextInt("메뉴선택: ");
		switch (sel) {
			case 1:
				return View.PROD;
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
			
			System.out.println("----------------------장바구니 리스트------------------------");
			System.out.println("장바구니 번호\t제품코드\t수량\t단가\t합계");
			System.out.println("--------------------------------------------------------");
			int s = (int) sessionStorage.get("ssum");
			
			for (Map<String, Object> vo : list) {
				String cart_no = (String) vo.get("ORDER_NO");
				String prod_no = (String) vo.get("PROD_NO");
				BigDecimal qty = (BigDecimal) vo.get("DETAIL_QTY");
				int qty1 = qty.intValue();
				BigDecimal price = (BigDecimal) vo.get("PROD_PRICE");
				int price1 = price.intValue();
				System.out.println(cart_no + "\t" + prod_no + "\t" + qty + "\t" + price + "\t" + (qty1 * price1));

				int sum = qty1 * price1;
				s = s + sum;
				sessionStorage.put("ssum", s);
			}
			System.out.println("--------------------------------------------------------");
			System.out.println("");

		
			System.out.println("세션저장값: " + sessionStorage.get("ssum"));
			cartListPrint();
			int sel = ScanUtil.nextInt("메뉴 선택 : ");
			switch (sel) {
			case 1:
				return View.CART_BUY;
			case 2:
				return View.CART_UPDATE;
			case 3:
				return View.CART_DELETE;
			case 4:
				return View.PROD;
			default:
				return View.CART_LIST;
			}
		}else {
		System.out.println("장바구니가 비었습니다.");
		}
		return null;
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
		
		System.out.println("1.메뉴 구입");
		System.out.println("2.뒤로가기");
		int sel = ScanUtil.nextInt("메뉴 선택 : ");
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
		OrdersVo cart = (OrdersVo)sessionStorage.get("cart");
		MemberVo mem = (MemberVo)sessionStorage.get("login");
		
		List<Object> list = new ArrayList();
		
		String code = ScanUtil.nextLine("제품코드 입력 : ");
		int qty = ScanUtil.nextInt("수량 입력 : ");
		String cart_no = cart.getOrder_no();
		
		list.add(cart_no);
		list.add(code);
		
		prodService.prodBuy(list, qty);
		
	}
	

	private View prodCart2() {
		while(true) {
			prodCart1();
			
			System.out.println("장바구니에 추가되었습니다.");
			System.out.println(" ");
			System.out.println("1.더 구매");
			System.out.println("2.장바구니로");
			int sel = ScanUtil.nextInt("메뉴선택: ");
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
			System.out.println("(경고 : 장바구니정보가 삭제됩니다.)");
			String yn = ScanUtil.nextLine("되돌아가시겠습니까?(Y/N)");
			 
			if(yn.equalsIgnoreCase("Y")) {
				return View.USER_MENU;
			}else if(yn.equalsIgnoreCase("N")) {
				return View.PROD;
			}else {
				System.out.println("잘못입력 되었습니다.");
			}
			return View.PROD;
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
			return View.SESSION;
		case 2:
			return View.TICKET;
		case 3:
			return View.USER_UPDATE;
		case 4:
			return View.FEEDBACK;
		case 5:
			String yn = ScanUtil.nextLine("로그아웃하시겠습니까?(Y/N)");
			if(yn.equalsIgnoreCase("Y")) {
				sessionStorage.remove("login");
				sessionStorage.remove("cart");
				sessionStorage.remove("sum");
				return View.HOME;
			}else if(yn.equalsIgnoreCase("N")) {
				return View.USER_MENU;
			}else {return View.USER_MENU;}
		default:
			return View.USER_MENU;
		}
	
	}
	
	private View userUpdate() {
		MemberVo login = (MemberVo)MainController.sessionStorage.get("login");
		String id = login.getUsers_id();
		List<MemberVo> uid = memService.u_id();
		List<MemberVo> list = memService.userList(id);
		userList(list);
		userUpdate1();
		
		List<Object> param = new ArrayList();
		
		int sel = ScanUtil.nextInt("번호입력: ");
		switch (sel) {
		case 1:
			while (true) {
			    String nic = ScanUtil.nextLine("변경할 닉네임 입력 : ");
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
			    String tel = ScanUtil.nextLine("변경할 전화번호 입력 : ");
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
			String pass = ScanUtil.nextLine("변경할 비밀번호 입력: ");
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
	
	private View adminLogin() {

		
		System.out.println("-----------관리자로그인-----------");
		String id =ScanUtil.nextLine("ID>>");
		String pass =ScanUtil.nextLine("PASS>>");
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		
		
		boolean login = adService.login(param);
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
		AdminVo admin = (AdminVo)sessionStorage.get("adminLogin");
		System.out.println("*"+admin.getAdmin_nm()+"*관리자님 환영합니다.");
		
		return View.ADMIN_MENU;
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
		
		return View.USER_MENU;
	}
	
	private View session() {
		MemberVo mem = (MemberVo) sessionStorage.get("login");
		
		//(상품)주문번호 생성
		List<Object> order = new ArrayList();
		String no = mem.getUsers_no();
		order.add(no);
		memService.cartin(order);
	
		//(상품)주문번호 세션스토리지 저장
		OrdersVo cart_no = (OrdersVo)memService.cartList(no);
		MainController.sessionStorage.put("cart", cart_no);
		
		//주문번호 확인 출력
		OrdersVo cart = (OrdersVo)sessionStorage.get("cart");
//		System.out.println(cart.getOrder_no());
		
		
		return View.PROD;
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
			signup();
			return View.HOME;
		default:
			return View.HOME;
		}
	}
	
	private View signup() {
		System.out.println("----회원가입----");
		List<MemberVo> uid = memService.u_id();
		List<Object> param = new ArrayList();

		//이름 생성
		String name;
		while (true) {
			name = ScanUtil.nextLine("이름 입력 : ");
			if (Pattern.matches("^[가-힣]{1,6}$", name)) {
				param.add(name);
				break;
			}
			System.out.println("이름 형식이 잘못되었습니다. 다시 입력해주세요.");
		}
		
		// 아이디 생성
		String id;
		while (true) {
		    id = ScanUtil.nextLine("아이디 입력 : ");
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
		
		//비밀번호
		while (true) {
		    String pass = ScanUtil.nextLine("비밀번호 입력 : ");
		    if (Pattern.matches("^[a-zA-Z0-9]{6,12}$", pass)) {
		        param.add(pass);
		        break;
		    }
		    System.out.println("비밀번호 형식이 잘못되었습니다. 다시 입력해주세요.");
		}

		//닉네임 생성
		String nic;
		while (true) {
		    nic = ScanUtil.nextLine("닉네임 입력 : ");
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
		
		//전화번호 생성
		String tel;
		while (true) {
		    tel = ScanUtil.nextLine("전화번호 입력 : ");
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
		System.out.println(name+"님 가입을 환영합니다. 다시 로그인해주세요.");
		return View.HOME;
	}
}






