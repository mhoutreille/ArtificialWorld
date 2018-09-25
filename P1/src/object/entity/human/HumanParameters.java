package object.entity.human;

import java.io.Serializable;
import java.util.Date;

public class HumanParameters implements Serializable{

	private String firstName = null;
	private String lastName  = null;
	
	private Double weightInKg = null;
	private Double heightInCm = null;
	private Date  dateOfBirth = null;
	
	
	
	public Double getWeightInKg() {
		return weightInKg;
	}
	
	public void setWeightInKg(Double weightInKg) {
		this.weightInKg = weightInKg;
	}
	
	public Double getHeightInCm() {
		return heightInCm;
	}
	
	public void setHeightInCm(Double heightInCm) {
		this.heightInCm = heightInCm;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setgetDateOfBirth(Date age) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
