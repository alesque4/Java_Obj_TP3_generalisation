package fr.pizzeria.model;

import java.util.Arrays;

public class PizzaMemDao implements IPizzaDao {
	
	private static final int TAB_AGRANDIR = 5;
	
	private static Pizza[] tabPizza;
	
	public PizzaMemDao() {
		tabPizza = new Pizza[1];
		
		//Ajouts des pizzas
		saveNewPizza(new Pizza("PEP","Pépéroni",12.50));
		saveNewPizza(new Pizza("MAR","Margherita",14.00));
		saveNewPizza(new Pizza("REIN","La Reine",11.50));
		saveNewPizza(new Pizza("FRO","La 4 Fromages",12.00));
		saveNewPizza(new Pizza("CAN","La cannibale",12.50));
		saveNewPizza(new Pizza("SAV","La savoyarde",13.00));
		saveNewPizza(new Pizza("ORI","L'orientale",13.50));
		saveNewPizza(new Pizza("IND","L'indienne",14.00));
	}
	
	/**
	 * Renvoie le tableau de pizzas
	 * @return le tableau de pizzas
	 */
	public Pizza[] findAllPizzas() {
		return tabPizza;
	}

	/**
	 * Ajout d'une pizza
	 * @param la pizza à ajouter
	 */
	public void saveNewPizza(Pizza pizza) {
		
		//On vérifie si le code pizza est libre
		if(!pizzaExists(pizza.getCode())) {
			//Si le tableau est plein on l'agrandit
			if(tabPizza[tabPizza.length-1] != null) {
				tabPizza = Arrays.copyOf(tabPizza, tabPizza.length + TAB_AGRANDIR);
			}
			//Ajout de la pizza au premier emplacement libre
			for(int i=0; i<tabPizza.length; i++) {
				if(tabPizza[i] == null) {
					tabPizza[i] = pizza;
					break;
				}
			}
		}	
	}

	/**
	 *  Cherche une pizza avec son code et la met à jour
	 * @param Le code recherché
	 * @Param La nouvelle pizza
	 */
	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza oldPizza;
		
		//Recherche de la pizza
		oldPizza = findPizzaByCode(codePizza);
		
		//Si la pizza existe, on la met à jour
		if(oldPizza != null) {
			oldPizza.setCode(pizza.getCode());
			oldPizza.setLibelle(pizza.getLibelle());
			oldPizza.setPrix(pizza.getPrix());
		}
	}

	/**
	 *  Cherche une pizza avec son code et la supprime si elle existe
	 * @param Le code recherché
	 */
	public void deletePizza(String codePizza) {
		for(int i=0; i<tabPizza.length; i++) {
			if(tabPizza[i] != null && tabPizza[i].getCode().equals(codePizza)) {
				tabPizza[i] = null;
			}
		}
	}

	/**
	 * Cherche une pizza avec son code et la renvoie si elle existe
	 * @param Le code recherché
	 * @return La pizza si elle est trouvée ou null si on ne trouve rien
	 */
	public Pizza findPizzaByCode(String codePizza) {
		for(int i=0; i<tabPizza.length; i++) {
			if(tabPizza[i] != null && tabPizza[i].getCode().equals(codePizza)) {
				return tabPizza[i];
			}
		}
		return null;
	}

	/**
	 * Cherche une pizza avec son code et indique si elle existe
	 * @param Le code recherché
	 * @return true si la pizza existe, false sinon
	 */
	public boolean pizzaExists(String codePizza) {
		for(int i=0; i<tabPizza.length; i++) {
			if(tabPizza[i] != null && tabPizza[i].getCode().equals(codePizza)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String result = "";
		
		if(tabPizza != null) {
			for(int i=0; i<tabPizza.length; i++) {
				if(tabPizza[i] != null) {
					result = result + tabPizza[i].toString() + '\n';
				}
			}
		}
		
		return result;
	}
}
