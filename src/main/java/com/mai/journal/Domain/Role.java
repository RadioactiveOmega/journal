package com.mai.journal.Domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,                   //Для студентов
    LECTURER,               //Для преподавателей
    HEAD_OF_DEPARTMENT,     //Для начальника кафедры
    ADMIN;                  //Роль со всеми возможностями


    @Override
    public String getAuthority() {
        return name();
    }
}
