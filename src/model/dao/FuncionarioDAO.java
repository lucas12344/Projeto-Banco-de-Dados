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
import model.bean.Funcionario;


public class FuncionarioDAO {
    
    public void create(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
      
       
        try {
            stmt = con.prepareStatement("INSERT INTO funcionario(nome,data_nascimento,endereco, telefone, cargo)VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getData_nascimento());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getCargo());
        
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public List<Funcionario> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setData_nascimento(rs.getString("data_nascimento"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCargo(rs.getString("cargo"));
              
                
                funcionarios.add(funcionario);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return funcionarios; 
    }
    
        public void update(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
      
        
        
        try {
            stmt = con.prepareStatement("UPDATE funcionario SET nome = ?, cpf = ?, datanasc = ?, sexo = ?, endereco = ?, contato = ?, email = ? WHERE id = ?");
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getData_nascimento());
            stmt.setString(3, f.getEndereco());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getCargo());
        
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
          public void delete(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
      
        
        
        try {
            stmt = con.prepareStatement("DELETE FROM funcionario WHERE id = ?");
            stmt.setInt(1, f.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        public List<Funcionario> readForDesc(String desc){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Funcionario funcionario = new Funcionario();
                
                
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setData_nascimento(rs.getString("data_nascimento"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCargo(rs.getString("cargo"));
                
                funcionarios.add(funcionario);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return funcionarios; 
    }
    
    
    
    
    
    
    
}
 