<%@page import="modelo.Cliente"%>
<%@page import="modelo.ChamadoDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Chamado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cliente cLog = (Cliente) session.getAttribute("cliente");
    Chamado c = new Chamado();
    int bin = Integer.parseInt(request.getParameter("bin"));
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    try {
        ChamadoDAO cDAO = new ChamadoDAO();
        c = cDAO.carregarPorBin(bin);
    } catch (Exception e) {
        out.print("ERRO:" + e);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>B1NARI0M - Visão Geral</title>

        <!--=======LINK's CSS=======-->
        <link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.7-dist/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="css/style_especificas.css">
        <link rel="stylesheet" type="text/css" href="css/forms.css">
        <link rel="icon" type="text/css" href="img/icon_logo_shurt.png">
    </head>
</head>
<body class="body">
    <div class="container-fluid">
        <div class="row">
            <section id="sectionCliente" class="section">
                <!--=======================MENU PERFIL=======================-->
                <div id="divDadosPerfilCliente" class="divDadosPerfil col-xs-12 col-md-3 ">
                    <div class="row">
                        <div class="position logo col-xs-12">
                            <a href="index.jsp"><div class="position imgLogo"></div></a>
                        </div>
                        <!--=======================DADOS PERFIL=======================-->
                        <i class="i fa fa-user-circle-o">
                            <a href="logout.jsp"><div class="btnLogout"><i class="fa fa-sign-out"></i></div></a>
                        </i>
                        <div class="btnCloseMenu"><i class="fa fa-times" aria-hidden="true"></i></div>
                        <div class="dadosPerfil">
                            <div id="nomeCliente" class="margin nome"><%=cLog.getNome()%></div>
                            <h4 class="titleMat">Matricula:</h4>
                            <div id="matriculaCliente" class="margin matricula"><%=cLog.getMatricula()%></div>
                            <h4 class="titleSetor">Setor:</h4>
                            <div id="setorClienteChamadoSearch" class="margin matricula"><%=cLog.getSetor()%></div>
                            <h4 class="titleTelefone">Telefone:</h4>
                            <div id="telefoneClienteChamadoSearch" class="margin matricula"><%=cLog.getTelefone()%></div>
                            <h5 id="titleSetorCliente" class="titleSetor">Área Cliente</h5>
                        </div>
                        <!--==============================================-->
                        <div id="divMenuPerfilCliente" class="divMenuPerfil">
                            <nav id="navMenuCliente" class="navMenu">
                                <ul id="ulMenuCliente" class="position margin ulMenu" type="none">
                                    <li id="liVisaoGeralCliente" class="margin liVisaoGeral liVisaoGeralCliente">
                                        <a href="telaCliente.jsp">
                                            <h5 class="op"><i class="fa fa-address-card-o" aria-hidden="true"></i>&nbsp;&nbsp;Visão Geral</h5>
                                        </a>
                                    </li>

                                    <li id="li1" class="margin liVisaoGeral li1">
                                        <a href="#">
                                            <h5 class="op"><i class="fa fa-envelope iMenu" aria-hidden="true"></i>
                                                &nbsp;&nbsp;Chamado&nbsp;&nbsp;<i class="fa fa-caret-down drop1" aria-hidden="true"></i>
                                            </h5>
                                        </a>
                                        <ul id="ulSubMenu1" class="ulSubMenu ulSubMenu1">
                                            <li id="liSubMenuChamado1" class="liSubMenu">
                                                <a href="telaCliente_abrirChamado.jsp"><i class="fa fa-folder-open"></i>&nbsp;&nbsp;Abrir Chamado</a>
                                            </li>
                                            <li id="liSubMenuChamado2" class="liSubMenu">
                                                <a href="telaCliente_pesquisarChamado.jsp"><i class="fa fa-search-plus"></i>&nbsp;&nbsp;Pesquisar Chamado</a>
                                            </li>
                                            <li id="liSubMenuChamado3" class="liSubMenu">
                                                <a href="telaCliente.jsp"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;Listar Chamados</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <!--==============================================-->
                <!--=======================CONTROLE DE CHAMADOS=======================-->
                <div id="divControlCliente" class="controleChamado col-xs-12 col-md-9 col-md-offset-3">
                    <div class="row">
                        <div id="headerSectionCliente" class="position headerSection">
                            <div class="btnOpenMenu"><i class="fa fa-bars" aria-hidden="true"></i></div>
                            <h3 class="position"><i class="fa fa-search" aria-hidden="true"></i>&nbsp;&nbsp;Detalhe do Chamado: </h3>
                        </div>
                        <div id="divForm2" class="divForm2">
                            <form method="POST" action="#" id="form2" class="form2 formDetalheChamado">

                                <label id="lblDescricao" class="labelChamado">Descrição: </label><br/>
                                <textarea rows="4" cols="30" readonly><%=c.getDescricao()%></textarea><br/><br/>

                                <label id="lblNome" class="labelChamado">Nome:</label>
                                <input type="text" id="inputNome" class="input inputChamado margin" value="<%=cLog.getNome()%>" readonly><br/><br/>

                                <label id="lblData" class="labelChamado">Data de abertura:</label>
                                <input type="text" value="<%=sdf.format(c.getDa())%>" id="inputData" class="input inputChamado margin" readonly><br/><br/>
                                <hr></hr>

                                <label id="lblEtiqEquipamento" class="labelChamado">Etiqueta do Equipamento:</label>
                                <input type="text"  id="inputEtiqueta" class="input inputChamado margin" value="<%=c.getEquipamento().getEtiqueta()%>" readonly>
                                <br/>
                                <hr></hr>

                                <label id="lblTecnico" class="labelChamado">Técnico:</label>
                                <input type="text" id="inputTecnico" class="input inputChamado margin" value="<%=c.getUsuario().getNome()%>" readonly>
                            </form>
                        </div>
                    </div>
                </div>
                <!--==============================================-->
            </section>
        </div>
    </div>

    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/script.js"></script>
</body>
</html>

