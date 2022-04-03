<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  <link rel="stylesheet" type="text/css" href="/css/allPosts.css">
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Posts page</title>
  </head>
  <body>
  	<div class="container-fluid">
  <div class="row">
       <div class="nav-container bg-secondary">
         <nav class="navbar navbar-expand-lg navbar-light">
           <div class="container-fluid">
             <a class="navbar-brand" href="/"><img alt="" src="/img/logoBLUE.jpg"  height="40px" style="border-radius: 7px;"></a>
             <button
               class="navbar-toggler"
               type="button"
               data-bs-toggle="collapse"
               data-bs-target="#navbarTogglerDemo02"
               aria-controls="navbarTogglerDemo02"
               aria-expanded="false"
               aria-label="Toggle navigation"
             >
               <span class="navbar-toggler-icon"></span>
             </button>
             <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                 <li class="nav-item">
                   <a class="nav-link active" aria-current="page" href="/"
                     >Home</a
                   >
                 </li>
                 <li class="nav-item">
                   <a class="nav-link" aria-current="page" href="#"
                     >Register</a
                   >
                 </li>
                 <li class="nav-item">
                   <a class="nav-link" aria-current="page" href="#">Section</a>
                 </li>
                 <li class="nav-item">
                   <a class="nav-link" aria-current="page" href="/#about"
                     >About us</a
                   >
                 </li>
               </ul>
               <form class="d-flex">
                 <input
                   class="form-control me-2"
                   type="search"
                   placeholder="Search"
                   aria-label="Search"
                 />
                 <button class="btn btn-primary" type="submit">
                   Search
                 </button>
               </form>
             </div>
           </div>
         </nav>
       </div>
     </div>
     <div class="row">
     		<h1 class="my-5">Doctor's Community</h1>
     		<div class="col-12 justify-content-between" style="display:flex;">
     			<h2>Title: <c:out value="${post.title}"></c:out></h2>
     			<h2>Category: <c:out value="${post.category}"></c:out></h2>
     			<h2>Patient: <c:out value="${post.postUser.username}"></c:out></h2>
     		</div>
     		<div class="col-12">
     			<div class= "overflow-auto p-5 " style="height:auto; border: 2px solid black; border-radius: 15px;">
     				<p style="font-size: 25px;"><c:out value="${post.description}"></c:out></p>
     				<form:form action="/posts/${post.id}" method="post" modelAttribute="postComment">
  					<form:input type="hidden" path="commentPost" value="${post.id}"/>
     				<form:input type="hidden" path="commentUser" value="${currentUser.id}"/>
     					<div class="form-floating">
							<form:textarea path="content" class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></form:textarea>
							<form:label path="content" for="floatingTextarea2">Comment</form:label>
						</div>
						<div class="row justify-content-end">
							<button type="submit" class="btn btn-outline-secondary col-1 my-4 me-3">Advise</button>
						</div>
     				</form:form>
     				<div class="p-3 overflow-auto" style="height:400px; border: 2px solid black; border-radius: 15px;">
    				<c:forEach items="${comments}" var="comment">
     					<div class="overflow-auto p-3 my-4" style="height:190px; border: 2px solid black; border-radius: 15px;">
							<p style="font-size: 20px;"><c:out value="${comment.content}"></c:out></p>
							<div class="text-end" >
								<div class="form-floating mb-3 col-1 ">
								  <input type="number" min ="0" max="5" class="form-control" style="width:70px" id="floatingInput" placeholder="name@example.com">
								  <label for="floatingInput">Rating</label>
								</div>
				                <c:set var="liked" value="${false}"/>
                                <c:forEach items="${comment.likedByUsers}" var="liker">
                                <c:set var="user1" value="${currentUser.id}"/>
                                <c:set var="user2" value="${liker.id}"/>
                                    <c:if test="${user1 == user2}">
                                        <c:set var="liked" value="${true}"/>
                                    </c:if>
                                </c:forEach>
                                <c:choose>
                                    <c:when test="${liked == false}">
                        					<a href="/posts/${comment.commentPost.id}/like/${comment.id}"><button type="button" class="btn btn-sm btn-outline-secondary" style="height:30px">Like</button></a>
                                    </c:when>
                                    <c:otherwise>
											<a href="/posts/${comment.commentPost.id}/unlike/${comment.id}"><button type="button" class="btn btn-sm btn-outline-secondary" style="height:30px">DisLike</button></a>
                                    </c:otherwise>
                                </c:choose>
							</div>
     					</div>
					</c:forEach> 
     				</div>	
     			</div>
     		</div>  		
     		    <footer class="text-center text-lg-start text-white mt-5" style="background-color: #929fba">
                <!-- Grid container -->
                <div class="container p-4 pb-0">
                    <!-- Section: Links -->
                    <section class="">
                        <!--Grid row-->
                        <div class="row">
                            <!-- Grid column -->
                            <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
                                <h6 class="text-uppercase mb-4 font-weight-bold">
                                    Company name
                                </h6>
                                <p>
                                    Here you can use rows and columns to organize your footer
                                    content. Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit.
                                </p>
                            </div>
                            <!-- Grid column -->

                            <hr class="w-100 clearfix d-md-none" />

                            <!-- Grid column -->
                            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
                                <h6 class="text-uppercase mb-4 font-weight-bold">Products</h6>
                                <p>
                                    <a class="text-white">MDBootstrap</a>
                                </p>
                                <p>
                                    <a class="text-white">MDWordPress</a>
                                </p>
                                <p>
                                    <a class="text-white">BrandFlow</a>
                                </p>
                                <p>
                                    <a class="text-white">Bootstrap Angular</a>
                                </p>
                            </div>
                            <!-- Grid column -->

                            <hr class="w-100 clearfix d-md-none" />

                            <!-- Grid column -->
                            <hr class="w-100 clearfix d-md-none" />

                            <!-- Grid column -->
                            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                                <h6 class="text-uppercase mb-4 font-weight-bold">Contact</h6>
                                <p><i class="fas fa-home mr-3"></i> New York, NY 10012, US</p>
                                <p><i class="fas fa-envelope mr-3"></i> info@gmail.com</p>
                                <p><i class="fas fa-phone mr-3"></i> + 01 234 567 88</p>
                                <p><i class="fas fa-print mr-3"></i> + 01 234 567 89</p>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                                <h6 class="text-uppercase mb-4 font-weight-bold">Follow us</h6>

                                <!-- Facebook -->
                                <a class="btn btn-primary btn-floating m-1" style="background-color: #3b5998" href="#!"
                                    role="button"><i class="fab fa-facebook-f"></i></a>

                                <!-- Twitter -->
                                <a class="btn btn-primary btn-floating m-1" style="background-color: #55acee" href="#!"
                                    role="button"><i class="fab fa-twitter"></i></a>

                                <!-- Google -->
                                <a class="btn btn-primary btn-floating m-1" style="background-color: #dd4b39" href="#!"
                                    role="button"><i class="fab fa-google"></i></a>

                                <!-- Instagram -->
                                <a class="btn btn-primary btn-floating m-1" style="background-color: #ac2bac" href="#!"
                                    role="button"><i class="fab fa-instagram"></i></a>

                                <!-- Linkedin -->
                                <a class="btn btn-primary btn-floating m-1" style="background-color: #0082ca" href="#!"
                                    role="button"><i class="fab fa-linkedin-in"></i></a>
                                <!-- Github -->
                                <a class="btn btn-primary btn-floating m-1" style="background-color: #333333" href="#!"
                                    role="button"><i class="fab fa-github"></i></a>
                            </div>
                        </div>
                        <!--Grid row-->
                    </section>
                    <!-- Section: Links -->
                </div>
                <!-- Grid container -->

                <!-- Copyright -->
                <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
                    © 2020 Copyright:
                    <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
                </div>
                <!-- Copyright -->
            </footer>   
     </div>
         <footer class="text-center text-lg-start text-white bg-secondary mt-3" >
                <!-- Grid container -->
                <div class="container p-4 pb-0">
                    <!-- Section: Links -->
                    <section class="">
                        <!--Grid row-->
                        <div class="row">
                            <!-- Grid column -->
                            <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
                                <h6 class="text-uppercase mb-4 font-weight-bold">
                                    Company name
                                </h6>
                                <p>
                                    Here you can use rows and columns to organize your footer
                                    content. Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit.
                                </p>
                            </div>
                            <!-- Grid column -->

                            <hr class="w-100 clearfix d-md-none" />

                            <!-- Grid column -->
                            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
                                <h6 class="text-uppercase mb-4 font-weight-bold">Products</h6>
                                <p>
                                    <a class="text-white">MDBootstrap</a>
                                </p>
                                <p>
                                    <a class="text-white">MDWordPress</a>
                                </p>
                                <p>
                                    <a class="text-white">BrandFlow</a>
                                </p>
                                <p>
                                    <a class="text-white">Bootstrap Angular</a>
                                </p>
                            </div>
                            <!-- Grid column -->

                            <hr class="w-100 clearfix d-md-none" />

                            <!-- Grid column -->
                            <hr class="w-100 clearfix d-md-none" />

                            <!-- Grid column -->
                            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                                <h6 class="text-uppercase mb-4 font-weight-bold">Contact</h6>
                                <p><i class="fas fa-home mr-3"></i> Axsos Academy, NY 10012, US</p>
                                <p><i class="fas fa-envelope mr-3"></i> info@gmail.com</p>
                                <p><i class="fas fa-phone mr-3"></i> + 01 234 567 88</p>
                                <p><i class="fas fa-print mr-3"></i> + 01 234 567 89</p>
                            </div>
                            <!-- Grid column -->

                            <!-- Grid column -->
                 <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                     <h6 class="text-uppercase mb-4 font-weight-bold">Follow us</h6>

                     <!-- Facebook -->
                      <a class="btn btn-primary btn-floating m-1" style="background-color: black; href="#!"
                         role="button"><img alt="" src="/img/facebook-logo.jpg"  height="40px" style="border-radius: 7px;"></a>

                     <!-- Twitter -->
                       <a class="btn btn-primary btn-floating m-1" style="background-color: black; href="#!"
                         role="button"><img alt="" src="/img/Twitter.png"  height="40px" style="border-radius: 7px;"></a>


                     <!-- Linkedin -->
                     <a class="btn btn-primary btn-floating m-1" style="background-color: black; href="#!"
                         role="button"><img alt="" src="/img/linked.png"  height="40px" style="border-radius: 7px;"></a>
                     <!-- Github -->
                    <a class="btn btn-primary btn-floating m-1" style="background-color: black; href="#!"
                         role="button"><img alt="" src="/img/github.png"  height="40px" style="border-radius: 7px;"></a>
                 
                        </div>
                        <!--Grid row-->
                    </section>
                    <!-- Section: Links -->
                </div>
                <!-- Grid container -->

                <!-- Copyright -->
                <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
                    © 2020 Copyright:
                    <a class="text-white" href="https://mdbootstrap.com/">MDBootstrap.com</a>
                </div>
                <!-- Copyright -->
            </footer>  
   </div>
</body>
</html>