<%@page import="model.Buyerregister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/buyerregister.js"></script>
</head>
<body>
		<div class="container"><div class="row"><div class="col-6">
		<h1>Buyer Register Page </h1>
		<form id="formBuyer" name="formBuyer">
		
 		First Name:
 		<input id="fname" name="fname" type="text"class="form-control form-control-sm">
 		<br> Last Name:
 		<input id="lname" name="lname" type="text"class="form-control form-control-sm">
 		<br> Tele No:
 		<input id="phone" name="phone" type="text"class="form-control form-control-sm">
 		<br> Birth Date:
 		<input id="bdate" name="bdate" type="text"class="form-control form-control-sm">
 		<br>
 		Email:
 		<input id="email" name="email" type="text"class="form-control form-control-sm">
 		<br> Country:
 		<input id="country" name="country" type="text"class="form-control form-control-sm">
 		<br> Password:
 		<input id="password" name="password" type="text"class="form-control form-control-sm">
 		<br> Confirm Password:
 		<input id="cpassword" name="cpassword" type="text"class="form-control form-control-sm">
 		<br>
 		
 	
		
		<input id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary">
 		<input type="hidden" id="hidbidSave"name="hidbidSave" value="">
		</form>
		
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		<br>
		
		<div id="divItemsGrid">
		
		 <%
		   
		 Buyerregister itemObj = new Buyerregister();
 			
 			out.print(itemObj.readBuyer());
 		%>
</div>
</div> </div> </div>
</body>
</html>