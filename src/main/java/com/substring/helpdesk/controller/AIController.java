package com.substring.helpdesk.controller;

import com.substring.helpdesk.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/helpdesk")
@RequiredArgsConstructor
public class AIController {

    private final AIService service;

    @PostMapping
    public ResponseEntity<String >  getResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return ResponseEntity.ok(service.getResponseFromAssistant(query,conversationId));
    }

    @PostMapping("/stream")
    public Flux<String> stringResponse(@RequestBody String query, @RequestHeader("Conversation")String conversationId){
        return this.service.streamResponseFromAAssistant(query,conversationId);
    }
}
