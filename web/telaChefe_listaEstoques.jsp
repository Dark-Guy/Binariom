<%@page import="modelo.Usuario"%>
<%@page import="modelo.Estoque"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario uCh = (Usuario) session.getAttribute("usuario");
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
        <script type="text/javascript">
            function excluir(id, nome) {
                var url = "gerenciar_estoque.do?op=excluir&id=" + id;
                if (confirm("Tem certeza que quer excluir o estoque ?" + nome)) {
                    window.open(url, "_self");
                }
            }
        </script>
    </head>
</head>
<body class="body">
    <div class="container-fluid">
        <div class="row">
            <section id="sectionChefe" class="section">
                <!--=======================MENU PERFIL=======================-->
                <div id="divDadosPerfilChefe" class="divDadosPerfil col-xs-12 col-md-3 ">
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
                            <div id="nomeChefe" class="margin nome"><%=uCh.getNome()%></div>
                            <h4 class="titleMat">Matrícula:</h4>
                            <div id="matriculaChefe" class="margin matricula"><%=uCh.getMatricula()%></div>
                            <h5 id="titleSetorChefe" class="titleSetor">Área Administrativa</h5>
                        </div>
                        <!--==============================================-->
                        <div id="divMenuPerfilChefe" class="divMenuPerfil">
                            <nav id="navMenuChefe" class="navMenu">
                                <ul id="ulMenuChefe" class="position margin ulMenu" type="none">
                                    <li id="liVisaoGeralChefe" class="margin liVisaoGeral liVisaoGeralChefe">
                                        <a href="telaChefe.jsp">
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
                                                <a href="telaChefe_abrirChamado.jsp"><i class="fa fa-folder-open"></i>&nbsp;&nbsp;Abrir Chamado</a>
                                            </li>
                                            <li id="liSubMenuChamado2" class="liSubMenu">
                                                <a href="telaChefe_pesquisarChamado.jsp"><i class="fa fa-search-plus"></i>&nbsp;&nbsp;Pesquisar Chamado</a>
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
                                                <a href="telaChefe_inserirEquipamento.jsp"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Equipamento</a>
                                            </li>
                                            <li id="liSubMenuEquipamento2" class="liSubMenu">
                                                <a href="telaChefe_listaEquipamentos.jsp"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;Listar Equipamentos</a>
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
                                                <a href="telaChefe_inserirEstoque.jsp"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Estoque</a>
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
                                                <a href="telaChefe_inserirComponente.jsp"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Componente</a>
                                            </li>
                                        </ul>
                                    </li>

                                    <li id="li6" class="margin liVisaoGeral li6">
                                        <a href="#">
                                            <h5 class="op"><i class="fa fa-users iMenu" aria-hidden="true"></i>
                                                &nbsp;&nbsp;Usuarios&nbsp;&nbsp;<i class="fa fa-caret-down drop6" aria-hidden="true"></i>
                                            </h5>
                                        </a>
                                        <ul id="ulSubMenu6" class="ulSubMenu ulSubMenu6">
                                            <li id="liSubMenuUsuario1" class="liSubMenu">
                                                <a href="telaChefe_inserirUsuario.jsp"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Usuário</a>
                                            </li>
                                            <li id="liSubMenuUsuario2" class="liSubMenu">
                                                <a href="telaChefe_listaUsuarios.jsp"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;Listar Usuários</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li id="li7" class="margin liVisaoGeral li7">
                                        <a href="#">
                                            <h5 class="op"><i class="fa fa-user-circle iMenu" aria-hidden="true"></i>
                                                &nbsp;&nbsp;Clientes&nbsp;&nbsp;<i class="fa fa-caret-down drop5" aria-hidden="true"></i>
                                            </h5>
                                        </a>
                                        <ul id="ulSubMenu7" class="ulSubMenu ulSubMenu7">
                                            <li id="liSubMenuCliente1" class="liSubMenu">
                                                <a href="telaChefe_inserirCliente.jsp"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Cliente</a>
                                            </li>
                                            <li id="liSubMenuCliente2" class="liSubMenu">
                                                <a href="telaChefe_listaClientes.jsp"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;Listar Clientes</a>
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
                <div id="divControlChefe" class="controleChamado col-xs-12 col-md-9 col-md-offset-3">
                    <div class="row">
                        <div id="headerSectionChefe" class="position headerSection">
                            <div class="btnOpenMenu"><i class="fa fa-bars" aria-hidden="true"></i></div>
                            <h3 class="position"><i class="fa fa-list-ol" aria-hidden="true"></i>&nbsp;&nbsp;Lista de Estoques</h3>
                        </div>
                        <div id="divTableList" class="divTableList col-xs-10 col-xs-offset-1">
                            <center>
                                <table class="tableList table table-responsive">
                                    <tr>
                                        <th>NOME</th>
                                        <th>QUANTIDADE</th>
                                        <th>OPÇÕES</th>
                                    </tr>
                                    <%
                                        try {
                                            Estoque estoque = new Estoque();
                                            for (Estoque e : estoque.listar()) {
                                    %>
                                    <tr>
                                        <td><%=e.getNome()%></td>
                                        <td><div id="quantidadeEstoque" class="quantidadeChamado"><%=e.contarComponentes(e.getId())%></div></td>
                                        <td>
                                            <a href="telaChefe_checarEstoque.jsp?id=<%=e.getId()%>&nome=<%=e.getNome()%>" title="Checar"><i class="fa fa-eye" aria-hidden="true"></i></a>
                                            ou
                                            <a href="telaChefe_requisitarComponente.jsp" title="Requisitar Componente"><i class="fa fa-cart-plus" aria-hidden="true"></i></a>
                                        </td>
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
