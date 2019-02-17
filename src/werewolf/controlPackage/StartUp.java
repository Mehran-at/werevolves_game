package werewolf.controlPackage;

import werewolf.roles.Player;

import java.util.List;
import java.util.Scanner;

public class StartUp {
    private Scanner scanner = new Scanner(System.in);

    public List<Player> setTheGame() {
        Integer numberOfPlayers = askNumberOfPlayers();
        RoleDistributor distributor = new RoleDistributor(numberOfPlayers);
        List<Player> players = distributor.distributeTheRoles();
        return players;
    }


    private Integer askNumberOfPlayers() {
        System.out.println("Please enter the number of players!");
        return scanner.nextInt();
    }


}
