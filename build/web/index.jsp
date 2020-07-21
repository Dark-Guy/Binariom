<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>B1NARI0M - Tela Inicial</title>
        <!--=======LINK's CSS=======-->
        <link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.7-dist/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="icon" type="text/css" href="img/icon_logo_shurt.png">
    </head>
    <body class="body">
        <div class="position container-fluid">
            <div class="row">
                <section id="sectionHome" class="margin section">
                    <div id="divHeaderHome" class="display divHeader">
                        <a href="index.jsp"><div id="logoHome" class="logo"></div></a>
                        <h5 class="position">Sistema de Controle de Chamados</h5>
                    </div>

                    <div id="opSetorHome" class="display opSetor col-xs-8 col-xs-offset-2 col-lg-5 col-lg-offset-6">
                        <div id="setClientHome" class="position setClient">
                            <a id="linkClientHome" href="loginCliente.jsp" class="position linkClient">
                                <i class="i fa fa-user-circle-o"></i><br/><br/>
                                Cliente
                            </a>
                        </div>
                        <div id="setAdminHome" class="position setAdmin">
                            <a id="linkAdminHome" href="loginB1nari0m.jsp" class="position linkAdmin">
                                <i class="position i fa fa-cogs"></i><br/><br/>
                                Administrativo
                            </a>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>
