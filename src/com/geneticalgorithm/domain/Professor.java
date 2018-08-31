package com.geneticalgorithm.domain;

public class Professor {
	private int id;
	private String professorName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	

	public Professor(int id, String professorName) {
		super();
		this.id = id;
		this.professorName = professorName;
	}

	public String getProfessorName() {
		return professorName;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", professorName=" + professorName + "]";
	}

	public Professor() {
		super();
	}


}
