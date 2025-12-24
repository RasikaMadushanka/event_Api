package edu.icet.ecom.Controller;

import edu.icet.ecom.Model.Dto.event_dto;
import edu.icet.ecom.Model.Dto.registration_dto;
import edu.icet.ecom.Service.registration_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
public class registration_Controller {
    @Autowired
    registration_Service registrationService;
    @GetMapping("/all")
    public List<registration_dto>getallRegistration(){
        return registrationService.getalRegister();
    }
    @PostMapping("/add")
    public void addRegistration(@RequestBody registration_dto registration){
       registrationService.addRegistration(registration);

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<registration_dto> updateregister(@PathVariable String id, @RequestBody registration_dto register) {
        registration_dto updateregister = registrationService.updateRegister(id, register);
        return ResponseEntity.ok(updateregister);
    }
    @DeleteMapping("/{id}")
    public void deleteRegister(@PathVariable String id) {
        registrationService.deleteregister(id);
    }

}
