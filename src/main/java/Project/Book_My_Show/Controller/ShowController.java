package Project.Book_My_Show.Controller;

import Project.Book_My_Show.EntryDtos.ShowEntryDto;
import Project.Book_My_Show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;



    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){

           String result=  showService.addShow(showEntryDto);

             return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
