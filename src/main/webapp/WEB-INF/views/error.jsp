<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Error Page</title>
</head>
<body>
<h1>
	Operation failed.  Please try again.  
</h1>

<P>  Exception is: ${exception.message}. </P>
</body>
</html>
