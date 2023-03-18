package Project.Book_My_Show.Services;

import Project.Book_My_Show.Convertors.TheaterConvertor;
import Project.Book_My_Show.Entities.MovieEntity;
import Project.Book_My_Show.Entities.ShowEntity;
import Project.Book_My_Show.Entities.TheaterEntity;
import Project.Book_My_Show.Entities.TheaterSeatEntity;
import Project.Book_My_Show.EntryDtos.TheaterEntryDto;
import Project.Book_My_Show.Enums.SeatType;
import Project.Book_My_Show.ResponseDto.GetMovieResponseDto;
import Project.Book_My_Show.ResponseDto.GetTheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Project.Book_My_Show.Repository.TheaterRepository;
import Project.Book_My_Show.Repository.TheaterSeatRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    TheaterSeatRepository theaterSeatRepository;

    public  String addTheater(TheaterEntryDto theaterEntryDto) throws  Exception{
        /*
        1->created theater
        2-> i need to save theater :I need theaterEntity
        3->Always set the attribute before saving.
         */

           if(theaterEntryDto.getName()==null || theaterEntryDto.getLocation()==null){
               throw  new Exception("name and location should valid");
           }


        TheaterEntity theaterEntity= TheaterConvertor.convertDtoToEntity(theaterEntryDto);

        List<TheaterSeatEntity> theaterSeatEntityList=createTheaterSeats(theaterEntryDto,theaterEntity);


        theaterEntity.setTheaterSeatEntityList(theaterSeatEntityList);

        theaterRepository.save(theaterEntity);

        return "Theater added successfully";
    }

      private  List<TheaterSeatEntity> createTheaterSeats(TheaterEntryDto theaterEntryDto,TheaterEntity theaterEntity){

        int noClassicSeat=theaterEntryDto.getClassicSeatCount();
        int noPremiumSeat= theaterEntryDto.getPremiumSeatCount();

        List<TheaterSeatEntity> theaterSeatEntitiesList=new ArrayList<>();


        //  CLASSIC

        for(int count=1;count<=noClassicSeat;count++){

            // we need to make a new TheaterSeatEntity

            TheaterSeatEntity theaterSeatEntity= TheaterSeatEntity.builder().seatType(SeatType.CLASSIC)
                     .seatNo(count+"C").theaterEntity(theaterEntity).build();

            theaterSeatEntitiesList.add(theaterSeatEntity);

        }

        // PREMIUM

          for(int count=1;count<=noPremiumSeat;count++){

              TheaterSeatEntity theaterSeatEntity=TheaterSeatEntity.builder().seatType(SeatType.PREMIUM)
                      .seatNo(count+"P").theaterEntity(theaterEntity).build();

                 theaterSeatEntitiesList.add(theaterSeatEntity);
          }

                 return  theaterSeatEntitiesList;

      }
      public List<GetTheaterResponseDto>getTheaterList() throws Exception
      {
          List<TheaterEntity>theaterEntityList=theaterRepository.findAll();
          List<GetTheaterResponseDto>getTheaterResponseDtoList=new ArrayList<>();
          for(TheaterEntity i:theaterEntityList)
          {
              GetTheaterResponseDto getTheaterResponseDto=new GetTheaterResponseDto();
              getTheaterResponseDto.setId(i.getId());
              getTheaterResponseDto.setName(i.getName());
              getTheaterResponseDto.setLocation(i.getLocation());
              getTheaterResponseDtoList.add(getTheaterResponseDto);
          }

          return getTheaterResponseDtoList;
      }
    public List<GetMovieResponseDto>getAllMoviesInTheater(String theaterName) {
        TheaterEntity theaterEntity = theaterRepository.findByName(theaterName);
        List<ShowEntity> showEntityList = theaterEntity.getShowEntityList();
        List<GetMovieResponseDto> movieResponseDtoList = new ArrayList<>();
        for (ShowEntity i : showEntityList) {
            GetMovieResponseDto movieResponseDto = new GetMovieResponseDto();
            movieResponseDto.setId(i.getMovieEntity().getId());
            movieResponseDto.setMovieName(i.getMovieEntity().getMovieName());
            movieResponseDto.setDuration(i.getMovieEntity().getDuration());
            movieResponseDto.setRatings(i.getMovieEntity().getRatings());
            movieResponseDto.setGenre(i.getMovieEntity().getGenre());
            movieResponseDto.setLanguage(i.getMovieEntity().getLanguage());
            movieResponseDtoList.add(movieResponseDto);//adding the movie into the list
        }


        return movieResponseDtoList;
    }
}
