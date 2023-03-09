package Project.Book_My_Show.EntryDtos;


import Project.Book_My_Show.Enums.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {

   private LocalDate showDate;
    private LocalTime showTime;
    private ShowType showType;
    private  int movieId;
    private int theaterId;
    private  int classicSeatPrice;
    private  int premiumSeatPrice;
}
