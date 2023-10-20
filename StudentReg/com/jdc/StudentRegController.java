package com.jdc;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public abstract class StudentRegController implements StudentRegForm{
	public static void main(String[] args) {

		
		
	}

	Scanner sc = new Scanner(System.in);

	private ArrayList<Student> stuList = new ArrayList<>();
	private ArrayList<String> menu = new ArrayList<>();
	
	

	{
		
		menu.add(". Add Student Info.");
		menu.add(". Show Student Info(with RollNumber).");
		menu.add(". Show all Studets.");
		menu.add(". Update Student Info.");
		menu.add(". Delete Student Info.");
		
	}

	private void showMenu(){
	
		System.out.println();
		System.out.println("This is our Application menu.");
		System.out.println("=========================");
		int count = 1;
		for(String str : menu){
			System.out.println(count+str);
			count++;
		}
		System.out.println("=========================");
		
		breakLine();


	}

	private int getMenu(){
		System.out.print("Enter the Menu Number that you want to do : ");
		int menuNum = 0;
		do{
			menuNum = new Scanner(System.in).nextInt();
			if(menuNum <= 0 || menuNum > menu.size()){
				System.out.print("the number you entered is incorrect. Retype : ");
			}
		}while(menuNum <= 0 || menuNum > menu.size());

		return menuNum;

	}

	private void addStudent(){
		
		Student student = new Student();

		student.setRollNum(rollNum());
		student.setName(name());
		student.setGender(gender());

		stuList.add(student);
	}

	private void showAllStudent(){
		int count = 1;
		for(Student student : stuList){
		System.out.println("this is student "+count+"'s Info.");
		showStudent(student);
			
		count++;

		}
	}

	private void showStudent(Student student){
		
			System.out.println("=========================");
			System.out.println(showRollNum(student.getRollNum()));
			System.out.println(showName(student.getName()));
			System.out.println(showGender(student.getGender()));
			System.out.println(showDate(student.getDate()));
			System.out.println("=========================");
			breakLine();

	}


	private void showStudentWithRoll(){
		// System.out.println("enter Student's Roll Number that you want to show : ");
		// int rollNum = sc.nextInt();

		int rollNum = getInt("enter Student's Roll Number that you want to show  : ");
		// int index = -1;
		// stuList.forEach(student -> {
		// 	if(student.getRollNum() == rollNum){
		// 		index = stuList.indexOf(student);
				
		// 	}

		// });

		for(Student student : stuList){
			if(student.getRollNum() == rollNum){
				showStudent(student);
				break;
			}
		}

		// if(index == -1){
		// 	System.out.println("the Roll Number that you  entered is not exists.");
		// }else{
		// 	showStudent(stuList.get(index));
		// }
	}

	private String showRollNum(int rollNum){
		return "Roll Number : "+rollNum;
	}

	private String showName(String name){
		return "Name : "+name;
	}

	private String showGender(String gender){
		return "Gender : "+gender;
	}

	private String showDate(Date date){
		return "The registered date is : "+date;
	}



	private int  rollNum(){
		System.out.print("enter Student's RollNum : ");
		return sc.nextInt();
	}

	private String gender(){
		System.out.print("enter Student's Gender : ");
		return sc.next();
	}

	private String name(){
		System.out.print("enter Student's Name : ");
		return new Scanner(System.in).nextLine();
	}

	private void updateStudent(){
		int rollNum = getInt("Enter Student's Roll Number that you want to Update : ");
		for(Student student : stuList){
			if(rollNum == student.getRollNum()){
				student.setRollNum(rollNum());
				student.setName(name());
				student.setGender(gender());
				student.setDate(new Date());
			}
		}


		

	}

	private void deleteStudent(){
		int rollNum = getInt("Enter Student's Roll Number that you want to Delete : ");
		Student deleteStudent =  null;
		for(Student student : stuList){
			if(student.getRollNum() == rollNum){
				deleteStudent = student;
			}
		}
		if( deleteStudent != null){
			stuList.remove(deleteStudent);
		}else{
			deleteStudent();
		}


	}


	public void run(){
		// intro message 
		showMessage("Welcome to Student Register Application.");


		do{
			// show menu
			showMenu();

			// get user's menu chooise
			int menu = getMenu();
			if(menu == 1){
				addStudent();
			}
			if(menu == 2){
				showStudentWithRoll();
			}
			if(menu == 3){
				showAllStudent();
			}
			if(menu == 4){
				updateStudent();
			}
			if(menu == 5){
				deleteStudent();
			}

		}while(!getString("do you want to stop? (enter \"y\" if you want to stop) : ").equalsIgnoreCase("y"));

		showMessage("Bye Bye See you next time.");
		
	}

	private String getString(String message){
		System.out.print(message);
		return new Scanner(System.in).nextLine();

	}

	private int getInt(String message){
		System.out.print(message);
		return sc.nextInt();
	}

	private void showMessage(String message){

		String s = "";
		for(int i = 0 ; i < message.length() ; i++){
			s += "=";
		}

		System.out.println("=="+s+"==");
		System.out.println("= "+message+" =");
		System.out.println("=="+s+"==");


	}

	private void breakLine(){
		System.out.println();
	}




}