package com.bohyeon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class Index extends HttpServlet
{
   @Override
   public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
   {
      response.setCharacterEncoding("UTF-8");//Send data
      response.setContentType("text/html; charet=UTF-8");//Receive data
      
      String _cnt=request.getParameter("cnt");//p key value
      
      int cnt = 0;//null �Է½ÿ� �������� �⺻�Է°�
      
      PrintWriter out = response.getWriter();
      
      if(_cnt!=null&&_cnt!="")
      {
         cnt=Integer.parseInt(_cnt);//cnt���� null ���� ���� �� �⺻�� ���
      }
      
      out.write("<!DOCTYPE html>");
      out.write("<html>");
      out.write("<head>");
      out.write("<meta charset=\"UTF-8\">");
      out.write("<title>Insert title here</title>");
      out.write("</head>");
      out.write("<body>");
      out.write("   <form action=\"greeting\" method=\"get\">");
      out.write("      <fieldset>");
      out.write("         <legend>ȯ���λ� �Է���</legend>");
      out.write("         <div>");
      out.write("            <label>�ݺ�Ƚ��</label>");
      out.write("            <input type=\"text\" name=\"cnt\"/>");
      out.write("         </div>");
      out.write("         <div>");
      out.write("            <input type=\"submit\" vaule=\"say hello\"/>");
      out.write("         </div>");
      out.write("      </fieldset>");
      out.write("   </form>");
      for(int i=0; i<cnt; i++)
      {
         out.println((i+1)+":�ȳ� ���� !!<br>");
      }
      out.write("</body>");
      out.write("</html>");
   }
}