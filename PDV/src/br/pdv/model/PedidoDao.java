package br.pdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.util.Conv;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PedidoDao {

    private Connection connection;

    public PedidoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void AddPedido(PedidoBean MeuPedido) {

        String sql = "insert into pedidos (DATA_PEDIDO,DATA_ENTREGA,CLIENTEID,REPRESENTANTEID) values (?,?,?,?)";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setDate(1, Conv.cal2dtbd(MeuPedido.getDATA_PEDIDO()));
            stmt.setDate(2, Conv.cal2dtbd(MeuPedido.getDATA_ENTREGA()));
            stmt.setInt(3, MeuPedido.getCLIENTEID());
            stmt.setInt(4, MeuPedido.getREPRESENTANTEID());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PedidoBean> ListarTodosPedidos() {
        List<PedidoBean> ListadePedidos = new ArrayList<PedidoBean>();
        try {
            String sql = "select * from pedidos";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoBean pBean = new PedidoBean();
                pBean.setID(rs.getInt("id"));
                // String data = new SimpleDateFormat("dd/MM/yyyy").format(seuCalendar.getTime());   
                SimpleDateFormat dataformatada = new SimpleDateFormat("dd/MM/yyyy");
                Calendar data = dataformatada.getCalendar();
                data.setTime(rs.getDate("DATA_PEDIDO"));
                pBean.setDATA_PEDIDO(data);
                SimpleDateFormat dataformatada2 = new SimpleDateFormat("dd/MM/yyyy");
                Calendar data2 = dataformatada2.getCalendar();
                data.setTime(rs.getDate("DATA_ENTREGA"));
                pBean.setDATA_PEDIDO(data);
                pBean.setCLIENTEID(rs.getInt("CLIENTEID"));
                pBean.setREPRESENTANTEID(rs.getInt("REPRESENTANTEID"));
                ListadePedidos.add(pBean);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ListadePedidos;
    }

    public PedidoBean BuscaPedido_ID(Long id) {
        PedidoBean pBean = null;

        try {
            String sql = "select * from pedidos where id=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pBean = new PedidoBean();
                pBean.setID(rs.getInt("id"));
                pBean.setDATA_PEDIDO(Conv.dtbd2cal(rs.getDate("DATA_PEDIDO")));             
                pBean.setDATA_ENTREGA(Conv.dtbd2cal(rs.getDate("DATA_ENTREGA")));
                pBean.setCLIENTEID(rs.getInt("CLIENTEID"));
                pBean.setREPRESENTANTEID(rs.getInt("REPRESENTANTEID"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pBean;
    }

    public List<PedidoBean> Listagem_De_Pedidos_Por_CLIENTE(int CLIENTEID) {
        List<PedidoBean> PedidosCliente = new ArrayList<PedidoBean>();
        try {
            String sql = "SELECT * FROM pedidos where CLIENTEID=? order by DATA_PEDIDO Desc ";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, CLIENTEID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PedidoBean pBean = new PedidoBean();
                pBean.setID(rs.getInt("ID"));            
                pBean.setDATA_PEDIDO(Conv.dtbd2cal(rs.getDate("DATA_PEDIDO")));
                pBean.setDATA_ENTREGA(Conv.dtbd2cal(rs.getDate("DATA_ENTREGA")));
                pBean.setCLIENTEID(rs.getInt("CLIENTEID"));
                PedidosCliente.add(pBean);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return PedidosCliente;
    }

    public void AlteraPedido(PedidoBean MeuPedido) {
        String sql = "update pedidos set DATA_PEDIDO=?,DATA_ENTREGA=?,CLIENTEID=?,REPRESENTANTEID=? where id=? ";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setDate(1, Conv.cal2dtbd(MeuPedido.getDATA_PEDIDO()));
            stmt.setDate(2, Conv.cal2dtbd(MeuPedido.getDATA_ENTREGA()));
            stmt.setInt(3, MeuPedido.getCLIENTEID());
            stmt.setInt(4, MeuPedido.getREPRESENTANTEID());
            stmt.setInt(5, MeuPedido.getID());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void RemovePedido(int id) {
        try {
            String sql = "delete from pedidos where id =?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PedidoBean Busca_Ultimo_Pedido_Gravado() {
        PedidoBean pBean = null;
        try {
            String sql = "select max(ID) as id , DATA_PEDIDO,DATA_ENTREGA,CLIENTEID,REPRESENTANTEID   from pedidos";
            PreparedStatement s = this.connection.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                pBean = new PedidoBean();
                pBean.setID(rs.getInt("ID"));            
                pBean.setDATA_PEDIDO(Conv.dtbd2cal(rs.getDate("DATA_PEDIDO")));
                pBean.setDATA_ENTREGA(Conv.dtbd2cal(rs.getDate("DATA_ENTREGA")));
                pBean.setCLIENTEID(rs.getInt("CLIENTEID"));
                pBean.setREPRESENTANTEID(rs.getInt("REPRESENTANTEID"));
                
            }
            rs.close();
            s.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pBean;
    }
}
