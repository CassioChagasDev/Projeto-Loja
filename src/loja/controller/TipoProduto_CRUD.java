package loja.controller;

import loja.model.Tipo_model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TipoProduto_CRUD {

   Conexao co = new Conexao();

   public void salvar(Tipo_model cli) {
   try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO tipo(DescTipo) VALUES( ? )");

       stmt.setString(1, cli.getDescTipo());

       stmt.execute();
       stmt.close();

      } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERRO..."+e.getMessage(),"Cadastro de Clientes",0);
      }
   }

   public List listar() {

     List<Tipo_model> lista = new ArrayList<Tipo_model>();

      try{
          co.conectar();
          PreparedStatement stmt = co.con.prepareStatement(
                "SELECT * FROM Tipo");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

          Tipo_model t = new Tipo_model();
          t.setIdTipo(rs.getInt("idTipo"));
          t.setDescTipo(rs.getString("DescTipo"));
          lista.add(t);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Tipos", 0);
      }
      return lista;
    }

}
