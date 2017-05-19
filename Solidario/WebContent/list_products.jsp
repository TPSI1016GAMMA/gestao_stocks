<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList, model.ProductCategory, model.BarCode , model.Product"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produtos - Gestão de Stocks</title>


<!-- Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 
<!-- DataTables -->
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css">
  
<script type="text/javascript" src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"></script>


        <script type="text/javascript">
            $(document).ready(function() {
                $('#teste').dataTable({
           
                	
                	  //-----------------------Posisonamento do "Show Entries"-------------//
                	  dom:'frtlip',
                	  
                	  //----------------------Tirar a Label e meter uma placeholer---------//
                	  language: {
                		  		search: "" ,
                	            searchPlaceholder: "Procurar Produto"
                	            
                	            },
                	                       	                        	            	         
                		
                });
                
          
                $('div.dataTables_filter input').addClass('form-control ');
            });

     
        </script>
    <!-- CSS -Todo Separar ficheiro -->    
        <style type="text/css">

 		#teste_filter label{
        
        float:left;
        
        }
      	#teste_filter input{
        
        margin-left:0 !important;
        
        }
        

        #teste_paginate{
        
        text-align: center;
        

        
        
        }
        
        #new_product{
        float: right;
		margin-bottom: 2%;
	
		}
             
     
    	#btn_delete{
    	
    	margin-right: 2%;
    	
    	}  
        
        </style>

</head>
<body>
<!-- Navegador -->
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
    
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
    
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
    
          <a class="navbar-brand" href="#">Gestor de Stocks</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">

       </div>
      </div>
    </nav>

<!--Container  -->
<div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar" style="margin-top: 3%;">
          <ul class="nav nav-sidebar" style="position:fixed;" >
            <li><a href="#">Home<span class="sr-only">(current)</span></a></li>    
        
            <li><a href="#">Gestão Produtos</a></li>
            <li><a href="#">Gestão Warehouse</a></li>
             </ul>
    
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-top: 0%;">
          <h1 class="page-header">Produto</h1>

			<div class="jumbotron">
		 	<button class="btn btn-primary" id="new_product" data-toggle="modal" data-target="#modal_new"><span class="glyphicon glyphicon-plus"></span> Novo Produto</button>
			
	
		<table id="teste" class="table table-striped table-bordered" width="100%" cellspacing="0" style="background-color: white;margin-top: 1%;">
		<thead>
			<tr><th>ID</th><th>Produto</th><th>Stock Minimo</th><th>Acções</th></tr>
		
		</thead>
		<tbody>			
			
			
			
			
			<%
			/*
			ArrayList product = (ArrayList) request.getAttribute("product");
			for (int i = 0; i < product.size(); i++) {
				Product p = (Product) product.get(i);
				
			}
			*/
			
			%>
			
		</tbody>		
		
		</table>
				
				
				
				
				
				   
			</div>	
        </div>
      </div>
    </div>
    
 





<!-- Modal Inserir Armazens? -->
   <div class="modal fade" id="modal_new" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title">Inserir Produto</h4>
        
        
 </div><!--  Header -->

      <div class="modal-body" id="product_body">
			  
	  	<form method="post" action="ProductHandler">
			
				
				<input class="form-control" type="text" name="tf_product" placeholder="Nome do Produto">

				<br>				
				<select name="s_category" class="form-control">

		

				</select>
				
			
				
				<br>
					<input type="number" class="form-control" placeholder="Stock Minimo">
				
				<br>
				
				<input type="radio" name="state" value="1"> Activo<br>
 				<input type="radio" name="state" value="2"> Inactivo<br>					
			
			
    
     	</div><!--  Body -->
      	
      	<div class="modal-footer">
    
    	<input type="submit" class="btn btn-primary" value="Inserir Produto"  name="Inserir Produto">
    			
		</form>
    
       </div><!-- footer -->



    </div><!--  Content -->

  </div><!--  Dialog -->


</div><!--  Fim da Modal -->





</body>
</html>