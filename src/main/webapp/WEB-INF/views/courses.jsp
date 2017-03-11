<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Courses</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Courses</h1>
            <p>Current courses</p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${courses}" var="course">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${course.courseId}</h3>
                        <p>${course.name}</p>
                        <p>${course.description}</p>
                        <p>
                            <a href=" <spring:url value="/courses/enrolledStudents?courseId=${course.courseId}" /> " class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Enrolled Students
                            </a>
                        </p>
                        <p>
                            <a href=" <spring:url value="/courses/delete?courseId=${course.courseId}" /> " class="btn btn-danger">
                                <span class="glyphicon-minus-sign glyphicon"/></span> Delete course
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
        <a href="<spring:url value="/courses/add" />" class="btn btn-primary">
            <span class="glyphicon-plus-sign glyphicon"/></span> Add course
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