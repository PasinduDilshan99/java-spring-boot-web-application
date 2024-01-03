<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" />
    <title>hello jsp</title>
</head>
<body>
<div class="container">
   <h1>login</h1>
    <pre>${errorMessage}<pre>
    <form method="POST">
        Name:<input type="text" name="name">
         password:<input type="password" name="password">
         <input type="submit">
    </form>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.0/js/jquery.min.js"></script>
    </div>
</body>
</html>
