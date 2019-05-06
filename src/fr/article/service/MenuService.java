package fr.article.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import fr.article.model.*;

public abstract class MenuService {
	public abstract void executeUC(Scanner input, ArticleMemDao dao, TypeMemDao typeDao);
	
	/**
	 * Demande une nouvelle pizza à l'utilisateur
	 * @return la pizza saisie par l'utilisateur
	 */
	protected Article demandeArticle(Scanner input, TypeMemDao typeDao) {
		boolean inputOk = false;
		char inputChar;
		String temp, typeNom;
		TypeArticle typeArticle;
		Article inputArticle = new Article();
		HashMap<String, String> articleMap = inputArticle.getInfos();
		
		//gestion du type
		System.out.println("Article d'un type déjà existant ? (o/n)");
		while(!inputOk) {
			if(input.hasNextLine()) {
				temp = input.nextLine();
				inputChar = temp.charAt(0);
				if(inputChar == 'o') {
					//Type déjà existant
					inputOk = true;
					
					//Récupération du type
					System.out.println("Entrez le type : ");
					typeNom = input.next();
					typeArticle = typeDao.findTypeByName(typeNom);
					inputArticle.setType(typeArticle);
					
					//Si le type est trouvé, on demande l'article
					if(typeArticle != null) {
						System.out.println("Entrez le code : ");
						inputArticle.setCode(input.next());
						
						//Pour chaque attribut du type on demande la valeur
						for(HashMap.Entry<String, TypeAttribut> entry : typeArticle.getAttributs().entrySet()) {
							System.out.println("Entrez une valeur pour le champ "+entry.getKey()+" : ");
							switch(entry.getValue()) {
							case Texte:
								System.out.println("Entrez le texte (sans espace)");
								inputArticle.getInfos().put(entry.getKey(), input.next());
								break;
							case nombre:
							case prix:
								//TODO
								break;
							default:
								break;
								
							}
						}
					//Sinon on revient au menu	
					}else {
						System.out.println("Impossible de trouver ce type. Retour au menu.");
					}
				}else if(inputChar == 'n') {
					//Nouveau Type
					inputOk = true;
					
				}
			}
		}
	}
	
	protected TypeArticle demandeType(Scanner input) {
		
	}
}
