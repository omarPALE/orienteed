package com.orienteed.orienteed.management.system.Repository;

import com.orienteed.orienteed.management.system.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projectRepo extends JpaRepository<Project, Integer> {
}
