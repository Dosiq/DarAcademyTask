package kz.dar.university.datastoreapi.controllers;

import kz.dar.university.datastoreapi.DTO.EventDTO;
import kz.dar.university.datastoreapi.model.Event;
import kz.dar.university.datastoreapi.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {


    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/check")
    public String healthCheck(){
        return "event";
    }

    @GetMapping("/all")
    public List<Event> getAll(){
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable Long id){
        return eventService.getEventById(id);
    }

//    @GetMapping("/filter")
//    public List<Event> getFilterEvents(Category category, String section){
//        return eventService.getFilterEvents(category, section);
//    }

    @PostMapping
    public Event createEvent(@RequestBody Event event){

        return eventService.createNewEvent(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent){
        return eventService.updateEvent(id, updatedEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id){
        eventService.deleteEvent(id);
    }



}
