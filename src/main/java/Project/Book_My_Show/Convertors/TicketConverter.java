package Project.Book_My_Show.Convertors;

import Project.Book_My_Show.Entities.TicketEntity;
import Project.Book_My_Show.EntryDtos.TicketEntryDto;

public class TicketConverter {


 public  static TicketEntity convertEntryToEntity(TicketEntryDto ticketEntryDto){

       TicketEntity ticketEntity=new TicketEntity();
       return  ticketEntity;

 }

}
