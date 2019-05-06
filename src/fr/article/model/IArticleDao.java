package fr.article.model;

public interface IArticleDao {
	Article[] findAllArticle();
	void saveNewArticle(Article article);
	void updateArticle(String code, Article article);
	void deleteArticle(String code);
	Article findArticleByCode(String code);
	boolean articleExists(String code);
	}
