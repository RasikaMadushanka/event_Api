package edu.icet.ecom.Service;


import edu.icet.ecom.Model.Dto.event_dto;
import edu.icet.ecom.Model.Entity.event_entity;
import edu.icet.ecom.Repository.event_Repository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class event_Service {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    event_Repository eventRepository;

    public void addevent(event_dto event) {
        event_entity model = modelMapper.map(event, event_entity.class);
        eventRepository.save(model);

    }

    public event_dto updateevent(String id, event_dto event) {
        // Check if event exists
        event_entity existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Event not found with ID: " + id));

        // Update fields (only those you want to allow updating)
        existingEvent.setTitle(event.getTitle());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setDate(event.getDate());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setCapacity(event.getCapacity());
        existingEvent.setStatus(event.getStatus());
        event_entity updatedEvent = eventRepository.save(existingEvent);

        // Return updated DTO
        return modelMapper.map(updatedEvent, event_dto.class);
    }

    public void deleteevent(String id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found with ID: " + id);
        }
    }

    public List<event_dto> getAllEvents() {
        List<event_entity> eventList = eventRepository.findAll();
        return eventList.stream()
                .map((element) -> modelMapper.map(element, event_dto.class))
                .toList();
    }
}
