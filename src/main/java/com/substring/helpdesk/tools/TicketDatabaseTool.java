package com.substring.helpdesk.tools;


import com.substring.helpdesk.entity.Ticket;
import com.substring.helpdesk.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {
    private final TicketService ticketService;

    @Tool(description = "This tool helps to create new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket details") Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    //get ticket using username
    @Tool(description = "this tool helps to get ticket by username.")
    public Ticket getTicketByUserName(@ToolParam(description = "username whose ticket is required") String username){
        return ticketService.getTicketByUsername(username);
    }

    @Tool(description= "this tool helps to update ticket.")
    public Ticket updateTicket(@ToolParam(description = "new ticket details with ticket id.") Ticket ticket){
        return ticketService.updateTicket(ticket);
    }

    // get current system time

    @Tool(description = "This tool helps to get current system time")
    public String getCurrentTime(){
        return String.valueOf(System.currentTimeMillis());
    }
}
