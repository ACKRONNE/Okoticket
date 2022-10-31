 <%@page import="Entidad.ViaRecibidos"%>
<%@page import="DAO.ViaRecibidosDAO"%>
<%
            
 ViaRecibidosDAO obj=new ViaRecibidosDAO();
            	ViaRecibidos beanViaRecibidos = new ViaRecibidos();
            	  String cod = request.getParameter("cod");
            	beanViaRecibidos.setIdVia(cod);
                  obj.eliminar(beanViaRecibidos);
                  request.getRequestDispatcher("InicioViaRecibido.jsp").forward(request, response);

%>