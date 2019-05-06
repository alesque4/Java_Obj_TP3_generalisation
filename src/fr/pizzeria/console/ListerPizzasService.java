package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.PizzaMemDao;

public class ListerPizzasService extends MenuService {

	/**
	 * Affiche les pizzas
	 */
	void executeUC(Scanner input, PizzaMemDao dao) {
		System.out.println("Liste des pizzas");
		System.out.println(dao.toString());
	}

}
