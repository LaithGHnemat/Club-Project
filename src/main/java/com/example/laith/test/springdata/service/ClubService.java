package com.example.laith.test.springdata.service;

import com.example.laith.test.springdata.exceptions.ClubNotFoundException;
import com.example.laith.test.springdata.model.Club;
import com.example.laith.test.springdata.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClubService {

    @Autowired
    ClubRepository clubRepository;


    public Club addClub(Club club) {
        return clubRepository.save(club);
    }

    public List<Club> findAll() {
        return (List<Club>) clubRepository.findAll();
    }

    public Club findClubById(Long id) throws ClubNotFoundException {
        return clubRepository.findClubById(id)
                .orElseThrow(() -> new ClubNotFoundException("Club by id " + id + " was not found"));
    }


    public boolean deleteClub(Long id) {
        if (clubRepository.findById(id).isPresent()) {
            clubRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateClub(Club club) {
        if (!clubRepository.findById(club.getId()).isPresent())
            return false;
            clubRepository.save(club);
            return true;
    }
    // here  costume methode to findClubByNameAndNationality without query.
    public Club findClubByNameAndNationality(String  name,String nationality) {
        return clubRepository.findClubByNameAndNationality(name,nationality)
                .orElseThrow(() -> new ClubNotFoundException("Club  was not found"));
    }

    // here  costume Query
   public Club filterClub(String name, String nationality,Double budget) {
        return clubRepository.gatClub(name, nationality, budget)
                .orElseThrow(() -> new ClubNotFoundException("Club  was not found"));
    }


    public int updateClubBudget( Double budget, Long id) {
      return  clubRepository.updateBudget(budget,id);
    }

}
