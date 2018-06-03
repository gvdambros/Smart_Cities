package gvdambros.smartCities.RestAPI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incidents")
public class Incident {

	@Id
	@GeneratedValue
    Long id;
    Long userId;

    @Enumerated(EnumType.ORDINAL)
    IncidentType type;
    Date date;
    Integer numberOfLikes;
    
    //List<String> comments;
    
    String description;
    
    @Enumerated(EnumType.ORDINAL)
    IncidentStatus status;
    
	public Incident() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public IncidentType getType() {
		return type;
	}
	public void setType(IncidentType type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNumberOfLikes() {
		return numberOfLikes;
	}
	public void setNumberOfLikes(Integer numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public IncidentStatus getStatus() {
		return status;
	}
	public void setStatus(IncidentStatus status) {
		this.status = status;
	}
    
}
