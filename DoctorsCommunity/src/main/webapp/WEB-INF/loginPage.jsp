<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
  <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
</head>
<body>
	<div class="container-fluid p-5 m-5 border">
		<div class="row">
			<div class="col-5 p-4 m-4">
			    <c:if test="${logoutMessage != null}">
			        <c:out value="${logoutMessage}"></c:out>
			    </c:if>
			    <h1>Login Page</h1>
			    <c:if test="${errorMessage != null}">
			        <c:out value="${errorMessage}"></c:out>
			    </c:if>
			    <form method="POST" action="/login">
			    	 <div class="form-floating my-3">
			             <input  class="form-control" type="text" id="username" name="username"/>
			             <label  for="floatingInput">Username:</label>
				  	</div>
			  		<div class="form-floating my-3">
			             <input class="form-control" type="password" id="password" name="password"/>
			             <label for="floatingInput">Password:</label>
			  		</div>
			        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			        <button type="submit" class="btn btn-info" value="Login!">Log In</button>
			    </form>
			</div>
		</div>
	</div>
</body>
</html>