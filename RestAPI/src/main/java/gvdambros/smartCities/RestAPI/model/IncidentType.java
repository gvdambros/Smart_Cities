package gvdambros.smartCities.RestAPI.model;

public enum IncidentType {
    SANEAMENTO(0),
    ELETRICO(1),
    AMBIENTAL(2),
    LIXO(3),
    TRANSPORTE(4);

    private final Integer id;

    IncidentType(final Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public Integer toInteger(){
        return this.id;
    }

}
