/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class RepresentanteDao {
    
       private Connection connection;

    public RepresentanteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
   
    
    
    public void Gravar(RepresentanteBean rep) {
        String sql = "insert into representantes "
                + "(Nome,Endereco,Bairro,Cidade,Estado,Cep,Telefone,Fax,Celular,CNPJ_CPF,Email,Contato) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, rep.getNome());
            stmt.setString(2, rep.getEndereco());
            stmt.setString(3, rep.getBairro());
            stmt.setString(4, rep.getCidade());
            stmt.setString(5, rep.getEstado());
            stmt.setString(6, rep.getCep());
            stmt.setString(7, rep.getTelefone());
            stmt.setString(8, rep.getFax());
            stmt.setString(9, rep.getCelular());
            stmt.setString(10, rep.getCNPJ_CPF());
            stmt.setString(11, rep.getEmail());
            stmt.setString(12, rep.getContato() );
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<RepresentanteBean> ListarTodosRepresentantes() {
        List<RepresentanteBean> ListadeRepresentantes = new ArrayList<RepresentanteBean>();
        try {
            String sql = "select * from representantes";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RepresentanteBean rBean = new RepresentanteBean();
                rBean.setId(rs.getInt("id"));
                rBean.setNome(rs.getString("Nome"));
                rBean.setBairro(rs.getString("Bairro"));
                rBean.setCidade(rs.getString("Cidade"));
                rBean.setEndereco(rs.getString("Endereco"));
                rBean.setEstado(rs.getString("Estado"));
                rBean.setTelefone(rs.getString("Telefone"));
                rBean.setEmail(rs.getString("Email"));
                rBean.setContato(rs.getString("Contato"));
                ListadeRepresentantes.add(rBean); // colocando a lista de representantes
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ListadeRepresentantes;
    }

    public RepresentanteBean BuscaRepresentantePor_ID(Long id) {
        RepresentanteBean rBean = null;
        try {
            String sql = "select * from representantes where id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rBean = new RepresentanteBean();
                rBean.setId(rs.getInt("id"));
                rBean.setNome(rs.getString("Nome"));
                rBean.setBairro(rs.getString("Bairro"));
                rBean.setCidade(rs.getString("Cidade"));
                rBean.setEndereco(rs.getString("Endereco"));
                rBean.setEstado(rs.getString("Estado"));
                rBean.setCep(rs.getString("Cep"));
                rBean.setFax(rs.getString("Fax"));
                rBean.setCelular(rs.getString("Celular"));
                rBean.setCNPJ_CPF(rs.getString("CNPJ_CPF"));
                rBean.setTelefone(rs.getString("Telefone"));
                rBean.setEmail(rs.getString("Email"));
                rBean.setContato(rs.getString("Contato"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rBean;
    }
    
    
        public RepresentanteBean BuscaRepresentantePor_GetINT(int id) {
        RepresentanteBean rBean = null;
        try {
            String sql = "select * from representantes where id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                rBean = new RepresentanteBean();
                rBean.setId(rs.getInt("id"));
                rBean.setNome(rs.getString("Nome"));
                rBean.setBairro(rs.getString("Bairro"));
                rBean.setCidade(rs.getString("Cidade"));
                rBean.setEndereco(rs.getString("Endereco"));
                rBean.setEstado(rs.getString("Estado"));
                rBean.setCep(rs.getString("Cep"));
                rBean.setFax(rs.getString("Fax"));
                rBean.setCelular(rs.getString("Celular"));
                rBean.setCNPJ_CPF(rs.getString("CNPJ_CPF"));
                rBean.setTelefone(rs.getString("Telefone"));
                rBean.setEmail(rs.getString("Email"));
                rBean.setContato(rs.getString("Contato"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rBean;
    }
    
    
    
    

    public void altera(RepresentanteBean rBean) {
        String sql = "update representantes set  Nome=?,Endereco=?,Bairro=?,Cidade=?,"
                + "Estado=?,Cep=?,Telefone=?,Fax=?,Celular=?,CNPJ_CPF=?,Email=?  where id=?  ";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
          
            stmt.setString(1, rBean.getNome());
            stmt.setString(2, rBean.getEndereco());
            stmt.setString(3, rBean.getBairro());
            stmt.setString(4, rBean.getCidade());
            stmt.setString(5, rBean.getEstado());
            stmt.setString(6, rBean.getCep());
            stmt.setString(7, rBean.getTelefone());
            stmt.setString(8, rBean.getFax());
            stmt.setString(9, rBean.getCelular());
            stmt.setString(10, rBean.getCNPJ_CPF());
            stmt.setString(11, rBean.getEmail());
            stmt.setLong(12, rBean.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    	public void remove(Long id) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from representantes where id = ?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    
}
