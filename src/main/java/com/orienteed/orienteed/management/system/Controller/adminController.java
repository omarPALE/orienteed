package com.orienteed.orienteed.management.system.Controller;
import com.orienteed.orienteed.management.system.Model.User;
import com.orienteed.orienteed.management.system.Model.updateClientDTO;
import com.orienteed.orienteed.management.system.Model.Client;
import com.orienteed.orienteed.management.system.Service.adminService;
import com.orienteed.orienteed.management.system.Service.projectService;
import com.orienteed.orienteed.management.system.Service.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;



@RestController
public class adminController {


    private final adminService adminservice;
    private final projectService projectservice;
    private final userService userservice;
    @Autowired
    public adminController(adminService adminservice, projectService projectservice, userService userservice) {
        this.adminservice = adminservice;
        this.projectservice = projectservice;
        this.userservice = userservice;
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

    @PostMapping("/assignPm")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> assignProjectManger(@RequestBody User user, @RequestParam int projId){

        if(  !projectservice.validProject(projId)  )

            return  ResponseEntity.badRequest().body("Invalid project ID");
        if( userservice.isProjectMangerUser(user.getUserId()) ){
            adminservice.assignPM(user.getUserId(), projId);
        }
        else
            return  ResponseEntity.badRequest().body("this user do not had permission to be project manager.");

        return ResponseEntity.ok().build();
    }


}
