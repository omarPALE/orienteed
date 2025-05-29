package com.orienteed.orienteed.management.system.Controller;
import com.orienteed.orienteed.management.system.Model.User;
import com.orienteed.orienteed.management.system.Model.updateClientDTO;
import com.orienteed.orienteed.management.system.Model.Client;
import com.orienteed.orienteed.management.system.Service.adminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;



@RestController
public class adminController {


    private final adminService adminservice;

    @Autowired
    public adminController(adminService adminservice) {
        this.adminservice = adminservice;
    }


    @PostMapping("/addClient")
    @PreAuthorize("hasRole('admin')")
    public String addClient(@Valid @RequestBody Client client) {
        return adminservice.addService(client);
    }

    @PatchMapping("/updateClientInfo")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> updateClientInfo( @RequestBody updateClientDTO dto) {
        if(dto.getIndustry() == null && dto.getContactEmail() == null)
            return  ResponseEntity.badRequest().body("Industry and contactEmail is null");
        else if(dto.getContactEmail().isEmpty() && dto.getIndustry().isEmpty())
            return  ResponseEntity.badRequest().body("Industry and contactEmail is empty");

        return adminservice.UpdateService(dto);
    }


    @DeleteMapping("/deleteClient")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> deleteClient(@RequestBody Client c) {

    return adminservice.deleteClient(c.getClientName());
    }

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> assignProjectManger(@RequestBody User user, @RequestParam int projId){

        adminService.assignPM(user.getUserId());
        return ResponseEntity.ok().build();
    }


}
