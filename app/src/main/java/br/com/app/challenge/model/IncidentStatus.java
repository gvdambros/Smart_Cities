package br.com.app.challenge.model;

import br.com.app.challenge.smart_cities.R;

/**
 * Created by gvdambros on 10/7/17.
 */

public enum IncidentStatus {
    SOLICITADO, EM_ANDAMENTO, CONLUIDO;

    public String toString(){
        switch (this) {
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

    public Integer toIconID(){
        switch (this) {
            case SOLICITADO:
                return R.drawable.solicitado;
            case EM_ANDAMENTO:
                return R.drawable.em_andamento;
            case CONLUIDO:
                return R.drawable.concluido;
            default:
                return R.drawable.user_photo;
        }
    }


}
