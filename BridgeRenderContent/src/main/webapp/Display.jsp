<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
    <title>Rendered Content</title>
</head>
<body>
    <h1>Rendered Content</h1>
    <div>
        <%-- Use JSTL to conditionally escape or render content --%>
        <c:choose>
            <c:when test="${param.format == 'html'}">
                <%-- For HTML, output directly (careful with XSS) --%>
                <%= request.getAttribute("content") %>
            </c:when>
            <c:otherwise>
                <%-- For other types, escape HTML entities --%>
                <c:out value="${content}"/>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>