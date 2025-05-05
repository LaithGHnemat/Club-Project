package com.example.laith.test.springdata.repository;


import com.example.laith.test.springdata.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    //1)queries look up or derived query.

    Optional<Club> findClubById(Long id);

    //2)
    // custom method/ look at Query creation in JPA, the link is here:
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    Optional<Club> findClubByNameAndNationality(String name, String nationality);


    @Query(value = "select * from club where name= :clubName " +
            "AND nationality= :clubNationality And budget >= :clubBudget ",nativeQuery = true)
    List<Club> filter(@Param("clubName")String name,
                      @Param("clubNationality") String nationality,
                      @Param("clubBudget") Double budget);



    //3)
    @Query(value = "SELECT * from club where name= :Name AND nationality= :Nationality And budget= :Budget",nativeQuery = true)
    Optional<Club> gatClub(@Param("Name") String name, @Param("Nationality") String nationality
            , @Param("Budget") double budget);

    @Modifying // it will make changes on the DB, not just select, we use it in update delete and insert
    @Query(value = "update club set budget= :budget where id= :id ",nativeQuery = true)
    int updateBudget(@Param("budget")Double budget,@Param("id") Long id);// ask someOne about it.


}
