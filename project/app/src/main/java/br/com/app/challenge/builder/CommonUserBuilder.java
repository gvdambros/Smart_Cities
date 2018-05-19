package br.com.app.challenge.builder;

import java.util.Date;

import br.com.app.challenge.model.CommonUser;
import br.com.app.challenge.model.Incident;
import br.com.app.challenge.model.IncidentType;
import br.com.app.challenge.activity.R;

public class CommonUserBuilder {


    public CommonUser buildMockUser (){
        CommonUser mockCommonUser = new CommonUser("gvdambros@gmail.com", "12345", "Gustavo Dambros", "(51)982294106", "Rua João Pessoa");
        Incident mockAmbientalIncident = new Incident(IncidentType.TRANSPORTE, new Date(), "Buraco na minha rua.", mockCommonUser.getName(), R.drawable.street_hole);
        Incident mockEletricalIncident = new Incident(IncidentType.ELETRICO, new Date(), "Faltou luz no bairro Farroupilha.", mockCommonUser.getName(), R.drawable.street_blackout);
        mockCommonUser.addIncidentes(mockAmbientalIncident);
        mockCommonUser.addIncidentes(mockEletricalIncident);
        return mockCommonUser;
    }
}
