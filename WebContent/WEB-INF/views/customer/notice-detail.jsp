
<%@page import="com.bohyeon.web.entities.Notice"%>
<%@page import="com.bohyeon.web.dao.mybatis.MyBatisNoticeDao"%>
<%@page import="com.bohyeon.web.dao.NoticeDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tbody>
			<tr>
				<td>제목</td>
				<td colspan="3">${n.title}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd"
						value="${n.regDate}" /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${n.writer}</td>
				<td>조회수</td>
				<td>${n.hit}</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4">${n.content}</td>
			</tr>
		</tbody>
	</table>
	<div>
		<a href="notice">목록</a> <a href="notice-edit?code=${n.code}">수정</a> 
		<a href="notice-del?code=${n.code}">삭제</a></div>
</body>
</html>