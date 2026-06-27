package com.substring.helpdesk.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class AiConfig {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(AiConfig.class);

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, JdbcChatMemoryRepository jdbcChatMemoryRepository){

        //chat memory ko create kar sakte hain

        var chatMemory = MessageWindowChatMemory.builder()
                        .chatMemoryRepository(jdbcChatMemoryRepository)
                        .maxMessages(15)
                                .build();

        logger.info("chatClient bean created");
        logger.info("chat memery bean created. {}",chatMemory.getClass().getName());

        return builder
                .defaultSystem("sumarize the response within 400 words.")

                .defaultAdvisors(new SimpleLoggerAdvisor(), MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }
}
