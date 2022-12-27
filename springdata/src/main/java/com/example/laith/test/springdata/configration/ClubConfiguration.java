package com.example.laith.test.springdata.configration;

import com.example.laith.test.springdata.dto.PlayerDTO;
import com.example.laith.test.springdata.model.Club;
import com.example.laith.test.springdata.model.Player;
import com.example.laith.test.springdata.repository.PlayerRepository;
import com.example.laith.test.springdata.service.ClubService;
import com.example.laith.test.springdata.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

@Configuration
@Transactional
public class ClubConfiguration {

    @Autowired
    ClubService clubService;

    @Autowired
    PlayerRepository playerService;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            insertData();
        };

    }

    private void insertData() {
        Club madrid = new Club("Real Madrid", "Spanish", 87);
        clubService.addClub(madrid);
        clubService.addClub(new Club("Barcelona","Spanish ",95));
        clubService.addClub(new Club("Atletico Madrid","Spanish",74));
        playerService.save(new Player("CR7",7L,"wing",madrid));

    }


}
