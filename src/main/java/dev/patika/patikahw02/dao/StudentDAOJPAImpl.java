package dev.patika.patikahw02.dao;

import dev.patika.patikahw02.models.Student;
import dev.patika.patikahw02.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements StudentDAO<Student>{
    private static final Logger logger = LoggerFactory.getLogger(StudentDAOJPAImpl.class);
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student i", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = this.findById(id);

        if (student == null){
            logger.error("Student not found with id: " + id);
        }
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }
}
