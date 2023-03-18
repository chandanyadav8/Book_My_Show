package Project.Book_My_Show.Services;

import Project.Book_My_Show.Convertors.UserConvertor;
import Project.Book_My_Show.Entities.UserEntity;
import Project.Book_My_Show.EntryDtos.UserEntryDto;
import Project.Book_My_Show.Repository.UserRepository;
import Project.Book_My_Show.ResponseDto.GetUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

     public String addUser(UserEntryDto userEntryDto)throws  Exception,NullPointerException{

         UserEntity userEntity= UserConvertor.convertDtoToEntity(userEntryDto);
         userRepository.save(userEntity);

         return "User add successfully";
     }
     public GetUserResponseDto getUserName(int id)
     {
         UserEntity user=userRepository.findById(id).get();
         GetUserResponseDto userResponseDto=new GetUserResponseDto();
         userResponseDto.setId(user.getId());
         userResponseDto.setName(user.getName());
         userResponseDto.setAge(user.getAge());
         userResponseDto.setEmail(user.getEmail());
         userResponseDto.setAddress(user.getAddress());
         userResponseDto.setMobNo(user.getMobNo());

         return userResponseDto;
     }






}
