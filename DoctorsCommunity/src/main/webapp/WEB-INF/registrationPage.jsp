<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
  <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
</head>
<body>
	 <div class="container-fluid m-5 p-5">
        <div class="row justify-content-center py-5 border">
            <div class="col-5">
			   <h1 class="mb-5">Patient Registration </h1>
			   <p><form:errors path="user.*"/></p>
			   <form:form method="POST" action="/registration" modelAttribute="user">
			   
			   	    <div class="form-floating my-3">
			             <form:input path="username" class="form-control" id="floatingInput" placeholder="name@example.com"/>
			             <form:label path="username" for="floatingInput">Username:</form:label>
			  		</div>
			  		<div class="form-floating my-3">
			             <form:input path="email" class="form-control" id="floatingInput" placeholder="name@example.com"/>
			             <form:label path="email" type="email" for="floatingInput">E-mail:</form:label>
			  		</div>
			  		<div class="form-floating my-3 col-2">
			             <form:input path="age" class="form-control col-2" id="floatingInput" placeholder="name@example.com"/>
			             <form:label path="age" type="number" for="floatingInput">Age:</form:label>
			  		</div>
			  		<div class="form-floating my-3">
			             <form:input path="password" class="form-control" type="password" id="floatingInput" placeholder="name@example.com"/>
			             <form:label path="password" for="floatingInput">Password:</form:label>
			  		</div>
			  		<div class="form-floating my-3">
			             <form:input path="passwordConfirmation" type="password" class="form-control" id="floatingInput" placeholder="name@example.com"/>
			             <form:label path="passwordConfirmation" for="floatingInput">Confirm Password:</form:label>
			  		</div>
			       <button type="submit" class="btn btn-light">Register</button>
			   </form:form>
            </div>
        </div>
    </div>
</body>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
</html>