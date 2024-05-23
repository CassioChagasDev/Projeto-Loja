
package loja.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import loja.model.Itemvenda_model;

public class Itemvenda_CRUD {

Conexao co = new Conexao();

  public void salvar(Itemvenda_model cli) {

    try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO item_venda(idProduto,idVenda,QuaVendida,TotParcial) " +
     "VALUES( ?, ?, ?, ? )");

       stmt.setInt(1, cli.getIdProduto());
       stmt.setInt(2, cli.getIdVenda());
       stmt.setInt(3, cli.getQtde());
       stmt.setDouble(4, cli.getTotalparc());

       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Clientes",0);
      }
   }
}
