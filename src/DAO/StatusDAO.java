
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JOptionPane;

import Entidad.Status;
import Utilidades.ConexionDB;


public class StatusDAO {
	
	public void eliminar(Status statu) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("delete from  Status  where idStatus=?");
			psta.setString(1, statu.getIdStatus());

			psta.executeUpdate();
			psta.close();
			cnx.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		    JOptionPane.showMessageDialog(null,"error al eliminar");
		}

	}
		
	public void actualizar(Status statu) {

			try {

				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("update  Status set status =? where idStatus=?");
				psta.setString(1, statu.getStatus());
				psta.setString(2, statu.getIdStatus());

				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al actualizar");
			}

		}
	public void insertar(Status statu) {

			try {
				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("insert into Status(idStatus,status) values(?,?)");
				psta.setString(1, statu.getIdStatus());
				psta.setString(2, statu.getStatus());
				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public Status buscarStatu(String codigo) {

		Status bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Status where idStatus='"+ codigo + "'");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				bean = new Status(rs.getString(1), rs.getString(2));
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return bean;
	}
	
	public String buscarCodigoStatu() {

		String codigo = "S00001";
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select MAX(idStatus) as valor from Status");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				if(rs.getString(1).substring(1)!= null) {
					codigo = "S";
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

	
	public ArrayList<Status> listarStatu() {
		ArrayList<Status> lista = new ArrayList<Status>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Status");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				Status em = new Status(rs.getString(1), rs.getString(2));
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

