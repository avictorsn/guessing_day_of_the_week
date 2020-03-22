<%-- 
    Document   : dia
    Created on : 22/03/2020, 02:17:59
    Author     : anton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>O dia da semana é...</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    </head>
    <body>
        <c:set var="weekDay" value="${dayOfTheWeek}"></c:set>
        <center>
            <h5>${errorMsg}</h5>
            <h4>Você entrou com os valores: dia ${day}, mês ${month}, ano ${year} </h4>
            <h1>${dayOfTheWeek}</h1>
        </center>
    </body>
</html>
