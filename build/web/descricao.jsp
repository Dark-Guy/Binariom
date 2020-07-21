<%
    String descricao = request.getParameter("descricao");
    int bin = Integer.parseInt(request.getParameter("bin"));

    DecimalFormat zf = new DecimalFormat("000000");

%>
<%@page import="java.text.DecimalFormat" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Chamado <%=descricao%></title>

        <link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.7-dist/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="css/popup.css">
    </head>
    <body>
        <header class="header col-xs-12">
            <h1><i class="fa fa-info"></i>&nbsp;&nbsp;Chamado: <%=zf.format(bin)%></h1>
        </header>
        <section>
            <p>
                <% out.println(descricao);%>
            </p>
        </section>
    </body>
</html>