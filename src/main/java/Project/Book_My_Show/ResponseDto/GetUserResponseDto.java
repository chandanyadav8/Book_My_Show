package Project.Book_My_Show.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetUserResponseDto {
    private int id;
    private String name;
    private int age;
    private String email;
    private String mobNo;

    private String address;

}
