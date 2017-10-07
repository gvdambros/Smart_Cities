package br.com.app.challenge.br.com.app.challenge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gvdambros on 10/7/17.
 */

public class Usuario_Comum extends Usuario {

    int nivel;
    int experiencia;
    List<Incidente> meus_incidentes;

    public Usuario_Comum(String nome, String telefone, String endereco) {
        super(nome, telefone, endereco);
        nivel = 0;
        experiencia = 0;
        meus_incidentes = new ArrayList<Incidente>();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public List<Incidente> getMeus_incidentes() {
        return meus_incidentes;
    }

    public void setMeus_incidentes(List<Incidente> meus_incidentes) {
        this.meus_incidentes = meus_incidentes;
    }

    public void addIncidentes(Incidente incidente) {
        this.meus_incidentes.add(incidente);
    }

    public String[] getIncidentesToStringArray(){
        String[] incidentesStringArray = new String[ this.meus_incidentes.size() ];
        for(int i = 0; i < this.meus_incidentes.size(); i++){
            incidentesStringArray[i] = this.meus_incidentes.get(i).toString();
        }
        return incidentesStringArray;
    }
}
