import java.util.*;
import java.awt.Graphics;
public class Polygone extends Figure {
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
	private LinkedList<Point> e;
	public Polygone(LinkedList<Point> e) {
		super("","");
		this.setE(e);
	}
	public void Translate(double dx,double dy) {
		for(Point w: getE()) {
			w.Translate(dx, dy);
		}
	}
	public Point getCentre() {
		double a=0,b=0;
		for(Point z: getE()) {
			a+=z.getX();
			b+=z.getY();
		}
		a=a/getE().size();
		b=b/getE().size();
		return (new Point("","",a,b));
	}
	public boolean add(Point u) {
		getE().add(u);
		return true;
	}
	public String toString() {
		return (super.toString() + "Les Points: " + "\n" +  getE().toString());
	}
	public Polygone clone() {
		LinkedList<Point> clone=new LinkedList<Point>();
		for(Point p: this.getE()) {
			clone.add(p.clone());
		}
		Polygone cloner=new Polygone(clone);
		cloner.setCouleur1(this.getCouleur1());
		cloner.setCouleur2(this.getCouleur2());
		cloner.setFilled(this.isFilled());
		return cloner;
	}
	public boolean equals(Polygone B) {
		int n=getE().size();
		int g=0, g1=0;
		if(n!=B.getE().size())return false;
		int i1=0, i2=0;
		Point[] P1=getE().toArray(new Point[getE().size()]);
		Point[] P2=B.getE().toArray(new Point[B.getE().size()]);
		for(i1=0;i1<n;i1++) {
			while(i2<n && !P1[i1].equals(P2[i2])) i2++;
				if(P1[i1-1+(n * ((i1==0) ? 1 : 0))].equals(P2[i2-1+(n * ((i2==0) ? 1 : 0))]))g++;
				if(P1[(i1+1)%n].equals(P2[(i2+1)%n]))g++;
				if(P1[(i1+1)%n].equals(P2[i2-1+(n * ((i2==0) ? 1 : 0))]))g1++;
				if(P1[i1-1+(n * ((i1==0) ? 1 : 0))].equals(P2[(i2+1)%n]))g1++;
			i2=0;
		}
		if(g==2*n || g1==2*n)return true;
				return false;
			}
	public LinkedList<Point> getE() {
		return e;
	}
	public void setE(LinkedList<Point> e) {
		this.e = e;
	}
	public void paint(Graphics g){
		if(!this.isHided()) {
			int[] p=new int[e.size()];
			int[] p1=new int[e.size()];
			int a=0;
			for(Point i: e) {
				p[a]=(int)i.getX();
				p1[a]=(int)i.getY();
				a++;
			}
			g.setColor(this.getCouleur1());
			g.drawPolygon(p,p1,(int)e.size());
			if(!this.isFilled()) {
				g.drawPolygon(p,p1,(int)e.size());
			}
			if(this.isFilled()) {
				g.fillPolygon(p,p1,(int)e.size());
			}
		}
	}
		}
