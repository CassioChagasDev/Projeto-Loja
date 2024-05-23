
package loja.model;

import java.util.Date;

public class Cliente_model {

    private int idCli;
    private String nomeCli;
    private Date dataNascCli;
    private String foneCli;
    private String emailCli;

    public Date getDataNascCli() {
        return dataNascCli;
    }

    public void setDataNascCli(Date dataNascCli) {
        this.dataNascCli = dataNascCli;
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        this.emailCli = emailCli;
    }

    public String getFoneCli() {
        return foneCli;
    }

    public void setFoneCli(String foneCli) {
        this.foneCli = foneCli;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }



}
