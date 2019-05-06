package fr.article.model;

import java.util.Arrays;

public class ArticleMemDao implements IArticleDao {
	
	private static final int TAB_AGRANDIR = 5;
	
	private static Article[] tabArticle;
	
	public ArticleMemDao() {
		tabArticle = new Article[1];
		
		//Ajouts des articles
		
	}
	
	/**
	 * Renvoie le tableau d'article
	 * @return le tableau d'article
	 */
	public Article[] findAllArticle() {
		return tabArticle;
	}

	/**
	 * Ajout d'une pizza
	 * @param la pizza à ajouter
	 */
	public void saveNewArticle(Article a) {
		
		//On vérifie si le code est libre
		if(!articleExists(a.getCode())) {
			//Si le tableau est plein on l'agrandit
			if(tabArticle[tabArticle.length-1] != null) {
				tabArticle = Arrays.copyOf(tabArticle, tabArticle.length + TAB_AGRANDIR);
			}
			//Ajout de l'article au premier emplacement libre
			for(int i=0; i<tabArticle.length; i++) {
				if(tabArticle[i] == null) {
					tabArticle[i] = a;
					break;
				}
			}
		}	
	}

	/**
	 * Cherche un article avec son code et la met à jour. On ne change pas le type de l'article.
	 * @param Le code recherché
	 * @Param Le nouvel article
	 */
	public void updateArticle(String codeArticle, Article article) {
		Article oldArticle;
		
		//Recherche de l'article
		oldArticle = findArticleByCode(codeArticle);
		
		//Si l'article existe, on le met à jour
		if(oldArticle != null) {
			oldArticle.setCode(article.getCode());
			oldArticle.setInfos(article.getInfos());
		}
	}

	/**
	 *  Cherche un article avec son code et le supprime si il existe
	 * @param Le code recherché
	 */
	public void deleteArticle(String codeArticle) {
		for(int i=0; i<tabArticle.length; i++) {
			if(tabArticle[i] != null && tabArticle[i].getCode().equals(codeArticle)) {
				tabArticle[i] = null;
			}
		}
	}

	/**
	 * Cherche une pizza avec son code et la renvoie si elle existe
	 * @param Le code recherché
	 * @return La pizza si elle est trouvée ou null si on ne trouve rien
	 */
	public Article findArticleByCode(String codeArticle) {
		for(int i=0; i<tabArticle.length; i++) {
			if(tabArticle[i] != null && tabArticle[i].getCode().equals(codeArticle)) {
				return tabArticle[i];
			}
		}
		return null;
	}

	/**
	 * Cherche une pizza avec son code et indique si elle existe
	 * @param Le code recherché
	 * @return true si la pizza existe, false sinon
	 */
	public boolean articleExists(String codeArticle) {
		for(int i=0; i<tabArticle.length; i++) {
			if(tabArticle[i] != null && tabArticle[i].getCode().equals(codeArticle)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String result = "";
		
		if(tabArticle != null) {
			for(int i=0; i<tabArticle.length; i++) {
				if(tabArticle[i] != null) {
					result = result + tabArticle[i].toString() + '\n';
				}
			}
		}
		
		return result;
	}
}
