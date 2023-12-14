package print;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import controller.MainController;
import vo.EmpVo;
import vo.FeedBackVo;
import vo.MemberVo;
import vo.NoticeVo;
import vo.OrdersVo;
import vo.ProdVo;
import vo.TicketVo;
import vo.Tkt_buyVo;

public class Print {
	
	public void printVar() {
		System.out.println(" ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ ");
	}
	
    public void pic() {
    	System.out.println("\r\n" +
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠞⠋⠉⢉⣉⣹⣿⣿⣷⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⣶⣾⣷⣶⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠔⠉⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⡿⠋⠀⠀⠀⠉⠻⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠿⢿⣿⡇⠀⠀⢀⣀⠀⠀⠸⡇⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⡿⢛⣥⣶⣶⣶⣶⣬⡛⢿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⠀⠘⣿⠇⠀⠀⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⡿⢡⣿⣿⡿⠟⠿⢿⣿⣿⡌⢿⣿⣿⣿⣿⣧⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣄⣾⡿⠁⠀⠙⠀⠀⠀⠘⢿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⡇⣿⣿⣿⠀⠂⠐⠀⣿⣿⣿⢸⣿⣿⣿⣿⣿⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⠿⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣧⠹⣿⣿⣦⣀⣀⣴⣿⣿⠏⣼⣿⣿⣿⣿⡿⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠴⠚⠋⠁⠀⠀⠀⠀⠀⢰⣧⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣷⣝⠿⣿⣿⣿⣿⠿⣫⣾⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⣤⣤⣶⠋⠀⠀⠀⠀⢀⣤⠀⠀⠀⠀⢸⣿⣷⣷⣄⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣾⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠔⠋⠁⠀⣠⣼⠿⠿⠛⢿⣿⣆⣀⡠⠴⠾⠿⠿⢤⣤⣀⣀⡘⣿⣿⣿⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠃⠀⠀⢠⠞⠉⠀⠀⠀⠀⠀⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢿⡏⠛⠛⠻⢿⣿⣶⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⠿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣆⠀⠀⠀⠈⠻⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡇⠀⠀⠀⠈⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⢀⣰⣿⣷⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣇⠀⠀⠀⠀⠈⢿⣿⣿⣿⠿⠷⠦⣄⡀⠀⠀⠀⠀⠀⠀⣸⠁⠀⠀⠀⠀⢹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⢠⣶⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡆⠀⠀⠀⠀⠀⢿⣿⠇⠀⠀⠀⠈⠙⣦⡀⠀⠀⠀⢠⠇⠀⠀⠀⠀⠀⢸⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⡄⠀⠀⠀⠀⠸⣿⠀⠀⠀⠀⠀⠀⠌⠻⣦⣀⣴⠏⠀⠀⠀⠀⠀⠀⠀⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⠀⣆⣠⣴⡿⠿⠛⠛⠛⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⡄⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⢸⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠞⠉⠀⠀⠈⠉⠁⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣷⣄⡀⠀⠀⠀⠀⠀⠀⣀⣼⣿⣿⣿⣦⣀⣀⣠⣿⣄⠀⠀⠀⠀⠀⠐⠾⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣞⣁⣀⣤⣤⣤⣤⣤⣤⣀⣀⣀⠀⠀⠘⣿⣿⣿⣿⣟⠻⢿⣿⣿⣿⣶⣶⡶⠞⠋⠉⠁⠀⠀⠀⠀⠈⠻⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠈⠙⠓⠀⠀⠀⠀⠀⠀⡴⢟⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⢠⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠛⠛⠛⠿⠿⠿⣿⣿⣷⣄⡀⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⢠⣷⠤⢤⣴⣿⣿⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⢀⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠲⢤⡀⠀⠀⢰⣶⠀⠀⠀⠘⠀⣀⣀⢻⠟⠛⠿⢿⣿⣿⣿⣿⣶⣶⣤⣤⣤⣀⣀⣀⣀⡤⠞⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⢀⡀⠀⠀⠀⡀⠂⠀⠀⠀⠀⠀⣤⠤⠤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣄⠸⣏⠀⠀⢀⣴⠟⠋⠙⠛⠛⠛⠛⠿⠿⠿⠶⢦⣤⣤⣤⣀⣀⣀⡈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠉⠛⠚⠉⠀⠀⠀⠀⠀⠀⠀⣿⣀⠀⣸⠇⠀⣴⠛⠉⠙⢦⠀⠀⣦⠀⠀⣤⡀⠀⢀⠀⠀⠀⠀⠀⠉⠛⠛⠒⠒⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠙⠛⠛⠛⠷⢶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡏⠉⠉⠉⠀⠀⡇⠀⠀⠀⢸⡇⠀⢹⠀⣸⠙⡇⠀⡞⠀⢠⡟⠛⠒⠒⠀⠀⣤⢤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠹⢤⣤⡤⠟⠀⠀⢸⣰⠃⠀⡇⡼⠁⠀⢸⠗⠶⠤⠄⠀⢀⣇⣀⠀⣸⠇⠀⢠⠖⠋⠛⢲⡀⠀⢠⡀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠉⠢⠤⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠛⠁⠀⠀⢾⣤⣀⣀⡀⠀⢸⠃⠉⢻⡅⠀⠀⣿⠀⠀⣤⣄⡀⠀⠀⢳⣀⡴⠋⠀⢰⣿⡄⠀⢀⣶⠆⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠙⠒⠒⠶⠤⠤⣤⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠈⠀⠀⠀⠻⠀⠀⠙⢦⣀⣀⣼⠁⠀⠀⢠⡏⠀⠀⠀⢸⠁⡇⢀⡞⣸⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠙⠛⠓⠶⠶⠤⣤⣤⡤⠖⠋⠉⠉⠉⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠃⠀⠀⠀⠿⠀⢻⡞⠀⡟⠀⠀⠀⠈⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠦⣤⣄⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠈⠻⠶⠤⠤⠤⠤⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠙⠛⠓⠲⠶⠤⠤⣄⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + 
    			"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠒⠒⠂⠤⠤⠤⠤⠤⠄⠐⠂⠀⠀⠀⠀⠀⠀⠀⠀");
    }
	public void printHome() { //첫 화면
//		System.out.println("\r\n" + 
//				"                _____ _    _____       _______ __                      \r\n" + 
//				"               / /   | |  / /   |     / ____(_) /_____  ___  __________\r\n" + 
//				"          __  / / /| | | / / /| |    / /_  / / __/ __ \\/ _ \\/ ___/ ___/\r\n" + 
//				"         / /_/ / ___ | |/ / ___ |   / __/ / / /_/ / / /  __(__  |__  ) \r\n" + 
//				"         \\____/_/  |_|___/_/  |_|  /_/   /_/\\__/_/ /_/\\___/____/____/  " );

		System.out.print("　 "
				+ "\r\n" + 
				"┏━━ HOME ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃                                                                                ┃\r\n" +
				"┃ 1.회원 로그인                                                                                                                                          ┃\r\n" +
				"┃ 2.관리자 로그인                                                                                                                                       ┃\r\n" + 
				"┃ 3.회원가입                                                                                                                                              ┃\r\n" +
				"┃                                                                                ┃\r\n" +
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
	
	public void loginfail() { // 로그인 안될때
		
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━ 로그인 실패  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃                                                                                ┃\r\n" +
				"┃ 1.다시 로그인                                                                                                                                          ┃\r\n" +
				"┃ 2.회원 가입                                                                                                                                             ┃\r\n" + 
				"┃ 3.홈                                                                                                                                                       ┃\r\n" +
				"┃                                                                                ┃\r\n" +
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
	
	
	
	public void userMenu1() { //회원 메뉴
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━ 회원메뉴  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃                                                                                ┃\r\n" +
				"┃ 1.상품 구매                                                                                                                                             ┃\r\n" +
				"┃ 2.이용권 구매                                                                                                                                          ┃\r\n" + 
				"┃ 3.회원정보 수정                                                                                                                                       ┃\r\n" + 
				"┃ 4.피드백 게시판                                                                                                                                       ┃\r\n" + 
				"┃ 5.로그아웃	                                                                 ┃\r\n" +
				"┃                                                                                ┃\r\n" +
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
	
	public void prod1() {
		
		System.out.println(" ================================================================================  ");
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━ 상품구매  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃                                                                                ┃\r\n" +
				"┃ 1.음식 구매                                                                                                                                             ┃\r\n" +
				"┃ 2.운동용품 구매                                                                                                                                       ┃\r\n" + 
				"┃ 3.장바구니 내역                                                                                                                                       ┃\r\n" + 
				"┃ 4.결제 내역                                                                                                                                             ┃\r\n" + 
				"┃ 5.홈                                                                                                                                                       ┃\r\n" +
				"┃                                                                                ┃\r\n" +
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
	
	public void prodbuyprint() {
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃ 1.상품 구매하기                                                                                                                                       ┃\r\n" + 
				"┃ 2.뒤로가기                                                                                                                                              ┃\r\n" + 
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
		
	}
	
    public void cartinprint() {//장바구니 추가되었을때
		
    	System.out.print("　 "
				+ "\r\n" + 
				"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃ 장바구니에 추가되었습니다                                                                                                                         ┃\r\n" +
				"┃                                                                                ┃\r\n" +
				"┃ 1.더 추가하기                                                                                                                                          ┃\r\n" + 
				"┃ 2.장바구니로 이동                                                                                                                                    ┃\r\n" + 
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
    
    public void cartnoprint() { //장바구니비었을때
    	
    	System.out.print("　 "
    			+ "\r\n" + 
    			"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
    			"┃ 장바구니가 비었습니다                                                                                                                               ┃\r\n" +
    			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
    }
	
    public void cartListPrint() { //장바구니채워졌을때
    	System.out.print("　 "
    			+ "\r\n" + 
    			"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
    			"┃ 1.결제하기                                                                                                                                              ┃\r\n" +
    			"┃ 2.장바구니 수정                                                                                                                                       ┃\r\n" + 
    			"┃ 3.뒤로가기                                                                                                                                              ┃\r\n" + 
    			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}

    public void cartupdate() { //장바구니 수정
    	System.out.print("　 "
    			+ "\r\n" + 
    			"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
    			"┃ 1.상품 취소                                                                                                                                             ┃\r\n" +
    			"┃ 2.상품수량 수정                                                                                                                                       ┃\r\n" + 
    			"┃ 3.뒤로가기                                                                                                                                              ┃\r\n" + 
    			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
    }
   
    public void buycomplete() { //결제 Y
    	
    	System.out.print("　 "
    			+ "\r\n" + 
    			"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
    			"┃ 결제가 완료되었습니다                                                                                                                               ┃\r\n" +
    			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
    }
    public void buycancle() { //결제 N
    	
    	System.out.print("　 "
    			+ "\r\n" + 
    			"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
    			"┃ 결제가 취소되었습니다                                                                                                                               ┃\r\n" +
    			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
    }
    public void back() { //돌아가기
    	
    	System.out.print("　 "
    			+ "\r\n" + 
    			"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
    			"┃1.돌아가기                                                                                                                                                ┃\r\n" +
    			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
    }
    
    public void ticket1() { //이용권 구매
		
		System.out.println(" ================================================================================  ");
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━ 이용권 구매  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃                                                                                ┃\r\n" +
				"┃ 1.PT 이용권                                                                                                                                           ┃\r\n" +
				"┃ 2.요가 이용권                                                                                                                                          ┃\r\n" + 
				"┃ 3.헬스 이용권                                                                                                                                          ┃\r\n" + 
				"┃ 4.장바구니 내역                                                                                                                                       ┃\r\n" + 
				"┃ 5.결제 내역                                                                                                                                             ┃\r\n" +
				"┃ 6.홈                                                                                                                                                       ┃\r\n" +
				"┃                                                                                ┃\r\n" +
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
    
    public void ptticket() { //이용권 구매
    	
    	System.out.println(" ================================================================================  ");
    	System.out.print("　 "
    			+ "\r\n" + 
    			"┏━━━ PT  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
    			"┃ 1.트레이너 전체 리스트                                                                                                                             ┃\r\n" +
    			"┃ 2.트레이너 이름 검색                                                                                                                                ┃\r\n" + 
    			"┃ 3.뒤로가기                                                                                                                                              ┃\r\n" +
    			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
    }
    
    
	public void noticeList1(List<NoticeVo> list) { //회원 공지사항
		System.out.println("");
		System.out.println(" ============================== JAVA Fitness 공지사항 ============================= ");
		System.out.println("  NO\t제목\t\t내용\t\t\t날짜\t\t작성자");
		System.out.println(" ================================================================================  ");
		for (NoticeVo vo  : list) {
		String no = (String)vo.getNotice_no();
		String til = (String)vo.getNotice_title();
		String con = (String)vo.getNotice_content();
		String date = (String)vo.getNotice_date();
		System.out.println("  "+no+"\t"+til+"\t"+con+"\t"+date+"\t관리자");
		}
		System.out.println(" ================================================================================  ");
		System.out.println("");
	}
	
	public void prodlist(List<ProdVo> list) { //상품 정보
		
		System.out.println("");
		System.out.println("");
		System.out.println(" ================================= 상품정보 ======================================= ");
		System.out.println("    상품코드\t\t제품명\t\t상세정보\t\t\t\t가격");
		System.out.println(" ================================================================================ ");
		for (ProdVo food : list) {
		String no = (String)food.getProd_no();
		String name = (String)food.getProd_nm();
		String content = (String)food.getProd_content();
		int price = (int)food.getProd_price();
		
		System.out.println("  "+no+"\t"+name+"\t"+content+"\t\t"+price);
		}
		System.out.println(" ================================================================================  ");
	}

	public void cartList2(List<Map<String, Object>> list) { //장바구니 내역
		
		System.out.println(" =================================== 장바구니 내역 ================================== ");
		System.out.println("   장바구니 번호\t\t상품코드\t\t수량\t단가\t합계");
		System.out.println(" ================================================================================  ");		
		
		for (Map<String, Object> vo  : list) {
			String              cart_no = (String)vo.get("ORDER_NO");
			String              prod_no = (String)vo.get("PROD_NO");
			BigDecimal              qty = (BigDecimal)vo.get("DETAIL_QTY");
			BigDecimal            price = (BigDecimal)vo.get("PROD_PRICE");
			int qty1 = qty.intValue();
			int price1 = price.intValue();
			System.out.println("  "+cart_no + "\t\t" + prod_no + "\t" + qty + "\t" + price + "\t" + (qty1 * price1));
		}
		System.out.println(" ================================================================================  ");
	}
	
	public void cartBuyList1(List<OrdersVo> list) {
		
		System.out.println(" ================================= 결제내역 리스트  ================================== ");
		System.out.println("  장바구니 번호\t\t총금액\t\t날짜");
		System.out.println(" ================================================================================  ");
		
		for (OrdersVo vo  : list) {
			String     cart_no = (String)vo.getOrder_no();
			int        prod_no = (int)vo.getOrder_pay();
			String          date = (String)vo.getOrder_date();
		System.out.println("  "+cart_no+"\t\t"+prod_no+"\t\t"+date);
		}
		System.out.println(" ================================================================================  ");
		System.out.println("");
	}
	
	
	
	
	public void ptselect() {
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃ 1.트레이너 선택                                                                                                                                       ┃\r\n" + 
				"┃ 2.뒤로가기                                                                                                                                              ┃\r\n" + 
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
	
	public void ptselect2() {
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃ 1.해당 트레이너 이용권 리스트                                                                                                                   ┃\r\n" + 
				"┃ 2.뒤로가기                                                                                                                                              ┃\r\n" + 
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
	
	public void warning() { //돌아가기
    	
    	System.out.print("　 "
    			+ "\r\n" + 
    			"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
    			"┃ !경고! 장바구니 정보가 삭제됩니다                                                                                                            ┃\r\n" +
    			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
    }
	
	public void tktlist(List<TicketVo> list) {

		System.out.println(" ================================== 이용권 리스트  ================================== ");
		System.out.println("  이용권번호\t이용권\t\t\t가격");
		System.out.println(" ================================================================================  ");

		for (TicketVo vo : list) {
			String no = (String) vo.getTicket_no();
			String name = (String) vo.getTkt_name();
			String lgu = (String) vo.getTkt_lgu();
			int price = (int) vo.getTkt_price();
			String emp = (String) vo.getEmployee_no();
			int time = (int) vo.getTkt_time();
			System.out.println("  "+no + "\t" + name + "\t\t" +  price);
		}
		System.out.println(" ================================================================================  ");
	}
	

	public void ptList(List<EmpVo> list) { //empvo ptlist

	      System.out.println(" ================================ PT트레이너 리스트  ================================= ");
	      System.out.println("  직원번호\t이름\t전화번호\t\t경력");
	      System.out.println(" ================================================================================  ");
	      for (EmpVo vo : list) {
	         String no = (String) vo.getEmployee_no();
	         String name = (String) vo.getEmp_name();
	         String tel = (String) vo.getEmp_tel();
	         String career = (String) vo.getCareer();
	         System.out.println("  "+no + "\t" + name + "\t" + tel + "\t" + career);
	      }
	      System.out.println(" ================================================================================  ");
	   }
	
	public void ptbuy() {
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃ 1.이용권 선택하기                                                                                                                                    ┃\r\n" + 
				"┃ 2.뒤로가기                                                                                                                                              ┃\r\n" + 
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
	
	public void tktalarm() {
		System.out.print("　 "
				+ "\r\n" + 
				"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n" + 
				"┃ 이용권 사용시작 날짜를 입력해주세요                                                                                                           ┃\r\n" + 
				"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n" );
	}
	
	
	
	public void printListMenu() {
		System.out.println("1. 상세조회");
		System.out.println("2. 상품 변경");
		System.out.println("3. 상품 삭제");
		System.out.println("4. 홈으로");
	}
	
	public void printDetail() {
		System.out.println("1.상품 이름 검색");
		System.out.println("2.분류 코드 검색");
		System.out.println("3.메인메뉴 돌아가기");
	}
	
	
	
	
	
	
	
	
	
	public void prodFood1() {
		System.out.println("1.구입");
		System.out.println("2.뒤로가기");
		System.out.println("");
	}
	public void userUpdate1() {
		System.out.println("1.닉네임 변경");
		System.out.println("2.전화번호 변경");
		System.out.println("3.비밀번호 변경");
		System.out.println("4.돌아가기");
	}
	

	public void feedbackList1(List<FeedBackVo> list) {
		

		System.out.println(" ============================== 상품정보 사항 ============================= ");
		System.out.println("NO\t작성자\t제목\t내용\t날짜\t확인여부");
		System.out.println("----------------------------------------------");
		MemberVo login = (MemberVo) MainController.sessionStorage.get("login");
		login.getUsers_name();

		for (FeedBackVo vo : list) {
			String no = (String) vo.getFeedback_no();
			String til = (String) vo.getFeedback_til();
			String con = (String) vo.getFeedback_con();
			String date = (String) vo.getFeedback_date();
			String feed_yn = (String) vo.getFeedback_yn();

			System.out.println(
					no + "\t" + login.getUsers_name() + "\t" + til + "\t" + con + "\t" + date + "\t" + feed_yn);
		
		
		System.out.println(no+"\t"+login.getUsers_name()+"\t"+til+"\t"+con+"\t"+date+"\t"+feed_yn);
		}
		System.out.println("----------------------------------------------");
		System.out.println("");
	}
	
		


	
	
	public void userList(List<MemberVo> list) {
		
		System.out.println("-------------------회원 정보---------------------");
		System.out.println("NO\t이름\t아이디\t패스워드\t닉네임\t전화번호");
		System.out.println("----------------------------------------------");
		
		for (MemberVo vo  : list) {
		String no = (String)vo.getUsers_no();
		String name = (String)vo.getUsers_name();
		String id = (String)vo.getUsers_id();
		String pass = (String)vo.getUsers_pass();
		String nic = (String)vo.getUsers_nic();
		String tel = (String)vo.getUsers_tel();
		
		System.out.println(no+"\t"+name+"\t"+id+"\t"+pass+"\t"+nic+"\t"+tel);
		}
		System.out.println("----------------------------------------------");
		System.out.println("");
	}
	
	
	
	
	
	
	
//	관리자
	public void adminMenu1() {
		System.out.println("1. 회원관리");
		System.out.println("2. 상품관리");
		System.out.println("3. 게시판관리");
		System.out.println("4. 직원관리");
		System.out.println("5. 이용권관리");
		System.out.println("6. 로그아웃");
	}

	public void admin_mem() {
		System.out.println("1. 회원 전체조회");
		System.out.println("2. 회원삭제(탈퇴)관리");
		System.out.println("3. 로그아웃");
	}

	public void feedbackList2(List<FeedBackVo> list) {

		System.out.println("-------------------------- 피드백 확인필요 사항 -----------------------------");
		System.out.println("NO\t작성자\t제목\t\t내용\t\t날짜\t\t확인여부");
		System.out.println("-----------------------------------------------------------------------");

		for (FeedBackVo vo : list) {
			String no = (String) vo.getFeedback_no();
			String til = (String) vo.getFeedback_til();
			String con = (String) vo.getFeedback_con();
			String date = (String) vo.getFeedback_date();
			String feed_yn = (String) vo.getFeedback_yn();
			String userno = (String) vo.getUsers_no();

			System.out.println(no + "\t" + userno + "\t" + til + "\t" + con + "\t" + date + "\t" + feed_yn + "\t");
		}
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("");
	}
	
	

	public void adminuser() {
		System.out.println("1. 회원 전체조회");
		System.out.println("2. 회원 삭제(탈퇴)관리");
		System.out.println("3. 메인메뉴");
		System.out.println("");
	}

	public void adminprod() {
		System.out.println("1. 상품 조회");
		System.out.println("2. 상품 추가");
		System.out.println("3. 메인메뉴");
		System.out.println("");
	}

	public void adminprod2() {
		System.out.println("카테로그 선택");
		System.out.println("1. 푸드");
		System.out.println("2. 운동용품");
		System.out.println("3. 뒤로가기");
		System.out.println("");
	}

	public int prodlist2(List<ProdVo> list) { // number 값 보내기

		System.out.println("-------------------상품 정보---------------------");
		System.out.println("NO\t상품번호\t제품명\t상세정보\t가격");
		System.out.println("----------------------------------------------");
		int number = 1;
		for (ProdVo food : list) {
			String no = (String) food.getProd_no();
			String name = (String) food.getProd_nm();
			String content = (String) food.getProd_content();
			int price = (int) food.getProd_price();
			System.out.println(number + "\t" + no + "\t" + name + "\t" + content + "\t" + price);
			number++;
		}
		System.out.println("----------------------------------------------");
		System.out.println("");
		return number;
	}

	public void empList(List<EmpVo> list) {

		System.out.println("----------------------------------직원 정보-----------------------------------------");
		System.out.println("NO\t이름\t전화번호\t\t담당업무\t입사일\t\t급여\t평가\t경력");
		System.out.println("---------------------------------------------------------------------------------");

		for (EmpVo vo : list) {
			String no = (String) vo.getEmployee_no();
			String name = (String) vo.getEmp_name();
			String tel = (String) vo.getEmp_tel();
			String lgu = (String) vo.getEmp_lgu();
			String hire = (String) vo.getEmp_hire();
			int salary =  (int) vo.getSalary();
			String eva = (String) vo.getEmp_eva();
			String career = (String) vo.getCareer();
			
			System.out.println(no + "\t" + name + "\t" + tel + "\t" + lgu + "\t" + hire + "\t" + salary + "\t" + eva
					+ "\t" + career);
		}
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("");
	}

	public void adminboard() {
		System.out.println("1. 공지사항");
		System.out.println("2. 피드백게시판");
		System.out.println("3. 뒤로가기");
		System.out.println("");
	}

	
	
	
	
	public void tlist2(List<Tkt_buyVo> list) {

	      System.out.println("NO\t총금액\t구매날짜");

	      for (Tkt_buyVo vo : list) {
	         String no = (String) vo.getTktbuy_no();
	         int price = (int) vo.getTkt_pay();
	         String date = (String) vo.getTktbuy_date();

	         System.out.println(no + "\t" + price + "\t" + date);
	      }
	      System.out.println("----------------------------------------------");
	      System.out.println("");
	   }
	
	// 성경수정, 티켓은 수정이 필요없다!!!
		public void tktcartListPrint() {
			System.out.println("1. 구입");
			System.out.println("2. 장바구니 삭제");
			System.out.println("3. 돌아가기");
		}
		
		
		
		
}
