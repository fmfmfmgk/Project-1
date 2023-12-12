package dao;

import java.util.List;

import util.JDBCUtil;
import vo.AdminVo;
import vo.EmpVo;

public class AdminDao {
	public static AdminDao instance = null;

	private AdminDao() {

	}

	public static AdminDao getInstance() {
		if (instance == null) {
			instance = new AdminDao();
		}
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	//관리자 로그인
	public AdminVo login(List<Object> param) {
		String sql = "SELECT * \r\n" + 
				   	 " FROM ADMIN\r\n" + 
				   	 " WHERE ADMIN_ID = ?\r\n" + 
				   	 " AND ADMIN_PW = ? ";
			return jdbc.selectOne(sql, param, AdminVo.class);

	}
	
	//회원삭제
	public void userDelete(List<Object> param) { //(관리자)유저삭제
		String sql = " UPDATE USERS\r\n" + 
				"  SET DEL_YN ='Y'\r\n" + 
				" WHERE USERS_NO = ? ";
		jdbc.update(sql, param);
	}
	
	//직원 리스트 출력
	public List<EmpVo> empList() {
		String sql = "SELECT EMPLOYEE_NO,\r\n" + 
				"       EMP_NAME,\r\n" + 
				"       EMP_TEL,\r\n" + 
				"       EMP_LGU,\r\n" + 
				"       TO_CHAR(EMP_HIRE,'YY/MM/DD'),\r\n" + 
				"       SALARY,\r\n" + 
				"       EMP_EVA,\r\n" +
				"       CAREER\r\n" + 
				"  FROM EMPLOYEES \r\n" + 
				"  WHERE DEL_YN='N' \r\n" ;
		return jdbc.selectList(sql, EmpVo.class);
	}

	//직원 삭제
	public void empDelete(List<Object> param) {
		String sql = " UPDATE EMPLOYEES\r\n" + 
				"  SET DEL_YN ='Y'\r\n" + 
				" WHERE EMPLOYEE_NO = ? ";
		jdbc.update(sql, param);
		
	}
	
	//직원 수정
	public void empUpdate(List<Object> param, int select) {
		String front = "UPDATE EMPLOYEES\r\n"+
	               " SET  ";
		String temp = "";
		if(select ==1) {
		temp =	"   EMP_TEL = ?,\r\n" +
				"   EMP_LGU = ?,\r\n" + 
				"   EMP_EVA = ?\r\n" + 
				"WHERE EMPLOYEE_NO = ?";
		}
		if(select ==2) {
		temp =	"   EMP_TEL = ?" +
				" WHERE EMPLOYEE_NO = ?";
		}
		if(select ==3) {
		temp =	"   EMP_LGU = ?" + 
				" WHERE EMPLOYEE_NO = ?";
		}
		if(select ==4) {
		temp =	"   EMP_EVA = ?" + 
				" WHERE EMPLOYEE_NO = ?";
		}
		String sql = front + temp;
		jdbc.update(sql, param);
	}
}
	
	

	