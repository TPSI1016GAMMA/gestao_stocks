<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList, model.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Produto</title>
<!--Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>   
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
	<div class="container">
        
        <div class="jumbotron">
        <h3><span class="label label-success">Inserir Produto</span></h3>


	<form action="ProductHandler" method="post">

		<div class="input-group">

			<input type="text" placeholder="Nome" class="form-control"
				aria-describedby="sizing-addon1" name="nome">
		</div>

	
		<input type="submit" class="btn btn-primary" value="Inserir">



	</form>
</div>
</div>
	<br>

	<table class="table table-striped">
		<tr>
			<th>Nome</th>
			

		</tr>
		<%
			ArrayList products = (ArrayList) request.getAttribute("products");
			for (int i = 0; i < products.size(); i++) {
				Product p = (Product) products.get(i);
				out.append("<tr><td> " + p.getNome() + "</td></tr>");

			}
			
		%>
	</table>
    </body>
</html>
