package demo.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.project.model.LoginBean;

public class OneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		System.out.println("init method");
	}

    public OneServlet() {
        super();
        System.out.println("Successfully created");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
		RequestDispatcher rd = request.getRequestDispatcher("/files/index.html");
		
		LoginBean lb = new LoginBean();
		lb.setPassword(pwd);
		lb.setUserid(id);
		
		int value = lb.loginValidate();
		if(value == 1) {
			rd = request.getRequestDispatcher("/secondServlet");
			rd.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("wrong");
			rd.include(request,response);
		}
		
	}


}
