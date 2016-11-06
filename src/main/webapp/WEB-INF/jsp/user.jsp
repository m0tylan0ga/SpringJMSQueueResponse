<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="java.util.List"%>
<%@page import="com.example.models.Topic"%>
<%@page import="com.example.models.User"%>
<html lang="en" xmlns:th="http://www.springframework.org/schema/mvc">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>User Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <body>
        </br>
        </br>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <h3><p class="text-center">Queue</p></h3>
            </div>
            <div class="col-md-4"></div>
        </div>
        </br>
        </br>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <table class="table">
                    <thead>
                        <tr>
                            <th>User name</th>
                            <th>Category</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${subscribers}" var="user">
                            <tr>
                                <td><c:out value="${user.name}"/></td>
                                <td><c:out value="${user.topic}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-4"></div>
        </div>
        </br>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <h3><a href='/'/>Refresh</a></h3>
            </div>
            <div class="col-md-4"></div>
        </div>
    </body>
</html>