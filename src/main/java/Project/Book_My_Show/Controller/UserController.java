package Project.Book_My_Show.Controller;

import Project.Book_My_Show.Entities.UserEntity;
import Project.Book_My_Show.EntryDtos.UserEntryDto;
import Project.Book_My_Show.ResponseDto.GetMovieResponseDto;
import Project.Book_My_Show.ResponseDto.GetUserResponseDto;
import Project.Book_My_Show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDto){

             try{

                 String response= userService.addUser(userEntryDto);
                 return  new ResponseEntity<>(response, HttpStatus.CREATED);

             }catch(Exception e){

                 String result="user could not be added";
                 return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
             }
    }
    @GetMapping("/getUserName/{id}")
    public ResponseEntity<GetUserResponseDto> getUserName(@PathVariable("id")int id)
    {
        try {

            GetUserResponseDto user = userService.getUserName(id);
            return new ResponseEntity<>(user,HttpStatus.FOUND);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.FOUND);
        }

    }

}
