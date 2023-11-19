<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%@include file="components/navbar.jsp" %>

    <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="car paint-card" >
					<div class="card-body">
					<p class="fs-4 text-center">User Login</p>
					<%  String str=(String)session.getAttribute("fail");
					    
						if(str!=null)
						{%>
							<h3 style="color:red"><%= str %></h3>
						 <%	
						 session.removeAttribute("fail");
						}
					%>
						<form action="UserLogin" method="post">
							<div class="mb-3">
								<label class="form-label">Email Address</label>
								<input name="email" type="email" class="form-control" required>	
								</div>
							<div class="mb-3">
								<label class="form-label">Password</label>
								<input name="password" type="password" class="form-control" required>					
							</div>
							<button type="submit" class="btn bg-success text-white col-md-12">Login</button>
						</form>
						<h3>New User ? <a href="userRegister.jsp" class="text-success fs-3 text-decoration-none">Register</a></h3>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>