package Project.Book_My_Show.Convertors;

import Project.Book_My_Show.Entities.ShowEntity;
import Project.Book_My_Show.EntryDtos.ShowEntryDto;

public class ShowConvertors {

    public  static ShowEntity  convertEntryToEntity(ShowEntryDto showEntryDto){

        ShowEntity showEntity=ShowEntity.builder().showDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime()).showType(showEntryDto.getShowType())
                .build();

          return  showEntity;

    }
}
