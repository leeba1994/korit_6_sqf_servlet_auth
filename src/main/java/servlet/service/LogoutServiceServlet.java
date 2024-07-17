package servlet.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	session.invalidate();	// 강제로 세션 만료
//    	resp.sendRedirect("/ssa/index");	//알림창 없이 바로 홈으로 이동
		StringBuilder responsebody = new StringBuilder();
		responsebody.append("<script>");
		responsebody.append("alert('로그아웃 완료!');");	//로그아웃 알림창 뛰우고 홈으로 이동
		responsebody.append("location.href='/ssa/index';");
		responsebody.append("</script>");		
		resp.setContentType("text/html");
		resp.getWriter().println(responsebody.toString());
    }

}
