package entity.rallye;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.utilisateur.Coureur;

public class EditionRallye {
	
	private int numEdition;
	private Rallye rallye;
	private Date dateDeb;
	private Date dateFin;
	private List<Etape> lstEtapes;
	
	public EditionRallye() {
		super();
	}

	public EditionRallye( Rallye rallye, Date dateDeb, Date dateFin) {
		
		this.rallye = rallye;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.lstEtapes = new ArrayList<Etape>();
	}
	
	public EditionRallye(int numE, Date dateDeb, Date dateFin) {
		
		this.numEdition = numE;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.lstEtapes = new ArrayList<Etape>();
	}
	
	public EditionRallye(int numE, Date dateDeb, Date dateFin, List<Etape> etapes) {
		
		this.numEdition = numE;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.lstEtapes = etapes;
	}
	
	public EditionRallye(int numE, Rallye rallye, Date dateDeb, Date dateFin) {
		
		this.rallye = rallye;
		this.numEdition = numE;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.lstEtapes = new ArrayList<Etape>();
	}
	
	public EditionRallye( Rallye rallye, Date dateDeb, Date dateFin, List<Etape> etapes) {
		
		this.rallye = rallye;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.lstEtapes = etapes;
	}
	
	public EditionRallye(Date dateDeb, Date dateFin, List<Etape> etapes) {
		
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.lstEtapes = etapes;
	}
	
	public EditionRallye(int numE, Rallye rallye, Date dateDeb, Date dateFin, List<Etape> etapes) {
		
		this.rallye = rallye;
		this.numEdition = numE;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.lstEtapes = etapes;
	}
	
	//pour récupérer infos concernant une édition rallye
	public int getNumEdition() {
		return numEdition;
	}
	
	public Date getDateDeb() {
		return dateDeb;
	}
	
	public Date getDateFin() {
		return dateFin;
	}
	
	//pour modifier infos concernant une rallye --> UML Mise à jour edition rallye
	public void setNumEdition(int numEdition) {
		this.numEdition = numEdition;
	}
	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public void nominerConstructeur(String nomCon) {};
	
	public List<Etape> recupererEtape(int ordreE){
		
		return null;
	}
	
	public void ajouterEtape(Etape e) {};
	
	public void suppEtape(Etape e) {};
	
	public int recupererClassementCoureur(Coureur c) {
	
		return 0;	
	}
	
	public List<Coureur> recupererClassementCoureurs() {
		return null;
	}
	
	public int recupererClassementConstructeurNomine(String nomCon) {
		
		return 0;
	}
	
	public List<String> recupererClassementConstructeursNomines() {
		
		return null;
	}
	public int recupererClassementEquipeConstructeur(String nomCon) {
		
		return 0;
	}
	
	public Rallye getRallye() {
		return rallye;
	}

	public void setRallye(Rallye rallye) {
		this.rallye = rallye;
	}

	
	
}
