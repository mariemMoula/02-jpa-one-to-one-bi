package com.mimi.cruddemo.dao;


import com.mimi.cruddemo.entity.Instructor;
import com.mimi.cruddemo.entity.InstuctorDetail;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstuctorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
