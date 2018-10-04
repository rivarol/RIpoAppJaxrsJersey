package nc.metier;

import java.util.*;
import nc.metier.modele.*;;

public class CatalogueMetierImpl implements ICatalogueMetier{
	
	private Map<Long, Categorie> categories=new HashMap<Long, Categorie>();
	private Map<Long, Produit> produits=new HashMap<Long, Produit>();
	

	@Override
	public Categorie ajouterCategorie(Categorie c) {
		categories.put(c.getIdCategorie(), c);
		return c;
	}

	@Override
	public Produit ajouterProduit(Produit p) {
		p.setCategorie(getCaterie(p.getCategorie().getIdCategorie()));
		produits.put(p.getIdProduit(), p);
		return p;
	}

	@Override
	public List<Categorie> listCategories() {
		return new ArrayList<Categorie>(categories.values());
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCategorie) {
		List<Produit> products=new ArrayList<Produit>();
		for(Produit p : produits.values()) {
			if(p.getCategorie().getIdCategorie().equals(idCategorie)) {
				products.add(p);
			}
				
		}
		return products;
	}

	@Override
	public List<Produit> listProduits() {
		return new ArrayList<Produit>(produits.values());
	}

	@Override
	public List<Produit> produitsParMotCle(String mC) {
		List<Produit> products=new ArrayList<Produit>();
		for(Produit p : produits.values()) {
			if(p.getDesignation().contains(mC)) {
				products.add(p);
			}
				
		}
		return products;
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		categories.put(c.getIdCategorie(), c);
		return c;
	}

	@Override
	public boolean deleteProduit(Long idProduit) {
		if(produits.get(idProduit)!=null) {
			produits.remove(idProduit);
			return true;
		}
		else throw new RuntimeException("Produit non trouvé");
	}

	@Override
	public Produit updateProduit(Produit p) {
		produits.put(p.getIdProduit(), p);
		return p;
	}

	@Override
	public Categorie getCaterie(Long idCategorie) {
		return categories.get(idCategorie);
	}

	@Override
	public Produit getProduit(Long idProduit) {
		return produits.get(idProduit);
	}
	
	public void initialsationCatalogue() {
		ajouterCategorie(new Categorie(1L,  "Télévision", "tv.png"));
		ajouterCategorie(new Categorie(2L, "Imprimante", "lpr.png"));
		ajouterCategorie(new Categorie(3L, "Ordinateur", "pc.png"));
		ajouterProduit(new Produit(1L, "Ordinateur Packard Bell", 580.85, "pb.png", getCaterie(3L)));
		ajouterProduit(new Produit(2L, "Samsung led 107 pouces", 2570.99, "samsung.png", getCaterie(1L)));
		ajouterProduit(new Produit(3L, "HP Photosmart 2250", 178.22, "hp.png", getCaterie(2L)));
		
	}

}
