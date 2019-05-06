package fr.article.model;

import java.util.Arrays;

public class TypeMemDao implements ITypeMemDao{

	private final static int TAB_AGRANDIR = 5;
	private TypeArticle[] typeTab;
	
	public TypeMemDao() {
		typeTab = new TypeArticle[TAB_AGRANDIR];
	}
	
	@Override
	public TypeArticle[] findAllTypes() {
		return typeTab;
	}
	
	@Override
	public void saveNewType(TypeArticle type) {
		//Si le type existe déjà, on ne l'ajoute pas
		if(!typeExists(type.getNom())) {
			//Agrandissement du tableau si besoin
			if(typeTab[typeTab.length-1] != null) {
				typeTab = Arrays.copyOf(typeTab, typeTab.length + TAB_AGRANDIR);
			}
			
			//Ajout au premier emplacement libre
			for(int i=0; i<typeTab.length; i++) {
				if(typeTab[i] == null) {
					typeTab[i] = type;
					return;
				}
			}
		}
	}

	@Override
	public void deleteType(String nom) {
		for(int i=0; i<typeTab.length; i++) {
			if(typeTab[i].getNom().equals(nom)) {
				typeTab[i] = null;
			}
		}
	}

	@Override
	public TypeArticle findTypeByName(String nom) {
		for(int i=0; i<typeTab.length; i++) {
			if(typeTab[i].getNom().equals(nom)) {
				return typeTab[i];
			}
		}
		return null;
	}

	@Override
	public boolean typeExists(String nom) {
		for(int i=0; i<typeTab.length; i++) {
			if(typeTab[i].getNom().equals(nom)) {
				return true;
			}
		}
		return false;
	}
}
