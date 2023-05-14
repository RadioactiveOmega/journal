package com.mai.journal.Repos;

import com.mai.journal.Domain.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GroupRepository extends CrudRepository<Group, Long> {
    @Query("SELECT g.id FROM Group g WHERE g.name = :name")
    Long findIdByName(@Param("name") String name);
}
