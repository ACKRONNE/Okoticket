<!-- EMPRESA: OKO TECNOLOGIA
DESARROLLADO POR: INSIGHT DIGITAL
FECHA 10/07/2022
TITULO: EDITA CLIENTE -->

<!DOCTYPE html>
<%@page import="Entidad.Clientes"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Utilidades.ConexionDB,java.sql.*,DAO.ClientesDAO" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Oko Tickets</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>
<%
			String cod = request.getParameter("cod");
			ClientesDAO obj=new ClientesDAO();
    	    Clientes bean = obj.buscarCliente(cod);

        %>
<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Oko Tickets</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="inicio.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Inicio</span></a>
            </li>

            <!-- Divider -->
           <hr class="sidebar-divider">

            <!-- Heading -->
          
            <!-- Nav Item - Pages Collapse Menu -->
          

            <!-- Nav Item - Utilities Collapse Menu -->
             <li class="nav-item">
                <a class="nav-link" href="InicioPrioridad.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Prioridades</span></a>
            </li>
			<li class="nav-item">
                <a class="nav-link" href="InicioStatus.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Status</span></a>
            </li>

           

            <!-- Nav Item - Pages Collapse Menu -->
             <li class="nav-item">
                <a class="nav-link" href="InicioCliente.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Clientes</span></a>
            </li>

            <!-- Nav Item - Charts -->
             <li class="nav-item">
                <a class="nav-link" href="InicioUsuario.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Usuario</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="InicioTipoTicket.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Tipo de Ticket</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="InicioViaRecibido.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Via Recibido</span></a>
            </li>
            
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Administrador</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
			            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
			                                aria-labelledby="userDropdown">
			                               
			                                <div class="dropdown-divider"></div>
			                                <a class="dropdown-item" href="index.jsp" data-toggle="modal" data-target="#logoutModal">
			                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
			                                    Logout
			                                </a>
			             </div>
	                </li>
                </nav>
                
                
                <!-- Editar Ticket -->  
                
                <div class="row">
                
	                <div class="col-6 p-5" >
						<div class="text-center">
	                         <h1 class="h4 text-gray-900 mb-4">Editar Cliente</h1>
	                    </div>
	                    <form class="user">
	                                    	<div class="form-group">
	                                           <input type="text" name="cod" class="form-control form-control-user" value="<%=bean.getIdClientes()%>"
                               					readonly="readonly">
	                                        </div>
	                                        <div class="form-group">
	                                            <input type="text" class="form-control form-control-user"  
	                                                placeholder="Ingrese Rif..." name="txtRif" value="<%=bean.getRif()%>">
	                                        </div>
	                                         <div class="form-group">
	                                            <input type="text" class="form-control form-control-user"  
	                                                placeholder="Ingrese Nombre de la Empresa..." name="txtNombreEmpresa" value="<%=bean.getNombreEmpresa()%>">
	                                        </div>
	                                         <div class="form-group">
	                                            <input type="text" class="form-control form-control-user"  
	                                                placeholder="Ingrese Contacto..." name="txtContacto" value="<%=bean.getContacto()%>">
	                                        </div>
	                                         <div class="form-group">
	                                            <input type="text" class="form-control form-control-user"  
	                                                placeholder="Ingrese Direccion..." name="txtDireccion" value="<%=bean.getDireccion()%>">
	                                        </div>	                  						
											  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script> 
	                                        <div align=center>
		                                        <div class="col-6">
			                                        <input type="hidden" name="accion"/>
                    							    <input type="button" name="btn" class="btn btn-primary btn-user btn-block"
                                           						value="Editar Datos" onclick="enviarDatos();">		                                        
		                                        </div>
		                                    </div>
	                                       
	                                    </form>
	                                    <script type="text/javascript">
        
								        function enviarDatos(){
								        	if(document.forms[0].txtRif.value.length==0){
								        		alert("Ingrese Rif");
								            	return;	
								        	}
								        	if(document.forms[0].txtNombreEmpresa.value.length==0){
								        		alert("Ingrese el Nombre de la Empresa");
								            	return;	
								        	}
								        	if(document.forms[0].txtContacto.value.length==0){
								        		alert("Ingrese el Numero de Contacto");
								            	return;	
								        	}
								        	if(document.forms[0].txtDireccion.value.length==0){
								        		alert("Ingrese la Direccion");
								            	return;	
								        	}
								
								        	document.forms[0].accion.value="editarCliente";
								        	document.forms[0].submit();
								        }
								        </script>
								        
								        <%
								        if(request.getParameter("accion")!=null && request.getParameter("accion").equals("editarCliente")){
								      	  
								        	Clientes beanCliente = new Clientes();
								        	
								        	beanCliente.setIdClientes(request.getParameter("cod"));
										  	beanCliente.setRif(request.getParameter("txtRif"));
										  	beanCliente.setNombreEmpresa(request.getParameter("txtNombreEmpresa"));
										  	beanCliente.setContacto(request.getParameter("txtContacto"));
										  	beanCliente.setDireccion(request.getParameter("txtDireccion"));
						  	
								            obj.actualizar(beanCliente);
								              request.getRequestDispatcher("InicioCliente.jsp").forward(request, response);
								         
								          }
								          %>
	                </div>
	                
        </div>
    </div>
</div>
	                                    
	                     
	                   
	                </div>
               
                </div>
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Pagina diseñada por Insight Digital</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Listo para salir?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">click en "Logout" si estas listo para cerrar sesion.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="index.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>
    

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>

</html>