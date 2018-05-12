package br.com.app.challenge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gvdambros on 10/7/17.
 */

public class CommonUser extends User {

    int experience;
    List<Incident> myIncidents;

    public CommonUser(String nome, String telefone, String endereco) {
        super(nome, telefone, endereco);
        experience = 0;
        myIncidents = new ArrayList<Incident>();
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Incident> getMyIncidents() {
        return myIncidents;
    }

    public void setMyIncidents(List<Incident> myIncidents) {
        this.myIncidents = myIncidents;
    }

    public void addIncidentes(Incident incident) {
        this.myIncidents.add(incident);
    }

    public String[] getIncidentesAsStringArray(){
        String[] incidentesStringArray = new String[ this.myIncidents.size() ];
        for(int i = 0; i < this.myIncidents.size(); i++){
            incidentesStringArray[i] = this.myIncidents.get(i).toString();
        }
        return incidentesStringArray;
    }
}
