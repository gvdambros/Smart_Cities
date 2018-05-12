package br.com.app.challenge.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gvdambros on 10/7/17.
 */

public class Incident implements Serializable {

    int id;
    IncidentType type;
    Date incidentDate;
    int numberOfLikes;
    List<String> comments;
    String description;
    IncidentStatus status;
    String authorName;
    Integer photo;

    public Incident(IncidentType type, Date incidentDate, String description, String author_name, Integer photo) {
        this.type = type;
        this.incidentDate = incidentDate;
        this.description = description;
        this.numberOfLikes = 0;
        this.comments = new ArrayList<String>();
        this.status = IncidentStatus.SOLICITADO;
        this.authorName = author_name;
        this.photo = photo;
    }

    public String getAutor() {
        return authorName;
    }

    public void setAutor(String authorName) {
        this.authorName = authorName;
    }

    public IncidentType getType() {
        return type;
    }

    public void setType(IncidentType type) {
        this.type = type;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return "ID: " + this.id + " Data: " + this.incidentDate.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }
}
