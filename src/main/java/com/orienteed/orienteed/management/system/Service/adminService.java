package com.orienteed.orienteed.management.system.Service;


import com.orienteed.orienteed.management.system.Model.Client;
import com.orienteed.orienteed.management.system.Model.updateClientDTO;
import com.orienteed.orienteed.management.system.Repository.clientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class adminService {

    private final clientRepo clientdb;
    @Autowired
    public adminService(clientRepo clientdb) {
        this.clientdb = clientdb;

    }

    public static void assignPM(int userId) {


    }

    public String addService(Client client) {
        clientdb.save(client);
        return "success";

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
