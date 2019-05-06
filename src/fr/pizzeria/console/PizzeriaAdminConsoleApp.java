/**
 * TP1 Java objet
 * @author Alexandre Meur
 */

package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.*;

public class PizzeriaAdminConsoleApp {
	
	public static Scanner input = new Scanner(System.in);

	/**
	 * Programme principal
	 * @param args
	 * @throws Exception Si le switch arrive au default (ne devrait pas arriver)
	 */
	public static void main(String[] args) throws Exception {
		boolean quitte = false;
		int choixUtilisateur = 0;
		PizzaMemDao dao = new PizzaMemDao();
		Pizza pizzaInput = null;
		String codeInput = "";
		
		while(!quitte) {
			//Affichage du menu
			afficheMenu();
			
			//Récupération du choix de l'utilisateur
			choixUtilisateur = recupereChoixUtilisateur();
			
			//gestion du choix de l'utilisateur
			switch(choixUtilisateur){
				//Liste des pizzas
				case 1:
					affichePizzas(dao);
					break;
					
				//Ajout d'une pizza
				case 2:
					//Demandes des infos à l'utilisateur
					System.out.println("Ajout d'une nouvelle pizza");
					pizzaInput = demandePizza();
					dao.saveNewPizza(pizzaInput);
					break;
					
				//Modification d'une pizza
				case 3:
					//Demande le code de la pizza
					System.out.println("Mise à jour d'une pizza");
					System.out.println("Entrez le code de la pizza à modifier : ");
					codeInput = input.next();
					
					//Demande la nouvelle pizza
					System.out.println("Entrez la nouvelle pizza");
					pizzaInput = demandePizza();
					
					//Maj
					dao.updatePizza(codeInput, pizzaInput);
					break;
					
				//Suppression d'une pizza
				case 4:
					//affichage des pizzas
					affichePizzas(dao);
					
					//Demande le code de la pizza
					System.out.println("Entrez le code de la pizza à supprimer : ");
					codeInput = input.next();
					
					//Supression
					dao.deletePizza(codeInput);

					break;
				//Fin du programme
				case 99:
					System.out.println("Au revoir :(");
					quitte = true;
					break;
				default:
					System.out.println("/!\\ Ne devrait pas arriver ici /!\\");
					throw new Exception("Default switch ne devrait pas être accessible");
			}
		}
	}
	
	/**
	 * Affiche le menu
	 */
	public static void afficheMenu() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	/**
	 * Récupère le choix de l'utilisateur pour le menu. Ne peut pas retourner un choix qui n'existe pas.
	 * @return Un choix valide pour le menu
	 */
	public static int recupereChoixUtilisateur() {
		boolean inputOk = false;
		int choix = 0;
		while(!inputOk) {
			if(input.hasNextInt()) {
				choix = input.nextInt();
				//Si l'entrée n'est pas bonne on demande une option valide
				if(choix != 1 && choix != 2 && choix != 3 && choix != 4 && choix != 99) {
					System.out.println("Entrez une option valide");
				}else {
					inputOk = true;
				}
			}else {
				System.out.println("Entrez une option valide");
				input.next();
			}
		}
		return choix;
	}
	
	/**
	 * Affiche les pizzas
	 */
	public static void affichePizzas(PizzaMemDao dao) {		
		System.out.println("Liste des pizzas");
		System.out.println(dao.toString());
	}
	
	/**
	 * Demande une nouvelle pizza à l'utilisateur
	 * @return la pizza saisie par l'utilisateur
	 */
	public static Pizza demandePizza() {
		String codeAjout, libelleAjout;
		double prixAjout=0;
		boolean inputOk = false;
		
		System.out.println("Veuillez saisir le code : ");
		codeAjout = input.next();
		System.out.println("Veuillez saisir le nom (sans espace): ");
		libelleAjout = input.next();
		while(!inputOk) {
			System.out.println("Veuillez saisir le prix:");
			if(input.hasNextDouble()) {
				prixAjout = input.nextDouble();
				inputOk = true;
			}else {
				input.next();
			}
		}
		return new Pizza(codeAjout, libelleAjout, prixAjout);
	}
}




