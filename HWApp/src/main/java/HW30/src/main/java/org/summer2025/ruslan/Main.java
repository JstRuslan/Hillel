package org.summer2025.ruslan;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.summer2025.ruslan.dao.GenericDao;
import org.summer2025.ruslan.dao.GenericDaoImp;
import org.summer2025.ruslan.entity.Student;

public class Main {
    public static void main(String[] args) {
        System.out.println("JPA and Hibernate");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hillel-persistence-unit");
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Snow");
        student.setEmail("j.snow@gmail.com");

        GenericDao dao = new GenericDaoImp(emf);

        // save an account
        dao.save(student);

        // get created account from db
        Student newStudent = (Student) dao.findById(1L);
        System.out.println(newStudent);
    }
}