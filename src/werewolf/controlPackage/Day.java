package werewolf.controlPackage;

import werewolf.roles.Moderator;
import werewolf.roles.Player;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Day implements Scene {
    private List<Player> players;
    private Moderator moderator;

    public Day(List<Player> players) {
        this.players = players;
        this.moderator = new Moderator(players);
    }

    @Override
    public void events() {
        List<Player> suspects = moderator.callForVote();
        Integer accused  = countTheVote(suspects);
        System.out.println("Player" + accused+ " is sentence to dead by majority of the votes!");
        List<Player>  live = moderator.execute(accused);
        if(!isGameFinished(live)){
        Scene night = new Night(this.players);
        night.events();
    }
    }

    public Integer countTheVote(List<Player> suspect) {
        List<Integer> collect = suspect.stream()
                .collect(groupingBy((Player::getName),
                        toList()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().size() - e1.getValue().size())
                .map(integerListEntry -> integerListEntry.getValue().size())
                .collect(toList());
        return collect.get(0);

    }

    private Boolean isGameFinished(List<Player> live){
        List<Player> liveWereWolf = live.stream()
                //.limit(e -> e.getKind.equal("wereWolf"))
                .collect(toList());
        List<Player> liveVillagers = live.stream()
                //.limit(e -> !e.getKind.equal("wereWolf"))
                .collect(toList());

        return (liveWereWolf.size() >= liveVillagers.size()) ||
                liveWereWolf.size() == 0;
    }

}
