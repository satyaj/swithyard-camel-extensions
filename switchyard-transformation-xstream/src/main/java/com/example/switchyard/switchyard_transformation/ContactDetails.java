package com.example.switchyard.switchyard_transformation;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.springframework.stereotype.Component;

@CsvRecord(separator = ";")
public class ContactDetails extends BindyCsvDataFormat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1170450532744250756L;
	
	
	@DataField(pos = 1,required = true,trim = true)
	private String fisrtName;
	@DataField(pos = 2,required = true,trim = true)
	private String lastName;
	@DataField(pos = 3,required = true,trim = true,length=10)
	private String primaryNumber;
	@DataField(pos = 4,trim = true,length=10)
	private String secondaryNymber;
	@DataField(pos = 5,trim = true)
	private String emailId;

	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPrimaryNumber() {
		return primaryNumber;
	}
	public void setPrimaryNumber(String primaryNumber) {
		this.primaryNumber = primaryNumber;
	}
	public String getSecondaryNymber() {
		return secondaryNymber;
	}
	public void setSecondaryNymber(String secondaryNymber) {
		this.secondaryNymber = secondaryNymber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
