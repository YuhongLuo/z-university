<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Student Lookup</title>
</head>
<body> <center>
<h1>Use the student id to lookup a student</h1>
<form name="GetStudentIdForm" action="./executeidlookup" method="POST">
    Student Id: <input type="TEXT" name="studentId">
    <input type="submit" value="Lookup">
</form>
</body>
</html>