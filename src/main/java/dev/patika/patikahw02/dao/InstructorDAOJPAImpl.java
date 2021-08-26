package dev.patika.patikahw02.dao;

import dev.patika.patikahw02.models.Instructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements InstructorDAO<Instructor> {
    private static final Logger logger = LoggerFactory.getLogger(InstructorDAOJPAImpl.class);
    private final EntityManager entityManager;

    @Autowired
    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructor = this.findById(id);

        if (instructor == null){
            logger.error("Instructor not found with id: " + id);
        }
        entityManager.remove(instructor);

    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    public void delete(Instructor object) {
        entityManager.remove(entityManager.getReference(Instructor.class, object.getId()));
    }
}
