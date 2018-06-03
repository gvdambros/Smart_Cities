package gvdambros.smartCities.RestAPI.model;

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

    public Integer toInteger(){
        switch (this) {
            case SOLICITADO:;
                return 0;
            case EM_ANDAMENTO:
                return 1;
            case CONLUIDO:
                return 2;
            default:
                return -1;
        }
    }


}
