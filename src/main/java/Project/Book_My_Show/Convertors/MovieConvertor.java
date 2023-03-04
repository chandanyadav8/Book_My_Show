package Project.Book_My_Show.Convertors;

import Project.Book_My_Show.Entities.MovieEntity;
import Project.Book_My_Show.EntryDtos.MovieEntryDto;

public class MovieConvertor {

    public  static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity=MovieEntity.builder().movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration()).genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage()).ratings(movieEntryDto.getRatings()).build();

        return  movieEntity;

    }
}
