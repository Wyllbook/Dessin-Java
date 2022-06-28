import java.io.*;
import java.awt.*;
public abstract class Figure implements Cloneable, Comparable<Figure>,Serializable{
	/** 
	  * Definition d'une classe point mathematique dans un plan qui peut etre
	  * considere dans un repere cartesien ou polaire.  Un point peut etre dessine,
	  * translate.  Sa distance par rapport a un autre point peut etre obtenue.
	  *
	  * @author		Minatchy Jérôme
	  * @version	$Date$
	  *
	  */
	private static final long serialVersionUID = 1L;
private String nom;
 private String couleur;
 private Color Couleur1;
 private Color Couleur2;
 private boolean Filled;
 private boolean Hided;
public Figure(String x,String y) {
//	Representation interne d'un point
	//	---------------------------------
	this.couleur=x; // Couleur
	this.nom=y; // nom
	this.setCouleur1(new Color(0,0,0));
	this.setCouleur2(new Color(0,0,0));
	this.Filled=false;
	this.setHided(false);
}
 public abstract void Translate(double dx,double dy) ;
 public abstract Figure clone() ;
 public abstract void paint(Graphics g);
 /** Fonction de translation de la figure geometrique
  * @param dx valeur de la translation en X
  * @param dy valeur de la translation en Y
  */
 public abstract Point getCentre() ;
 public String toString() {
	 return ("Nom: " + nom  + "\n" + "Couleur: " + couleur + "\n");
 }
 
 /** Fonction d'affichage de la figure geometrique.
  * A l'avenir, devrait etre une fonction graphique
  * ici juste un System.out.println()
  */
public void afficher() {
	System.out.println(this);
}
/** 
 * Getteur du Nom
 * @return String représentant le nom
 */
public String getNom() {
	return nom;
}
/** 
 * Setteur du Nom
 * @param string remplaçant la première valeur
 * @return String représentant le nom
 */
public void setNom(String nom) {
	this.nom = nom;
}
/** 
 * Getteur de la Couleur
 * @return String représentant la couleur
 */
public String getCouleur() {
	return couleur;
}
/** 
 * Setteur de la Couleur
 * @param string remplaçant la première valeur
 * @return String représentant la couleur
 */
public void setCouleur(String couleur) {
	this.couleur = couleur;
}
/** 
 * Comparation de la distance entre les centre et le point de coorsonnée (0,0)
 * @param Figure a comparé
 * @return Booléan où 1 si la figure comparé a une distance plus longue 0 si elle est égal et -1 pour les autres cas
 */
public int compareTo(Figure t) {
	if(t.getCentre().distance(new Point("","",0,0))>this.getCentre().distance(new Point("","",0,0))) {
		return 1;
	}
	if(t.getCentre().distance(new Point("","",0,0))==this.getCentre().distance(new Point("","",0,0))) {
		return 0;
	}
	return -1;
}
public Color getCouleur1() {
	return Couleur1;
}
public void setCouleur1(Color couleur1) {
	Couleur1 = couleur1;
}
public Color getCouleur2() {
	return Couleur2;
}
public void setCouleur2(Color couleur2) {
	Couleur2 = couleur2;
}
public boolean isFilled() {
	return Filled;
}
public void setFilled(boolean filled) {
	Filled = filled;
}
public boolean isHided() {
	return Hided;
}
public void setHided(boolean hided) {
	Hided = hided;
}
}
