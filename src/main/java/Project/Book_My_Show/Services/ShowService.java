package Project.Book_My_Show.Services;
import Project.Book_My_Show.Convertors.ShowConvertors;
import Project.Book_My_Show.Entities.*;
import Project.Book_My_Show.EntryDtos.ShowEntryDto;
import Project.Book_My_Show.Enums.SeatType;
import Project.Book_My_Show.Repository.MovieRepository;
import Project.Book_My_Show.Repository.ShowRepository;
import Project.Book_My_Show.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Project.Book_My_Show.Repository.TheaterRepository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class ShowService {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowEntryDto showEntryDto)
    {
        //1. Create a showEntity
        ShowEntity showEntity = ShowConvertors.convertEntryToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();


        //Setting the attribute of foreignKe
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        //Pending attributes the listOfShowSeatsEnity

        List<ShowSeatEntity> seatEntityList = createShowSeatEntity(showEntryDto,showEntity);

        showEntity.setListOfShowSeats(seatEntityList);


        //Now we  also need to update the parent entities


        showEntity = showRepository.save(showEntity);

        movieEntity.getShowEntityList().add(showEntity);
        theaterEntity.getShowEntityList().add(showEntity);


        movieRepository.save(movieEntity);

        theaterRepository.save(theaterEntity);

        return "The show has been added successfully";

    }
    private  List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity){


        //Now the goal is to create the ShowSeatEntity
        //We need to set its attribute

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();

        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());

            else
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity); //parent : foreign key for the showSeat Entity

            seatEntityList.add(showSeatEntity); //Adding it to the list
        }
        return  seatEntityList;
    }
    public List<LocalTime> getShowTime(String theater, String movie) throws Exception
    {
        TheaterEntity theaterEntity=theaterRepository.findByName(theater);
        List<ShowEntity>showEntityList=theaterEntity.getShowEntityList();
        List<LocalTime>timeList=new ArrayList<>();
        for(ShowEntity i:showEntityList){
            if(i.getMovieEntity().getMovieName().equals(movie))
            {
                timeList.add(i.getShowTime());
            }

        }
        return timeList;
    }
}
