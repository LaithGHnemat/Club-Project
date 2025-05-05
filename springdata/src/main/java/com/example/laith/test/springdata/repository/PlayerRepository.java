package com.example.laith.test.springdata.repository;

import com.example.laith.test.springdata.model.Player;
import com.example.laith.test.springdata.projection.ManagerStatisticProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findPlayerByClubId(Long clubId);


    // using Projection
    @Query(value = "select (select count(*) from player) playerCount,"
            + " (select count(*) from club) clubCount", nativeQuery = true)
    ManagerStatisticProjection getHRStatistic ();
}
