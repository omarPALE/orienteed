package com.orienteed.orienteed.management.system.Service;


import com.orienteed.orienteed.management.system.Model.Client;
import com.orienteed.orienteed.management.system.Model.Project;
import com.orienteed.orienteed.management.system.Model.User;
import com.orienteed.orienteed.management.system.Model.updateClientDTO;
import com.orienteed.orienteed.management.system.Repository.clientRepo;
import com.orienteed.orienteed.management.system.Repository.projectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class adminService {

    private final clientRepo clientdb;
    private final projectRepo projecdb;

    @Autowired
    public adminService(clientRepo clientdb, projectRepo projecdb) {
        this.clientdb = clientdb;
        this.projecdb = projecdb;
    }



    public String addService(Client client) {
        clientdb.save(client);
        return "success";

    }
    public void assignPM(int userId, int projId) {
        Project project = projecdb.findById(projId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.setUser(new User(userId));
        projecdb.save(project);
        System.out.println(project.toString());

    }

    public ResponseEntity<?> UpdateService(updateClientDTO client) {
        String ind = client.getIndustry();
        String email = client.getContactEmail();
        String name  = client.getClientName();

             Client c = clientdb.findByClientName(client.getClientName());
        if(c==null) return ResponseEntity.notFound().build();
        if(ind != null)
            c.setIndustry(ind);
        if(email != null)
            c.setContactEmail(email);
        clientdb.save(c);

        return ResponseEntity.ok("success");
    }

    public ResponseEntity<?> deleteClient(String name) {
        int id =clientdb.findByClientName(name).getClientId();
//        Client c =new Client();
//        c  = clientdb.findByClientName(name);
//        System.out.println(c.toString());

        if( clientdb.findByClientName(name).getClientId()==id) {
            clientdb.deleteById(id);
            return ResponseEntity.ok("success");
        }
        else return ResponseEntity.notFound().build();
    }
}
