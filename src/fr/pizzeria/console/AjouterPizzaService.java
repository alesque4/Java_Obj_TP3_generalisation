package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.*;

public class AjouterPizzaService extends MenuService {

	@Override
	void executeUC(Scanner input, PizzaMemDao dao) {
		Pizza inputPizza;
		
		//Demande d'une nouvelle pizza
		inputPizza = demandePizza(input);
		
		//Ajout de la pizza
		dao.saveNewPizza(inputPizza);
	}

}
