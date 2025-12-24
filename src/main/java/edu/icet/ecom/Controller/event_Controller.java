package edu.icet.ecom.Controller;

import edu.icet.ecom.Model.Dto.event_dto;
import edu.icet.ecom.Service.event_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")

public class event_Controller {

    @Autowired
     event_Service eventService;
    @PostMapping("/add")
    public void addEvent(@RequestBody event_dto event) {
        eventService.addevent(event);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<event_dto> updateEvent(@PathVariable String id, @RequestBody event_dto event) {
        event_dto updatedEvent = eventService.updateevent(id, event);
        return ResponseEntity.ok(updatedEvent);
    }
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteevent(id);
    }
    @GetMapping("/all")
    public List<event_dto> getAllEvents() {
        return eventService.getAllEvents();
    }

}

