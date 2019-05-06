/**
 * TP3 Java objet. Version plus générique
 * @author Alexandre Meur
 */

package fr.article.console;

import java.util.Scanner;

import fr.article.model.*;
import fr.article.service.MenuService;
import fr.article.service.MenuServiceFactory;

public class ArticleAdminConsoleApp {
	
	public static Scanner input = new Scanner(System.in);

	/**
	 * Programme principal
	 * @param args
	 * @throws Exception Si le switch arrive au default (ne devrait pas arriver)
	 */
	public static void main(String[] args) throws Exception {
		boolean quitte = false;
		int choixUtilisateur = 0;
		TypeMemDao typeDao = new TypeMemDao();
		ArticleMemDao dao = new ArticleMemDao();
		MenuServiceFactory factory = new MenuServiceFactory();
		MenuService service;
		
		while(!quitte) {
			afficheMenu();
			
			//Récupération du choix de l'utilisateur
			choixUtilisateur = recupereChoixUtilisateur();
			
			//Lancement du service correspondant
			service = factory.serviceFactory(choixUtilisateur);
			if(service != null) {
				service.executeUC(input, dao, typeDao);
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
		System.out.println("1. Lister les articles");
		System.out.println("2. Ajouter un nouvel article");
		System.out.println("3. Mettre à jour un article");
		System.out.println("4. Supprimer un article");
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
}




