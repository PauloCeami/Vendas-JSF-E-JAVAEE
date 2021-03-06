package br.pdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItensVendaDao {

	private Connection connection;

	public ItensVendaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void Inserir_Itens_na_Venda(ItensVendaBean Itens) {
		try {
			String sql = "insert into produtos_pedido (PEDIDOID,PRODUTOID,QUANTIDADE,PRECO_UNITARIO) values (?,?,?,?)";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, Itens.getPEDIDOID());
			stmt.setInt(2, Itens.getPRODUTOID());
			stmt.setInt(3, Itens.getQUANTIDADE());
			stmt.setDouble(4, Itens.getPRECO_UNITARIO());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<ItensVendaBean> Busca_os_Itens_De_1_Venda_Apenas_Agrupado(int MeuPedido) {
		List<ItensVendaBean> ListaDeItens = new ArrayList<ItensVendaBean>();
		try {
			String sql = "select * from produtos_pedido where PEDIDOID = ? group by PEDIDOID  ";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, MeuPedido);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ItensVendaBean iBean = new ItensVendaBean();
				iBean.setPEDIDOID(rs.getInt("PEDIDOID"));
				iBean.setPRODUTOID(rs.getInt("PRODUTOID"));
				iBean.setQUANTIDADE(rs.getInt("QUANTIDADE"));
				iBean.setPRECO_UNITARIO(rs.getDouble("PRECO_UNITARIO"));
				ListaDeItens.add(iBean);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ListaDeItens;
	}
	
	
	
	public List<ItensVendaBean> Busca_os_Itens_De_1_Venda_Apenas(int MeuPedido) {
		List<ItensVendaBean> ListaDeItens = new ArrayList<ItensVendaBean>();
		try {
			String sql = "select * from produtos_pedido where PEDIDOID = ? ";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, MeuPedido);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ItensVendaBean iBean = new ItensVendaBean();
				iBean.setPEDIDOID(rs.getInt("PEDIDOID"));
				iBean.setPRODUTOID(rs.getInt("PRODUTOID"));
				iBean.setQUANTIDADE(rs.getInt("QUANTIDADE"));
				iBean.setPRECO_UNITARIO(rs.getDouble("PRECO_UNITARIO"));
				ListaDeItens.add(iBean);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ListaDeItens;
	}
	
	
	
	
	

	public ItensVendaBean Busca_Produto_Existente_na_Venda(int Id_Produto,
			int Id_Pedido) {
		ItensVendaBean Itens = null;
		try {
			String Sql = "select * from produtos_pedido where PRODUTOID=? and PEDIDOID=?";
			PreparedStatement stmt = this.connection.prepareStatement(Sql);
			stmt.setInt(1, Id_Produto);
			stmt.setInt(2, Id_Pedido);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Itens = new ItensVendaBean();
				Itens.setPRODUTOID(rs.getInt("PRODUTOID"));
				Itens.setPEDIDOID(rs.getInt("PEDIDOID"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return Itens;

	}

	public void RemoveItensPedido(int Pedido) {

		try {
			String sql = "delete from produtos_pedido where PEDIDOID = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, Pedido);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
