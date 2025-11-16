package org.summer2025.ruslan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "mark")
    private int mark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @Override
    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;

        Homework homework = (Homework) ob;

        return Objects.equals(id, homework.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", mark='" + mark + '\'' +
                ", student_id=" + student +
                '}';
    }
}
