package edu.icet.ecom.Service;

import edu.icet.ecom.Model.Dto.event_dto;
import edu.icet.ecom.Model.Dto.registration_dto;
import edu.icet.ecom.Model.Entity.event_entity;
import edu.icet.ecom.Model.Entity.registration_entity;
import edu.icet.ecom.Repository.registration_Repository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class registration_Service {
    ModelMapper modelMapper = new ModelMapper();


    @Autowired
    registration_Repository registrationRepository;

    public List<registration_dto> getalRegister() {
        List<registration_entity> registerlist= registrationRepository.findAll();
        return registerlist.stream()
                .map((element) -> modelMapper.map(element, registration_dto.class))
                .toList();
    }

    public void addRegistration(registration_dto registration) {
        registration_entity model = modelMapper.map(registration, registration_entity.class);
        registrationRepository.save(model);
    }

    public void deleteregister(String id) {
        if (registrationRepository.existsById(id)) {
            registrationRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found with ID: " + id);
        }


    }

    public registration_dto updateRegister(String id, registration_dto register) {
        registration_entity existingRegister = registrationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Event not found with ID: " + id));
        existingRegister.setName(register.getName());
        existingRegister.setEmail(register.getEmail());
        existingRegister.setRegisteredAt(register.getRegisteredAt());
        registration_entity updateRegister = registrationRepository.save(existingRegister);

        // Return updated DTO
        return modelMapper.map(updateRegister, registration_dto.class);
    }
}
