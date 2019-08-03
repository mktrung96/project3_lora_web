package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ultis.Constant;

/**
 * Servlet implementation class InformationController
 */
@WebServlet("/Information.do")
public class InformationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.sendRedirect(Constant.JSP_INFORMATION);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constant.JSP_INFORMATION);
		// Chuyển dữ liệu lỗi và user vừa set sang cho ADM001 để hiển thị
		requestDispatcher.forward(request, response);
	}

}
