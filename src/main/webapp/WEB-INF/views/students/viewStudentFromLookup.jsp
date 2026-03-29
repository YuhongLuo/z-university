<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
   <title>Student Lookup Result</title>
</head>
<body>
  <h1>Student Lookup Result</h1>
  <c:if test = "${student == null}">
         <p>No student was found with id: ${badStudentId} <p>
  </c:if>
  
  <c:if test = "${student != null}">
  Last Name: &nbsp; ${student.name.lastName} <br>
  First Name: &nbsp; ${student.name.firstName} <br>
  Age: &nbsp; ${student.age} <br>
  Enrollment Date: &nbsp; <fmt:formatDate value="${student.enrollDate}" pattern="yy-MMM-dd"/> <br>
  Id: &nbsp; ${student.id} <br>
  </c:if>

</body>
</html>