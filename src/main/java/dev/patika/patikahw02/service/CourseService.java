package dev.patika.patikahw02.service;


import dev.patika.patikahw02.dao.CourseDAO;
import dev.patika.patikahw02.models.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Business Logic is created around the Service
@Service
public class CourseService implements BaseService<Course>{

    private final CourseDAO courseDAO;

    // Since there are two beans we chose one inside @Qualifier
    public CourseService(@Qualifier("courseDAOJPAImpl") CourseDAO CourseDAO) {
        this.courseDAO = CourseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course Course) {
        return (Course) courseDAO.save(Course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Course update(Course Course) {
        return (Course) courseDAO.update(Course);
    }
}
