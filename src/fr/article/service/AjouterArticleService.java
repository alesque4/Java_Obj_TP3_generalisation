package fr.article.service;

import java.util.Scanner;

import fr.article.model.*;

public class AjouterArticleService extends MenuService {

	@Override
	public void executeUC(Scanner input, ArticleMemDao dao) {
		Article inputArticle;
		
		//Demande d'une nouvelle pizza
		inputArticle = demandeArticle(input);
		
		//Ajout de la pizza
		dao.saveNewArticle(inputArticle);
	}

}
