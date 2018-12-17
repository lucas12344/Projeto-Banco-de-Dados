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
import model.bean.Cliente;


public class ClienteDAO {
   
    public void create(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
      
       
        try {
            stmt = con.prepareStatement("INSERT INTO cliente(nome,cpf,datanasc,sexo,endereco,contato,email)VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getDataNasc());
            stmt.setString(4, c.getSexo());
            stmt.setString(5, c.getEndereco());
            stmt.setString(6, c.getContato());
            stmt.setString(7, c.getEmail());

            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Cliente> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNasc(rs.getString("datanasc"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setContato(rs.getString("contato"));
                cliente.setEmail(rs.getString("email"));
                
                clientes.add(cliente);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes; 
    }
    
        public void update(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
      
        
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, datanasc = ?, sexo = ?, endereco = ?, contato = ?, email = ? WHERE id = ?");
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getDataNasc());
            stmt.setString(4, c.getSexo());
            stmt.setString(5, c.getEndereco());
            stmt.setString(6, c.getContato());
            stmt.setString(7, c.getEmail());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
          public void delete(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
      
        
        
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        public List<Cliente> readForDesc(String desc){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Cliente cliente = new Cliente();
                
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNasc(rs.getString("datanasc"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setContato(rs.getString("contato"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes; 
    }
    
    
    
}
