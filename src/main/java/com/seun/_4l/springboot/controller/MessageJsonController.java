package com.seun._4l.springboot.controller;

import com.seun._4l.springboot.dto.User;
import com.seun._4l.springboot.publisher.RabbitMQJsonProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class MessageJsonController {
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent successfully....");
    }
}
