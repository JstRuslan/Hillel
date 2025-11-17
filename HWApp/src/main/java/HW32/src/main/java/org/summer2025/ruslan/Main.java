package org.summer2025.ruslan;


import org.summer2025.ruslan.order.CoffeeOrderBoard;

public class Main {
    public static void main(String[] args) {

        CoffeeOrderBoard board = new CoffeeOrderBoard();

        board.addOrder("Ivan");
        board.addOrder("Olga");
        board.addOrder("Alina");
        board.addOrder("Nina");

        board.draw();

        board.deliver();
        board.deliver(9);

        board.draw();
    }
}
