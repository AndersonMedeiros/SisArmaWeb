
<%@page import="dao.Relatorio"%>
<%@page import="bean.Equipamento"%>
<%@page import="java.util.List"%>

<%@include  file="cr/header.jsp"%>

<% List<Equipamento> lista = new Relatorio().listaEquipamentoCategoria(); %>

<div> <br/> </div>
<canvas class="line-chart"> </canvas>


<script src="js/chart.js"></script>
<script>
    var ctx = document.getElementsByClassName("line-chart");
    var chartGraph = new Chart(ctx, {
    type: 'doughnut',
            data: {
            labels: [<%for (Equipamento e : lista) {%> "<%=e.getCategoria().getCategoria()%>", <%}%>],
                    datasets: [{

                    data: [<%for (Equipamento d : lista) {%> "<%=d.getQtd()%>", <%}%>],
                            backgroundColor: [
                                    'rgba(255, 99, 132, 1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)'
                            ]
                    }
                    ]
            },
            options: {
            title:{
            display: true,
                    fontSize: 20,
                    text: "Equipamentos Separados por Categorias "
            }
            }
    });
</script> 

<br/>

<%@include  file="cr/footer.jsp"%>
