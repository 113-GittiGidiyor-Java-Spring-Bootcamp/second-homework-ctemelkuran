package dev.patika.patikahw02.service;


import dev.patika.patikahw02.dao.CourseDAO;
import dev.patika.patikahw02.models.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService implements BaseService<Course>{

    private CourseDAO CourseDAOJPA;

    public CourseService(@Qualifier("courseDAOHibernateImpl") CourseDAO CourseDAOJPA) {
        this.CourseDAOJPA = CourseDAOJPA;
    }

    @Override
    public List<Course> findAll() {
        return CourseDAOJPA.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) CourseDAOJPA.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course Course) {
        return (Course) CourseDAOJPA.save(Course);
    }

    @Override
    public void deleteById(int id) {

    }
}
