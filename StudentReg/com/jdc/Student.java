package com.jdc;
import java.util.Date;
public class Student{

	public static void main(String[] args) {
		new Student().setGender("malee");

	}



	private String name;
	private int rollNum;
	private String gender;
	private Date date;

	public Student(){
		
		
		this.date = new Date();

	}

	public void setName(String name){
		this.name = name;

	}

	public String getName(){
		return name;
	}

	public void setRollNum(int rollNum){
		this.rollNum = rollNum;

	}

	public int getRollNum(){
		return rollNum;
	}

	public void setGender(String gender){
		for(genderEnum ge : genderEnum.values()){
			if(gender.equalsIgnoreCase(ge.toString())){
				this.gender = ge.toString();
				break;
			}

		}
		if(gender == null){
			this.gender = "None";
		}
		
	}

	public String getGender(){
		return gender;
	}

	public Date getDate(){
		return date;
	}

	public void setDate(Date date){
		this.date = date;
	}

	static enum genderEnum{
		Male(){
			public String toString(){
				return "Male";
			}
		},
		Female(){
			public String toString(){
				return "Female";
			}
			};

		
	}



}