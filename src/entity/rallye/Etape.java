package entity.rallye;

import java.util.ArrayList;
import java.util.List;

public class Etape {

	private int id;
	private EditionRallye edition;
	private int ordreE;
	private Double distance;
	private String niveau;
	private List<Speciale> speciales;
	
	public Etape(int ordre, Double distance, String n) {
		this.ordreE = ordre;
		this.distance = distance;
		this.niveau = n;
		this.speciales = new ArrayList<Speciale>();
	}

	public Etape(int id, int ordre, Double distance, String n) {
		this.id = id;
		this.ordreE = ordre;
		this.distance = distance;
		this.niveau = n;
		this.speciales = new ArrayList<Speciale>();
	}
	
	public Etape(int ordre, Double distance, String n, EditionRallye edition) {
		this.ordreE = ordre;
		this.distance = distance;
		this.niveau = n;
		this.speciales = new ArrayList<Speciale>();
		this.edition =  edition;
	}

	public Etape(int id, int ordre, Double distance, String niveau, EditionRallye edition) {
		this.id = id;
		this.edition = edition;
		this.ordreE = ordre;
		this.distance = distance;
		this.niveau = niveau;
		this.speciales = new ArrayList<Speciale>();
	}

	public Etape(int id, int ordre, Double distance, String n, EditionRallye edition, List<Speciale> speciales) {
		this.id = id;
		this.edition = edition;
		this.ordreE = ordre;
		this.distance = distance;
		this.niveau = n;
		this.speciales = speciales;
	}

	public Etape(int id, int ordre, Double distance, String niveau, List<Speciale> speciales) {
		this.id = id;
		this.ordreE = ordre;
		this.distance = distance;
		this.niveau = niveau;
		this.speciales = speciales;
	}

	public Etape(int ordre, double doubleValue, String string, int editionId) {

	}

	public int getOrdreE() {
		return ordreE;
	}

	public void setOrdreE(int ordreE) {
		this.ordreE = ordreE;
	}

	public Double getDistanceE() {
		return distance;
	}

	public void setDistanceE(Double distanceE) {
		this.distance = distanceE;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EditionRallye getEdition() {
		return edition;
	}

	public void setEdition(EditionRallye edition) {
		this.edition = edition;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public List<Speciale> getSpeciales() {
		return speciales;
	}

	public void setSpeciales(List<Speciale> speciales) {
		this.speciales = speciales;
	}
}
