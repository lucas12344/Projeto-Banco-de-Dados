package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.SaidaCaixa;

public class SaidaCaixaDAO {
    
       public void create(SaidaCaixa s) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cxsaida (tipo,descricao,dataregistro,valor)VALUES(?,?,?,?)");
            stmt.setString(1, s.getTipo());
            stmt.setString(2, s.getDescricao());
            stmt.setString(3, s.getDataregistro());
            stmt.setDouble(4, s.getValor());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro de Saída feito com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
    
}
