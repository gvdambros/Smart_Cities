package br.com.app.challenge.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gvdambros on 10/7/17.
 */

public class Incidente {

    static int gerador_de_id = 1;

    int id;
    Tipo_De_Incidente tipo;
    Date dia_do_incidente;
    Date dia_de_finalizacao;
    int numereros_de_joinhas;
    List<String> comentarios;
    // Local //
    String descricao;
    Status_Do_Incidente status;

    public Incidente(Tipo_De_Incidente tipo, Date dia_do_incidente, /*Local,*/ String descricao) {
        this.id = gerador_de_id++;
        this.tipo = tipo;
        this.dia_do_incidente = dia_do_incidente;
        this.descricao = descricao;
        this.numereros_de_joinhas = 0;
        this.comentarios = new ArrayList<String>();
        this.dia_de_finalizacao = new Date();
        this.status = Status_Do_Incidente.SOLICITADO;
    }

    public Tipo_De_Incidente getTipo() {
        return tipo;
    }

    public void setTipo(Tipo_De_Incidente tipo) {
        this.tipo = tipo;
    }

    public Date getDia_do_incidente() {
        return dia_do_incidente;
    }

    public void setDia_do_incidente(Date dia_do_incidente) {
        this.dia_do_incidente = dia_do_incidente;
    }

    public Date getDia_de_finalizacao() {
        return dia_de_finalizacao;
    }

    public void setDia_de_finalizacao(Date dia_de_finalizacao) {
        this.dia_de_finalizacao = dia_de_finalizacao;
    }

    public int getNumereros_de_joinhas() {
        return numereros_de_joinhas;
    }

    public void setNumereros_de_joinhas(int numereros_de_joinhas) {
        this.numereros_de_joinhas = numereros_de_joinhas;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString(){
        return "ID: " + this.id + " Data: " + this.dia_do_incidente.toString();
    }

}
