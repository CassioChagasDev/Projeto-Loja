
package loja.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import loja.model.Cliente_model;

public class Cliente_CRUD {

  Conexao co = new Conexao();

  public void salvar(Cliente_model cli) {
   try{
      co.conectar();
      PreparedStatement stmt = co.con.prepareStatement(
     "INSERT INTO cliente(DesCliente,DatNascimento,Telefone,Email) " +
     "VALUES( ?, ?, ?, ? )");

       stmt.setString(1, cli.getNomeCli());
       stmt.setString(2, (String.valueOf(cli.getDataNascCli())));
       stmt.setString(3, cli.getFoneCli());
       stmt.setString(4, cli.getEmailCli());
 
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
                "SELECT MAX(idcliente) FROM cliente"); 

    // quando o resultado do SELECT é apenas 1 valor pode ser assim:
    
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

     List<Cliente_model> lista = new ArrayList<Cliente_model>();

      try{
          co.conectar();
     
          PreparedStatement stmt = co.con.prepareStatement(
              "SELECT * FROM cliente" );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

          Cliente_model t = new Cliente_model();
          t.setIdCli(rs.getInt("idCliente"));
          t.setNomeCli(rs.getString("DesCliente"));
          lista.add(t);
       }
        stmt.close();

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Clientes", 0);
      }
      return lista;
    }

  /*  public boolean listar_dados2(int num) {

        boolean v=false;
        
      try{
          co.conectar();
     
          PreparedStatement stmt = co.con.prepareStatement(
              "SELECT * FROM cliente where idCliente = "+num );

        ResultSet rs = stmt.executeQuery();

        if (rs.wasNull()) 
             v = false;
        else
             v= true;
       
       

      }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO..."+e.getMessage(), "Consulta de Clientes", 0);
      }
      return v;
    }
 */
}
