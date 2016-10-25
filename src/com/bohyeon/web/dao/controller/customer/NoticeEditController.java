package com.bohyeon.web.dao.controller.customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bohyeon.web.dao.NoticeDao;
import com.bohyeon.web.dao.mybatis.MyBatisNoticeDao;
import com.bohyeon.web.entities.Notice;

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice;

		notice = noticeDao.get(_code);
		request.setAttribute("n", notice);

		request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code = request.getParameter("code");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		Notice n = new Notice();
		n.setCode(code);
		n.setTitle(title);
		n.setContent(content);
		
		noticeDao.update(n);
		
		response.sendRedirect("notice-detail?code="+code);

	}

}
