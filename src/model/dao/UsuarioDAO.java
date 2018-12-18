package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;


public class UsuarioDAO {
 
     public boolean checkLogin(String login, String senha){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if (rs.next()){
                
                check = true;
                
              
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return check; 
    }
     
     public void create(Usuario u) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (login,senha)VALUES(?,?)");
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     
        public List<Usuario> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Usuario usuario = new Usuario();
                
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                              
                usuarios.add(usuario);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return usuarios; 
    }
     
     
      public void update(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
      
        
        
        try {
            stmt = con.prepareStatement("UPDATE usuario SET senha = ? WHERE id = ?");
            
            //stmt.setString(1, u.getLogin());
            stmt.setString(1, u.getSenha());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Senha atualizada com sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
    
    
}
