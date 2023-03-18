package Project.Book_My_Show.ResponseDto;

import Project.Book_My_Show.Entities.ShowEntity;
import Project.Book_My_Show.Enums.Genre;
import Project.Book_My_Show.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedNotifications;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetMovieResponseDto {

    private int id;

    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;

}
