package Project.Book_My_Show.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTheaterResponseDto {
    private int id;

    private String name;

    private String location;
}
