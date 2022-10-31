<!-- EMPRESA: OKO TECNOLOGIA
DESARROLLADO POR: INSIGHT DIGITAL
FECHA 10/07/2022
TITULO: ELIMINA TICKET DESDE LA VISTA ADMINISTRADOR -->

 <%@page import="Entidad.Tickets"%>
<%@page import="DAO.TicketsDAO"%>
<%
            
 TicketsDAO obj=new TicketsDAO();
            	Tickets beanTicket = new Tickets();
            	  String cod = request.getParameter("cod");
            	beanTicket.setIdTicket(cod);
                  obj.eliminar(beanTicket);
                  request.getRequestDispatcher("inicio.jsp").forward(request, response);

%>