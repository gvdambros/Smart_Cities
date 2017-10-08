package br.com.app.challenge.model;

import br.com.app.challenge.smart_cities.R;

/**
 * Created by gvdambros on 10/7/17.
 */

public enum Tipo_De_Incidente {
    SANEAMENTO, ELETRICO, RUAS_E_CALCADAS, AMBIENTAL,
    LIXO, TRANSPORTE;

    public String toString(){
        switch (this) {
            case RUAS_E_CALCADAS:
                return "Ruas e calçadas";
            case AMBIENTAL:
                return "Ambiental";
            case ELETRICO:
                return "Elétrico";
            case LIXO:
                return "Lixo";
            case TRANSPORTE:
                return "Transporte";
            case SANEAMENTO:
                return "Saneamento";
            default:
                return "...";
        }
    }

    public Integer toIconID(){
        switch (this) {
            case RUAS_E_CALCADAS:
                return R.drawable.rua_e_calcada;
            case AMBIENTAL:
                return R.drawable.ambiente;
            case ELETRICO:
                return R.drawable.eletrico;
            case LIXO:
                return R.drawable.lixo;
            case TRANSPORTE:
                return R.drawable.transporte;
            case SANEAMENTO:
                return R.drawable.saneamento;
            default:
                return R.drawable.user_photo;
        }
    }
}
