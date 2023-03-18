package Project.Book_My_Show.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class AddTheaterResponseDto {

}
//    Extra API's to try to strengthen the concept :
//
//
//        Basic API : getMovieById, GetAllMovies, GetUserName,updatePassword, getTheaterList, getallMovies in a theater.
//
//
//        1. Get Show time for a theater and a movie
//        2. Find the movieName with the Maximum number of Shows across all places combined.
//        3. Get count of unique locations of a theater
//        4. Get the list of theaters Showing a particular time.
//        5. Get All ticket book by a particular user (userId input : get all the ticket booked by Him)
//        6. Cancel Ticket
//        7. Find total collection (revenue) that a particular movie has made in its lifetime (across all theaters combined)
//        8. rate movie Flop or Hit based on collection or ticketBooked
