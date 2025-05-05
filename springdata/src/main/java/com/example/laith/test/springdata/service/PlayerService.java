package com.example.laith.test.springdata.service;

import com.example.laith.test.springdata.exceptions.PlayerExistClubException;
import com.example.laith.test.springdata.exceptions.TheSameClubException;
import com.example.laith.test.springdata.model.Player;
import com.example.laith.test.springdata.projection.ManagerStatisticProjection;
import com.example.laith.test.springdata.repository.ClubRepository;
import com.example.laith.test.springdata.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ClubRepository  clubRepository;

    public Player addPlayer(Player  playerDTO) {
        /*if(player.getId()!=null){
            throw new PlayerExistClubException("This player is exist, you can't add him again dude..  ");
        }*/
      //  Optional<Player> currentPlayer = playerRepository.findById(player.getId());
        //Player newPlayer = currentPlayer.get();
        //newPlayer.setName(player.getName());

        if(null!=playerDTO.getId()){
            Optional<Player> currentPlayer = playerRepository.findById(playerDTO.getId());
            if(currentPlayer.isPresent()){
                throw new PlayerExistClubException("This player is exist, you can't add him again dude..  ");
            }
        }
       /* Player  player = new Player();
        player.setPosition(playerDTO.getPosition());
        player.setName(playerDTO.getName());
        player.setNumber(playerDTO.getNumber());*/

      /*  if(null!=playerDTO.getClubId()){
            Optional<Club> byId = clubRepository.findById(playerDTO.getClubId());
            player.setClub(byId.get());
        }*/

       return playerRepository.save(playerDTO);
    }

    public List<Player> findAll() {
        return  playerRepository.findAll();
    }




    public boolean deletePlayer(Long id) {
        if (playerRepository.findById(id).isPresent()) {
            playerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updatePlayer(Player player) {
        Optional<Player> currentPlayer = playerRepository.findById(player.getId());
        if (!currentPlayer.isPresent())
            return false;
        if(currentPlayer.get().getId()== player.getId()){
         throw new TheSameClubException("this player is playing with this club.. ");
        }
        playerRepository.save(player);
        return true;
    }

    public List<Player> findPlayerByClubId(Long clubId){
        List<Player> playerByClubId = playerRepository.findPlayerByClubId(clubId);
        if(playerByClubId==null)
            throw new TheSameClubException("no players with this id  ");
        return playerByClubId;
    }

    public ManagerStatisticProjection getHRStatistic (){
     return    playerRepository.getHRStatistic();
    }

}
