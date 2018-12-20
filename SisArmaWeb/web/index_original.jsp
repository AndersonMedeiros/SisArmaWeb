<%@page import="bean.ItemParticular"%>
<%@page import="bean.Item"%>
<%@page import="dao.Relatorio"%>
<%@page import="bean.Destino"%>
<%@include file="cr/header.jsp" %>
<%
    List<Item> lista = new Relatorio().prontoReserva();
    List<ItemParticular> lista2  = new Relatorio().prontoReservaParticular();
%>
    <h3> Situação da Reserva de Armamento - Material Carga e Relacional </h3>
    <div class="table-responsive">
        <table class="table table-hover table-striped" >
            <thead>
                <tr>
                    <th>Equipamento</th>
                    <th>Arma</th>
                    <th>Calibre</th>
                    <th>Fabricante</th>
                    <th>Previsto</th>
                    <th>Cautelado</th>
                    <th>Reserva</th>
                </tr>
            </thead>
            <tbody>

                <%for (Item i : lista) {%>
                <tr>
                    <td><%=i.getEquipamento().getNome() %></td>
                    <td><%=i.getEquipamento().getArma().getArma() %></td>
                    <td><%=i.getEquipamento().getCalibre().getCalibre() %></td>
                    <td><%=i.getEquipamento().getFabricante().getFabricante() %></td>
                    <td><%=i.getReserva() %></td>
                    <td><%=i.getCautelado() %></td>
                    <td><%=i.getTotal() %></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
            
<h3> Situação da Reserva de Armamento - Material Particular</h3>
    <div class="table-responsive">
        <table class="table table-hover table-striped tab-pane">
            <thead>
                <tr>
                    <th>Equipamento</th>
                    <th>Arma</th>
                    <th>Calibre</th>
                    <th>Fabricante</th>
                    <th>Quantidade</th>
                </tr>
            </thead>
            <tbody>

                <%for (ItemParticular ip : lista2) {%>
                <tr>
                    <td><%=ip.getEquipamento().getNome() %></td>
                    <td><%=ip.getEquipamento().getArma().getArma() %></td>
                    <td><%=ip.getEquipamento().getCalibre().getCalibre() %></td>
                    <td><%=ip.getEquipamento().getFabricante().getFabricante() %></td>
                    <td><%=ip.getEquipamento().getQtd() %></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>

<div> <br/> </div>
</div>
<%@include file="cr/footer.jsp" %>



