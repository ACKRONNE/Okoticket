<!-- EMPRESA: OKO TECNOLOGIA
DESARROLLADO POR: INSIGHT DIGITAL
FECHA 10/07/2022
TITULO: ELIMINA STATUS -->

 <%@page import="Entidad.Status"%>
<%@page import="DAO.StatusDAO"%>
<%
            
 StatusDAO obj=new StatusDAO();
            	Status beanStatus = new Status();
            	  String cod = request.getParameter("cod");
            	beanStatus.setIdStatus(cod);
                  obj.eliminar(beanStatus);
                  request.getRequestDispatcher("InicioStatus.jsp").forward(request, response);

%>