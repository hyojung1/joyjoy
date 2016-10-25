package com.bohyeon.web.dao.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bohyeon.web.dao.NoticeDao;
import com.bohyeon.web.dao.mybatis.MyBatisNoticeDao;
import com.bohyeon.web.entities.Notice;

@WebServlet("/customer/notice-reg")
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-reg.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		NoticeDao noticeDao = new MyBatisNoticeDao();

		Notice n = new Notice();

		n.setTitle(title);
		n.setContent(content);
		
		//현재 로그인 사용자 정보를 얻는 로직
		n.setWriter("BH");

		noticeDao.insert(n);
		response.sendRedirect("notice");
	}
}
