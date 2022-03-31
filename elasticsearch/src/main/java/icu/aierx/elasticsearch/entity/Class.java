package icu.aierx.elasticsearch.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/3/19
 */
@Entity
@Table(name = "db_class")
public class Class {
    @Id
    @GeneratedValue(generator = "uuid")
    private Long classId;

    private String className;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "db_class_students",
            joinColumns = @JoinColumn(name = "class_class_id", referencedColumnName = "students_id"))
    private List<Student> students = new java.util.ArrayList<>();

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
