<!-- EMPRESA: OKO TECNOLOGIA
DESARROLLADO POR: INSIGHT DIGITAL
FECHA 10/07/2022
TITULO: ELIMINA CLIENTE -->

 <%@page import="Entidad.Clientes"%>
<%@page import="DAO.ClientesDAO"%>
<%
            
 ClientesDAO obj=new ClientesDAO();
            	Clientes beanClientes = new Clientes();
            	  String cod = request.getParameter("cod");
            	beanClientes.setIdClientes(cod);
                  obj.eliminar(beanClientes);
                  request.getRequestDispatcher("InicioCliente.jsp").forward(request, response);

%>