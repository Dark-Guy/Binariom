<%
	String erro = request.getParameter("erro");
%>
<!DOCTYPE html>
<html>
<head>
	<title>ERRRO!</title>
	<link rel="stylesheet" type="text/css" href="css/popup.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.7-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.css">
</head>
<body>
<header style="width: 100%; height: 80px;" class="header">
    <a href="index.jsp"><div class="logo"></div></a>
</header>
<section class="section">
	<h3>ERRO</h3><br/>
	<i class="fa fa-exclamation-triangle"></i><br/><br/>
	<p><% out.println(erro);%></p>
</section>
</body>
</html>