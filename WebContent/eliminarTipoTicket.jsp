<!-- EMPRESA: OKO TECNOLOGIA
DESARROLLADO POR: INSIGHT DIGITAL
FECHA 10/07/2022
TITULO: ELIMINA TIPO TICKET -->

 <%@page import="Entidad.TipoTickets"%>
<%@page import="DAO.TipoTicketsDAO"%>
<%
            
 TipoTicketsDAO obj=new TipoTicketsDAO();
            	TipoTickets beanTipoTickets = new TipoTickets();
            	  String cod = request.getParameter("cod");
            	beanTipoTickets.setIdTipo(cod);
                  obj.eliminar(beanTipoTickets);
                  request.getRequestDispatcher("InicioTipoTicket.jsp").forward(request, response);

%>