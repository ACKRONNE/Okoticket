
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JOptionPane;

import Entidad.TipoUsuario;
import Entidad.Tickets;
import Entidad.Usuarios;
import Utilidades.ConexionDB;


public class UsuariosDAO {
	
	public void eliminar(Usuarios usuario) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("delete from  Usuarios  where idUsuario=?");
			psta.setString(1, usuario.getIdUsuario());

			psta.executeUpdate();
			psta.close();
			cnx.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		    JOptionPane.showMessageDialog(null,"error al eliminar");
		}

	}
		
	public void actualizar(Usuarios usuario) {

			try {

				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("update  Usuarios set rol=?, cedula=?, nombre=?, correo=?, contrasena=? where idUsuario=?");
				psta.setString(1, usuario.getRol());
				psta.setString(2, usuario.getCedula());
				psta.setString(3, usuario.getNombre());
				psta.setString(4, usuario.getCorreo());
				psta.setString(5, usuario.getContrasena());
				psta.setString(6, usuario.getIdUsuario());

				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public void insertar(Usuarios usuario) {

			try {
				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("insert into  Usuarios(idUsuario, rol, cedula, nombre, correo, contrasena) values(?,?,?,?,?,?)");
				psta.setString(1, usuario.getIdUsuario());
				psta.setString(2, usuario.getRol());
				psta.setString(3, usuario.getCedula());
				psta.setString(4, usuario.getNombre());
				psta.setString(5, usuario.getCorreo());
				psta.setString(6, usuario.getContrasena());
				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public Usuarios buscarUsuario(String codigo) {

		Usuarios bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Usuarios where idUsuario='"
							+ codigo + "'");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				bean = new Usuarios(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return bean;
	}
	
	public String buscarCodigoUsuario() {

		String codigo = "U00001";
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select MAX(idUsuario) as valor from Usuarios");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).substring(1)!= null) {
					codigo = "U";
					int valor = Integer.parseInt(rs.getString(1).substring(1)) + 1;
					Formatter fmt = new Formatter();
					codigo += fmt.format("%05d", valor);
				}
					
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return codigo;
	}
	public ArrayList<Usuarios> listarUsuario() {
		ArrayList<Usuarios> lista = new ArrayList<Usuarios>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Usuarios");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				Usuarios em = new Usuarios(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
				lista.add(em);
			}

			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());

		}
		return lista;
	}
	
	public Usuarios buscarCorreo(String correo) {
		
		Usuarios bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Usuarios where correo='"
							+ correo + "'");
			ResultSet rs = psta.executeQuery();
			
			while (rs.next()) {
				bean = new Usuarios(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));

			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		    
		}

		return bean;
	}
	public ArrayList<TipoUsuario> listarTipoUsuario() {

		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		lista.add(new TipoUsuario("Administrador", "Administrador"));
		lista.add(new TipoUsuario("Operador", "Operador"));
		return lista;
	}
}

