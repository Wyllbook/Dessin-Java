
import java.util.*;
/** 
 * Definition d'une classe point mathematique dans un plan qui peut etre
 * considere dans un repere cartesien ou polaire.  Un point peut etre dessine,
 * translate.  Sa distance par rapport a un autre point peut etre obtenue.
 *
 * @author		Minatchy Jérôme
 * @version	$Date$
 *
 */
public class test {
	public static void testPoint() {
		Point u= new Point("Bleu","Jonathan",3,5);
		Point v= new Point("Bleu","Jonathan",9,16);
		System.out.println(u.compareTo(v));
		u.getCentre().afficher();
		System.out.println(u.equals(v));
		Point e= new Point(v);
		e.afficher();
		Point w= u.clone();
		System.out.println(u.distance(v));
		v.Translate(-6, -11);
		System.out.println(u.equals(v));
		u.afficher();
		w.afficher();
		System.out.println(u==w);
	}
	public static void testSegment() {
		Point u= new Point("Bleu","Jonathan",3,0);
		Point v= new Point("Bleu","Jonathan",3,16);
		Segment r=new Segment(u,v);
		Segment w= r.clone();
		System.out.println(r.getCentre());
		System.out.println(r.getLongueur());
		System.out.println(r.getMilieu());
		r.afficher();
		w.afficher();
		w.Translate(5, 6);
		r.afficher();
		w.afficher();
		System.out.println(w==r);
	}
	public static void testCercle() {
		Point u= new Point("Bleu","Jonathan",3,0);
		Point v= new Point("Bleu","Jonathan",3,16);
		Cercle w= new Cercle(u,v);
		w.afficher();
		w.getCentre().afficher();
		Cercle y=w.clone();
		System.out.println(w==y);
		w.afficher();
		y.afficher();
		y.Translate(25, 45);
		w.afficher();
		y.afficher();
	}
	public static void testPolygone() {
		Point u= new Point("Bleu","Jonathan",0,0);
		Point v= new Point("Bleu","Jonathan",0,1);
		Point t= new Point("Bleu","Jonathan",0,2);
		Point d= new Point("Bleu","Jonathan",0,3);
		Point po= new Point("Bleu","Jonathan",0,7);
		LinkedList<Point> r= new LinkedList<Point>();
		r.add(u);
		r.add(v);
		r.add(t);
		r.add(d);
		Polygone a= new Polygone(r);
		a.add(po);
		a.afficher();
		a.getCentre().afficher();
		Polygone x= a.clone();
		System.out.println(x==a);
		x.afficher();
		System.out.println(x.equals(a));
		Collections.shuffle(x.getE());
		x.afficher();
		System.out.println(x.equals(a));
	}
	public static void testStructure() {
		LinkedList<Figure> ru = new LinkedList<Figure>();
		Point u= new Point("Bleu","Jonathan",0,0);
		Point v= new Point("Bleu","Jonathan",0,1);
		Point t= new Point("Bleu","Jonathan",0,2);
		Point d= new Point("Bleu","Jonathan",0,3);
		Point po= new Point("Bleu","Jonathan",0,7);
		Cercle w= new Cercle(u,v);
		Segment r=new Segment(t,d);
		ru.add(w);
		ru.add(r);
		ru.add(po);
		System.out.println(ru);
		for(Figure tu : ru) {
			tu.Translate(2, 200);
		}
		System.out.println(ru);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testPoint();
		testSegment();
		testCercle();
		testPolygone();
		testStructure();
	}

}
