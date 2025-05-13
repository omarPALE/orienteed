package com.orienteed.orienteed.management.system.Repository;

import com.orienteed.orienteed.management.system.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User, Long> {


}
