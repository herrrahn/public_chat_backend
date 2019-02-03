package com.rahn.demo.messagens;

import com.rahn.demo.users.User;
import com.rahn.demo.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MessageController {

    private MessageRepository messageRepository;
    private UserRepository userRepository;

    private static final Float DIFF = 0.01000f; // +-1km

    @Autowired
    public MessageController(MessageRepository messageRepository,
                             UserRepository userRepository){

        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/send")
    public Message sendMessage(
            @RequestParam("user_id") Integer userId,
            @RequestParam(value = "target", defaultValue = "ALL") Target target,
            @RequestParam("message") String message,
            @RequestParam("longitude") Float longitude,
            @RequestParam("latitude") Float latitude
            ){
        Optional<User> user = userRepository.findById(userId);

        return messageRepository.save(new Message(
                user.orElse(null),
                target,
                message,
                longitude,
                latitude));
    }

    @GetMapping("/messages")
    public Iterable<Message> messages(
            @RequestParam(value = "longitude") Float longitude,
            @RequestParam("latitude") Float latitude) {


        return messageRepository.findAllByTargetEqualsAndAndLatitudeBetweenAndLongitudeBetween(Target.ALL,
                latitude - DIFF,
                latitude + DIFF,
                longitude - DIFF,
                longitude + DIFF);
    }

}
