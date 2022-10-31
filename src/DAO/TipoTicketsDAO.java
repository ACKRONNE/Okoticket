
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JOptionPane;

import Entidad.TipoTickets;
import Utilidades.ConexionDB;


public class TipoTicketsDAO {
	
	public void eliminar(TipoTickets tipoticket) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("delete from  TipoTicket   where idTipo=?");
			psta.setString(1, tipoticket.getIdTipo());

			psta.executeUpdate();
			psta.close();
			cnx.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		    JOptionPane.showMessageDialog(null,"error al eliminar");
		}

	}
		
	public void actualizar(TipoTickets tipoticket) {

			try {

				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("update  Tipoticket set requerimiento=? where idTipo=?");
				psta.setString(1, tipoticket.getRequerimiento());
				psta.setString(2, tipoticket.getIdTipo());

				psta.executeUpdate();
				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al actualizar");
			}

		}
	public void insertar(TipoTickets tipoticket) {

			try {
				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("insert into  Tipoticket (idTipo,requerimiento) values(?,?)");
				psta.setString(1, tipoticket.getIdTipo());
				psta.setString(2, tipoticket.getRequerimiento());
				psta.executeUpdate();
				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public TipoTickets buscarTipoTicket(String codigo) {

		TipoTickets bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Tipoticket where idTipo='"
							+ codigo + "'");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				bean = new TipoTickets(rs.getString(1), rs.getString(2));
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return bean;
	}
	
	public String buscarCodigoTipoTickets() {

		String codigo = "T00001";
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select MAX(idTipo) as valor from Tipoticket");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).substring(1)!= null) {
					codigo = "T";
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

	
	public ArrayList<TipoTickets> listarTipoTicket() {
		ArrayList<TipoTickets> lista = new ArrayList<TipoTickets>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Tipoticket");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				TipoTickets em = new TipoTickets(rs.getString(1), rs.getString(2));
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

