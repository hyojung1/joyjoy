<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
String sql = "SELECT * FROM NOTICE_VIEW WHERE TITLE LIKE ? ";
String query="";
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection(url,"c##sist","dclass ");
//Statement st = con.createStatement();
//ResultSet rs = st.executeQuery(sql);

PreparedStatement st = con.prepareStatement(sql);
st.setString(1, "%"+query+"%");
//Statement st = con.prepareStatement();

ResultSet rs = st.executeQuery();

String code="";
String title="";
String writer="";
Date regdate;
int hit;



%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1><a href="">보현 online</a></h1>
		
		<ul>
			  <li><a href="../index.jsp">HOME</a></li>
				<li><a href="notice.jsp">공지사항</a></li>		
		</ul>
		<%-- 제목, 문장, 목록, 폼, 표--%>
		<table border="5">
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</thead>
			<tbody>
			<%while(rs.next()){
				code = rs.getString("CODE");
				title = rs.getString("TITLE");
				writer = rs.getString("WRITER");
				regdate = rs.getDate("REGDATE");
				hit=rs.getInt("HIT");%>
				<tr>
					<td><%=code%></td>
					<td><a href="notice-detail.jsp?code=<%=code%>"><%=title %></a></td>
					<td><%=writer %></td>
					<td><%=regdate%></td>
					<td><%=hit%></td>
				</tr>
			<%}
				rs.close();
				st.close();
				con.close(); %>
				<tr>
					<td>2</td>
					<td>JSP 강의가 시작됩니다.</td>
					<td>bohyeon</td>
					<td>2016-09-08</td>
					<td>847</td>
				</tr>
			</tbody>
		</table>

</body>
</html>