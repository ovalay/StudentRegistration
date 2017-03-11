<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <p>Add course</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form  method="POST" modelAttribute="newCourse" class="form-horizontal">
        <fieldset>
            <legend>Add new course</legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="courseId">Course Id</label>
                <div class="col-lg-10">
                    <form:input id="courseId" path="courseId" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="name">Name</label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="description">Description</label>
                <div class="col-lg-10">
                    <form:input id="description" path="description" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn
                         btn-primary" value ="Add"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>