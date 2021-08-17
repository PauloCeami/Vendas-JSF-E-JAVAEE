/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pdv.model;

import java.sql.Connection;

/**
 *
 * @author Analista
 */
public class RepresentanteBean extends ClienteBean{

    private Connection connection;

    public RepresentanteBean() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    String contato;

 

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    
    
}
