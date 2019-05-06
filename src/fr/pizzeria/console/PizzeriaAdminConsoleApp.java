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
		MenuServiceFactory factory = new MenuServiceFactory();
		MenuService service;
		
		while(!quitte) {
			afficheMenu();
			
			//R�cup�ration du choix de l'utilisateur
			choixUtilisateur = recupereChoixUtilisateur();
			
			//Lancement du service correspondant
			service = factory.serviceFactory(choixUtilisateur);
			if(service != null) {
				service.executeUC(input, dao);
			}else {
				System.out.println("Au revoir :(");
				quitte = true;
			}
		}
	}
	
	/**
	 * Affichage du menu
	 */
	public static void afficheMenu() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre � jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	/**
	 * R�cup�re le choix de l'utilisateur pour le menu. Ne peut pas retourner un choix qui n'existe pas.
	 * @return Un choix valide pour le menu
	 */
	public static int recupereChoixUtilisateur() {
		boolean inputOk = false;
		int choix = 0;
		while(!inputOk) {
			if(input.hasNextInt()) {
				choix = input.nextInt();
				//Si l'entr�e n'est pas bonne on demande une option valide
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
}




