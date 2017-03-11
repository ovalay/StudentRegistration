<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Students</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Students</h1>
            <p>Current students</p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${students}" var="student">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${student.firstName}</h3>
                        <p>${student.lastName}</p>
                        <p>${student.studentId}</p>
                        <p>
                            <a href=" <spring:url value="/students/details?studentId=${student.studentId}" /> " class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Student details
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<footer class="container">
    <p>
        <a href="<spring:url value="/students/add" />" class="btn btn-primary">
            <span class="glyphicon-plus-sign glyphicon"/></span> Add student
        </a>
    </p>
    <p>
        <a href="/" class="btn btn-default">
            <span class="glyphicon-home glyphicon"></span> Home
        </a>
    </p>
</footer>
</body>
</html>