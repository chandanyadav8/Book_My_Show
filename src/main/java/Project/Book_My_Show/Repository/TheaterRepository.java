package Project.Book_My_Show.Repository;

import  Project.Book_My_Show.Entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository  extends JpaRepository<TheaterEntity,Integer> {
    TheaterEntity findByName(String name);
}

