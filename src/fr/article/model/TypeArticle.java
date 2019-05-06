package fr.article.model;

import java.util.HashMap;

public class TypeArticle {

	private String nom;
	private HashMap<String, String> attributs;
	
	
	public String getAttributeType(String attr){
		return attributs.get(attr);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public HashMap<String, String> getAttributs() {
		return attributs;
	}
	public void setAttributs(HashMap<String, String> attributs) {
		this.attributs = attributs;
	}
}
