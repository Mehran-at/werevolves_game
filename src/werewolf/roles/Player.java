package werewolf.roles;

public class Player {

    private int name;
    private Role role;
    private String personality;

    public Player(int name, Role role) {
        this.role = role;
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }


    @Override
    public String toString() {
        return String.valueOf("Player num"+name+ "; "+role.getKind());
    }
}
