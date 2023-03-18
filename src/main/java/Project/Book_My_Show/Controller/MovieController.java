package Project.Book_My_Show.Controller;
import Project.Book_My_Show.EntryDtos.MovieEntryDto;
import Project.Book_My_Show.ResponseDto.GetMovieResponseDto;
import Project.Book_My_Show.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping("/add")

    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){


        try{

            String result= movieService.addMovie(movieEntryDto);
            return  new ResponseEntity<>(result, HttpStatus.CREATED);

        }catch (Exception e){

            String response="Movie not added";
            return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        } }
    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<GetMovieResponseDto> getMovieById(@PathVariable("id")int id)
    {
        try {

            GetMovieResponseDto movie = movieService.getMovieById(id);
            return new ResponseEntity<>(movie,HttpStatus.FOUND);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.FOUND);
        }

    }
    @GetMapping("getAllMovies")
    public ResponseEntity<List<GetMovieResponseDto>> getAllMovies()
    {
        try{
            List<GetMovieResponseDto>movieList=movieService.getAllMovies();
            return new ResponseEntity<>(movieList,HttpStatus.FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



}
