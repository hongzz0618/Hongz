<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
*{
    margin: 0%;
    padding: 0%;
    font-size: 40px;
    font-family: 'Dokdo', cursive;

  }
  body{
    background-image: url(https://basquebeer.com/wp-content/uploads/2014/03/fondo-claro.jpg);
    background-repeat: no-repeat;
    background-size: cover;
    width: 100%;
      height: 100%;
      position: absolute;
      top: 0px;
      display: flex;
   justify-content: center;
   align-items: center;
      font-size: 30px;
      color: blue;
  }
h1{
background-color: pink;
border: 2px solid black;
border-radius: 5px;
padding: 2px 5px;
}

a{
background-color: gray;
color:black;
font-size:50px;
border: 2px solid black;
}
</style>
</head>
<body>
<h1>Bienvenido al servlet de HONG!!</h1><br/> 
<a href="/JSP/jsp/login.jsp" title="">LOGIN</a><br/>
<a href="/JSP/jsp/tienda.jsp" title="">SHOP</a>
</body>
</html>