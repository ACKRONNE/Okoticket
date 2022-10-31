
package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JOptionPane;

import Entidad.Clientes;
import Entidad.Prioridades;
import Utilidades.ConexionDB;


public class ClientesDAO {
	
	public void eliminar(Clientes cliente) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("delete from  Clientes  where idClientes=?");
			psta.setString(1, cliente.getIdClientes());

			psta.executeUpdate();
			psta.close();
			cnx.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		    JOptionPane.showMessageDialog(null,"error al eliminar");
		}

	}
		
	public void actualizar(Clientes cliente) {

			try {

				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("update  Clientes set rif=?, nombreEmpresa=?, contacto=?,direccion=? where idClientes=?");
				psta.setString(1, cliente.getRif());
				psta.setString(2, cliente.getNombreEmpresa());
				psta.setString(3, cliente.getContacto());
				psta.setString(4, cliente.getDireccion());
				psta.setString(5, cliente.getIdClientes());

				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al actualizar");
			}

		}
	public void insertar(Clientes cliente) {

			try {
				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("insert into Clientes(idClientes,rif,nombreEmpresa, contacto, direccion) values(?,?,?,?,?)");
				psta.setString(1, cliente.getIdClientes());
				psta.setString(2, cliente.getRif());
				psta.setString(3, cliente.getNombreEmpresa());
				psta.setString(4, cliente.getContacto());
				psta.setString(5, cliente.getDireccion());

				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public Clientes buscarCliente(String codigo) {

		Clientes bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Clientes where idClientes='"+ codigo + "'");
			ResultSet rs = psta.executeQuery();
		
			while (rs.next()) {
				bean = new Clientes(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return bean;
	}
	
	public String buscarCodigoCliente() {

		String codigo = "C00001";
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select MAX(idClientes) as valor from Clientes");
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

	
	public ArrayList<Clientes> listarCliente() {
		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Clientes");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				Clientes em = new Clientes(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
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

