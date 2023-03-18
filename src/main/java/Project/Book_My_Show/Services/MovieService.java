package Project.Book_My_Show.Services;


import Project.Book_My_Show.Convertors.MovieConvertor;
import Project.Book_My_Show.Entities.MovieEntity;
import Project.Book_My_Show.EntryDtos.MovieEntryDto;
import Project.Book_My_Show.Repository.MovieRepository;
import Project.Book_My_Show.ResponseDto.GetMovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String  addMovie(MovieEntryDto movieEntryDto)throws  Exception{

        MovieEntity movieEntity= MovieConvertor.convertEntryDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movies added successfully";
    }
    public GetMovieResponseDto getMovieById(int id) throws Exception
    {
        MovieEntity movie=movieRepository.findById(id).get();
        GetMovieResponseDto ans=new GetMovieResponseDto();
        ans.setId(movie.getId());
        ans.setMovieName(movie.getMovieName());
        ans.setDuration(movie.getDuration());
        ans.setRatings(movie.getRatings());
        ans.setGenre(movie.getGenre());
        ans.setLanguage(movie.getLanguage());
        return ans;
    }
    public List<GetMovieResponseDto>getAllMovies()
    {
        List<MovieEntity> movieList=movieRepository.findAll();
        List<GetMovieResponseDto> movieResponseDtoList=new ArrayList<>();
        for(MovieEntity i:movieList)
        {
            GetMovieResponseDto movieResponseDto=new GetMovieResponseDto();
            movieResponseDto.setId(i.getId());
            movieResponseDto.setMovieName(i.getMovieName());
            movieResponseDto.setDuration(i.getDuration());
            movieResponseDto.setRatings(i.getRatings());
            movieResponseDto.setGenre(i.getGenre());
            movieResponseDto.setLanguage(i.getLanguage());
            movieResponseDtoList.add(movieResponseDto);//adding the movie into the list

    }
        return movieResponseDtoList;
}
}
