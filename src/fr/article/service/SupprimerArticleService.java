package fr.article.service;

import java.util.Scanner;

import fr.article.model.ArticleMemDao;

public class SupprimerArticleService extends MenuService {

	@Override
	public void executeUC(Scanner input, ArticleMemDao dao) {
		String codeInput;
		ListerArticleService listeService = new ListerArticleService();
		
		//Listage des pizzas
		listeService.executeUC(input, dao);
		
		//Demande le code de la pizza
		System.out.println("Entrez le code de la pizza à supprimer : ");
		codeInput = input.next();
		
		//Supression
		dao.deleteArticle(codeInput);
	}

}
