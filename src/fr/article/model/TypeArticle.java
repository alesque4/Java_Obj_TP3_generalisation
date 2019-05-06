package fr.article.model;

import java.util.HashMap;

public class TypeArticle {

	private String nom;
	private HashMap<String, TypeAttribut> attributs;
	
	
	public TypeAttribut getAttributeType(String attr){
		return attributs.get(attr);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public HashMap<String, TypeAttribut> getAttributs() {
		return attributs;
	}
	public void setAttributs(HashMap<String, TypeAttribut> attributs) {
		this.attributs = attributs;
	}
}
