package data;

import com.example.databasteamecho.model.Player;


public class PlayerData {

    public void createPlayers() {


        Player player1 = new Player("John", "Doe", "Johnd", "johndoe@example.com", 555, "123 Main St", 10001, "New York", "USA");
        Player player2 = new Player("Alice", "Smith", "Alices", "alicesmith@example.com", 555, "456 Elm St", 20002, "Washington", "USA");
        Player player3 = new Player("Bob", "Johnson", "Bobj", "bobjohnson@example.com", 555, "789 Oak St", 30003, "Atlanta", "USA");
        Player player4 = new Player("Emily", "Brown", "Emilyb", "emilybrown@example.com", 555, "101 Pine St", 40004, "Chicago", "USA");
        Player player5 = new Player("David", "Wilson", "Davidw", "davidwilson@example.com", 555, "202 Maple St", 50005, "Los Angeles", "USA");

    }
}

