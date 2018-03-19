package servelet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.*;
import dao.*;
/**
 * Servlet implementation class single
 */
@WebServlet("/single")
public class single extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public single() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");  
	   
	   //有用户登录的情形

		FilmDao filmdao = new FilmDao();
		String id=request.getParameter("id");
		Filmtable film = filmdao.getFilmByFilmId(id);
		request.setAttribute("film",film);
		
		if(session.getAttribute("login")!=null) {
			   String username=session.getAttribute("username").toString();
			   Usertable user=new UserDao().getUserByUsername(username);
			   request.setAttribute("userid",user.getId());
			   Scoretable scoretable =new ScoredDao().getScoretableByuserIdandFilmid(Integer.toString(user.getId()), id);
			   if(scoretable==null) {
				   request.setAttribute("hasscored", null);
			   }else {
				   request.setAttribute("hasscored", "yes");
					String points=scoretable.getScore()*6+"px";
				   request.setAttribute("points",points);
			   }
		   }
		
		String totalpoints = film.getScore();
		totalpoints=Double.parseDouble(totalpoints)*6+"px";
		request.setAttribute("totalpoints", totalpoints);
		
        RequestDispatcher view=request.getRequestDispatcher("single.jsp");
	    view.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
