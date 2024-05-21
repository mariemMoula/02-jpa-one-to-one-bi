package com.mimi.cruddemo.dao;

import com.mimi.cruddemo.entity.Instructor;
import com.mimi.cruddemo.entity.InstuctorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AppDaoImpl  implements AppDao{
    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist((theInstructor));
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return  entityManager.find(Instructor.class, theId);

    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor =entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstuctorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstuctorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstuctorDetail tempInstDet =entityManager.find(InstuctorDetail.class, theId);
        // remove the associated object refrence
        // break bi-directional link
        tempInstDet.getInstructor().setInstuctorDetail(null);
        // delete instructor detail
        entityManager.remove(tempInstDet);
    }
}
