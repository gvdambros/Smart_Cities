package br.com.app.challenge.model;

/**
 * Created by gvdambros on 10/7/17.
 */

public enum Status_Do_Incidente {
    SOLICITADO, EM_ANDAMENTO, CONLUIDO;

    public String toString(){
        switch (this){
            case SOLICITADO:
                return "Solicitado";
            case EM_ANDAMENTO:
                return "Em Andamento";
            case CONLUIDO:
                return "Concluído";
            default:
                return "...";
        }
    }
}
