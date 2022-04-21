package HH.palvelinohjelmointi.WorkoutNotes.domain;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity

public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String musclegroup;
	private String comment;
	private int week;
	
	
	 @ManyToOne
	 @JsonIgnoreProperties ("notes")
	    @JoinColumn(name = "levelid")
	    private Level level;
	
	
	
	public Note() {
		super();
		this.musclegroup=null;
		this.comment=null;
		this.week=0;
		this.level=null;
	}
	

	public Note(String musclegroup, String comment, int week, Level level) {
		super();
		this.musclegroup = musclegroup;
		this.comment = comment;
		this.week = week;
		this.level = level;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMusclegroup() {
		return musclegroup;
	}


	public void setMusclegroup(String musclegroup) {
		this.musclegroup = musclegroup;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public int getWeek() {
		return week;
	}


	public void setWeek(int week) {
		this.week = week;
	}


	public Level getLevel() {
		return level;
	}


	public void setLevel(Level level) {
		this.level = level;
	}


	@Override
	public String toString() {
		if (this.level != null)
		return "Note [id=" + id + ", musclegroup=" + musclegroup + ", comment=" + comment + ", week=" + week
				+ ", level=" + this.getLevel() + "]";
		else
			return "Note [id=" + id + ", musclegroup=" + musclegroup + ", comment=" + comment + ", week=" + week
					+ ", level=" + "]";
	}
	
}