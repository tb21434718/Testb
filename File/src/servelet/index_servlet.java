package servelet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.*;
import dao.FilmDao;
import dao.RecommendDao;

/**
 * Servlet implementation class index_servlet
 */
@WebServlet("/index_servlet")
public class index_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String round=request.getParameter("round");
		HttpSession session =request.getSession();
		
		RecommendDao recommend=new RecommendDao();//判断是否有推荐列表
       
		
		int round_int= Integer.parseInt(round);
		FilmDao temp=new FilmDao();
		temp.getbaseflim(round_int);
		ArrayList<Filmtable> film=temp.getBase();
		
		String loginstatus=(String) session.getAttribute("login");
		String userid=(String)session.getAttribute("uid");
		String username=(String)session.getAttribute("username");
		
		temp.get_vistor_films();
		ArrayList<Filmtable> vistor_film=temp.getVistor_film();
		
		if(username==null) {
			request.setAttribute("vistor_film", vistor_film);	
		}else {//用户登录后 after user login
			List<String> recommendtmp=recommend.getRecommendMovie(userid);
			if(recommendtmp.isEmpty()||recommendtmp.size()==0)
			{
				request.setAttribute("vistor_film", vistor_film);	
			}
			else{
				//加判断条件
				request.setAttribute("vistor_film", temp.getRecommend(recommendtmp));
				
			}  
		}
		
		request.setAttribute("film",film);
		request.setAttribute("round1",round);
	
		 RequestDispatcher view=request.getRequestDispatcher("film.jsp");
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
