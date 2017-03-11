<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Welcome</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>

<body>
<div class="jumbotron">
    <div class="container">
    <h1> Student Registration system</h1>
    </div>
</div>
<div class="container">
    <p class="lead">There are two sections to the site, Students and Courses.</p>
    <p>Use the Student section to view existing students, add new students, leave enrolled courses and see details of each student's enrolled courses.</p>
    <p>Use the courses section of the site to view existing courses, add and remove courses, enroll in a course and view the students currently enrolled on each course.</p>
<div class="row">
    <div class="col-md-6"><a href="/students/list">Go to Students</a></div>
    <div class="col-md-6"><a href="/courses/list">Go to Courses</a></div>
</div>
</div>
</body>
</html>