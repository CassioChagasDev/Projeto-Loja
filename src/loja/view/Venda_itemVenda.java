package loja.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loja.controller.*;
import loja.model.*;
import loja.model.Produto_model;

public class Venda_itemVenda extends javax.swing.JFrame {

    int cod=0,id=0, id_cli, qt=0,quant=0;;
    double totalpag=0, totalparc=0;
    
    ArrayList<item_prod> list_pro = new ArrayList<item_prod>();
    int x=0;
    Conexao c = new Conexao();
    int cont=0;


    public Venda_itemVenda() {
        initComponents();
        x=1;
        busca(); // chama o metodo para pegar o proximo idvenda para salvar na tabela venda
        busca2(); // chama o metodo para carregar o jComboBox do Cliente
        busca3(); // chama o método para carregar o jComboBox do produto

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS DA VENDA"));
        jPanel1.setLayout(null);

        jLabel1.setText("idVenda");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 40, 80, 14);

        jTextField1.setEditable(false);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(70, 40, 100, 20);

        jLabel5.setText("Data da Venda");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 120, 80, 14);

        try {
            jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(110, 120, 120, 20);

        jLabel6.setText("Cliente");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 80, 40, 14);

        jComboBox2.setEditable(true);
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox2MousePressed(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboBox2KeyReleased(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(70, 80, 320, 20);

        jLabel7.setText("TOTAL À PAGAR");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(270, 120, 100, 14);

        jTextField4.setEditable(false);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(380, 120, 130, 20);

        jButton1.setText("FECHAR VENDA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(410, 60, 120, 23);

        jButton4.setText("NOVA VENDA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(410, 20, 120, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 10, 560, 170);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DADOS DOS PRODUTOS"));
        jPanel2.setLayout(null);

        jLabel2.setText("Produto");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 40, 60, 14);

        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(90, 40, 180, 20);

        jLabel3.setText("Qtde");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(290, 40, 40, 14);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(330, 40, 80, 20);

        jLabel4.setText("Preço");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(420, 40, 40, 14);

        jTextField3.setEditable(false);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(460, 40, 80, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Preço unitário", "Qtde comprada", "Total do produto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 520, 140);

        jButton2.setText("SALVAR PEDIDO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(170, 250, 190, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 190, 560, 280);

        jButton3.setText("MENU");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(420, 480, 150, 23);

        setSize(new java.awt.Dimension(603, 556));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       Venda_model v1 = new Venda_model();
       Itemvenda_model v = new Itemvenda_model();
       Produto_model pm = new Produto_model();

       if(x==1){ // primeira vez salva depois só altera

       v1.setIdvenda(cod);
       v1.setIdCliente(busca5());
       v1.setTotalpagar(totalpag);
       
    
       try { 
            DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            v1.setData(new java.sql.Date(((java.util.Date) formatador.parse(jFormattedTextField1.getText())).getTime()));
           } catch (ParseException ex) {
               Logger.getLogger(Venda_itemVenda.class.getName()).log(Level.SEVERE, null, ex);
           }

       Venda_CRUD ven = new Venda_CRUD();
       ven.salvar(v1);
       }
       x++;
       
       v.setIdProduto(busca4()); // chama o metodo para pegar o idproduto para salvar na tabela itemvenda
       v.setIdVenda(Integer.parseInt(jTextField1.getText()));
       v.setQtde(Integer.parseInt(jTextField2.getText()));
       v.setTotalparc(totalparc);
   

       Itemvenda_CRUD item = new Itemvenda_CRUD();
       item.salvar(v);
       
       pm.setIdProduto(v.getIdProduto());
       qt = quant - v.getQtde();
       pm.setQtde(qt);
       Produto_CRUD p = new Produto_CRUD();
       p.alterar(pm);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      Venda_model v2 = new Venda_model();

       v2.setIdvenda(Integer.parseInt(jTextField1.getText()));
       v2.setIdCliente(id_cli);
       v2.setTotalpagar(Double.parseDouble(jTextField4.getText()));
      
        try { 
            DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
           /* String hora = "10:00";
            SimpleDateFormat f = new SimpleDateFormat("HH:mm"); 
            Date data = f.parse(hora); 
            System.out.println("hora1 "+data);
            Time time = new Time(data.getTime());
            System.out.println("hora2 "+time);*/
            v2.setData(new java.sql.Date(((java.util.Date) formatador.parse(jFormattedTextField1.getText())).getTime()));
            //v2.setData(time);
           } catch (ParseException ex) {
               Logger.getLogger(Venda_itemVenda.class.getName()).log(Level.SEVERE, null, ex);
           }

       Venda_CRUD ven = new Venda_CRUD();
       ven.alterar(v2);
       
       
        JOptionPane.showMessageDialog(null, "Venda Finalizada!!!!", "Vendas", 1);
        cont=0;
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        Menu m = new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyReleased
       
    }//GEN-LAST:event_jComboBox2KeyReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
     


    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MousePressed
  
    }//GEN-LAST:event_jComboBox2MousePressed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed

    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        busca();
        jTextField4.setText("");
        jFormattedTextField1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

  public void busca()
    {
        Venda_CRUD vend = new Venda_CRUD();
        c.conectar();
        cod = vend.listar();
        jTextField1.setText(String.valueOf(cod+1));
    }

    public void busca2()
    {

        Cliente_CRUD t = new Cliente_CRUD();
      
        List<Cliente_model> lista_cli = (List<Cliente_model>) t.listar_dados();
        
        for(int i=0; i<lista_cli.size();i++)
        {
            jComboBox2.addItem(lista_cli.get(i).getNomeCli());
            
        }


    }

     public void busca3()
    {

        Produto_CRUD t = new Produto_CRUD();
        List<Produto_model> lista_prod = (List<Produto_model>) t.listar_dados();

        for(int i=0; i<lista_prod.size();i++)
        {
            jComboBox1.addItem(lista_prod.get(i).getDescProduto());
        }

    }

     public int busca4()
    {
 
        Produto_CRUD t = new Produto_CRUD();

        List<Produto_model> lista_produto = (List<Produto_model>) t.listar_dados();
        
        for(int i=0; i<lista_produto.size();i++)
        {
            if(jComboBox1.getSelectedItem().toString().equals(lista_produto.get(i).getDescProduto()))
            {
                id = lista_produto.get(i).getIdProduto();
                jTextField3.setText(String.valueOf(lista_produto.get(i).getPreco()));
                totalparc = Integer.parseInt(jTextField2.getText())* lista_produto.get(i).getPreco();
                totalpag = totalpag + totalparc;
                jTextField4.setText(String.valueOf(totalpag));
                
                quant = lista_produto.get(i).getQtde();
                
                item_prod it = new item_prod();

                it.setDescProduto(lista_produto.get(i).getDescProduto());
                it.setPreco(lista_produto.get(i).getPreco());
                it.setQtde(Integer.parseInt(jTextField2.getText()));
                it.setTotal(totalparc);
                list_pro.add(it);
            }
        }
        preencher_tabela();
        return id;

    }

  public void preencher_tabela()
  {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for(int a=0; a<list_pro.size();a++){
           modelo.addRow(new Object[]{
             list_pro.get(a).getDescProduto(),
             list_pro.get(a).getPreco(),
             list_pro.get(a).getQtde(),
             list_pro.get(a).getTotal()
        });
        }
  }
  public int busca5()
    {
        Cliente_CRUD t = new Cliente_CRUD();
        List<Cliente_model> lista_cliente = (List<Cliente_model>) t.listar_dados();

        for(int i=0; i<lista_cliente.size();i++)
        {
            if(jComboBox2.getSelectedItem().toString().equals(lista_cliente.get(i).getNomeCli()))
            {
                id_cli = lista_cliente.get(i).getIdCli();
            }
        }
        return id_cli;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venda_itemVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
