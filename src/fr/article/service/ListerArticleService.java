package fr.article.service;

import java.util.Scanner;

import fr.article.model.ArticleMemDao;

public class ListerArticleService extends MenuService {

	/**
	 * Affiche les pizzas
	 */
	public void executeUC(Scanner input, ArticleMemDao dao) {
		System.out.println("Liste des pizzas");
		System.out.println(dao.toString());
	}

}
