<!-- EMPRESA: OKO TECNOLOGIA
DESARROLLADO POR: INSIGHT DIGITAL
FECHA 10/07/2022
TITULO: ELIMINA PRIORIDADES -->

 <%@page import="Entidad.Prioridades"%>
<%@page import="DAO.PrioridadesDAO"%>
<%
            
 PrioridadesDAO obj=new PrioridadesDAO();
            	Prioridades beanPrioridades = new Prioridades();
            	  String cod = request.getParameter("cod");
            	beanPrioridades.setIdPrioridades(cod);
                  obj.eliminar(beanPrioridades);
                  request.getRequestDispatcher("InicioPrioridad.jsp").forward(request, response);

%>