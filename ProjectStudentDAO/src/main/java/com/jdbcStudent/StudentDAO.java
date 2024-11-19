package com.jdbcStudent;

import java.util.List;

public interface StudentDAO {
   void insert(Student s);
   List<Student> fetchAll();
   Student fetchSpecificId(int i);
   int update(Student s);
   int delete(int i);
}
