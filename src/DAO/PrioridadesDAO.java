
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JOptionPane;

import Entidad.Prioridades;
import Utilidades.ConexionDB;


public class PrioridadesDAO {
	
	public void eliminar(Prioridades prioridad) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("delete from  Prioridades  where idPrioridades=?");
			psta.setString(1, prioridad.getIdPrioridades());

			psta.executeUpdate();
			psta.close();
			cnx.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		    JOptionPane.showMessageDialog(null,"error al eliminar");
		}

	}
		
	public void actualizar(Prioridades prioridad) {

			try {

				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("update  Prioridades set prioridades=? where idPrioridades=?");
				psta.setString(1, prioridad.getPrioridades());
				psta.setString(2, prioridad.getIdPrioridades());

				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al actualizar");
			}

		}
	public void insertar(Prioridades prioridad) {

			try {
				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("insert into Prioridades(idPrioridades,prioridades) values(?,?)");
				psta.setString(1, prioridad.getIdPrioridades());
				psta.setString(2, prioridad.getPrioridades());
				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public Prioridades buscarPrioridad(String codigo) {

		Prioridades bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Prioridades where idPrioridades='"+ codigo + "'");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				bean = new Prioridades(rs.getString(1), rs.getString(2));
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return bean;
	}
	
	public String buscarCodigoPrioridad() {

		String codigo = "P00001";
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select MAX(idPrioridades) as valor from Prioridades");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).substring(1)!= null) {
					codigo = "P";
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

	
	public ArrayList<Prioridades> listarPrioridad() {
		ArrayList<Prioridades> lista = new ArrayList<Prioridades>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Prioridades");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				Prioridades em = new Prioridades(rs.getString(1), rs.getString(2));
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

