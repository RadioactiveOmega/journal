package com.mai.journal.Services;

import com.mai.journal.Domain.Group;
import com.mai.journal.Generators.GroupAccessGenerator;
import com.mai.journal.Repos.GroupRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GroupService {
    GroupRepository groupRepository;
    StudentService studentService;

    UserService userService;
    GroupAccessGenerator groupAccessGenerator;

    public String[] registerGroup(String name, int count){
        log.info("Get a request to create new group named {} and have {} students", name, count);

        long countOfStudent = studentService.count();

        log.info("Generating accesses starting with number {}", countOfStudent);
        String[] accesses = groupAccessGenerator.generateAccess(countOfStudent,count);
        log.info("Accesses generated");

        Group group = new Group(name, countOfStudent + 1);
        groupRepository.save(group);
        long groupId = groupRepository.findIdByName(name);
        log.info("Group saved headmanId {} and deputyId {}", accesses[0], accesses[1]);

        for (String s: accesses){
            String[] data = s.split(" ");

            userService.createUser(data[0], data[1]);

            studentService.save(data[0], groupId);

        }
        log.info("All students saved");
        return accesses;
    }
}
