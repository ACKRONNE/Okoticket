 <%@page import="Entidad.Tickets"%>
<%@page import="DAO.TicketsDAO"%>
<%
            
 TicketsDAO obj=new TicketsDAO();
            	Tickets beanTicket = new Tickets();
            	  String cod = request.getParameter("cod");
            	beanTicket.setIdTicket(cod);
                  obj.eliminar(beanTicket);
                  request.getRequestDispatcher("vistaOperador.jsp").forward(request, response);

%>