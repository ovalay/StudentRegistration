<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
            <h1>Courses</h1>
            <p>Enrolled Students in Course id:${courseId}</p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${students}" var="student">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${student.studentId}</h3>
                        <p>${student.firstName}</p>
                        <p>${student.lastName}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<footer class="container">
    <p>
        <form method="GET" action="/courses/enroll" class="form-horizontal">
        <fieldset>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="studentId">Enter Student Id</label>
                <div class="col-lg-10">
                    <input id="studentId" name="studentId" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="studentId">Course Id</label>
                <div class="col-lg-10">
                    <input id="courseId" name="courseId" type="text" readonly="true" value="${courseId}" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn
                                 btn-primary" value ="Enroll in this course"/>
                </div>
            </div>
        </fieldset>
    </form>
    </p>
    <p>
        <a href="<spring:url value="/courses/list" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span> Back
        </a>
    </p>
</footer>
</body>
</html>