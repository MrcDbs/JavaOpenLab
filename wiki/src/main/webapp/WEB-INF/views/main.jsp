<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <title>MyWiki: ${titolo}</title>
       <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
              crossorigin="anonymous">
</head>
<body onload="document.getElementById('email').disabled=false;"
  style="font-family:Verdana; font-size:16px;" class="bg-light">
     <br/>
     <div class="row">
       <div class="col-12 col-lg-6 mx-auto">
         <div class="card-wrapper">
           <div class="card">
             <div class="card-body">
             <div class="jumbotron">
             <h1 class="display-5">MyWiki:${titolo}</h1>
               <p class="lead">MyWiki is a simple page application. If you know Wikipedia this application is similar but very simple.</p>
               <hr class="my-4">
               
               <form name="modificaFomr" action="edit.action" method="post">
               	<input type="hidden" name="titolo" value="${titolo}"/>
               	<input class="btn btn-primary" type="submit" value="Modifica"/>
               </form>
               
               <h5 class="card-title big-heading"></h5>
               <p><c:out value="${contenuto}" default="" escapeXml="false"/></p>
               <br/>
               <c:if test="${not empty mail_ok}">
               		<div class="alert alert-primary" role="alert">
               		<c:out value="${mail_ok}" default="" escapeXml="false"/>
               		</div>
               </c:if>
               <div class="py-1">
               <c:import url="fragments/pulsantiera.jsp"/>
               
               </div>
                    </div>
             </div>
           </div>
         </div>
       </div>
     </div>
</body>
</html>