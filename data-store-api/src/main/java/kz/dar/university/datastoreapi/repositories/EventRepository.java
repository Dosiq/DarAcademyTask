package kz.dar.university.datastoreapi.repositories;

import kz.dar.university.datastoreapi.model.Category;
import kz.dar.university.datastoreapi.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
//    List<Event> findBySectionAndCategory(String section, Category category);
//
//    List<Event> findBySection(String section);

    List<Event> findByCategory(Category category);



}
