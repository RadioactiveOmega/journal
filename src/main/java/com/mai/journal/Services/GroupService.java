package com.mai.journal.Services;

import com.mai.journal.Repos.GroupRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class GroupService {
    GroupRepository groupRepository;
}
