package dev.patika.patikahw02.dao;


import dev.patika.patikahw02.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {

    private EntityManager entityManager;

    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // to get a list we need a Query
    // Adding Hibarnate Framework Support solves the 'FROM' unexpected error
    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course e", Course.class).getResultList();
    }


    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public Course save(Course Course) {
        return entityManager.merge(Course);
    }

    @Override
    public void deleteById(int id) {

    }
}
