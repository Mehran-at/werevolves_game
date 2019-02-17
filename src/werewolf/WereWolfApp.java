package werewolf;

import werewolf.controlPackage.Day;
import werewolf.controlPackage.Night;
import werewolf.controlPackage.Scene;
import werewolf.controlPackage.StartUp;
import werewolf.roles.Moderator;
import werewolf.roles.Player;
import werewolf.roles.Role;

import java.util.List;

public class WereWolfApp {

    public static void main(String[] args) {
        StartUp startUp = new StartUp();
        List<Player> players = startUp.setTheGame();
        System.out.println(players);

        Scene night = new Night(players);
        night.events();
        Scene day = new Day(players);
        day.events();
    }
}
