

package loja.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import loja.model.Produto_model;


public class Produto_CRUD {

    Conexao co = new Conexao();
    
 public void salvar(Produto_model cli) {
        
     try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO produto(idTipo, validade, DescProd,Qtde,PreVenda) " +
     "VALUES( ?, ?, ?, ?, ? )");

       stmt.setInt(1, cli.getIdTipo());
       stmt.setString(2, cli.getValidade());
       stmt.setString(3, cli.getDescProduto());
       stmt.setInt(4, cli.getQtde());
       stmt.setDouble(5,cli.getPreco());
 
       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Clientes",0);
      }
   }

 public int listar() {

     int lista=0;

      try{
          co.conectar();
          PreparedStatement stmt = co.con.prepareStatement(
                "SELECT MAX(idproduto) FROM produto");

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

  public List listar_dados() {

     List<Produto_model> lista = new ArrayList<Produto_model>();

      try{
          co.conectar();
          PreparedStatement stmt = co.con.prepareStatement(
                "SELECT * FROM produto");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

          Produto_model t = new Produto_model();
          t.setIdProduto(rs.getInt("idProduto"));
          t.setDescProduto(rs.getString("DescProd"));
          t.setPreco(rs.getDouble("PreVenda"));
          t.setQtde(rs.getInt("qtde"));
          lista.add(t);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração de Clientes", 0);
      }
      return lista;
    }

   public void alterar(Produto_model p) {

     try{
         co.conectar();
         PreparedStatement stmt = co.con.prepareStatement(
                    "UPDATE produto " +
                    "SET " +
                       "    Qtde = ? " +
                    "WHERE " +
                    "    idProduto = ?");

            stmt.setInt(1,p.getQtde());
            stmt.setInt(2, p.getIdProduto());
            
            stmt.execute();
            stmt.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Alteração da Venda", 0);
        }
    }
}
