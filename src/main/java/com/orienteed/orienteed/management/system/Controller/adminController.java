package com.orienteed.orienteed.management.system.Controller;
import com.orienteed.orienteed.management.system.Model.updateClientDTO;
import com.orienteed.orienteed.management.system.Model.Client;
import com.orienteed.orienteed.management.system.Service.adminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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




}
/*//        String ind = client.getIndustry();
//        String email = client.getContactEmail();
//        String name  = client.getClientName();
//        if(name == null || name.isEmpty()) {
//            return ResponseEntity.badRequest().build();
//        }
//        try {
//            if( ind== null)
//                return  ResponseEntity.badRequest().body("Industry or contactEmail is null");
//            else if (ind.isEmpty()) {
//                return  ResponseEntity.badRequest().body("Industry or contactEmail is empty");
//            }
//            if(email == null){
//                return  ResponseEntity.badRequest().body("Industry or contactEmail is null");
//            }
//            else if(  email.isEmpty())
//                return  ResponseEntity.badRequest().body("Industry or contactEmail is empty");
//        }
//        catch(Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
*/