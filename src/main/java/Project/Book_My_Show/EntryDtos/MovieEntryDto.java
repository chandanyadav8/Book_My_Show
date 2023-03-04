package Project.Book_My_Show.EntryDtos;

import Project.Book_My_Show.Enums.Genre;
import Project.Book_My_Show.Enums.Language;
import lombok.Data;

import jakarta.persistence.*;


@Data
public class MovieEntryDto {




    private String movieName;

    private double ratings;

    private int duration;


    private Language language;

    private Genre genre;

}
