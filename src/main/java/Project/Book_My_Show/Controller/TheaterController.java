package Project.Book_My_Show.Controller;

import Project.Book_My_Show.Entities.TheaterEntity;
import Project.Book_My_Show.EntryDtos.TheaterEntryDto;
import Project.Book_My_Show.ResponseDto.GetMovieResponseDto;
import Project.Book_My_Show.ResponseDto.GetTheaterResponseDto;
import Project.Book_My_Show.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {


    @Autowired
    TheaterService theaterService;


     @PostMapping("/add")
    public ResponseEntity  addTheater(@RequestBody TheaterEntryDto theaterEntryDto){


        try {
            String result= theaterService.addTheater(theaterEntryDto);
             return  new ResponseEntity<>(result, HttpStatus.CREATED);

        }catch (Exception e){

              return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getTheaterList")
    public ResponseEntity<List<GetTheaterResponseDto>> getTheaterList(){
         try{
             List<GetTheaterResponseDto>TheaterResponseDtolist=theaterService.getTheaterList();
             return new ResponseEntity<>(TheaterResponseDtolist,HttpStatus.FOUND);
         }
         catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("getAllMoviesInTheater/{theaterName}")
    public ResponseEntity<List<GetMovieResponseDto>> getAllMoviesInTheater(@PathVariable("theaterName")String theaterName)
    {
        try{
            List<GetMovieResponseDto>movieList=theaterService.getAllMoviesInTheater(theaterName);
            return new ResponseEntity<>(movieList,HttpStatus.FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
