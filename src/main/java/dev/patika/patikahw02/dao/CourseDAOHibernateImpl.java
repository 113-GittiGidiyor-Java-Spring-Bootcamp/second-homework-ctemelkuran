package dev.patika.patikahw02.dao;

import dev.patika.patikahw02.models.Course;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOHibernateImpl implements CourseDAO<Course> {

    private EntityManager entityManager;

    public CourseDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course Course) {
        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(Course);
    }

    @Override
    public void deleteById(int id) {

    }
}
