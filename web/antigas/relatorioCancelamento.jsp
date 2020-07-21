<%-- 
    Document   : relatorio
    Created on : 26/06/2017, 10:35:36
    Author     : Gilberto
--%>

<%@page import="modelo.Usuario"%>
<%@page import="modelo.Chamado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Chamado c = new Chamado();
    int bin = Integer.parseInt(request.getParameter("bin"));
    String matricula = request.getParameter("matricula");


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conclusão de chamado</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.7-dist/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="css/popup.css">
        <link rel="stylesheet" type="text/css" href="css/forms.css">

        <script>
            function fecha() {

                window.close();
// dando um refresh na página principal
                opener.location.href = "gerenciar_chamado.do?bin=<%=bin%>&op=cancelarAdmin&status=Cancelar&usuario_matricula=<%=matricula%>";

            }
        </script>
    </head>
    <body>
        <header class="header">
            <div class="title"><i class="fa fa-list-alt"></i>&nbsp;&nbsp;Cancelamento de chamado</div>
        </header>
        <section class="section">
            <center>
                <br/><br/><label id="lblAtendimento" class="labelChamado">Motivo:</label><br/><br/> 
                <textarea cols="80"name="atendimento" rows="8" placeholder="Motivo de cancelamento"></textarea><br/><br/>
                <a class="btnFinalizarChamado" href="javascript:void(0)" onclick="fecha()">Cancelar chamado</a>
            </center>
        </section>
    </body>
</html>
