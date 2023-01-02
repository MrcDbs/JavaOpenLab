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
    MyWiki:modifica ${titolo}
  </div>
     <div class="row">
       <div class="col-12 col-lg-6 mx-auto">
         <div class="card-wrapper">
           <div class="card">
             <div class="card-body">
             
             	<form action="salva-pagina.action" method="post">
             		<textarea name="contenuto" cols="70" rows="15"><c:out value="${contenuto}"/></textarea> 
             		<br/>
             		<br/>
             		<input type="hidden" name="titolo" value="${titolo}"/>
             		<input class="btn" type="submit" value="Salva"/>
            	 </form>
             
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