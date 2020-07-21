<%@page import="modelo.Cliente"%>
<%@page import="modelo.ChamadoDAO"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Chamado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario uTec = (Usuario) session.getAttribute("usuario");
    Chamado c = new Chamado();
    Cliente cl = new Cliente();
    ArrayList<Usuario> tecnicos = new ArrayList<Usuario>();
    int bin = Integer.parseInt(request.getParameter("bin"));
    String cliente = request.getParameter("cliente");
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
    try {
        ChamadoDAO cDAO = new ChamadoDAO();
        c = cDAO.carregarPorBin(bin);

        Usuario u = new Usuario();
        tecnicos = u.listarTecnicos();

        cl.carregarPorMatricula(cliente);
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
                            <div id="nomeTecnico" class="margin nome">Gilberto Lopes</div>
                            <h4 class="titleMat">Matrícula:</h4>
                            <div id="matriculaTecnico" class="margin matricula">xxxxx-x</div>
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
                                                <a href="#"><i class="fa fa-folder-open"></i>&nbsp;&nbsp;Abrir Chamado</a>
                                            </li>
                                            <li id="liSubMenuChamado2" class="liSubMenu">
                                                <a href="#"><i class="fa fa-search-plus"></i>&nbsp;&nbsp;Pesquisar Chamado</a>
                                            </li>
                                            <li id="liSubMenuChamado3" class="liSubMenu">
                                                <a href="#"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;Listar Chamados</a>
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
                                                <a href="#"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Equipamento</a>
                                            </li>
                                            <li id="liSubMenuEquipamento2" class="liSubMenu">
                                                <a href="#"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;Listar Equipamentos</a>
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
                                                <a href="#"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Estoque</a>
                                            </li>
                                            <li id="liSubMenuEstoque2" class="liSubMenu">
                                                <a href="#"><i class="fa fa-list-ul"></i>&nbsp;&nbsp;Lista de Estoques</a>
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
                                                <a href="#"><i class="fa fa-plus-circle"></i>&nbsp;&nbsp;Inserir Componente</a>
                                            </li>
                                        </ul>
                                    </li>
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
                            <h3 class="position"><i class="fa fa-search" aria-hidden="true"></i>&nbsp;&nbsp;Detalhe do Chamado: </h3>
                        </div>
                        <div id="divForm2" class="divForm2">
                            <form method="POST" action="gerenciar_chamado.do" id="form2" class="form2 formDetalheChamado">
                                <input type="hidden" name="op" value="realizar">
                                <input type="hidden" name="bin" value="<%=c.getBin()%>">
                                
                                <label id="lblDescricao" class="labelChamado">Descrição: </label><br/>
                                <textarea name="descricaoChamado" rows="4" cols="30" maxlength="200" placeholder="Digite uma breve descrição"></textarea><br/><br/>
                                <label id="lblNome" class="labelChamado">Nome:</label>
                                <input type="text" name="nomeRequisitante" maxlength="20" id="inputNome" class="input inputChamado margin"><br/><br/>
                                <label id="lblData" class="labelChamado">Data de abertura:</label>
                                <input type="text" name="dataAbertura" maxlength="20" id="inputData" class="input inputChamado margin"><br/><br/>
                                <hr></hr>
                                <label id="lblLocalidade" class="labelChamado">Localidade:</label>
                                <input type="text" name="localidadeChamado" maxlength="20" id="inputLocalidade" class="input inputChamado margin">
                                <label id="lblEtiqEquipamento" class="labelChamado">Etiqueta do Equipamento:</label>
                                <input type="text" name="etiquetaEquipamento" maxlength="20" id="inputEtiqueta" class="input inputChamado margin">
                                <br/>
                                <hr></hr>
                                <label id="lblStatus" class="labelChamado">Status:</label>
                                <select title="Selecione o status" class="position select" name="statusChamado">
                                    <option></option>
                                </select><br/>
                                <label id="lblResponsavel" class="labelChamado">Responsável:</label>
                                <select title="Selecione o responsável" class="position select" name="responsavelChamado">
                                    <option></option>
                                </select><br/><br/>                                
                                <input type="submit" name="btnAbrirChamado" id="btnDetalheChamado" class="btnAbrirChamado margin" value="Salvar">
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