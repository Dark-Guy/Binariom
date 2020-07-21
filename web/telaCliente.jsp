<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Chamado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.ChamadoDAO"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cliente cLog = (Cliente) session.getAttribute("cliente");
    ArrayList<Chamado> chamados = new ArrayList<Chamado>();
    ChamadoDAO cDAO = new ChamadoDAO();
    chamados = cDAO.carregarChamadosPorMatricula(cLog.getMatricula());
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
        <link rel="stylesheet" type="text/css" href="css/tables.css">

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
                            <h4 class="titleMat">Matrícula:</h4>
                            <div id="matriculaCliente" class="margin matricula"><%=cLog.getMatricula()%></div>
                            <h4 class="titleSetor">Setor:</h4>
                            <div id="setorCliente" class="margin matricula"><%=cLog.getSetor()%></div>
                            <h4 class="titleTelefone">Telefone:</h4>
                            <div id="telefoneCliente" class="margin matricula"><%=cLog.getTelefone()%></div>
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
                            <h3 class="position"><i class="fa fa-list-ol" aria-hidden="true"></i>&nbsp;&nbsp;Lista de Chamados</h3>
                        </div>
                        <div id="divTableList" class="divTableList col-xs-10 col-xs-offset-1">
                            <center>
                                <table class="tableList table table-responsive">
                                    <tr>
                                        <th>BIN</th>
                                        <th>DETALHES</th>
                                        <th>STATUS</th>
                                        <th>DATA DE ABERTURA</th>
                                        <th>TÉCNICO</th>
                                        <th>ATENDIMENTO</th>
                                    </tr>
                                    <%
                                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
                                        DecimalFormat zf = new DecimalFormat("000000");
                                        try {
                                            for (Chamado c : chamados) {
                                    %>
                                    <tr>
                                        <td><%=zf.format(c.getBin())%></td>
                                        <td>
                                            <i id="iDetalhe" class="fa fa-info detalhe" style="cursor: pointer;" value="<%=c.getBin()%>" title="<%=c.getBin()%>" onclick="javascript:window.open('descricao.jsp?bin=<%=c.getBin()%>&descricao=<%=c.getDescricao()%>', 'popup', 'width=380, height=200, top=300, left=30')">   
                                            </i>
                                        </td>
                                        <td><%=c.getStatus()%></td>
                                        <td><%=df.format(c.getDa())%></td>
                                        <td><%=c.getUsuario().getNome()%></td>
                                        <td>
                                            <i id="iDetalhe" class="fa fa-info detalhe" style="cursor: pointer;" value="<%=c.getBin()%>" title="<%=c.getBin()%>" onclick="javascript:window.open('atendimento.jsp?bin=<%=c.getBin()%>&atendimento=<%=c.getAtendimento()%>', 'popup', 'width=380, height=200, top=300, left=30')">   
                                            </i>
                                        </td>
                                    </tr>
                                    <%
                                            }
                                        } catch (Exception e) {                                           
                                            out.print("ERRO:" + e);
                                        }
                                    %>
                                </table>
                                <a class="btnFinalizarChamado" href="telaCliente_abrirChamado.jsp" 
                                   style="
                                   display: block;
                                   width: 150px;
                                   padding: 5px;
                                   background: #eb5e28;
                                   border-radius: 5px;
                                   color: white;
                                   text-decoration: none;">Abrir Chamado</a>
                            </center>
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
