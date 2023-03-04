package Project.Book_My_Show.Convertors;

import Project.Book_My_Show.Entities.TheaterEntity;
import Project.Book_My_Show.EntryDtos.TheaterEntryDto;

public class TheaterConvertor {


    public  static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        return TheaterEntity.builder().location(theaterEntryDto.getLocation()).name(theaterEntryDto.getName()).build();

    }
}
