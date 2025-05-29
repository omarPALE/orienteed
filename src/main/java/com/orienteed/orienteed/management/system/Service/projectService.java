package com.orienteed.orienteed.management.system.Service;

import com.orienteed.orienteed.management.system.Repository.projectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class projectService {
    private final projectRepo projectdb;

    @Autowired
    public projectService(projectRepo projectdb) {
        this.projectdb = projectdb;
    }

    public boolean validProject(int projId) {

        return projectdb.existsById(projId);

  }
}
