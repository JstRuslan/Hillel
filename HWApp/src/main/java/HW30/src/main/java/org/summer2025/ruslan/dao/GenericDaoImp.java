package org.summer2025.ruslan.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Objects;

public class GenericDaoImp<Student, Long> implements GenericDao<Student, Long> {
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public GenericDaoImp(EntityManagerFactory emf) {
        this.emf = emf;
        entityManager = this.emf.createEntityManager();
    }

    @Override
    public void save(Student entity) {
//        Objects.requireNonNull(entity, "Parameter [student] must not be null!");
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
        entityManager.persist(entity);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println("Rollback transaction");
        }
    }

    @Override
    public Student findById(Long id) {
        return (Student) entityManager
                .createQuery("SELECT s FROM Student s WHERE s.id = :id", org.summer2025.ruslan.entity.Student.class)
                .setParameter("id", Objects.requireNonNull(id))
                .getSingleResult();
    }

    @Override
    public Student findByEmail(String email) {
        TypedQuery<Student> query = (TypedQuery<Student>) entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.email = :email", org.summer2025.ruslan.entity.Student.class);
        query.setParameter("email", email);
        Student student = query.getSingleResult();
    return student;
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
