<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sorayya
  Date: 8/28/2025
  Time: 1:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java2OpenSource (J2OS)</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.min.css">
    <script src="/assets/jquery.min.js"></script>
    <script src="/assets/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/navbar.jsp"/>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">Person CRUD</div>
        <div class="panel-body">


            <form action="/person/save">
                <input type="text" class="form-control" name="name" placeholder="Enter your name"/>
                <br/>
                <input type="text" class="form-control" name="family" placeholder="Enter your family"/>
                <br/>
                <input type="text" class="form-control" name="salary" placeholder="Enter your salary"/>
                <br/>
                <input type="submit" class="btn btn-primary" value="Save Person" style="width: 100%"/>
            </form>
            <br/>

            <table class="table table-hover table-striped table-responsive table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>FAMILY</th>
                    <th>SALARY</th>
                    <th>OPER</th>
                    <th>OPER</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.personList}" var="person">
                    <form action="/person/update">
                        <tr>
                            <td><input type="text" class="form-control" name="id" value="${person.id}" readonly/></td>
                            <td><input type="text" class="form-control" name="name" value="${person.name}"/></td>
                            <td><input type="text" class="form-control" name="family" value="${person.family}"/></td>
                            <td><input type="text" class="form-control" name="salary" value="${person.salary}"/></td>
                            <td><input type="submit" class="btn btn-primary" value="UPDATE"/></td>
                            <td><input type="button" class="btn btn-danger" value="DELETE"
                                       onclick="removePerson(${person.id})"/></td>
                        </tr>
                    </form>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    function removePerson(id) {
        if (confirm("are you sure?"))
            window.location = "/person/remove?id=" + id;
    }
</script>


</body>
</html>

