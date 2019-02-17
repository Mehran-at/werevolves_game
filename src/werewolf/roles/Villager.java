package werewolf.roles;

import java.util.List;
import java.util.Random;

public class Villager extends Role {

    private Random random = new Random();

    @Override
    public String getKind() {
        return "villager";
    }

    @Override
    public Player act(List<Player> players) {
        Player suspectWolf = vote(players);
        return suspectWolf;
    }

    private Player vote(List<Player> players) {
        int suspect = random.nextInt(players.size());
        return players.get(suspect);
    }
}
