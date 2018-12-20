<%@page import="dao.Relatorio"%>
<%@page import="bean.Destino"%>
<%@include file="cr/header.jsp" %>
<% List<Destino> listaDestino = new Relatorio().itemDestino(); %>
<canvas class="line-chart"> </canvas>

<div>
    <script src="js/chart.js"></script>
    <script>
        var ctx = document.getElementsByClassName("line-chart");
        var chartGraph = new Chart(ctx, {
        type: 'horizontalBar',
                data: {
                labels: [<%for (Destino des : listaDestino) {%> "<%=des.toString()%>",<%}%>],
                        datasets: [{
                        label: 'Quantidade de equipamentos já cautelados',
                                data: [<%for (Destino d : listaDestino) {%> "<%=d.getItemDesitno()%>", <%}%>],
                                borderWidth: 6,
                                backgroundColor: [
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)',
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                ]

                        }
                        ]
                },
                options: {
        title:{
         display: true,
         fontSize: 20,
         text: "Destino de Todos os Equipamentos já Cautelados"
        }
      }
        });
    </script>
</div>
<%@include file="cr/footer.jsp" %>



