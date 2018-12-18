package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.EntradaCaixa;

public class EntradaCaixaDAO {
    
     public void create(EntradaCaixa e) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cxentrada (tipo,descricao,dataregistro,valor)VALUES(?,?,?,?)");
            stmt.setString(1, e.getTipo());
            stmt.setString(2, e.getDescricao());
            stmt.setString(3, e.getDataregistro());
            stmt.setDouble(4, e.getValor());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro de Entrada feito com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
}
