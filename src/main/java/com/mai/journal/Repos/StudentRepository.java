package com.mai.journal.Repos;

import com.mai.journal.Domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
