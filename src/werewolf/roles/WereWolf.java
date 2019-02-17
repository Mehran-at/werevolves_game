package werewolf.roles;

import java.util.List;
import java.util.Random;

public class WereWolf extends Role {
    private Random random = new Random();

    @Override
    public String getKind() {
        return "wereWolf";
    }
    @Override
    public Player act(List<Player> villagers) {
       return killVillager(villagers);
    }

    private Player killVillager(List<Player> villagers) {
        int victim = random.nextInt(villagers.size());
        return villagers.get(victim);
    }
}
