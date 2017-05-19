<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="java.util.ArrayList, model.Warehouse, model.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Armazens - Gestão de Stocks</title>

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
                	            searchPlaceholder: "Procurar Armazem"
                	            
                	            },
                	                       	                        	            	         
                		
                });
                
          
                $('div.dataTables_filter input').addClass('form-control ');
                
                $('.edit').click(function() {
                	var id = $(this).attr('value');
                	$('#method').val("edit");
                	$('#txtName').val($('.line' + id + ' td.colName>a').html());
                	$("#ddlResp option").each(function() {
                			    if ($('.line' + id + ' td.colResp').html() == $(this).text()) {
                			    	$("#ddlResp").val($(this).val());
                			    }
                	});
                	$('.rbState').filter('[value=' + $('.colState').attr('id') + ']').prop('checked', true);
                });
                
                $('.delete').click(function() {
                	window.location.replace('WarehouseHandler?delete=' + $(this).attr('value'));
                });
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
        
        #new_warehouse{
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
            <li class="active"><a href="#">Gestão Warehouse</a></li>
             </ul>
    
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-top: 0%;">
          <h1 class="page-header">Armazens</h1>

			<div class="jumbotron">
		 	<button class="btn btn-primary" id="new_warehouse" data-toggle="modal" data-target="#menuWarehouse"><span class="glyphicon glyphicon-plus"></span> Novo Armazem</button>
		
		<table id="teste" class="table table-striped table-bordered" width="100%" cellspacing="0" style="background-color: white;margin-top: 1%;">
		<thead>
			<tr><th>ID</th><th>Nome Armazem</th><th>Responsavel</th><th>Estado</th><th>Acções</th></tr>
		
		</thead>
		<tbody>			
			
			
			
			
			<%
			ArrayList<Warehouse> warehouse = (ArrayList<Warehouse>) request.getAttribute("warehouse");
			for (int i = 0; i < warehouse.size(); i++) {
				Warehouse p = (Warehouse) warehouse.get(i);
				out.append("<tr class='line"+p.getId()+"'>");
				out.append("<td class='coldID'> " + p.getId() + "</td>");
				out.append("<td class='colName'><a href='ProductHandler?list=" + p.getId() + "'" + p.getName() + "</a></td>");
				out.append("<td class='colResp'> " + p.getResponsavel().getName() + "</td>");
				out.append("<td class='colState' id='" + (p.getEstado().equals("Activo")?1:2) + "'> " + p.getEstado() + "</td>");
				out.append("<td><button type=\"submit\" class=\"btn btn-danger delete\" id=\"btn_delete\" value=\""+ p.getId()+"\">Apagar</button>");
				out.append("<button type=\"submit\" class=\"btn btn-success edit\" id=\"btn_edit\" value=\""+ p.getId()+"\">Editar</button></td></tr>");
			}
			
			
		%>
			<tr class="line0"><td class="colID">0</td><td class="colName"><a href='ProductHandler?list=0'>Armazem1</a></td><td class="colResp">Pessoa2</td><td class="colState" id="1">Activo</td><td><button type="submit" class="btn btn-danger delete" id="btn_delete" value="0">Apagar</button><button type="submit" class="btn btn-success edit" data-toggle="modal" data-target="#menuWarehouse" id="btn_edit" value="0">Editar</button></td></tr>
		</tbody>		
		
		</table>
    
			</div>	
        </div>
      </div>
    </div>
    
    <!-- Modal Inserir Armazens? -->
   <div class="modal fade" id="menuWarehouse" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title">Inserir Armazem</h4>
        
        
        </div><!--  Header -->

        <div class="modal-body" id="warehouse_body">
			  
			  	<form method="post" action="WarehouseHandler">
			  		<input type="hidden" name="method" id="method" value="insert"/>
					<input class="form-control" type="text" id="txtName" name="tf_whname" placeholder="Nome do Armazem">
					<br>
			
					<select name="s_id_employee" id="ddlResp" class="form-control">
	
					<% 
					
					ArrayList<Employee> employee = (ArrayList<Employee>) request.getAttribute("employee");
					for (int i = 0; i < employee.size(); i++) {
						Employee p = (Employee) employee.get(i);
						out.append("<option value=\""+p.getId()+ "\">"+p.getName() +"</option>");
					}
					
					%>
						<option value="0">Pessoa1</option>
						<option value="1">Pessoa2</option>
					</select>
					<br>
					
					<input type="radio" class="rbState" name="state" value="1">Activo<br>
	 				<input type="radio" class="rbState" name="state" value="2">Inactivo<br>		
					<input type="submit" class="btn btn-primary" value="Inserir Armazem"  name="Inserir Armazem">
    			</form>
     	</div><!--  Body -->
      	
      	<div class="modal-footer">
  
       </div><!-- footer -->



    </div><!--  Content -->

  </div><!--  Dialog -->


</div><!--  Fim da Modal -->


</body>
</html>