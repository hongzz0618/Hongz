<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title></title>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <style>
    * {
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    margin: 0;
    padding: 0;
}
 
body {
  background-image: url(https://res.cloudinary.com/boom-creatividad-slu/image/upload/v1538048159/innovar-en-tu-tienda-online3_srie28.png);
  background-repeat: no-repeat;
  background-size: cover;
    font-family: "Roboto";

}
 
.wrap {
    width: 90%;
    max-width: 1000px;
    margin: 0 20px;
    /*margin: auto;*/
}
 
.formulario > div {
    padding: 20px 0;
 
}
.titol{
  text-align: center;
  background-color: pink;
  width: 40%;
  margin-left: 400px;
  font-size: 40px;

}
.box{
  background-color: aqua;
  border: 1px solid black;
  display: inline-block;
  font-size: 50px;

}
.radio{
  background-color: yellow;
  border: 1px solid black;
  display: inline-block;
  font-size: 50px;
  text-align: center;
}
b{
  background-color: orange;
  font-size: 50px;
}
.select{
  background-color: gray;
  font-size: 50px;
}

#checkbox{
margin-left: 90px;
}
  </style>



</head>
<body>
  <div class="wrap">
    <form action="/tienda" class="formulario" method="POST">
      <div class="titol"><fieldset>FORM Products</fieldset></div>

      <div class="checkbox">
        <div class="box"><label for="checkbox2">img1</label></div>
        <div class="box"><label for="checkbox2">img2</label></div>
        <div class="box"><label for="checkbox2">img3</label></div>
        <div class="box"><label for="checkbox2">img4</label></div>
        <div class="box"><label for="checkbox2">img5</label></div><br>
        
        <input type="checkbox" name="checkbox2" id="checkbox">
        <input type="checkbox" name="checkbox2" id="checkbox">
        <input type="checkbox" name="checkbox2" id="checkbox">
        <input type="checkbox" name="checkbox2" id="checkbox">
        <input type="checkbox" name="checkbox2" id="checkbox">
        
      </div>

      <div class="radio">
        <h2>Pay Mode</h2>
        <input type="radio" name="sexo" id="hombre">
        <label for="hombre">Cash</label>
    
        <input type="radio" name="sexo" id="mujer">
        <label for="mujer">Card</label>
    
        <input type="radio" name="sexo" id="alien">
        <label for="alien">PayPal</label>
      </div>
    
      <div class="text">
    <b>NICK</b>
        <input type="text" name="nick" id="hombre">
        
    <b>Comments</b>
        
      <textarea name="text"></textarea>
      
      </div>
    <div class="select">
      Quantity
      <select name="select">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="n">n</option>
</select>
    </div>
    
  </div>
  <div class="submit">
<input type="submit" value="confirmar">
<a href="/JSP/jsp/validar.jsp" title="">validar</a>
</div>

</form>
</body>
</html>
