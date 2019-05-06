package fr.article.model;

import java.util.HashMap;

public class Article {
	
	private TypeArticle type;
	private String code;
	private HashMap<String, String> infos;
	
	
	public TypeArticle getType() {
		return type;
	}
	public void setType(TypeArticle type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public HashMap<String, String> getInfos() {
		return infos;
	}
	public void setInfos(HashMap<String, String> infos) {
		this.infos = infos;
	}
	
	
}
