

package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;

import javax.swing.JOptionPane;

import Entidad.ViaRecibidos;
import Entidad.Status;
import Entidad.Clientes;
import Entidad.TipoTickets;
import Entidad.Prioridades;

import Entidad.Tickets;
import Utilidades.ConexionDB;


public class TicketsDAO {
	
	public void eliminar(Tickets ticket) {

		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("delete from  tickets  where idTicket=?");
			psta.setString(1, ticket.getIdTicket());

			psta.executeUpdate();
			psta.close();
			cnx.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		    JOptionPane.showMessageDialog(null,"error al eliminar");
		}

	}
		
	public void actualizar(Tickets ticket) {

			try {

				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("update  tickets set rif=?,tipoTicket=?,fechaSolicitudTicket=?,operadorDeRecepcion=?,viaRecibido=?,fechaCierre=?,status=?,asunto=?,descripcion=?, Prioridad=? where idTicket=?");
				psta.setString(1, ticket.getRif());
				psta.setString(2, ticket.getTipoTicket());
				psta.setString(3, ticket.getFechaSolicitudTicket());
				psta.setString(4, ticket.getOperadorDeRecepcion());
				psta.setString(5, ticket.getViaRecibido());
				psta.setString(6, ticket.getFechaCierre());
				psta.setString(7, ticket.getStatus());
				psta.setString(8, ticket.getAsunto());
				psta.setString(9, ticket.getDescripcion());
				psta.setString(10, ticket.getPrioridad());

				psta.setString(11, ticket.getIdTicket());

				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public void insertar(Tickets ticket) {

			try {
				Connection cnx = ConexionDB.getConexion();
				PreparedStatement psta = cnx
						.prepareStatement("insert into  tickets(idTicket,rif,TipoTicket,fechaSolicitudTicket,operadorDeRecepcion,viaRecibido,fechaCierre,status,asunto,descripcion,Prioridad) values(?,?,?,?,?,?,?,?,?,?,?)");
				psta.setString(1, ticket.getIdTicket());
				psta.setString(2, ticket.getRif());
				psta.setString(3, ticket.getTipoTicket());
				psta.setString(4, ticket.getFechaSolicitudTicket());
				psta.setString(5, ticket.getOperadorDeRecepcion());
				psta.setString(6, ticket.getViaRecibido());
				psta.setString(7, ticket.getFechaCierre());
				psta.setString(8, ticket.getStatus());
				psta.setString(9, ticket.getAsunto());
				psta.setString(10, ticket.getDescripcion());
				psta.setString(11, ticket.getPrioridad());

				System.out.println(psta.toString());
				psta.executeUpdate();

				psta.close();
				cnx.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			    JOptionPane.showMessageDialog(null,"error al guardar");
			}

		}
	public Tickets buscarTicket(String codigo) {

		Tickets bean = null;
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from tickets where idTicket='"
							+ codigo + "'");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				bean = new Tickets(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9),rs.getString(10),rs.getString(11));
			}
			rs.close();
			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());
		}

		return bean;
	}
	
	public String buscarCodigoTickets() {

		String codigo = "T00001";
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select MAX(idTicket) as valor from tickets");
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

	
	public ArrayList<Tickets> listarTicket() {
		ArrayList<Tickets> lista = new ArrayList<Tickets>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from tickets");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				Tickets em = new Tickets(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9),rs.getString(10),rs.getString(11));
				lista.add(em);
			}

			psta.close();
			cnx.close();
		} catch (Exception e) {

			System.out.println("" + e.toString());

		}
		return lista;
	}
	
	//Llamar base de dato status para la lista
	
	public ArrayList<Status> listarStatus() {

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
	public ArrayList<ViaRecibidos> listarViaRecibidos() {

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
	
	public ArrayList<TipoTickets> listarTipoTickets() {

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
	public ArrayList<Prioridades> listarPrioridades() {

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
	public ArrayList<Clientes> listarClientes() {

		ArrayList<Clientes> lista = new ArrayList<Clientes>();
		try {

			Connection cnx = ConexionDB.getConexion();
			PreparedStatement psta = cnx
					.prepareStatement("select * from Clientes");
			ResultSet rs = psta.executeQuery();
			while (rs.next()) {
				Clientes em = new Clientes(rs.getString(1), rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5));
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