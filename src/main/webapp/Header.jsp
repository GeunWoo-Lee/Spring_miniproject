<%@page import="kr.kedu.java01.spms.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//MemberVO member = (MemberVO)session.getAttribute("member");
%>    
<div style ="background-color:#00008b;color:#ffffff;
 height:20px;padding:5px;">
 SPMS(Simple Project Management System)
	<c:choose>
		<c:when test="${sessionScope.member.email != null}">
			<span style="float: right;"> ${sessionScope.member.name} <a
				style="color: white;"
				href="${pageContext.request.contextPath}/auth/logout.do"> 로그아웃</a>
			</span>
		</c:when>
		<c:otherwise> 	
			<span style="float: right;"> <a style="color: white;"
				href="../auth/login.do">로그인</a>
			</span>
		</c:otherwise>
	</c:choose>
</div>