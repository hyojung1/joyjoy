package com.bohyeon.web.dao.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bohyeon.web.dao.NoticeDao;
import com.bohyeon.web.dao.mybatis.MyBatisNoticeDao;
import com.boyeon.web.model.NoticeModel;

@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      String t= request.getParameter("t");
      String q= request.getParameter("q");
      String p= request.getParameter("p");

      int page =1;
      String field ="TITLE";
      String query="";
      
         
      if(t !=null && !t.equals(""))
         field=t;
      
      if(q !=null)
         query=q;
      
      if(p !=null && !p.equals(""))
         page= Integer.parseInt(p);
      
      
      NoticeDao noticeDao = new MyBatisNoticeDao();
      List<NoticeModel> list= noticeDao.getList(page, field, query);
      int count = noticeDao.getCount(field,query);
      
      request.setAttribute("list", list);
      request.setAttribute("count", count);

      //list = new MyBatisNoticeDao().getList();
      

      // 1.그냥 부르기: 네가 새로 해!
       //response.sendRedirect("notice");
      // 2.자원을 공유하면서 부르기: 일을 이어서 계속해!
      request.getRequestDispatcher("/WEB-INF/views/customer/notice.jsp").forward(request, response);

   }

   
}
