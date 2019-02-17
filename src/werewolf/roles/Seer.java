package werewolf.roles;

import java.util.List;
import java.util.Random;

public class Seer extends Villager {
    Random random = new Random();

    @Override
    public String getKind() {
        return "seer";
    }

    @Override
    public Player act(List<Player> players) {
        int wereWolf = random.nextInt(players.size());
        return players.get(wereWolf);
    }

}
