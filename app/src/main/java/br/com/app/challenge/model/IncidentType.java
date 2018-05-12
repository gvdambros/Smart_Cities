package br.com.app.challenge.model;

import br.com.app.challenge.smart_cities.R;

/**
 * Created by gvdambros on 10/7/17.
 */

public enum IncidentType {
    SANEAMENTO ("Saneamento"),
    ELETRICO("Elétrico"),
    AMBIENTAL("Ambiental"),
    LIXO("Lixo Urbano"),
    TRANSPORTE("Transporte");

    private final String text;

    IncidentType(final String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public String toString(){
        return this.text;
    }

    public Integer toIconID(){
        switch (this) {
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
                return -1;
        }
    }

    static public IncidentType fromString(String text) throws AppException {
        switch (text) {
            case "Elétrico":
                return ELETRICO;
            case "Saneamento":
                return SANEAMENTO;
            case "Ambiental":
                return AMBIENTAL;
            case "Lixo Urbano":
                return LIXO;
            case "Transporte":
                return TRANSPORTE;
            default:
                throw new AppException();

        }
    }
}
