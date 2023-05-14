package com.mai.journal.Domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "groups")
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group { //TODO доделать связи

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long headmanId;

    private Long deputyId;

    public Group(String name, Long headmanId, Long deputyId) {
        this.name = name;
        this.headmanId = headmanId;
        this.deputyId = deputyId;
    }

    public Group(String name, Long headmanId) {
        this.name = name;
        this.headmanId = headmanId;
    }
}
