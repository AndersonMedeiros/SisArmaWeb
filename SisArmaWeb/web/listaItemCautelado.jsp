<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.Item"%>
<%@page import="dao.Relatorio"%>
<%@page import="bean.Destino"%>
<%@include file="cr/header.jsp" %>
<%List<Item> lista = new Relatorio().listItemCautelado();%>
    <h2> Detalhes dos equipamentos que encontram-se cautelados no momento </h2>
    <div class="table-responsive">
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Equipamento</th>      
                    <th>Arma</th>
                    <th>Série</th>
                    <th>Calibre</th>
                    <th>Fabricante</th>
                    <th>Destino</th>
                    <th>Data</th>
                    <th>Armeiro</th>
                </tr>
            </thead>
            <tbody>

                <%for (Item i : lista) {%>
                <tr>
                    <td><%=i.getCautela().getMilitar().getLogin() %></td>
                    <td><%=i.getEquipamento().getNome() %></td>          
                    <td><%=i.getEquipamento().getArma().getArma() %></td>
                    <td><%=i.getEquipamento().getSerie() %></td>
                    <td><%=i.getEquipamento().getCalibre().getCalibre() %></td>
                    <td><%=i.getEquipamento().getFabricante().getFabricante() %></td>
                    <td><%=i.getCautela().getDestino().getDestino() %></td>
                    <td><%=new SimpleDateFormat("dd-MM-yyyy").format(i.getData_cautela())%></td>
                    <td><%=i.getCautela().getFuncaomilitar().getMilitar().getLogin() %></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>


<div> <br/> </div>
</div>
<%@include file="cr/footer.jsp" %>



