package com.mai.journal.Domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    private String patronymic;

    @Column(nullable = false)
    private Long groupId;

    public Student(String name, String surname, String patronymic, Long groupId) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.groupId = groupId;
    }

    public Student(String name, String surname, Long groupId) {
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
    }
}
