package Project.Book_My_Show.Services;


import Project.Book_My_Show.Convertors.MovieConvertor;
import Project.Book_My_Show.Entities.MovieEntity;
import Project.Book_My_Show.EntryDtos.MovieEntryDto;
import Project.Book_My_Show.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String  addMovie(MovieEntryDto movieEntryDto)throws  Exception{

        MovieEntity movieEntity= MovieConvertor.convertEntryDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movies added successfully";
    }
}
