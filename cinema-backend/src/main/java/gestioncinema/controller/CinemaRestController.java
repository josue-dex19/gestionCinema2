package gestioncinema.controller;

import gestioncinema.dao.*;
import gestioncinema.entity.Ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired ProjectionRepository projectionRepository;

    @PostMapping("buyTickets")
    @Transactional
    public List<Ticket> buyTicket(@RequestBody TicketForm ticketForm) {
        List<Ticket> tickets = new ArrayList<>();

        ticketForm.getTickets().forEach( idTicket -> {
            Ticket ticket = ticketRepository.findById(idTicket).get();
            ticket.setNameClient(ticketForm.getNameClient());
            ticket.setReserve(true);
            ticket.setPaymentCode(ticketForm.getCodePayment());

            Ticket savedTicket = ticketRepository.save(ticket);
            tickets.add(savedTicket);
        });
        return tickets;
    }

    @DeleteMapping("deleteCinemas/{id}/{idCity}")
    @Transactional
    public void deleteCinema(@PathVariable("id") Long id,
                             @PathVariable("idCity") Long idCity) {
        cinemaRepository.deleteCinemaByIdAndCityId(id, idCity);
    }
}
class TicketForm {
    private List<Long> tickets = new ArrayList<>();
    private String nameClient;
    private String codePayment;

    public TicketForm() {
    }

    public TicketForm(List<Long> tickets, String nameClient, String codePayment) {
        this.tickets = tickets;
        this.nameClient = nameClient;
        this.codePayment = codePayment;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getCodePayment() {
        return codePayment;
    }

    public void setCodePayment(String codePayment) {
        this.codePayment = codePayment;
    }
}
