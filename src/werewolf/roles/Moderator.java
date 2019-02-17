package werewolf.roles;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Moderator extends Role {
    private List<Player> players;
    private Set<Player> live;
    private List<Player> dead = new ArrayList<>();
    private Set<Player> savedOnes = new HashSet<>();

    public Moderator(List<Player> players) {
        this.players = players;
        this.live = new HashSet<>(players);
    }

    @Override
    public String getKind() {
        return "moderator";
    }

    @Override
    public Player act(List<Player> players) {

        return null;
    }


    public List<Player> callWerewolf() {
        List<Player> villagers = getVillagers();
        WereWolf wereWolf = new WereWolf();
        disPlay("WereWolfs wake up!");
        Player victim = wereWolf.act(villagers);
        if (!savedOnes.contains(victim)){
            live.remove(victim);
            dead.add(victim);
            disPlay("WereWolfs sleep!");
        }
        return dead;
    }

    public void callDoctor() {
        disPlay("Doctor wake up!");
        Doctor doctor = new Doctor();
        Player savedOne = doctor.act(players);
        savedOnes.add(savedOne);
        if(dead.contains(savedOne)){
            dead.remove(savedOne);
        }
        live.add(savedOne);
        disPlay("Doctor sleep!");

    }

    public void callSeer() {
        disPlay("WereWolfs wake up!");
        Seer seer = new Seer();
        Player wereWolf = seer.act(players);
        Boolean seerKnowledge = isWereWolf(wereWolf);

    }

    private Boolean isWereWolf(Player suspect){
        return suspect.getRole().getKind() == "wereWolf";
    }

    private List<Player> getVillagers() {
        return players.stream()
                .filter(e -> !e.getRole().getKind().equals("wereWolf"))
                .collect(toList());
    }

    public List<Player> callForVote() {
        System.out.println("It is time for vote!");
        List<Player> suspect = new ArrayList<>();
        for (int count = 0; count < live.size(); count++) {
                suspect.add(new Villager().act(players));
        }

        return suspect;
    }


     public List<Player> execute(Integer accused){
        return live.stream()
                .limit(e-> e.getName().equals(accused))
                .collect(toList());
    }


    void disPlay(Object object){
        System.out.println(object);
    }

}
