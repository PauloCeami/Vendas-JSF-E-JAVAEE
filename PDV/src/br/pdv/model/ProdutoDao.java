package br.pdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {

    private Connection connection;

    public ProdutoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void AddProduto(ProdutoBean MeuProduto) {

        String sql = "insert into produtos (Descricao,Preco_unitario) values (?,?)  ";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, MeuProduto.getDescricao());
            stmt.setDouble(2, MeuProduto.getPreco_unitario());
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<ProdutoBean> ListaTodosProdutos() {
        List<ProdutoBean> ListadeProdutos = new ArrayList<ProdutoBean>();
        try {
            String Sql = "select * from produtos";
            PreparedStatement stmt = this.connection.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoBean pBean = new ProdutoBean();
                pBean.setId(rs.getInt("id"));
                pBean.setDescricao(rs.getString("Descricao"));
                pBean.setPreco_unitario(rs.getDouble("Preco_unitario"));
                ListadeProdutos.add(pBean);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ListadeProdutos;
    }

    public ProdutoBean BuscaProdutos_ID(Long id) {
        ProdutoBean pBean = null;
        try {
            String Sql = "select * from produtos where id=?";
            PreparedStatement stmt = this.connection.prepareStatement(Sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pBean = new ProdutoBean();
                pBean.setId(rs.getInt("id"));
                pBean.setDescricao(rs.getString("descricao"));
                pBean.setPreco_unitario(rs.getDouble("preco_unitario"));
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pBean;
    }
    
    
    public ProdutoBean BuscaProdutos_IDGetINT(int id) {
        ProdutoBean pBean = null;
        try {
            String Sql = "select * from produtos where id=?";
            PreparedStatement stmt = this.connection.prepareStatement(Sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pBean = new ProdutoBean();
                pBean.setId(rs.getInt("id"));
                pBean.setDescricao(rs.getString("descricao"));
                pBean.setPreco_unitario(rs.getDouble("preco_unitario"));
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pBean;
    }
    
       public List<ProdutoBean> ListaProdutosWherelike(String descricao) { 
        List<ProdutoBean> ListadeProdutos = new ArrayList<ProdutoBean>();
        try {
            String Sql = "select * from produtos where descricao like ?";
            PreparedStatement stmt = this.connection.prepareStatement(Sql);
            stmt.setString(1, '%' + descricao +'%' );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoBean pBean = new ProdutoBean();
                pBean.setId(rs.getInt("id"));
                pBean.setDescricao(rs.getString("Descricao"));
                pBean.setPreco_unitario(rs.getDouble("Preco_unitario"));
                ListadeProdutos.add(pBean);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ListadeProdutos;
    }
    
    

    public void AlteraProduto(ProdutoBean MeuProduto) {
        String sql = "update produtos set descricao=?,preco_unitario=? where id=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, MeuProduto.getDescricao());
            stmt.setDouble(2, MeuProduto.getPreco_unitario());
            stmt.setInt(3, MeuProduto.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void RemoverProduto(Long id) {
        String sql = "delete from produtos where id=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

 
}
