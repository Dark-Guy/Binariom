<%@page import="modelo.Usuario"%>
<%@page import="modelo.Equipamento"%>
<%
    Usuario uTec = (Usuario) session.getAttribute("usuario");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <script type="text/javascript">
            function excluir(etiqueta) {
                var url = "gerenciar_equipamento.do?op=excluirTecnico&etiqueta=" + etiqueta;
                if (confirm("Tem certeza que quer excluir o equipamento?")) {
                    window.open(url, "_self");
                }
            }
        </script>
    </head>
</head>
<body class="body">
    <div class="container-fluid">
        <div class="row">
            <section id="sectionTecnico" class="section">
                <!--=======================MENU PERFIL=======================-->
                <div id="divDadosPerfilTecnico" class="divDadosPerfil col-xs-12 col-md-3 ">
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
                            <div id="nomeTecnico" class="margin nome"><%=uTec.getNome()%></div>
                            <h4 class="titleMat">Matrícula:</h4>
                            <div id="matriculaTecnico" class="margin matricula"><%=uTec.getMatricula()%></div>
                            <h5 id="titleSetorTecnico" class="titleSetor">Área Técnica</h5>
                        </div>
                        <!--==============================================-->
                        <div id="divMenuPerfilTecnico" class="divMenuPerfil">
                            <nav id="navMenuTecnico" class="navMenu">
                                <ul id="ulMenuTecnico" class="position margin ulMenu" type="none">
                                    <li id="liVisaoGeralTecnico" class="margin liVisaoGeral liVisaoGeralTecnico">
                                        <a href="telaTecnico.jsp">
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
                                                <a href="telaTecnico_abrirChamado.jsp"><i class="fa fa-folder-open"></i>&nbsp;&nbsp;Abrir Chamado</a>
                                            </li>
                                            <li id="liSubMenuChamado2" class="liSubMenu">
                                                <a href="telaTecnico_pesquisarChamado.jsp"><i class="fa fa-search-plus"></i>&nbsp;&nbsp;Pesquisar Chamado</a>
                                            </li>
                                        </ul>
                                    </li>

                                    <li id="li2" class="margin liVisaoGeral li2">
                                        <a href="#">
                                            <h5 class="op"><i class="fa fa-laptop iMenu" aria-hidden="true"></i>
                                                &nbsp;&nbsp;Equipamento&nbsp;&nbsp;<i class="fa fa-caret-down drop2" aria-hidden="true"></i>
                                            </h5>
                                        </a>
                                        <ul id="ulSubMenu2" class="ulSubMenu ulSubMenu2">
                                            <li id="liSubMenuEquipamento1" class="liSubMenu">
                                                <a href="telaTecnico_inserirEquipamento.jsp"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Equipamento</a>
                                            </li>
                                            <li id="liSubMenuEquipamento2" class="liSubMenu">
                                                <a href="telaTecnico_listaEquipamentos.jsp"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;Listar Equipamentos</a>
                                            </li>
                                        </ul>
                                    </li>

                                    <li id="li3" class="margin liVisaoGeral li3">
                                        <a href="#">
                                            <h5 class="op"><i class="fa fa-database iMenu" aria-hidden="true"></i>
                                                &nbsp;&nbsp;Estoque&nbsp;&nbsp;<i class="fa fa-caret-down drop3" aria-hidden="true"></i>
                                            </h5>
                                        </a>
                                        <ul id="ulSubMenu3" class="ulSubMenu ulSubMenu3">
                                            <li id="liSubMenuEstoque1" class="liSubMenu">
                                                <a href="telaTecnico_inserirEstoque.jsp"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Estoque</a>
                                            </li>
                                            <li id="liSubMenuEstoque2" class="liSubMenu">
                                                <a href="telaTecnico_listaEstoques.jsp"><i class="fa fa-eye"></i>&nbsp;&nbsp;Ver Estoques</a>
                                            </li>
                                        </ul>
                                    </li>

                                    <li id="li4" class="margin liVisaoGeral li4">
                                        <a href="#">
                                            <h5 class="op"><i class="glyphicon glyphicon-print iMenu" aria-hidden="true"></i>
                                                &nbsp;&nbsp;Componente&nbsp;&nbsp;<i class="fa fa-caret-down drop4" aria-hidden="true"></i>
                                            </h5>
                                        </a>
                                        <ul id="ulSubMenu4" class="ulSubMenu ulSubMenu4">
                                            <li id="liSubMenuComponente1" class="liSubMenu">
                                                <a href="telaTecnico_inserirComponente.jsp"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Componente</a>
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
                <div id="divControlTecnico" class="controleChamado col-xs-12 col-md-9 col-md-offset-3">
                    <div class="row">
                        <div id="headerSectionTecnico" class="position headerSection">
                            <div class="btnOpenMenu"><i class="fa fa-bars" aria-hidden="true"></i></div>
                            <h3 class="position"><i class="fa fa-list-ol" aria-hidden="true"></i>&nbsp;&nbsp;Lista de Equipamentos</h3>
                        </div>
                        <div id="divTableList" class="divTableList col-xs-10 col-xs-offset-1">
                            <center>
                                <table class="tableList table table-responsive">
                                    <tr>
                                        <th>ETIQUETA</th>
                                        <th>TIPO</th>
                                        <th>OPÇÕES</th>
                                    </tr>
                                    <%
                                        try {
                                            Equipamento equipamento = new Equipamento();
                                            for (Equipamento e : equipamento.listar()) {
                                    %>
                                    <tr>
                                        <td><%=e.getEtiqueta()%></td>
                                        <td><%=e.getTipo()%></td>
                                        <td>
                                            <a href="telaTecnico_alterarEquipamento.jsp?etiqueta=<%=e.getEtiqueta()%>" title="Alterar"><i class="fa fa-pencil" aria-hidden="true"></i></a> 
                                            ou 
                                            <a href="#" onclick="excluir('<%=e.getEtiqueta()%>')" title="Excluir"> <i class="fa fa-times" aria-hidden="true"></i></a>
                                            ou
                                            <a href="telaTecnico_listaComponentes.jsp?etiqueta=<%=e.getEtiqueta()%>" title="listar"><i class="fa fa-microchip" aria-hidden="true"></i></a></td>

                                    </tr>
                                    <%
                                            }
                                        } catch (Exception x) {
                                            out.print("ERRO:" + x);
                                        }
                                    %>
                                </table>
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
