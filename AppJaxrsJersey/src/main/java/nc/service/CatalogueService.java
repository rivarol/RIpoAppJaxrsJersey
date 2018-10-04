package nc.service;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import nc.metier.CatalogueMetierImpl;
import nc.metier.modele.*;

@Singleton
@Path("/catalogue")
@Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
public class CatalogueService {
	private CatalogueMetierImpl metier;

	public CatalogueService() {
		metier=new CatalogueMetierImpl();
		metier.initialsationCatalogue();
	}
	
	@GET
	@Path("/categories")
	public List<Categorie> consulterCategories(){
		return metier.listCategories();
	}
	
	@GET
	@Path("/produits")
	public List<Produit> consulterProduits(){
		return metier.listProduits();
	}
	
	@GET
	@Path("/categories/{idCategorie}/produits")
	public List<Produit> produitsParCategorie(@PathParam(value="idCategorie")Long idCategorie){
		return metier.produitsParCategorie(idCategorie);
	}
	
	@GET
	@Path("/recherche")
	public List<Produit> produitsParMotCle(@QueryParam(value="mC")String mC){
		return metier.produitsParMotCle(mC);
	}
	
	@GET
	@Path("/categories/{idCategorie}")
	public Categorie getCategorie(@PathParam(value="idCategorie")Long idCategorie) {
		return metier.getCaterie(idCategorie);
	}
	
	@GET
	@Path("/produits/{idProduit}")
	public Produit getProduit(@PathParam(value="idProduit")Long idProduit) {
		return metier.getProduit(idProduit);
	}
	
	@POST
	@Path("/categories")
	@Consumes(MediaType.APPLICATION_JSON)
	public Categorie saveCategorie(Categorie c) {
		return metier.ajouterCategorie(c);
	}
	
	@POST
	@Path("/produits")
	@Consumes(MediaType.APPLICATION_JSON)
	public Produit saveProduit(Produit p) {
		return metier.ajouterProduit(p);
	}
	
	@PUT
	@Path("/produits")
	@Consumes(MediaType.APPLICATION_JSON)
	public Produit updateProduit(Produit p) {
		return metier.updateProduit(p);
	}

	
	@DELETE
	@Path("/produits")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean deleteProduit(@FormParam("idProduit") Long idProduit) {
		return metier.deleteProduit(idProduit);
	}
	
}