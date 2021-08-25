package dev.patika.patikahw02.service;

import dev.patika.patikahw02.dao.InstructorDAO;
import dev.patika.patikahw02.models.Instructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor>{

    private final InstructorDAO instructorDAO;

    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return (Instructor) instructorDAO.findById(id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return (Instructor) instructorDAO.save(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return (Instructor) instructorDAO.update(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        instructorDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Instructor instructor) {
        instructorDAO.delete(instructor);
    }
}
