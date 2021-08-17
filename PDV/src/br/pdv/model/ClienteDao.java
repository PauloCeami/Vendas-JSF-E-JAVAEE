package br.pdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private Connection connection;

    public ClienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void Gravar(ClienteBean cli) {
        String sql = "insert into clientes "
                + "(Nome,Endereco,Bairro,Cidade,Estado,Cep,Telefone,Fax,Celular,CNPJ_CPF,Email) "
                + "values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getEndereco());
            stmt.setString(3, cli.getBairro());
            stmt.setString(4, cli.getCidade());
            stmt.setString(5, cli.getEstado());
            stmt.setString(6, cli.getCep());
            stmt.setString(7, cli.getTelefone());
            stmt.setString(8, cli.getFax());
            stmt.setString(9, cli.getCelular());
            stmt.setString(10, cli.getCNPJ_CPF());
            stmt.setString(11, cli.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClienteBean> ListarTodosClientes() {
        List<ClienteBean> ListadeClientes = new ArrayList<ClienteBean>();
        try {
            String sql = "select * from clientes";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClienteBean cBean = new ClienteBean();
                cBean.setId(rs.getInt("id"));
                cBean.setNome(rs.getString("Nome"));
                cBean.setBairro(rs.getString("Bairro"));
                cBean.setCidade(rs.getString("Cidade"));
                cBean.setEndereco(rs.getString("Endereco"));
                cBean.setEstado(rs.getString("Estado"));
                cBean.setTelefone(rs.getString("Telefone"));
                cBean.setEmail(rs.getString("Email"));
                ListadeClientes.add(cBean); // colocando a lista de clientes
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ListadeClientes;
    }

    public List<ClienteBean> vwListaClientesWhereLlike(String Nome) {
        List<ClienteBean> ListaClientes = new ArrayList<ClienteBean>();

        try {
            String sql = "select * from clientes where nome like ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, '%' + Nome + '%');
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteBean cli = new ClienteBean();
                cli.setId(rs.getInt("ID"));
                cli.setNome(rs.getString("NOME"));
                cli.setCidade(rs.getString("CIDADE"));
                cli.setCNPJ_CPF(rs.getString("CNPJ_CPF"));
                ListaClientes.add(cli);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ListaClientes;

    }

    public ClienteBean BuscaClientePor_ID(Long id) {
        ClienteBean cBean = null;
        try {
            String sql = "select * from clientes where id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cBean = new ClienteBean();
                cBean.setId(rs.getInt("id"));
                cBean.setNome(rs.getString("Nome"));
                cBean.setBairro(rs.getString("Bairro"));
                cBean.setCidade(rs.getString("Cidade"));
                cBean.setEndereco(rs.getString("Endereco"));
                cBean.setEstado(rs.getString("Estado"));
                cBean.setCep(rs.getString("Cep"));
                cBean.setFax(rs.getString("Fax"));
                cBean.setCelular(rs.getString("Celular"));
                cBean.setCNPJ_CPF(rs.getString("CNPJ_CPF"));
                cBean.setTelefone(rs.getString("Telefone"));
                cBean.setEmail(rs.getString("Email"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cBean;
    }
    
        public ClienteBean BuscaClientePor_ID_GetINT(int id) {
        ClienteBean cBean = null;
        try {
            String sql = "select * from clientes where id = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cBean = new ClienteBean();
                cBean.setId(rs.getInt("id"));
                cBean.setNome(rs.getString("Nome"));
                cBean.setBairro(rs.getString("Bairro"));
                cBean.setCidade(rs.getString("Cidade"));
                cBean.setEndereco(rs.getString("Endereco"));
                cBean.setEstado(rs.getString("Estado"));
                cBean.setCep(rs.getString("Cep"));
                cBean.setFax(rs.getString("Fax"));
                cBean.setCelular(rs.getString("Celular"));
                cBean.setCNPJ_CPF(rs.getString("CNPJ_CPF"));
                cBean.setTelefone(rs.getString("Telefone"));
                cBean.setEmail(rs.getString("Email"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cBean;
    }
    
    
    

    public void altera(ClienteBean cBean) {
        String sql = "update clientes set  Nome=?,Endereco=?,Bairro=?,Cidade=?,"
                + "Estado=?,Cep=?,Telefone=?,Fax=?,Celular=?,CNPJ_CPF=?,Email=?  where id=?  ";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);

            stmt.setString(1, cBean.getNome());
            stmt.setString(2, cBean.getEndereco());
            stmt.setString(3, cBean.getBairro());
            stmt.setString(4, cBean.getCidade());
            stmt.setString(5, cBean.getEstado());
            stmt.setString(6, cBean.getCep());
            stmt.setString(7, cBean.getTelefone());
            stmt.setString(8, cBean.getFax());
            stmt.setString(9, cBean.getCelular());
            stmt.setString(10, cBean.getCNPJ_CPF());
            stmt.setString(11, cBean.getEmail());
            stmt.setLong(12, cBean.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Long id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("delete from clientes where id = ?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
