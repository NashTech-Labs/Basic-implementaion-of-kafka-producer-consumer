package com.controller;



import com.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafkaapp")
public class KafkaController {

    @Autowired
    Producer producer;

    @GetMapping(value="/post")
    public String sendMessage(@RequestParam("Message") String msg) {

        producer.publishToTopic(msg);
        return "Publish Successfuly";
    }
}