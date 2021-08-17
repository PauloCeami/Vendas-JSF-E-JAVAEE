package br.pdv.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.util.Hash;

public class UsuarioDAO {
	// a conexao com o banco de dados
	private Connection connection;
	
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public Usuario validar(Usuario usuario) {
        Usuario usuarioLido = usuario;
        try {
            if (usuario.getEmail()==null) usuario.setEmail("");
            if (usuario.getSenha()==null) usuario.setSenha("");
            String sql = "SELECT * FROM usuarios " +
                    " WHERE email = ?  AND senha = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuarioLido = new Usuario();
                usuarioLido.setId(rs.getInt("id"));
                usuarioLido.setNome(rs.getString("nome"));
                usuarioLido.setEmail(rs.getString("email"));
                usuarioLido.setSenha(rs.getString("senha"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioLido;
    }
	
}
