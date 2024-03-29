package Project.Book_My_Show.Controller;

import Project.Book_My_Show.EntryDtos.ShowEntryDto;
import Project.Book_My_Show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;


    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto) {

        String result = showService.addShow(showEntryDto);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/getShowtime/{theater}/{movie}")
    public ResponseEntity<List<LocalTime>> getShowtime(@PathVariable("theater") String theater, @PathVariable("movie") String movie)
    {
        try {
            List<LocalTime> timeList = showService.getShowTime(theater, movie);
            return new ResponseEntity<>(timeList, HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }


}
