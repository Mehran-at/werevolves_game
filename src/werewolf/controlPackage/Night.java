package werewolf.controlPackage;

import werewolf.roles.Moderator;
import werewolf.roles.Player;
import werewolf.roles.Role;

import java.util.List;

public class Night implements Scene {

    private List<Player> players;
    private Moderator moderator;

    public Night(List<Player> players) {
        this.players = players;
        this.moderator = new Moderator(players);
    }

    @Override
    public void events() {
        moderator.callWerewolf();
        moderator.callDoctor();
        moderator.callSeer();
    }
}
