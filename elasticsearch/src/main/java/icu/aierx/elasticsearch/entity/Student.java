package icu.aierx.elasticsearch.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends AbstractPersistable {

    private String studentName;

    private List<Class> classes;
}