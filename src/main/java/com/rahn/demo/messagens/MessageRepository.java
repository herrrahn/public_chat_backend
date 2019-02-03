package com.rahn.demo.messagens;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface MessageRepository extends CrudRepository<Message, UUID> {
    public Iterable<Message> findAllByTargetEqualsAndAndLatitudeBetweenAndLongitudeBetween(Target target, Float la1, Float la2, Float lon1, Float lon2);

}