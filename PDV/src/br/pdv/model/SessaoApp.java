package br.pdv.model;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessaoApp {
    private final int TEMPO_EXPIRACAO = 3800; // 1800 segundos = 30 min
    private Usuario usuario;
    private long ultimoAcesso;

    public SessaoApp() {
        super();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(long ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
    
    public static Usuario leUsuario(HttpServletRequest request) { // le usuario logado
    	HttpSession s = request.getSession();
    	SessaoApp sa = ( null==s.getAttribute("sessaoapp")
    						? new SessaoApp()
    						: (SessaoApp) s.getAttribute("sessaoapp") );
    	return sa.getUsuario();
    }
    
    public static void encerra(HttpServletRequest request) {
    	HttpSession s = request.getSession();
    	if (null!=s.getAttribute("sessaoapp")) {
    		s.removeAttribute("sessaoapp");
    	}
    }
    
    public static void inicia(Usuario usuario, HttpServletRequest request) {
    	HttpSession s = request.getSession();
    	SessaoApp sa = ( null==s.getAttribute("sessaoapp")
    						? new SessaoApp()
    						: (SessaoApp) s.getAttribute("sessaoapp") );
        sa.setUsuario(usuario);
        Date d = new Date();
        sa.setUltimoAcesso(d.getTime()/1000);
        s.setAttribute("sessaoapp", sa);
    }
    
    public static boolean valida(HttpServletRequest request) {
    	boolean ret = false;
    	HttpSession s = request.getSession();
    	SessaoApp sa = ( null==s.getAttribute("sessaoapp")
    						? new SessaoApp()
    						: (SessaoApp) s.getAttribute("sessaoapp") );
        if (sa.usuario!=null) {
            Date d = new Date();
            long agora = d.getTime()/1000;
            long tempoDecorrido = agora-sa.ultimoAcesso;
            if (tempoDecorrido<=sa.TEMPO_EXPIRACAO) {
                sa.ultimoAcesso = agora;
                s.setAttribute("sessaoapp", sa);
                ret = true;
            }
        } 
    	return ret;
    }
    
}