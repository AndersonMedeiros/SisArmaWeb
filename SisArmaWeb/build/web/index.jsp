<%-- 
    Document   : Login
    Created on : 29/05/2018, 01:21:43
    Author     : ander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/estilo_tela_login.css" rel="stylesheet">
        
    </head>

    <body class="fundo">
        <div class="row">
            
            <div class="tela col-xs-12 col-md-12">
                
                <div class="col-xs-3 col-md-3 formLogin">
             
                    <form name="formEntrar" method="post" action="NewServlet">
                        <h1 id="titulo">SisArma</h1>
                        <div class="col-md-12" style="margin-left: auto; margin-right: auto; ">
                            <div class="form-group col-md-12">
                              <label id="lblLogin" name="lblLogin" for="lblLogin">Login:</label>
                              <input type="text" class="form-control" name="txtLogin" placeholder="Login" maxlength="30">
                            </div>
                            <div class="form-group col-md-12">
                              <label id="lblSenha" name="lblSenha" for="lblSenha">Senha:</label>
                              <input type="password" class="form-control" name="txtSenha" placeholder="Senha" maxlength="20" >
                            </div>
                        </div>
                        <div class="col-xs-12">
                            <div class="col-xs-6 col-md-6">
                                <button type="submit" class="btnE btn-centralizado" value="Entrar">Entrar</button>
                            </div>
                            <div class="col-xs-6 col-md-6">
                                <button type="reset" class="btnS btn-centralizado" value="Cancelar">Cancelar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
