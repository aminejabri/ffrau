package entity.rallye;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entity.declarations.Declaration;
import entity.utilisateur.Coureur;

public class Speciale {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public HashMap<Coureur, Double> getLstTemps() {
		return lstTemps;
	}

	public void setLstTemps(HashMap<Coureur, Double> lstTemps) {
		this.lstTemps = lstTemps;
	}

	public HashMap<Coureur, ArrayList<Declaration>> getLstD() {
		return lstD;
	}

	public void setLstD(HashMap<Coureur, ArrayList<Declaration>> lstD) {
		this.lstD = lstD;
	}

	public ArrayList<Declaration> getLstDc() {
		return lstDc;
	}

	public void setLstDc(ArrayList<Declaration> lstDc) {
		this.lstDc = lstDc;
	}
	private int id;
	private Etape etape;
	private int ordre;
	private Double distance;
	private Double chonometrage;   //temps limit
	private HashMap<Coureur, Double> lstTemps;
	private HashMap<Coureur, ArrayList<Declaration>> lstD;
	private ArrayList<Declaration> lstDc;
	
	public Speciale(int ordre, Double distance, Double chonometrage) {
		this.ordre = ordre;
		this.distance = distance;
		this.chonometrage = chonometrage;
		this.lstTemps = new HashMap<Coureur, Double>();
		this.lstD = new HashMap<Coureur, ArrayList<Declaration>>();
	}
	
	public Speciale(int id, int ordre, Double distance, Double chonometrage) {
	
		this.id = id;
		this.ordre = ordre;
		this.distance = distance;
		this.chonometrage = chonometrage;
		this.lstTemps = new HashMap<Coureur, Double>();
		this.lstD = new HashMap<Coureur, ArrayList<Declaration>>();
	}
	
	public Speciale(int id, int ordre, Double distance, Double chrono, Etape etape) {
		
		this.id = id;
		this.ordre = ordre;
		this.distance = distance;
		this.chonometrage = chrono;
		this.etape = etape;
		
		this.lstTemps = new HashMap<Coureur, Double>();
		this.lstD = new HashMap<Coureur, ArrayList<Declaration>>();
	}

	//pour récupérer infos concernant une speciale
	public int getOrdreS() {
		return ordre;
	}

	public Double getChonometrage() {
		return chonometrage;
	}
	//pour modifier infos concernant une rallye --> UML Mise à jour edition rallye
	public void setOrdreS(int ordreS) {
		this.ordre = ordreS;
	}
	public void setDistanceS(Double distance) {
		this.distance = distance;
	}
	public void setChonometrage(Double chonometrage) {
		this.chonometrage = chonometrage;
	}
	
	//enregistrer le temps utilisé par un coureur à une spéciale
	public void enregistrerTemps(Coureur coureur, Double temps) {
		this.lstTemps.put(coureur, temps);
	}
	//récupérer le temps utilisé par un coureur à une spéciale
	public Double recupererTempsParCoureur(Coureur coureur) {
		return this.lstTemps.get(coureur);
	}
	
	//ajouter une déclaration pour un coureur à une spéciale
	public void ajouterDeclaration(Coureur c, Declaration d) {
		if(this.lstD.containsKey(c)) {
			lstDc.add(d);
		}
		else {
			this.lstD.put(c, new ArrayList<Declaration>());
			this.lstD.get(c).add(d);
		}
	}
	//récupérer les déclarations par un coureur à une spéciale
	public List<Declaration> recupererDeclarations(Coureur c) {
		return this.lstD.get(c);
	}
	
	
}
