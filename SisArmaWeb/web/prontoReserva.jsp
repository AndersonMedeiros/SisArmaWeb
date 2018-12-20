<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.Item"%>
<%@page import="dao.Relatorio"%>
<%@page import="bean.Destino"%>
<%@include file="cr/header.jsp" %>
<%List<Item> lista = new Relatorio().prontoReserva();%>
<h2> Pronto Reserva - Companhia Comando e Serviço </h2>
<div class="table-responsive">
    <table class="table table-hover table-striped">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Arma</th>
                <th>Calibre</th>
                <th>Fabricante</th>
                <th>Qtd Reserva</th>
                <th>Qtd Cautelado</th>
                <th>Qtd Total</th>
            </tr>
        </thead>
        <tbody>

            <%for (Item i : lista) {%>
            <tr>

                <td><%=i.getEquipamento().getNome()%></td>

                <td><%=i.getEquipamento().getArma().getArma()%></td>
                <td><%=i.getEquipamento().getCalibre().getCalibre()%></td>
                <td><%=i.getEquipamento().getFabricante().getFabricante()%></td>
                <td><%=i.getReserva()%></td>
                <td><%= i.getCautelado()%></td>
                <td><%=i.getTotal()%></td>

            </tr>
            <%}%>
        </tbody>
    </table>
</div>


<div> <br/> </div>
<div> <form action="GerarRelatorio" method="post"><button type="submit">Gerar Relatório em PDF</button></form></div>

</div>
<%@include file="cr/footer.jsp" %>



