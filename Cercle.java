import java.awt.Graphics;

public class Cercle extends Figure{
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
	private double r;
	private Point a;
	public Cercle(Point Centre,double rayon) {
		super("","");
		setA(new Point(Centre));
		setR(rayon);
	}
	public Cercle(Point x,Point y) {
		super("","");
		setA(new Point(x));
		setR(x.distance(y));
	}
	public Point getCentre() {
		return this.getA();
	}
	public String toString() {
		return ("Rayon: " + String.valueOf(getR()) + "\n" + "Centre: " + getA().toString() + "\n");
	}
	public void Translate(double dx,double dy) {
		getA().Translate(dx, dy);
	}
	public boolean equals(Cercle x) {
		return (x.getA().equals(this.getA()) && x.getR()==this.getR());
	}
	public Cercle clone() {
		Cercle e = new Cercle(getA().clone(),getR());
		e.setCouleur(this.getCouleur());
		e.setNom(e.getNom());
		e.setCouleur1(this.getCouleur1());
		e.setCouleur2(this.getCouleur2());
		e.setFilled(this.isFilled());
		return e;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public Point getA() {
		return a;
	}
	public void setA(Point a) {
		this.a = a;
	}
	public void paint(Graphics g){
		if(!this.isHided()) {
			g.setColor(this.getCouleur1());
			if(!this.isFilled()) {
				g.drawOval((int)a.getX()-(int)r,(int)a.getY()-(int)r,(int)r*2,(int)r*2);
			}
			if(this.isFilled()) {
				g.fillOval((int)a.getX()-(int)r,(int)a.getY()-(int)r,(int)r*2,(int)r*2);
			}
		}
	}
}
