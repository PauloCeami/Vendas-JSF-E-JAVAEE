
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style type="text/css">
            <%@ include  file="css/bootstrap.css"%>
        </style>


<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
          <script src="../assets/js/html5shiv.js"></script>
        <![endif]-->

<!-- Fav and touch icons -->


  <style type="text/css">
           body {
	padding-top: 40px;
	padding-bottom: 40px;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
           
        </style>






</head>

<body>

	<div class="container">

	   <div class="row">
	   
	   <div class="span12">
	   
	   	<form action="." method="post" >
			<input type="hidden" name="acao" value="AutenticaUsuario" /> email:
			<input type="text" name="email" /><br /> senha: <input
				type="password" name="senha" /><br /> <input type="submit"
				value="Entrar" /><br />
		</form>
	   
	   </div>
	   
	   </div>
	</div>
	<!-- /container -->

	<!-- Le javascript
        ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->



</body>
</html>
