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

    @Column(name = "login")
    private String login;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
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

    public Student(String login, Long groupId) {
        this.login = login;
        this.groupId = groupId;
    }
}
