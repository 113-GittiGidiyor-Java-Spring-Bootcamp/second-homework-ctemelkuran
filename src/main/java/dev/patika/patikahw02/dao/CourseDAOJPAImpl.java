package dev.patika.patikahw02.dao;


import dev.patika.patikahw02.models.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO<Course> {

    private static final Logger logger = LoggerFactory.getLogger(CourseDAOJPAImpl.class);
    private final EntityManager entityManager;

    // Used constructor injection
    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // to get multiple data we need a Query
    // Adding Hibernate Framework Support solves the 'FROM' unexpected error
    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course e", Course.class).getResultList();
    }


    @Override
    public Course findById(int id) {

        return entityManager.find(Course.class, id);
    }


    // merge, is like persist, but it saves if the data doesn't exist updates if it exists.
    // Merge comprises persist
    // @Transactional provides begin(), commit() and close()
    @Override
    @Transactional
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Course course = this.findById(id);

        if(course == null){
            logger.error("Course not found with id: " + id);
        }
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public Course update(Course course){
        return entityManager.merge(course);
    }
}
