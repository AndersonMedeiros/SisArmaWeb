<%@page import="bean.ItemParticular"%>
<%@page import="bean.Equipamento"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.Relatorio"%>
<%@include file="cr/header.jsp" %>
<%
    List<Equipamento> lista = new Relatorio().listaEquipamentoParticular();
    
%>

    <h2> Detalhe de todos equipamentos particulares já cadastrado </h2>
    <div class="table-responsive">
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th>Equipamento</th>
                    <th>Série</th>
                    <th>Arma</th>
                    <th>Calibre</th>
                    <th>Fabricante</th>
                    <th>Quantidade</th>
                    <th>Obs</th>
                </tr>
            </thead>
            <tbody>

                <%for (Equipamento e : lista) {%>
                <tr>
                    <td><%=e.getNome()%></td>
                    <td><%=e.getSerie() %></td>
                    <td><%=e.getArma().getArma() %></td>
                    <td><%=e.getCalibre().getCalibre() %></td>
                    <td><%=e.getFabricante().getFabricante() %></td>
                    <td><%=e.getQtd() %></td>
                    <td><%=e.getObs() %></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
<div> <br/> </div>
</div>
<%@include file="cr/footer.jsp" %>



