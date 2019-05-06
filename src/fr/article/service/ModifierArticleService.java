package fr.article.service;

import java.util.Scanner;

import fr.article.model.Article;
import fr.article.model.ArticleMemDao;

public class ModifierArticleService extends MenuService {

	@Override
	public void executeUC(Scanner input, ArticleMemDao dao) {
		Article pizzaInput;
		String codeInput;
		
		//Demande le code de la pizza
		System.out.println("Mise à jour d'une pizza");
		System.out.println("Entrez le code de la pizza à modifier : ");
		codeInput = input.next();
		
		//Demande la nouvelle pizza
		System.out.println("Entrez la nouvelle pizza");
		pizzaInput = demandeArticle(input);
		
		//Maj
		dao.updateArticle(codeInput, pizzaInput);
	}
}
