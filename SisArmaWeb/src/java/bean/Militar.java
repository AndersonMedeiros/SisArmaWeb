/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ASUS
 */
public class Militar {

    private int id;
    private String idmilitar;
    private String nome;
    private String guerra;
    private String login;
    private String senha;
    private String sexo;
    private String status;
    private Graduacao graduacao;
    private OM om;
    private byte[] digital;
    private FuncaoMilitar  idarmeiro;
    private FuncaoMilitar  idoficialDia;

    public FuncaoMilitar getIdarmeiro() {
        return idarmeiro;
    }

    public void setIdarmeiro(FuncaoMilitar idarmeiro) {
        this.idarmeiro = idarmeiro;
    }

    public FuncaoMilitar getIdoficialDia() {
        return idoficialDia;
    }

    public void setIdoficialDia(FuncaoMilitar idoficialDia) {
        this.idoficialDia = idoficialDia;
    }
    
    public String getIdmilitar() {
        return idmilitar;
    }

    public void setIdmilitar(String idmilitar) {
        this.idmilitar = idmilitar;
    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGuerra() {
        return guerra;
    }

    public void setGuerra(String guerra) {
        this.guerra = guerra;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Graduacao getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(Graduacao graduacao) {
        this.graduacao = graduacao;
    }

    public OM getOm() {
        return om;
    }

    public void setOm(OM om) {
        this.om = om;
    }

    public void setDigital(byte[] digital) {
        this.digital = digital;
    }

    public byte[] getDigital() {
        return digital;
    }

 
    @Override
    public String toString() {
        return login;
    }
}
