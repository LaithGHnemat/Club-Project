package com.example.laith.test.springdata.controller;

import com.example.laith.test.springdata.model.Player;
import com.example.laith.test.springdata.projection.ManagerStatisticProjection;
import com.example.laith.test.springdata.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {


    @Autowired
    private PlayerService playerService;


    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAll() {
        List<Player> players = playerService.findAll();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Player> addClub(@RequestBody Player player) {
        Player newClub = playerService.addPlayer(player);


        return new ResponseEntity<>(newClub, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable("id") Long id) {
        boolean isDeleted = playerService.deletePlayer(id);
        if (isDeleted)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/club")
    public ResponseEntity<List<Player>> getByClub( @RequestParam Long id) {
        List<Player> clubs = playerService.findPlayerByClubId(id);
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }
// here we use projection
    @GetMapping("/sts")
    ManagerStatisticProjection getHRStatistic (){
        return  playerService.getHRStatistic();
    }
}
