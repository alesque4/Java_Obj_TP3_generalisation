package fr.article.service;

public class MenuServiceFactory {
	
	
	public MenuService serviceFactory(int choix) {
		switch(choix) {
		case 1:
			return new ListerArticleService();
		case 2:
			return new AjouterArticleService();
		case 3:
			return new ModifierArticleService();
		case 4:
			return new SupprimerArticleService();
		default :
			return null;
		}
	}
}
