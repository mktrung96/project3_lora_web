
package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ultis.Constant;
import validates.ValidateTrainCabin;

@WebServlet(urlPatterns = { "/SelectTrainCabin.do" })

/**
 * Class để xử lý cho màn hình 
 * 
 */

public class SelectTrainCabinController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher request = req.getRequestDispatcher(Constant.JSP_SELECTTRAINCABIN);
			request.forward(req, resp);
			// Nếu xảy ra lỗi thì sang màn hình system error
		} catch (Exception e) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(Constant.URL_SYSTEM_ERROR);
			// Chuyển dữ liệu lỗi và user vừa set sang cho servlet systemerror
			requestDispatcher.forward(req, resp);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Lấy đôi tượng session từ request
			HttpSession session = req.getSession();
			ValidateTrainCabin validateCabin = new ValidateTrainCabin();
			// set character utf8
			req.setCharacterEncoding("UTF-8");
			// lấy giá trị trên textbox trainname
			String trainName = req.getParameter("trainname");
			// lấy giá trị trên textbox cabinId
			String cabinId = req.getParameter("cabinId");
			// kiểm tra nhập liệu của user và pass
			List<String> listError = validateCabin.checkValidateTrainCabin(trainName, cabinId);
			// Nếu không có lỗi thì chuyển sang màn hình AQI
			if (listError.isEmpty()) {
				// Gán user cho session
				session.setAttribute(Constant.SESSION_SELECT_TRAIN, trainName);
				session.setAttribute(Constant.SESSION_SELECT_CABIN, cabinId);
				
				// Chuyển sang DisplayController để xử lý màn hìnhAQI
				resp.sendRedirect("DisplayAQI.do");

			} else {
				// Nếu có lỗi thì set giá trị lỗi lên vị trí error trên JSP_SELECTTRAINCABIN
				req.setAttribute("listError", listError);
				// Gửi lại giá trị trainName vừa mới cài đặt
				req.setAttribute("trainName", trainName);
				// tạo RequestDispatcher để chuyển tiếp dữ liệu lỗi cho JSP_SELECTTRAINCABIN
				RequestDispatcher request = req.getRequestDispatcher(Constant.JSP_SELECTTRAINCABIN);
				// Chuyển dữ liệu lỗi và user vừa set sang cho ADM001 để hiển thị
				request.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect(Constant.URL_SYSTEM_ERROR);
		}
	}
}
