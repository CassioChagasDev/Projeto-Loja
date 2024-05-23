
package loja.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import loja.model.Venda_model;


public class Venda_CRUD {

    Conexao co = new Conexao();

    public void salvar(Venda_model cli) {

     try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO venda (idCliente, TotVenda,DatVenda) " +
     "VALUES( ?, ?, ? )");

       stmt.setInt(1, cli.getIdCliente());
       stmt.setDouble(2, cli.getTotalpagar());
       stmt.setString(3, (String.valueOf(cli.getData())));
       
       
       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro da Venda",0);
      }
   }

   public void alterar(Venda_model cli) {

     try{
         co.conectar();
         PreparedStatement stmt = co.con.prepareStatement(
                    "UPDATE venda " +
                    "SET " +
                    "    idCliente = ?, " +
                    "    TotVenda = ?, " +
                    "    DatVenda = ? " +
                    "WHERE " +
                    "    idVenda = ?");

            stmt.setInt(1,cli.getIdCliente());
            stmt.setDouble(2, cli.getTotalpagar());
            stmt.setString(3, (String.valueOf(cli.getData())));
            stmt.setInt(4, cli.getIdvenda());
            
            stmt.execute();
            stmt.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração da Venda", 0);
        }
    }

    public int listar() {

     int lista=0;

      try{
          co.conectar();
          PreparedStatement stmt = co.con.prepareStatement(
                "SELECT MAX(idvenda) FROM venda");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            lista = rs.getInt(1);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Clientes", 0);
      }
      return lista;
    }

}
