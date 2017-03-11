<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Student Details</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Details</h1>
            <p>Details for ${student.firstName} ${student.lastName}</p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${student.firstName}</h3>
                        <p>${student.lastName}</p>
                        <p>${student.studentId}</p>
                        <p>
                            <a href=" <spring:url value="/students/studentCourses?studentId=${student.studentId}" /> " class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Enrolled courses
                            </a>
                        </p>
                    </div>
                </div>
            </div>
    </div>
</section>
<footer class="container">
    <a href="<spring:url value="/students/list" />" class="btn btn-default">
        <span class="glyphicon-hand-left glyphicon"></span> Back
    </a>
</footer>
</body>
</html>