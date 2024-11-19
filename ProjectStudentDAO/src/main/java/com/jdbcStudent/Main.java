package com.jdbcStudent;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      StudentDAO  sdao = new StudentDAOImpl();
//      
      // Insert Student Details
	   Student StudentInsert = new Student("Mohamed","Jameer","jameer07@gmail",123456);
     sdao.insert(StudentInsert);
      
      
      // Fetch All Student
     List<Student> studentList = sdao.fetchAll();
      for(Student studentFetchAll : studentList) {    
    	  System.out.println( studentFetchAll );
      }
      
      
      //Fetch Specific Id
       Student studentFetchSpecificId =  sdao.fetchSpecificId(2);
       System.out.println(studentFetchSpecificId );
      
      
         // Update Student
     Student studentUpdate = new Student(1,"jameer07@gmail");
      int x = sdao.update(studentUpdate);
      if(x!=0) {
    	   System.out.println("SuccessFully Update");
    	   }
      
      
      // Delete Student
      int y = sdao.delete(1);
    if(y!=0) {
 	   System.out.println("SuccessFully Delete");
    } 
	}

}
