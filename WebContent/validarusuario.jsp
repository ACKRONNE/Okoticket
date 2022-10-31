<!-- EMPRESA: OKO TECNOLOGIA
DESARROLLADO POR: INSIGHT DIGITAL
FECHA 10/07/2022
TITULO: VALIDA EL INICIO DE SESION, CORREO, CONTRASENA, EXISTENCIA DE USUSARIO, OPERADOR O ADMINISTRADOR -->



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Entidad.Usuarios,DAO.UsuariosDAO"%>

<%@page import="Utilidades.ConexionDB,java.sql.*,DAO.UsuariosDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>validar usuario</title>
</head>
<body>
<%
			String cod = request.getParameter("cod");


        %>
<%

String correo=request.getParameter("correo");
String contrasenatemp=request.getParameter("contrasena");


UsuariosDAO obj=new UsuariosDAO();
Usuarios bean = obj.buscarCorreo(correo);	


%>

<%
	if (bean!=null) {
		
	    String contrasena=bean.getContrasena();
	    String rol=bean.getRol();
	    String admin="Administrador";
	    String ope="Operador";
	    int l1=contrasena.length();
	    int l2=contrasenatemp.length();
	    
	    System.out.print(rol);
	    System.out.print(l1);
		System.out.print(l2);

	  if ((l1 > l2) && (l2>l1)||(l1==l2)){
		   System.out.print(l1);
		   System.out.print(l2);


			if (contrasenatemp.substring(0,contrasenatemp.length()).equals( (contrasena.substring(0,contrasenatemp.length()))))
			{
				
					if (  rol.substring(0,rol.length()).equals(admin.substring(0,admin.length()) ) ) 
					{
						
						   request.getRequestDispatcher("inicio.jsp").forward(request, response);    
						   System.out.print("Admin");
						   
					}else 
						if (rol.substring(rol.length()).equals(ope.substring(ope.length())))
						{
							
						   request.getRequestDispatcher("vistaOperador.jsp").forward(request, response);   
						   System.out.print("oper");
					    }                                           	
				
			}
		
		}else{
				
			request.getRequestDispatcher("errorContrasena.jsp").forward(request, response); 			
				
	    }
   }else{
			
	 request.getRequestDispatcher("error.jsp").forward(request, response); 			
			
   }

%>



</body>
</html>