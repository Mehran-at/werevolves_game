package werewolf.controlPackage;

import werewolf.roles.*;

import java.util.*;

public class RoleDistributor {

    private Integer numberOfPlayers;
    private List<Player> players = new ArrayList<>() ;
    private List<Role> listOfRoles;
    int count = 0;


    public RoleDistributor(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.listOfRoles = new ArrayList<>();
        listOfRoles.add(new Doctor());
        listOfRoles.add(new Seer());
        listOfRoles.add(new WereWolf());
        listOfRoles.add(new WereWolf());
    }

    List<Player> distributeTheRoles(){
        List<Player> players = new ArrayList<>();
        if(numberOfPlayers > 16){
            listOfRoles.add(new WereWolf());
        }
        else {
        List<Role> listOfRoles = generateRoles();
        players = shareCards(listOfRoles);
        }
        return players;
    }

    private List<Player> shareCards(List<Role> listOfRoles) {
        for (Role role:listOfRoles) {
            players.add(new Player(count,role));
            count++;
        }

        return players;
    }


    List<Role> generateRoles(){
        listOfRoles.add(new Villager());
        if(listOfRoles.size()< numberOfPlayers) {
            generateRoles();
        }
            return listOfRoles;
    }
}
