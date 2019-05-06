package fr.article.model;

public interface ITypeMemDao {
	
	TypeArticle[] findAllTypes();
	void saveNewType(TypeArticle type);
	void deleteType(String nom);
	TypeArticle findTypeByName(String nom);
	boolean typeExists(String nom);
}
