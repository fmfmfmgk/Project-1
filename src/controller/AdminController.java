package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import vo.ProdVo;
import vo.TicketVo;

public class AdminController extends Print {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	ProdService prodService = ProdService.getInstance();
	HealthService healthService = HealthService.getInstance();
	AdminService adService = AdminService.getInstance();
	BoardService boardService = BoardService.getInstance();
	MemberService memService = MemberService.getInstance();

	View tktDelete() {// 관리자-이용권삭제
		String select = ScanUtil.nextLine("삭제할 이용권 번호를 입력하세요.");
		List<Object> param = new ArrayList();
		param.add(select);
		prodService.tktDelete(param);
		System.out.println(param + "번 이용권이 삭제되었습니다.");
		return View.ADMIN_TICKET;
	}

	View tktUpdate() {// 관리자-이용권수정
		List<TicketVo> list = prodService.tktList();
		tktlist(list);

		String tktno = ScanUtil.nextLine("수정할 이용권 번호를 입력하세요 :");
		tktupdateprint();

		int menu = ScanUtil.nextInt("선택>>  ");
		List<Object> param = new ArrayList();
		String name;
		String lgu;
		int price;
		int time;

		if (menu == 1 || menu == 2) {
			name = ScanUtil.nextLine("이용권이름 : ");
			param.add(name);
		}
		if (menu == 1 || menu == 3) {
			lgu = ScanUtil.nextLine("이용권종류 : ");
			param.add(lgu);
		}
		if (menu == 1 || menu == 4) {
			price = ScanUtil.nextInt("이용권가격 : ");
			param.add(price);
		}
		if (menu == 1 || menu == 5) {
			time = ScanUtil.nextInt("이용권기간 : ");
			param.add(time);
		}
		if (menu == 6) {
			return View.ADMIN_TICKET;
		}
		param.add(tktno);
		prodService.tktUpdate(param, menu);
		tktupdatecomplete();
		return View.ADMIN_TICKET;
	}

	View tktInsert() {// 관리자-이용권추가
		List<Object> param = new ArrayList();

		String no = ScanUtil.nextLine("이용권 번호를 입력해주세요 :");
		String name = ScanUtil.nextLine("이용권 이름을 입력해주세요 :");
		String lgu = ScanUtil.nextLine("이용권 종류를 입력해주세요 :");
		int price = ScanUtil.nextInt("이용권 가격을 입력해주세요 :");
		String emp = ScanUtil.nextLine("이용권 담당직원을 입력해주세요 :");
		int time = ScanUtil.nextInt("이용권 사용기간을 입력해주세요 :");

		param.add(no);
		param.add(name);
		param.add(lgu);
		param.add(price);
		param.add(emp);
		param.add(time);

		tktwritecomplete();
		prodService.tktInsert(param);

		return View.ADMIN_TICKET;
	}

	View adminTkt() {// 관리자-이용권관리
		List<TicketVo> list = prodService.tktList();
		tktlist(list);
		ticketmenuprint();
		int select = ScanUtil.nextInt("선택>>  ");
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

	View feedbackChk() {// 관리자-피드백확인여부체크
		List<FeedBackVo> list = boardService.FeedbackListN();
		feedbackList2(list); // 피드백 확인필요 사항 출력
		int no = ScanUtil.nextInt("피드백 게시글 번호를 입력해주세요 : ");
		String yn = ScanUtil.nextLine("해당 게시글을 확인완료 처리 하시겠습니까?(Y/N) :");
		if (yn.equalsIgnoreCase("y")) {
			boardService.feedbackChk(no);
			feedcheckcomplete(); // 완료프린트
		} else {
			return View.ADMIN_BOARD;
		}
		return View.FEEDBACK_LIST;
	}

	View feedbackList() { // 관리자-피드백리스트
		List<FeedBackVo> list = boardService.FeedbackList();
		feedbackList2(list); // 피드백 확인필요 사항 출력
		feedcheckprint();// 피드백체크 프린트
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.FEEDBACK_CHK;
		case 2:
			return View.ADMIN_BOARD;
		default:
			return View.ADMIN_MENU;
		}
	}

	View noticeDelete() {// 관리자-공지사항삭제
		int no = ScanUtil.nextInt("삭제할 공지사항 번호를 선택해주세요 :");
		boardService.noticeDelete(no);
		noticedeletecomplete();
		return View.NOTICE;
	}

	View noticeUpdate() {// 관리자-공지사항수정
		List<NoticeVo> list = memService.noticeList();
		noticeList1(list);
		int no = ScanUtil.nextInt("수정할 공지사항 번호를 선택해주세요 :");
		List<Object> param = new ArrayList();
		String title = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		param.add(title);
		param.add(content);
		boardService.noticeUpdate(param, no);
		noticeupdatecomplete();
		return View.NOTICE;
	}

	View noticeInsert() {// 관리자-공지사항작성
		AdminVo login = (AdminVo) sessionStorage.get("adminLogin");
		String id = login.getAdmin_no();
		List<Object> param = new ArrayList();
		String name = ScanUtil.nextLine("공지사항 제목을 입력해주세요 :");
		String content = ScanUtil.nextLine("공지사항 내용을 입력해주세요 :");
		param.add(name);
		param.add(content);
		noticecomplete();
		boardService.noticeInsert(param, id);
		return View.NOTICE;
	}

	View noticeList() {// 관리자-공지사항관리
		List<NoticeVo> list = memService.noticeList();
		noticeList1(list);
		feedbacksel();
		int sel = ScanUtil.nextInt("선택>>  ");
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

	View adminBoard() {// 관리자-게시판관리
		adminboard();
		int sel = ScanUtil.nextInt("선택>>  ");
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

	View empDelete() {// 관리자-직원관리-직원정보삭제
		List<EmpVo> list = adService.empList();
		empList(list);

		String select = ScanUtil.nextLine("삭제할 직원 번호를 입력하세요 :");
		List<Object> param = new ArrayList();
		param.add(select);
		adService.empDelete(param);
		System.out.println(param + " 직원이 삭제되었습니다.");
		return View.EMP_LIST;
	}

	View empUpdate() {// 관리자-직원관리-직원정보수정
		List<EmpVo> list = adService.empList();
		empList(list);

		String empno = ScanUtil.nextLine("수정할 직원 번호를 입력하세요 :");
		empupdateprint();

		int menu = ScanUtil.nextInt("선택>>  ");
		List<Object> param = new ArrayList();
		String emp_tel;
		String emp_lgu;
		String emp_eva;

		if (menu == 1 || menu == 2) {
			emp_tel = ScanUtil.nextLine("새로운 연락처를 입력해주세요 :");
			param.add(emp_tel);
		}
		if (menu == 1 || menu == 3) {
			emp_lgu = ScanUtil.nextLine("새로운 담당업무를 입력해주세요 :");
			param.add(emp_lgu);
		}
		if (menu == 1 || menu == 4) {
			emp_eva = ScanUtil.nextLine("새로운 평가정보를 입력해주세요 :");
			param.add(emp_eva);
		}
		if (menu == 5) {
			return View.EMP_LIST;
		}
		param.add(empno);
		adService.empUpdate(param, menu);
		updatecompleteprint();
		return View.EMP_LIST;
	}

	View empList() {// 관리자-직원관리-직원조회
		List<EmpVo> list = adService.empList();

		empList(list);
		empmenuprint();
		int select = ScanUtil.nextInt("선택>>  ");
		switch (select) {
		case 1:
			return View.EMP_UPDATE;
		case 2:
			return View.EMP_DELETE;
		case 3:
			return View.ADMIN_MENU;
		default:
			return View.HOME;
		}
	}

	View supplyDelete() {// 관리자-상품관리-상품조회-운동용품-상품삭제
		String select = ScanUtil.nextLine("삭제할 상품 코드를 입력하세요 :");
		List<Object> param = new ArrayList();
		param.add(select);
		prodService.supplyDelete(param);
		System.out.println(param + "번 상품이 삭제되었습니다.");
		return View.ADMIN_PROD_SUPPLY;
	}

	View supplyUpdate() { // 관리자-상품관리-상품조회-운동용품-상품수정
		String param = "P201";
		List<ProdVo> list = prodService.prodList(param);

		String prodno = ScanUtil.nextLine("수정할 상품 코드를 입력하세요 :");
		produpdateprint();
		int menu = ScanUtil.nextInt("선택>>  ");
		List<Object> param2 = new ArrayList();
		String name;
		String content;
		int price;

		if (menu == 1 || menu == 2) {
			name = ScanUtil.nextLine("새로운 상품 이름을 입력하세요: ");
			param2.add(name);
		}
		if (menu == 1 || menu == 3) {
			content = ScanUtil.nextLine("새로운 상품 내용을 입력하세요: ");
			param2.add(content);
		}
		if (menu == 1 || menu == 4) {
			price = ScanUtil.nextInt("새로운 상품 가격을 입력하세요: ");
			param2.add(price);
		}
		if (menu == 5) {
			return View.ADMIN_PROD_SUPPLY;
		}
		param2.add(prodno);
		prodService.prodUpdate(param2, menu);
		produpdateprint2();
		return View.ADMIN_PROD_SUPPLY;
	}

	View adminProdSupply() {// 관리자-상품관리-상품조회-운동용품
		String param = "P201";
		List<ProdVo> list = prodService.prodList(param);
		prodlist(list);
		adminprodsupplyprint();
		int sel = ScanUtil.nextInt("선택>>  ");
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

	View foodDelete() {// 관리자-상품관리-상품조회-음식-상품삭제
		String select = ScanUtil.nextLine("삭제할 상품 코드를 입력하세요 :");
		List<Object> param = new ArrayList();
		param.add(select);
		prodService.foodDelete(param);
		System.out.println(param + "번 상품이 삭제되었습니다.");
		return View.ADMIN_PROD_FOOD;
	}

	View foodUpdate() {// 관리자-상품관리-상품조회-음식-상품수정

		String param = "P101";
		List<ProdVo> list = prodService.prodList(param);

		String prodno = ScanUtil.nextLine("수정할 상품 코드를 입력하세요 :");
		produpdateprint();
		int menu = ScanUtil.nextInt("선택>>  ");
		List<Object> param2 = new ArrayList();
		String name;
		String content;
		int price;

		if (menu == 1 || menu == 2) {
			name = ScanUtil.nextLine("새로운 상품 이름을 입력하세요: ");
			param2.add(name);
		}
		if (menu == 1 || menu == 3) {
			content = ScanUtil.nextLine("새로운 상품 내용을 입력하세요: ");
			param2.add(content);
		}
		if (menu == 1 || menu == 4) {
			price = ScanUtil.nextInt("새로운 상품 가격을 입력하세요: ");
			param2.add(price);
		}
		if (menu == 5) {
			return View.ADMIN_PROD_FOOD;
		}
		param2.add(prodno);
		prodService.prodUpdate(param2, menu);
		produpdateprint2();
		return View.ADMIN_PROD_FOOD;
	}

	View adminProdFood() {// 관리자-상품조회-음식
		String param = "P101";
		List<ProdVo> list = prodService.prodList(param);
		prodlist(list);
		adminprodsupplyprint();

		int sel = ScanUtil.nextInt("선택>>  ");
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

	View prodInsert() {// 관리자-상품관리-상품추가
		List<Object> param = new ArrayList();
		String prodNo = ScanUtil.nextLine("상품 종류를 입력해주세요:");
		String prodnm = ScanUtil.nextLine("상품 이름을 입력해주세요 :");
		String prodcon = ScanUtil.nextLine("상품 내용을 입력해주세요 :");
		int prodprice = ScanUtil.nextInt("상품 가격을 입력해주세요 :");

		param.add(prodNo);
		param.add(prodNo);
		param.add(prodnm);
		param.add(prodcon);
		param.add(prodprice);
		System.out.println("상품등록이 완료되었습니다");
		prodService.foodInsert(param);

		return View.ADMIN_PRODLIST;
	}

	View adminProdList() { // 관리자-상품관리-음식
		adminprod2();
		int sel = ScanUtil.nextInt("선택>>  ");
		switch (sel) {
		case 1:
			return View.ADMIN_PROD_FOOD;
		case 2:
			return View.ADMIN_PROD_SUPPLY;
		case 3:
			return View.ADMIN_PROD;
		default:
			return View.ADMIN_PROD;
		}
	}

	View adminProd() { // 관리자 상품관리 메뉴
		adminprod();
		int sel = ScanUtil.nextInt("선택>>  ");
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

	View adminUser() { // 관리자 회원관리 메뉴
		adminuser();
		int sel = ScanUtil.nextInt("선택>>  ");
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

	View adminMenu() { // 관리자 로그인 성공후 화면

		adminMenu1();
		int sel = ScanUtil.nextInt("선택>>  ");
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
			System.out.print("　 " + "\r\n"
					+ "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + "┃  "
					+ admin.getAdmin_nm()
					+ "님 로그아웃 되셨습니다                                                                                                                   ┃\r\n"
					+ "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n");
			return View.LOGIN;
		default:
			return View.LOGIN;
		}

	}

	View userDelete() {// 관리자-회원삭제
		List<MemberVo> list = memService.userList2();
		userList(list);

		String select = ScanUtil.nextLine("삭제할 회원 번호를 입력해주세요 :");
		List<Object> param = new ArrayList();
		param.add(select);
		adService.userDelete(param);
		userdeleteprint();
		return View.USER_LIST;
	}

	View userList() {// 관리자-회원조회
		List<MemberVo> list = memService.userList2();
		userList(list);
		back();
		int select = ScanUtil.nextInt("선택>>  ");
		switch (select) {
		case 1:
			return View.ADMIN_USER;
		default:
			return View.HOME;
		}
	}

	View adminLogin() { // 관리자로그인
		System.out.println("=================================== 관리자 로그인 ====================================\r\n");
		String id = ScanUtil.nextLine("ID>>");
		String pass = ScanUtil.nextLine("PASS>>");
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		boolean login = adService.login(param);
		if (!login) {
			loginfail();
			int sel = ScanUtil.nextInt("선택>> ");
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
		treeprint();
		AdminVo admin = (AdminVo) sessionStorage.get("adminLogin");
		System.out.println("*" + admin.getAdmin_nm() + "* 관리자님 환영합니다!");
		printVar();
		return View.ADMIN_MENU;

	}

}
