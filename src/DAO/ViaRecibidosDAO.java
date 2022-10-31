
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JOptionPane;

import Entidad.ViaRecibidos;
import Utilidades.ConexionDB;


public class ViaRecibidosDAO {
	
	public void eliminar(ViaRecibidos viaRecibido) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("delete from  ViaRecibido  where idVia=?");
			psta.setString(1, viaRecibido.getIdVia());

			psta.executeUpdate();
			psta.close();
			cnx.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		    JOptionPane.showMessageDialog(null,"error al eliminar");
		}

	}
		
	public void actualizar(ViaRecibidos viaRecibido) {

			try {

				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("update  ViaRecibido set viaRecibido =? where idVia=?");
				psta.setString(1, viaRecibido.getViaRecibido());
				psta.setString(2, viaRecibido.getIdVia());

				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al actualizar");
			}

		}
	public void insertar(ViaRecibidos viaRecibido) {

			try {
				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("insert into ViaRecibido(idVia,viaRecibido) values(?,?)");
				psta.setString(1, viaRecibido.getIdVia());
				psta.setString(2, viaRecibido.getViaRecibido());
				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public ViaRecibidos buscarViaRecibido(String codigo) {

		ViaRecibidos bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from ViaRecibido where idVia='"+ codigo + "'");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				bean = new ViaRecibidos(rs.getString(1), rs.getString(2));
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return bean;
	}
	
	public String buscarCodigoVia() {

		String codigo = "C00001";
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select MAX(idVia) as valor from ViaRecibido");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).substring(1)!= null) {
					codigo = "C";
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

	
	public ArrayList<ViaRecibidos> listarViaRecibido() {
		ArrayList<ViaRecibidos> lista = new ArrayList<ViaRecibidos>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from ViaRecibido");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				ViaRecibidos em = new ViaRecibidos(rs.getString(1), rs.getString(2));
				lista.add(em);
			}

			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());

		}
		return lista;
	}
}

