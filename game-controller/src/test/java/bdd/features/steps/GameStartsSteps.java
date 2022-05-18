package bdd.features.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.scrum.psd.battleship.controller.GameController;
import org.scrum.psd.battleship.controller.dto.Letter;
import org.scrum.psd.battleship.controller.dto.Position;
import org.scrum.psd.battleship.controller.dto.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameStartsSteps {
    private GameController controller = new GameController();

    @Given("I have {int} ships and computer has {int} ships")
    public void i_have_ships_and_computer_has_ships(int noOfMyShips, int noOfEnemyShips) {
        List<Ship> myFleet = new ArrayList<>();
        for (int i = 1; i <= noOfMyShips; i++) {
            myFleet.add(new Ship("Patrol Boat:" + i, 2, Arrays.asList(new Position(Letter.A, i), new Position(Letter.B, i))));
        }
        controller.myFleet = myFleet;
        List<Ship> enemyFleet = new ArrayList<>();
        for (int i = 1; i <= noOfEnemyShips; i++) {
            enemyFleet.add(new Ship("Patrol Boat:" + i, 2, Arrays.asList(new Position(Letter.A, i), new Position(Letter.B, i))));
        }
        controller.enemyFleet = enemyFleet;
    }

    @When("the game starts")
    public void the_game_starts() {

    }

    @Then("my ships available={int}, sank= {int} and enemy ships available={int}")
    public void my_ships_available_sank_and_enemy_ships_available(int myShipsAvailable, int sank, int enemyShipsAvailable) {
        Assertions.assertEquals(myShipsAvailable, controller.getYourShipsAfloat().size());
        Assertions.assertEquals(sank, controller.getYourShipsSunk().size());
        Assertions.assertEquals(enemyShipsAvailable, controller.getEnemyShipsAfloat().size());
    }
}
