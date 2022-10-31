<!-- EMPRESA: OKO TECNOLOGIA
DESARROLLADO POR: INSIGHT DIGITAL
FECHA 10/07/2022
TITULO: ELIMINA USUARIO -->

 <%@page import="Entidad.Usuarios"%>
<%@page import="DAO.UsuariosDAO"%>
<%
            
 UsuariosDAO obj=new UsuariosDAO();
            	Usuarios beanUsuarios = new Usuarios();
            	  String cod = request.getParameter("cod");
            	beanUsuarios.setIdUsuario(cod);
                  obj.eliminar(beanUsuarios);
                  request.getRequestDispatcher("InicioUsuario.jsp").forward(request, response);

%>