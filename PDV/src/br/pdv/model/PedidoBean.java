package br.pdv.model;

import java.sql.Date;
import java.util.Calendar;

public class PedidoBean {

    /* 6) A aplicação deverá implementar um cadastro de PEDIDOS (ID,
     DATA_PEDIDO, DATA_ENTREGA, CLIENTEID, REPRESENTANTEID).
     Deverão estar disponíveis recursos para o gerenciamento deste
     cadastro (INCLUSÃO, EXCLUSÃO, ALTERAÇÃO). */
    
    
    int ID;
    Calendar DATA_PEDIDO;
    Calendar DATA_ENTREGA;
    int CLIENTEID;
    int REPRESENTANTEID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Calendar getDATA_PEDIDO() {
        return DATA_PEDIDO;
    }

    public void setDATA_PEDIDO(Calendar DATA_PEDIDO) {
        this.DATA_PEDIDO = DATA_PEDIDO;
    }

    public Calendar getDATA_ENTREGA() {
        return DATA_ENTREGA;
    }

    public void setDATA_ENTREGA(Calendar DATA_ENTREGA) {
        this.DATA_ENTREGA = DATA_ENTREGA;
    }

    public int getCLIENTEID() {
        return CLIENTEID;
    }

    public void setCLIENTEID(int CLIENTEID) {
        this.CLIENTEID = CLIENTEID;
    }

    public int getREPRESENTANTEID() {
        return REPRESENTANTEID;
    }

    public void setREPRESENTANTEID(int REPRESENTANTEID) {
        this.REPRESENTANTEID = REPRESENTANTEID;
    }
    
    

  
    
    
    
    
}
