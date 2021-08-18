package dev.patika.patikahw02.dao;

import org.springframework.stereotype.Repository;

// Service, repository, Controller are annotations of @Component
@Repository
public interface CourseDAO<Course> extends BaseDAO<Course> {
}
