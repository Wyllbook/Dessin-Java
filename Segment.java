import java.awt.Graphics;;
public class Segment extends Figure{
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
	private Point a;
	private Point b;
/** 
*Constructeur de Segment a partir de deux point
* @return Point A
* @return Point B
*/
public Segment(Point x,Point y) {
	super("","");
	setA(x);
	setB(y);
}
/** 
 *Calcul de la Longueur
 * @return double représentant la longueur
 */
public double getLongueur() {
	return getA().distance(getB());
}
/** 
 *Verification de l'égalité des Point du segment
 * @param x Segment a comparer
 * @return boolean 1 si egalité 0 sinon
 */
public boolean equals(Segment x) {
	return (x.getA().equals(this.getA()) && x.getB().equals(this.getB()) || x.getB().equals(this.getA()) && x.getA().equals(this.getB()));
}
/** 
 * Translation de segment
 * @param dx Déplacement sur l'axe des abscisse
 * @param dy Déplacement sur l'axe des ordonnée
 */
public void Translate(double dx,double dy) {
	getA().Translate(dx, dy);
	getB().Translate(dx, dy);
}
/** 
 * Definition de la mise en page de l'affichage
 */
public String toString() {
	return (super.toString() + "Point a: " + "\n" + getA().toString() + "\n" + "Point b: " + "\n" + getB().toString() + "\n");
}
/** 
 * Recherche du millieu du segment
 * @return Point ayant pour coordonnées le milieu
 */
public Point getMilieu() {
	return new Point("None","Milieu",(getA().getX()+getB().getX())/2,(getA().getY()+getB().getY())/2);
}
/** 
 * Recherche du millieu du segment
 * @return Point ayant pour coordonnées le milieu
 */
public Point getCentre() {
	return new Point("None","Milieu",(getA().getX()+getB().getX())/2,(getA().getY()+getB().getY())/2);
}
/** 
 * Clonage en profondeur du segment
 * @return Nouveau segment
 */
public Segment clone() {
	Segment e = new Segment(getA().clone(),getB().clone());
	e.setNom(this.getNom());
	e.setCouleur(this.getCouleur());
	e.setCouleur1(this.getCouleur1());
	e.setCouleur2(this.getCouleur2());
	e.setFilled(this.isFilled());
	return e;
}
/** 
 * Getteur de B
 * @return point B
 */
public Point getB() {
	return b;
}
/** 
 * Setteur de B
 * @param string remplaçant la première valeur
 * @return point A
 */
public void setB(Point b) {
	this.b = b;
}
/** 
 * Getteur de A
 * @return point A
 */
public Point getA() {
	return a;
}
/** 
 * Setteur de A
 * @param string remplaçant la première valeur
 * @return point A
 */
public void setA(Point a) {
	this.a = a;
}
public void paint(Graphics g){
	if(!this.isHided()) {
		g.setColor(this.getCouleur1());
		g.drawLine((int)a.getX(),(int)a.getY(),(int)b.getX(),(int)b.getY());
	}
}
}
