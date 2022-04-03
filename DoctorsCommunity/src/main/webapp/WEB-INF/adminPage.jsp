<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adminstrator Page</title>
</head>
   <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
<body>
	<div class="container-fluid">
		 <div class="row">
    <nav class="navbar navbar-expand-lg bg-secondary" style="display: flex; justify-content: space-between;">
        <div class="logo">
            <a class="navbar-brand" href="/"><img alt="" src="/img/logoBLUE.jpg"  height="40px" style="border-radius: 7px;"></a>
        </div>
        <div class="otherbtns" style="display:flex;">
        	<div>
            <a href="/" class="btn btn-primary ">Home</a>
            <c:forEach items="${userRole.roles}" var="role">
            	 <c:if test="${role.id == 1}">
                   <c:set var="patient" value="${true}"/>
               	 </c:if>
      		</c:forEach> 
      		<c:choose>
               <c:when test="${patient == true}">
                       <a href="/user/${currentUser.id}" class="btn btn-primary ">profile</a>
               </c:when>
               <c:otherwise>
                      <a href="/doctor/${currentUser.id}" class="btn btn-primary ">profile</a>
               </c:otherwise>
           </c:choose>
        	</div>
             <form id="logoutForm" method="POST" action="/logout">
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		        <input type="submit" value="Logout!" class="btn btn-danger ms-1" />
	    	 </form>
        </div>
    </nav>
     </div>
		<div class="row">
			<h1 class="my-5">Welcome, Admin <c:out value="${currentUser.username}"></c:out></h1>
			<h3>All Site Users</h3>
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Username</th>
			      <th scope="col">E-mail</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
		        <c:forEach items="${siteUsers}" var="user">
			    <tr>
			      <th scope="row"><c:out value="${user.id}"></c:out></th>
			      <td><c:out value="${user.username}"></c:out></td>
			      <td><c:out value="${user.email}"></c:out></td>
			      <td><a href="/delete/${user.id}"><button type="button" class="btn btn-danger">Delete</button></a></td>
			    </tr>
	      		</c:forEach> 
			  </tbody>
			</table>			
		</div>
	</div>
</body>
</html>