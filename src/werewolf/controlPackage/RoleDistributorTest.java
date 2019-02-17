package werewolf.controlPackage;

import org.junit.jupiter.api.Test;
import werewolf.roles.Player;
import werewolf.roles.Role;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleDistributorTest {

    @Test
    void distributeTheRoles() {
        Integer numberOfPlayers = 7;
        RoleDistributor distributor = new RoleDistributor(numberOfPlayers);
        List<Player> actual = distributor.distributeTheRoles();
        assertEquals(7,actual.size());
    }

    @Test
    void generateRoles() {
        Integer numberOfPlayers = 7;
        RoleDistributor distributor = new RoleDistributor(numberOfPlayers);
        List<Role> roles = distributor.generateRoles();
        assertEquals(7,roles.size());

    }
}