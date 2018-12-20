<%@page import="bean.Graduacao"%>
<%@page import="dao.Relatorio"%>


<%@include file="cr/header.jsp" %>
<% List<Graduacao> lista = new Relatorio().graficoEfetivo(); %>

<canvas class="line-chart"> </canvas>

<div>
    <script src="js/chart.js"></script>
    <script>
        var ctx = document.getElementsByClassName("line-chart");
        var chartGraph = new Chart(ctx, {
        type: 'line',
                data: { 
                labels: ["Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez"],
                datasets:[{
                  label: "Taxa de Cliques - 2018",      
                  data: [5,10,5,14,20,15,14,6,12,15,5,10],
                  borderWidth: 5,
                  borderColor: 'rgba(77,166,253,1)',
                  backgroundColor: 'transparent',
                }]
                }         
        });
        
    </script>
</div>


<%@include file="cr/footer.jsp" %>



