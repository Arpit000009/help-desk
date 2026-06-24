package com.substring.helpdesk.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class AIService {

    private final ChatClient chatClient;

    public String getResponseFromAssistant(String query){

        //basic call to llm
        return this.chatClient
                .prompt()
                .user(query)
                .call()
                .content();
    }

}
