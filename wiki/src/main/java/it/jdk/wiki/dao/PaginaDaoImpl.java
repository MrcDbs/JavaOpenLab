package it.jdk.wiki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import it.jdk.wiki.controller.MyWikiException;
import it.jdk.wiki.model.Pagina;

public class PaginaDaoImpl implements PaginaDao{
	
	private DataSource ds;
	
	

	public PaginaDaoImpl() throws NamingException {
		Context initCtx = new InitialContext();
		Context envCtx  = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/postgres");
	}

	public void salva(Pagina pagina) throws MyWikiException {
		try (Connection con = ds.getConnection();
				PreparedStatement ps1 = con.prepareStatement("UPDATE pagina SET contenuto=?,modifica=? WHERE titolo=?");
				PreparedStatement ps2 = con.prepareStatement("INSERT INTO pagina (titolo,contenuto,modifica) VALUES (?,?,?)")){
			ps1.setString(1, pagina.getContenuto());
			ps1.setDate(2, new java.sql.Date(pagina.getUltimaModifica().getTime()));
			ps1.setString(3,pagina.getTitolo());
			int result = ps1.executeUpdate();
			if(result==0) {
				ps2.setString(1,pagina.getTitolo());
				ps2.setString(2, pagina.getContenuto());
				ps2.setDate(3, new java.sql.Date(pagina.getUltimaModifica().getTime()));
				ps2.executeUpdate();
			}
		}
		catch(SQLException e) {
			throw new MyWikiException(e);
		}
		
		
	}

	public void elimina(Pagina pagina) throws MyWikiException {
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM pagina WHERE titolo=?")){
			ps.setString(1, pagina.getTitolo());
			ps.executeUpdate();

		}
		catch(SQLException e) {
			throw new MyWikiException(e);
		}
		
	}

	public Pagina leggi(String titolo) throws MyWikiException {
		try (Connection con = ds.getConnection();
				ResultSet rs = con.createStatement().executeQuery("SELECT contenuto,modifica FROM pagina WHERE titolo = '"+titolo+"'")){
			if(rs.next()) {
				
				String contenuto = rs.getString(1);
				Date modifica = new Date(rs.getDate(2).getTime());
				
				// ISTANZIO UNA NUOVA PAGINA
				
				Pagina pagina = new Pagina();
				
				// ASSEGNO I CAMPI DEL RISULTATO DELLA QUERY ALLA NUOVA PAGINA
				
				pagina.setContenuto(contenuto);
				pagina.setTitolo(titolo);
				pagina.setUltimaModifica(modifica);
				return pagina;
			}
			else {
				throw new MyWikiException("Pagina con titolo "+titolo+" non preseente");
			}
		}
		catch(SQLException e) {
			throw new MyWikiException(e);
		}
		
	}

	public List<Pagina> elencaPagine() throws MyWikiException {
		return elencaPagine(null);
	}

	public List<Pagina> elencaPagineRecenti() throws MyWikiException {
		return elencaPagine(new java.util.Date());
	}
	
	private List<Pagina> elencaPagine(java.util.Date oggi) throws MyWikiException{
		String query = null;
		if(oggi!=null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(oggi);
			String data = "'"+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE)+"'";
			query = "SELECT titolo,contenuto,modifica FROM pagina WHERE modifica = "+data;
		}
		else {
			query = "SELECT titolo,contenuto,modifica FROM pagina";
		}
		try (Connection con = ds.getConnection();
			ResultSet rs = con.createStatement().executeQuery(query)){
			List<Pagina> pagine = new ArrayList<>();
			while(rs.next()) {
				String titolo = rs.getString(1);
				String contenuto = rs.getString(2);
				Date modifica = new Date(rs.getDate(3).getTime());
						
				Pagina pagina = new Pagina();
						
						
				pagina.setContenuto(contenuto);
				pagina.setTitolo(titolo);
				pagina.setUltimaModifica(modifica);
				pagine.add(pagina);
			}
			return pagine;
		}
		catch(SQLException e) {
			throw new MyWikiException(e);
		}
	}

}
