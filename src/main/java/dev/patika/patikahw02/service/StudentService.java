package dev.patika.patikahw02.service;

import dev.patika.patikahw02.dao.StudentDAO;
import dev.patika.patikahw02.models.Student;
import dev.patika.patikahw02.models.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements BaseService<Student>{

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return (Student) studentDAO.findById(id);
    }

    @Override
    public Student save(Student student) {
        return (Student) studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return (Student) studentDAO.update(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }
}
