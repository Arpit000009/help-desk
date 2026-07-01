package com.substring.helpdesk.tools;


import com.substring.helpdesk.DTO.CreateTicketRequest;
import com.substring.helpdesk.entity.Status;
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

    @Tool(description = "This tool helps to create a new ticket in the database.")
    public Ticket createTicketTool(
            @ToolParam(description = "Ticket details")
            CreateTicketRequest request) {

        Ticket ticket = new Ticket();

        ticket.setSummary(request.getSummary());
        ticket.setDescription(request.getDescription());
        ticket.setEmail(request.getEmail());
        ticket.setCategory(request.getCategory());
        ticket.setPriority(request.getPriority());

        // Backend-managed field
        ticket.setStatus(Status.OPEN);

        return ticketService.createTicket(ticket);
    }

    //get ticket using username
    @Tool(description = "this tool helps to get ticket by username.")
    public Ticket getTicketByUserName(@ToolParam(description = "email id whose ticket is required") String email){
        return ticketService.getTicketByEmailId(email);
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
