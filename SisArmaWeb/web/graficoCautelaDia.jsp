<%@page import="bean.Item"%>
<%@page import="bean.Graduacao"%>
<%@page import="dao.Relatorio"%>


<%@include file="cr/header.jsp" %>
<% List<Item> lista = new Relatorio().graficoDiaCautela() ; %>

<canvas class="line-chart"> </canvas>

<div>
    <script src="js/chart.js"></script>
    <script>
        var ctx = document.getElementsByClassName("line-chart");
        var chartGraph = new Chart(ctx, {
        type: 'line',
         data: {
          labels: [<%for (Item i : lista) {%> "<%=i.getId()  %>", <%}%> ],
          datasets:
              [{
                label: 'Equipamentos Cautelados',
                data: [<%for (Item it : lista) {%> "<%=it.getQtd()  %>", <%}%> ],
                borderWidth: 3,
                borderColor: 'rgba(13,164,66,1)',
                backgroundColor: 'transparent',
              }]
      },
      options: {
        title:{
         display: true,
         fontSize: 20,
         text: "Número de Equipamentos Cautelados por Dias"
        },
        
        
        
      }
        });
        
    </script>
</div>


<%@include file="cr/footer.jsp" %>



