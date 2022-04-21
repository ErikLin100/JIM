package HH.palvelinohjelmointi.WorkoutNotes.domain;

import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity

public class Level {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long levelid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
	private List<Note> notes;
	@JsonIgnoreProperties("level")  
	
	
	


public Level() {

}
public Level(String name) {
	super();
	this.name = name;
	
	
}
public Long getLevelid() {
	return levelid;
}
public void setLevelid(Long levelid) {
	this.levelid = levelid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Note> getNotes() {
	return notes;
}
public void setNotes(List<Note> notes) {
	this.notes = notes;
}
@Override
public String toString() {
	return "Level [levelid=" + levelid + ", name=" + name + "]";
}

}
