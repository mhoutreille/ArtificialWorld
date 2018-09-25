package object.entity.human;

import java.io.Serializable;

import object.entity.human.process.Life;
import object.occupation.Career;

public class Human implements Serializable {
	
	private String firstName = null;
	private String lastName = null;
	private String genre = null;
	
	private Human mother;
	private Human father;
	private Human companion;
	
	private HumanParameters parameters;
	private Career career;
	
	private Life life;
	
	
	public Human() {
		life = new Life(this);
	}

	public Human( String firstName, String lastName, String genre) {
		
		this.firstName = firstName;
		this.lastName = lastName;	
		this.genre = genre;	
		life = new Life(this);
	}
	
	public Human getMother() {
		return mother;
	}


	public void setMother(Human mother) {
		this.mother = mother;
	}


	public Human getFather() {
		return father;
	}


	public void setFather(Human father) {
		this.father = father;
	}


	public Human getCompanion() {
		return companion;
	}


	public void setCompanion(Human companion) {
		this.companion = companion;
	}


	public HumanParameters getParameters() {
		return parameters;
	}


	public void setParameters(HumanParameters parameters) {
		this.parameters = parameters;
	}


	public Career getCareer() {
		return career;
	}


	public void setCareer(Career career) {
		this.career = career;
	}


	public Life getLife() {
		return life;
	}


	public void setLife(Life life) {
		this.life = life;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
