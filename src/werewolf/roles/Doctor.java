package werewolf.roles;

import java.util.List;
import java.util.Random;

public class Doctor extends Villager {
    private Random random = new Random();

    @Override
    public String getKind() {
        return "doctor";
    }

    @Override
    public Player act(List<Player> players) {
       return heal(players);

    }

    private Player heal(List<Player> players) {
        int saved = random.nextInt(players.size());
        return players.get(saved);
    }
}
