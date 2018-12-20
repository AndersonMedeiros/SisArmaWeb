
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Relatórios</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Morris Charts CSS -->
        <link href="css/plugins/morris.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="listaItemCautelado.jsp">BEM-VINDO, <%
                            HttpSession sessao = request.getSession();
                            
                            if(sessao.getAttribute("situacao_login") == null){
                                sessao.setAttribute("login_usuario", "false");
                            }
                            else if(sessao.getAttribute("situacao_login").equals("true")){
                                out.println("<b>"+sessao.getAttribute("login_mil")+"</b>");
                            }
                        %> - SISTEMAS RESERVA DE ARMAMENTO WEB</a>
                </div>


                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="graficoCautelaDia.jsp"> Cautelas Dia</a>
                        </li>
                        <li>
                            <a href="destinoCautelado.jsp"> Destino Cautelado</a>
                        </li>
                        <li>
                            <a href="destinoGeral.jsp"> Destino Total</a>
                        </li>
                        <li>
                            <a href="equipamentos.jsp"> Armamentos</a>
                        </li>
                        <li>
                            <a href="equipamentosCategoria.jsp"> Categorias Material </a>
                        </li>
                        <li>
                            <a href="prontoReserva.jsp"> Informações da Reserva</a>
                        </li>                        

                        <li>
                            <a href="listaItemCautelado.jsp"> Informações das Cautelas</a>
                        </li>                        
                        <li>
                            <a href="particular.jsp">Informações Material Particulares</a>
                        </li>
                       
                        <li>
                            <form name="formSair" method="post" action="Sair">
                                <button name="btnSair" class="btnSair" type="submit" style="background: none; border: none; padding-top: 15px; padding-bottom: 15px; color: #999;"> Sair</button>
                            </form>
                        </li>
                        
                        
                        
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row" >
                        <div class="col-lg-12" >
                            <!--                            <h1 class="page-header">
                                                            SisArmaWeb <small> - Relatórios</small>
                                                        </h1>
                            -->                      
                        </div>
                    </div>
