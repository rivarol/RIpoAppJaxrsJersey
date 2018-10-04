package nc.metier;

import java.util.List;

import nc.metier.modele.*;

public interface ICatalogueMetier {
	public Categorie ajouterCategorie(Categorie c);
	public Produit ajouterProduit(Produit p);
	public List<Categorie> listCategories();
	public List<Produit> produitsParCategorie(Long idCategorie);
	public List<Produit> listProduits();
	public List<Produit> produitsParMotCle(String mC);
	public Categorie updateCategorie(Categorie c);
	public boolean deleteProduit(Long idProduit);
	public Produit updateProduit(Produit p);
	public Categorie getCaterie(Long idCategorie);
	public Produit getProduit(Long idProduit);
	
}