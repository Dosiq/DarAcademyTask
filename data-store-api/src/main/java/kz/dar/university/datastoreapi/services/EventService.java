package kz.dar.university.datastoreapi.services;

import kz.dar.university.datastoreapi.DTO.EventDTO;
import kz.dar.university.datastoreapi.model.Event;
import kz.dar.university.datastoreapi.repositories.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {


    private final EventRepository eventRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event createNewEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id).orElse(null);

        if(existingEvent != null){
//            modelMapper.map(updatedEvent, existingEvent);
            existingEvent.setTitle(updatedEvent.getTitle());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setDateOfStart(updatedEvent.getDateOfStart());
            existingEvent.setDateOfEnd(updatedEvent.getDateOfEnd());
//            existingEvent.setImage(updatedEvent.getImage());
            existingEvent.setCategory(updatedEvent.getCategory());
            existingEvent.setVotes(updatedEvent.getVotes());
//            existingEvent.setOwner(updatedEvent.getOwner());

            eventRepository.save(existingEvent);
        }

        return existingEvent;

    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}
