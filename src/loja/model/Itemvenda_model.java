

package loja.model;


public class Itemvenda_model {
    
   private int idProduto;
   private int idVenda;
   private int qtde;
   private double totalparc;
   
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getTotalparc() {
        return totalparc;
    }

    public void setTotalparc(double totalparc) {
        this.totalparc = totalparc;
    }



}
