<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
 </head>
<body>

<a href="/addnew">Add New Song</a>
<a href="">Top Songs</a>

<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Title</th>
      <th scope="col">Rating</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
<c:forEach items="${lookify}" var="lookify">
    <tr>
      <th scope="row">${lookify.id}</th>
      <td><a class="navbar-brand" href="/show/${lookify.id}">${lookify.title}</a></td>
      <td>${lookify.artist}</td>
      <td>${lookify.rating}</td>
      <td><a class="navbar-brand" href="/delete/${lookify.id}">DELETE</a></td>
    </tr>
	</c:forEach>
    
  </tbody>
</table>



<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
 --><!-- <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
 -->
</body>
</html>