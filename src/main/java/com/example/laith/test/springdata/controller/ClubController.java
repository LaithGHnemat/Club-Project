package com.example.laith.test.springdata.controller;

import com.example.laith.test.springdata.exceptions.ClubNotFoundException;
import com.example.laith.test.springdata.model.Club;
import com.example.laith.test.springdata.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubController {

    @Autowired
    private ClubService clubService;


    @GetMapping("/all")
    public ResponseEntity<List<Club>> getAllTodos() {
        List<Club> clubs = clubService.findAll();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Club> addClub(@RequestBody Club club) {
        Club newClub = clubService.addClub(club);
        return new ResponseEntity<>(newClub, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable("id") Long id) throws ClubNotFoundException {
        Club club = clubService.findClubById(id);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClub(@PathVariable("id") Long id) {
        boolean isDeleted = clubService.deleteClub(id);
        if (isDeleted)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Club> updateTodo(@RequestBody Club club) {
        boolean isUpdated = clubService.updateClub(club);
        if (isUpdated)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/{name}/{nationality}")// by jpa just it costumes method
    public ResponseEntity<Club> findByNameAndNationality(
            @PathVariable("name") String name, @PathVariable("nationality") String nationality) {
        Club club = clubService.findClubByNameAndNationality(name, nationality);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}/{nationality}/{budget}")
    public ResponseEntity<Club> filter(
            @PathVariable("name") String name,
            @PathVariable("nationality") String nationality,
            @PathVariable("budget") double budget) {
        Club clubs = clubService.filterClub(name, nationality, budget);
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @PutMapping("/budget")// this is custom method
    public int updateClubBudget(@RequestParam double budget, @RequestParam Long id) {
        return clubService.updateClubBudget(budget, id);
    }

}
