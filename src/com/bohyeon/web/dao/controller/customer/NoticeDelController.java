package com.bohyeon.web.dao.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bohyeon.web.dao.NoticeDao;
import com.bohyeon.web.dao.mybatis.MyBatisNoticeDao;
import com.bohyeon.web.entities.Notice;
import com.boyeon.web.model.NoticeModel;

@WebServlet("/customer/notice-del")
public class NoticeDelController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		
		noticeDao.delete(code);
		response.sendRedirect("notice");
	
	}

}
