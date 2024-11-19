package com.jdbcStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
	
	List<Student> studentList = new ArrayList<>();
    
	private final String INSERT_QUERY = "insert into student(fname,lname,email,mobile) values(?,?,?,?)";
	private final String FETCH_ALL_QUERY = "select * from student";
	private final String FETCH_SPECIFIC_ID_QUERY = "select * from student where id = ?";
	private final String UPDATE_QUERY = "update student set email = ? where id = ?";
	private final String DELETE_QUERY= "Delete from student where id = ?";

	
	private String url = "jdbc:mysql://localhost:3306/db";
	private String user = "root";
	private String password = "root";
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet resultSet;
	private Student s;
	
	public StudentDAOImpl(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,password);
			System.out.println("SuccessFull");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(Student s) {
		// TODO Auto-generated method stub
	 try {
		 pstmt = con.prepareStatement(INSERT_QUERY);
		 pstmt.setString(1,s.getFname());
		 pstmt.setString(2,s.getLname());
		 pstmt.setString(3,s.getEmail());
		 pstmt.setInt(4,s.getMobile());
		 
		 status = pstmt.executeUpdate();
		 
		 if(status != 0) {
			 System.out.println("SuccesFull Insert");
		 }
		 else {
			 System.out.println("Failer Insert");
		 }
		 
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
		
		
	}


	@Override
	public List<Student>  fetchAll() {
		// TODO Auto-generated method stub
		try {
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(FETCH_ALL_QUERY); 
			studentList = extractStudentFromResultSet(resultSet); 
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return studentList;
		
	}
	
	List<Student>  extractStudentFromResultSet(ResultSet resultSet ) {
		  try {
			  while(resultSet.next()) {
					studentList.add(new Student(resultSet.getInt("id"),
							resultSet.getString("fname"),
							resultSet.getString("lname"),
							resultSet.getString("email"),
							resultSet.getInt("mobile")
							));
					
				} 
			  
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return studentList;
	  }


	@Override
	public Student fetchSpecificId(int id) {
		// TODO Auto-generated method stub
		
		try {
			pstmt = con.prepareStatement(FETCH_SPECIFIC_ID_QUERY);
			pstmt.setInt(1, id);
			resultSet = pstmt.executeQuery();
			studentList = extractStudentFromResultSet(resultSet);
			if(! studentList.isEmpty()) {
				s = studentList.get(0);
			}
			else {
				System.out.println("No Record");
				System.exit(0);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}


	@Override
	public int update(Student s) {
		// TODO Auto-generated method stub
		try {
			pstmt =pstmt = con.prepareStatement(UPDATE_QUERY);
			pstmt.setString(1, s.getEmail());
			pstmt.setInt(2,s.getId());
			status = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}


	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {
			pstmt = con.prepareStatement(DELETE_QUERY);
			pstmt.setInt(1,id);
			status = pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
