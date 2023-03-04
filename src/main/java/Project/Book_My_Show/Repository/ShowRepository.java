package Project.Book_My_Show.Repository;

import Project.Book_My_Show.Entities.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShowRepository  extends JpaRepository<ShowEntity,Integer> {
}