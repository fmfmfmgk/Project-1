package util;

public enum View {
	
	//메인
	HOME,					// 기본화면
	ADMIN,
	USER,
	USER_MENU,
	LOGIN,
	USER_LOGIN,
	ADMIN_LOGIN,
	SIGNUP,
	LOGOUT,
	USER_UPDATE,
	USER_JOIN,
	
	//세션값 
	SESSION,
	
	
	//상품
	PROD,          //상품구입
	PROD_LIST,     //상품리스트
	PROD_INSERT,   //상품추가
	PROD_FOOD,     //음료
	PROD_FOOD_BUY, //음료
	PROD_SUPPLIES, //운동용품
	PROD_CART,     //품목 장바구니로
	
	
	
	
	CART_LIST,       //장바구니리스트
	CART_BUY,        //구입
	CART_BUY_LIST,   //구입내역
	CART_UPDATE,     //수정
	CART_DELETE,     //장바구니 삭제
	CART_CANCEL_ONE, //
	CART_UPDATE_QTY, //장바구니 수량수정

	
	
	YOGA_LIST,
	HEALTH_LIST,
	
	
	//이용권
	TICKET,
	TICKET_BUY,
	TICKET_LIST, //이용권판매 메뉴
	
	PT_MENU,
	PT_LIST,
	PT_LIST_DETAIL,
	PT_SEARCH,
	YOGA_BUY,
	HEALTH_BUY,
	
	
	
	//게시판
	FEEDBACK,
	FEEDBACK_INSERT,
	FEEDBACK_UPDATE,
	FEEDBACK_DELETE,

	
	PROD_DETAIL,
	PROD_UPDATE,
	PROD_DELETE,
	
	PROD_SCH_NAME,
	PROD_SCH_CODE,
	PROD_DETAIL_SEL,
	
	
//	*관리자
	//회원관리
	ADMIN_MENU,
	ADMIN_USER,
	USER_LIST, //회원전체조회
	USER_DELETE, //회원 삭제(탈퇴)
	//상품
	ADMIN_PROD,
	ADMIN_PRODLIST,
	ADMIN_PROD_FOOD,
	ADMIN_PROD_SUPPLY,
	
	FOOD_UPDATE,//음식수정
	FOOD_DELETE,//음식삭제
	SUPPLY_UPDATE, //운동용품 수정
	SUPPLY_DELETE, //상품 삭제
	
	ADMIN_BOARD,//게시판관리
	
	//게시판 관리
	NOTICE,
	NOTICE_INSERT,
	NOTICE_UPDATE,
	NOTICE_DELETE,
	FEEDBACK_LIST,
	FEEDBACK_CHK,
	
	//직원관리
	ADMIN_EMP,
	EMP_LIST,
	EMP_UPDATE,
	EMP_DELETE,
	
	//이용권관리
	ADMIN_TICKET,
	TICKET_INSERT,
	TICKET_UPDATE,
	TICKET_DELETE,
	
	
	
	
	
	
	
	
}
