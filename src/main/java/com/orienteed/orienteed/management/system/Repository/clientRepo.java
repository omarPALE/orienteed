package com.orienteed.orienteed.management.system.Repository;
import com.orienteed.orienteed.management.system.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepo extends JpaRepository <Client, Integer> {


    Client findByClientName(String name);
}
