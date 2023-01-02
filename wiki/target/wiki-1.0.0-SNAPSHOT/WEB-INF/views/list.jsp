<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>MyWiki: ${titolo}</title>
       <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
  </head>
  <body style="font-family:Verdana; font-size:16px;" class="bg-light">
   <div id="title" align="center" style="font-family:Verdana;font-size:32px;font-variant:small-caps">
    MyWiki:${intestazione}
  </div>
     <div class="row">
       <div class="col-12 col-lg-6 mx-auto">
         <div class="card-wrapper">
           <div class="card">
             <div class="card-body">
                <table class="table">
                     <tr>
                    <td>Titolo</td>
                    <td>Data ultima modifica</td>
                    <td></td>
                    <td></td>
                </tr>
                
                <c:forEach var="pagina" items="${lista}">
                	<tr>
                		<td><a href="main.action?titolo=${pagina.titolo}">${pagina.titolo}</a></td>
                		<td>${pagina.ultimaModifica}</td>
                		<td><a href="edit.action?titolo=${pagina.titolo}">Modifica</a></td>
                		<td><a href="elimina.action?titolo=${pagina.titolo}&tipo_richiesta=${tipo_richiesta}">Elimina</a></td>
                		</tr>
                		</c:forEach>
                </table>
                <h5 class="card-title big-heading"></h5>
                <div class="py-1">
                    <c:import url="fragments/pulsantiera.jsp"/>
                </div>
             </div>
           </div>
         </div>
       </div>
     </div>
  </body>
</html>
  

</body>
</html>