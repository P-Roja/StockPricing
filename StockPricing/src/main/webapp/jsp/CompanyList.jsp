<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="java.util.*,com.StockPricing.model.Company"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="Style/StockStyle.css">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<div class="topnav" id="myTopnav">
   
<div id="navbar" style = "float:right">
  <h4 align="center">List Of Companies</h4>

  
</div>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>

<div  id="content">



<br><br><h4 align="center">List of Companies</h4><br>



<%
List companyList=(List)request.getAttribute("companyList");
System.out.println(companyList);
%>

 <table class="table">

  <tbody>
<tr>
<th class="text-center" >Company Code</th>
<th>Company Name</th>
<th>Turn Over</th>
<th>CEO</th>
<th>Board of Directors</th>
</tr>

<% for(int i=0;i<companyList.size();i++){
	Company company=(Company)companyList.get(i);
	%>
<tr>
<td align="center"><%= company.getCompanyCode() %></td>
<td><%= company.getCompanyName() %></td>
<td><%= company.getTurnover()  %></td>
<td><%= company.getCeo() %>
<td><%= company.getBoardOfDirectors() %></td>

</tr>
<% }%>
 </tbody>
</table>
 
</div>

</body>
</html>


