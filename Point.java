import java.awt.Graphics;

public class Point extends Figure{
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
//	Representation interne d'un point
//	---------------------------------
private double x; // abscisse
private double y; // ordonnee
/**
 *  Construction d'un point a partir de son abscisse et de son ordonnnee et de sa couleur et de son nom
 *  @param	x	Couleur
 *  @param	y	Nom
 *  @param a abcissse
 *  @param b ordonnée
 */
public Point(String x,String y,double a,double b) {
	// System.out.println("CONSTRUCTEUR Point(" + x + ", " + y + ")");
	super(x,y);
	this.setX(a);
	this.setY(b);
}
/**
 *  Construction d'un point a partir de'un autre
 *  @param	x	Point a partir duquelle on construit
 */
public Point(Point x) {
	super(x.getNom(),x.getCouleur());
	this.x=x.x;
	this.y=x.y;
}
/** 
 * Clonage en profondeur du Point
 * @return Nouveau Point
 */
public Point clone() {
	Point e=new Point(this.getCouleur(),this.getNom(),this.x,this.y);
	e.setCouleur1(this.getCouleur1());
	e.setCouleur2(this.getCouleur2());
	e.setFilled(this.isFilled());
	return e;
}
/** 
 *Verification de l'égalité des coordonnées de deux points
 * @param x Point a comparer
 * @return boolean 1 si egalité 0 sinon
 */
public boolean equals(Point x) {
	return (x.x==this.x && x.y==this.y);
}
/** 
 * Definition de la mise en page de l'affichage
 */
public String toString() {
	return (super.toString() + "X: " + String.valueOf(x) + "\n" + "Y: " + String.valueOf(y) + "\n");
}
/** Afficher le point */
public Point getCentre() {
	return this;
}
/** 
* Translater le point de dx_ suivant l'axe des X et de dy_ suivant les Y.
* @param dx_ deplacement suivant l'axe des X
* @param dy_ deplacement suivant l'axe des Y
*/
public void Translate(double dx,double dy) {
	this.setX(dx+this.x);
	this.setY(dy+this.y);
}
/** Distance par rapport a un autre point
 */
public double distance(Point x) {
	return Math.sqrt(Math.pow((this.x-x.x),2)+Math.pow((this.y-x.y),2));
}
/** Abscisse du point 
 * @return x l'abscisse du point*/
public double getX() {
	return x;
}
/** Changer l'abscisse du point
 * @param x	la nouvelle abscisse
 */
public void setX(double x) {
	this.x = x;
}
/** Ordonnee du point 
 * @return y l'ordonnee du point*/
public double getY() {
	return y;
}
/** Changer l'ordonnee du point
 * @param y	la nouvelle ordonnee
 */
public void setY(double y) {
	this.y = y;
}
public void paint(Graphics g){
	if(!this.isHided()) {
	g.setColor(this.getCouleur1());
	if(!this.isFilled()) {
		g.fillOval((int)x,(int)y,3,3);
	}
}
}
}
