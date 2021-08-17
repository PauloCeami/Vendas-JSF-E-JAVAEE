package br.pdv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.pdv.model.ClienteBean;
import br.pdv.model.ClienteDao;
import br.pdv.model.ItensVendaBean;
import br.pdv.model.ItensVendaDao;
import br.pdv.model.PedidoBean;
import br.pdv.model.PedidoDao;
import br.pdv.model.ProdutoBean;
import br.pdv.model.ProdutoDao;
import br.pdv.model.RepresentanteBean;
import br.pdv.model.RepresentanteDao;
import br.util.Conv;

public class MovimentacaoVendas_RegraNegocio implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PedidoBean        pBean = new PedidoBean();
        PedidoDao         pDao = new PedidoDao();
        ItensVendaBean    iTensBean = new ItensVendaBean();
        ItensVendaDao     iTensDao = new ItensVendaDao();
        ClienteBean       cBean = new ClienteBean();
        ClienteDao        cDao = new ClienteDao();
        RepresentanteBean rBean = new RepresentanteBean();
        RepresentanteDao  rDao = new RepresentanteDao();
        ProdutoBean       prBean = new ProdutoBean();
        ProdutoDao        prDao = new ProdutoDao();
        

        

        if (null != request.getParameter("PEDIDOID")) {
            //1 verificar se este pedido ja foi gravado
            Long P = (Long.parseLong(request.getParameter("PEDIDOID")));
            if (null == pDao.BuscaPedido_ID(P)) {
                // 2 - Gravar um Pedido com data , cliente e vendedor 
                pBean.setDATA_PEDIDO(Conv.dtbr2cal(request.getParameter("DATA_PEDIDO")));
                pBean.setDATA_ENTREGA(Conv.dtbr2cal(request.getParameter("DATA_ENTREGA")));
                pBean.setCLIENTEID(Integer.parseInt(request.getParameter("CLIENTEID2")));
                pBean.setREPRESENTANTEID(Integer.parseInt(request.getParameter("REPRESENTANTEID2")));
                pDao.AddPedido(pBean);
            }
        }

        // 3 - Buscar o id dessa venda que foi gravada atraves do select max
        PedidoBean Ped = pDao.Busca_Ultimo_Pedido_Gravado();
        
        if (null != Ped) {
            request.setAttribute("id", Ped);
            
            cBean = cDao.BuscaClientePor_ID_GetINT(Ped.getCLIENTEID());
            request.setAttribute("idCliente", cBean);
            
            rBean = rDao.BuscaRepresentantePor_GetINT(Ped.getREPRESENTANTEID());
            request.setAttribute("idRepresentante", rBean);
          
            
            
        }
        

        // 4  verificar se este produto existe na venda tabela = produto_pedido
        int ProdutoExistente = Integer.parseInt(request.getParameter("IDPRODUTO2"));
        if (null != iTensDao.Busca_Produto_Existente_na_Venda(ProdutoExistente, Ped.getID())) {
            request.setAttribute("mensagem", "O Produto " + request.getParameter("IDPRODUTO") + " ja existe na venda !");
            request.getRequestDispatcher("Mensagem").forward(request, response);
            request.getRequestDispatcher("vw_Pedido.jsp?idpedido=" + Ped.getID() + "&DataPedido=" + Ped.getDATA_PEDIDO() + "&DataEntrega=" + Ped.getDATA_ENTREGA()).forward(request, response);
        } else {
            //inserindo os itens na venda
            iTensBean.setPEDIDOID(Ped.getID());
            iTensBean.setPRODUTOID(Integer.parseInt(request.getParameter("IDPRODUTO2")));
            String qtde = request.getParameter("QUANTIDADE");
            if (qtde == null) {
                iTensBean.setQUANTIDADE(1);
            } else {
                iTensBean.setQUANTIDADE(Integer.parseInt(request.getParameter("QUANTIDADE")));
            }
            iTensBean.setPRECO_UNITARIO(Double.parseDouble(request.getParameter("PRECO_UNITARIO")));
            iTensDao.Inserir_Itens_na_Venda(iTensBean);
            iTensDao.Busca_os_Itens_De_1_Venda_Apenas(Ped.getID());
            request.getRequestDispatcher("vw_Pedido.jsp").forward(request, response);
        }


    }
}
