package werewolf.roles;
import java.util.List;

public abstract class Role {

    String kind;
    String personality;
    List<Player> players;

    public Role() {
        this.kind = kind;
        this.personality = personality;
    }

    public String getPersonality() {

        return personality;
    }
    public abstract String getKind();

    public abstract Player act(List<Player> players);


}
