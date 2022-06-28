import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.util.*;

import javax.swing.*;
public class Editeur extends JFrame{
	private LinkedList<Figure> ru;
	public Editeur(LinkedList<Figure> x) {
		super();
		ru=x;
		this.repaint();
	}
	public Editeur() {
		super();
		ru=new LinkedList<Figure>();
		this.repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		for(Figure j: ru) {
			j.paint(g);
			j.setCouleur(j.getCouleur());
			j.setNom(j.getClass().getName().substring(0,1)+this.ru.indexOf(j));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame Chooser= new JFrame();
		JFileChooser poi=new JFileChooser();
		poi.setApproveButtonText("Enregistrer");
		JFrame Chooser1= new JFrame();
		JFileChooser poi1=new JFileChooser();
		Chooser1.setSize(new Dimension(670,400));
		Chooser1.getContentPane().add(poi1);
		Chooser.setSize(new Dimension(670,400));
		Chooser.getContentPane().add(poi);
		JFrame Options=new JFrame();
		JPanel y45=new JPanel();
		y45.setBackground(Color.white);
		JLabel O2=new JLabel();
		y45.add(O2);
		Options.setSize(new Dimension(670,400));
		Options.setResizable(false);
		Options.setTitle("Options");
		JPanel y10=new JPanel();
		JPanel y12=new JPanel();
		JButton y13 = new JButton("Ok");
		JButton y14 = new JButton("Changer Couleur Utilisée");
		JButton y16 = new JButton("Changer Couleur Figure Sélectionée");
		JButton y15 = new JButton("Changer Couleur Fond");
		y13.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {Options.dispose();}});
		y12.add(y13);
		y12.add(y14);
		y12.add(y15);
		y12.add(y16);
		JColorChooser y11=new JColorChooser();
		y10.add(y11);
		Options.getContentPane().add(y10);
		Options.getContentPane().add(y12,BorderLayout.SOUTH);
		final class Bouton extends JButton {
			  private String name;
			  public int ar;
			  public Bouton(String str){
			    super(str);
			    this.setMaximumSize(new Dimension(150,40));
			  	this.setPreferredSize(new Dimension(150,40));
			  	this.setMinimumSize(new Dimension(150,40));
			    this.name = str;
			  }
			        
			  public void paintComponent(Graphics g){
			    Graphics2D g2d = (Graphics2D)g;
			    GradientPaint gp = new GradientPaint(0, 0, Color.magenta, 0, 20, Color.pink, true);
			    g2d.setPaint(gp);
			    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
			    g2d.setColor(Color.white);
			    g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() /4), (this.getHeight() / 2) + 5);
			  }        
			}
		Point u1= new Point("Bleu","Jonathan",65,0);
		Point v= new Point("Bleu","Jonathan",480,10);
		Point t= new Point("Bleu","Jonathan",80,70);
		Point d= new Point("Bleu","Jonathan",32,300);
		Point po= new Point("Bleu","Jonathan",150,90);
		Cercle w= new Cercle(u1,v);
		Segment r=new Segment(t,d);
		Editeur a= new Editeur();
		Container u = a.getContentPane();
		JPanel y1 = new JPanel();
		JPanel y3 = new JPanel();
		JButton x8 = new Bouton("Cacher");
		JTabbedPane y4= new JTabbedPane();
		JPanel y65=new JPanel();
		JPanel y66=new JPanel();
		JPanel y70=new JPanel();
		y70.setLayout(new BorderLayout());
		JButton y67 = new JButton("Sauvegarder");
		JButton y68 = new JButton("Charger");
		JButton y69 = new JButton("Raffraichir");
		y67.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {Chooser.setVisible(true);}});
		y68.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {Chooser1.setVisible(true);}});
		y65.setBackground(Color.white);
		y66.setBackground(Color.white);
		y66.add(y70);
		y65.add(y67);
		y65.add(y68);
		y4.addTab("Sauvegarde", y65);
		y4.addTab("Figures", y66);
		y66.add(y69);
		y3.add(x8);
		a.ru.add(po);
		a.ru.add(w);
		a.ru.add(r);
		final class Zone extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1528329338448402192L;
			public int fig=0;
			public Figure fige;
			public Color CouleurUtil;
			public int h=0;
			public int h1=0;
			public Zone() {
				this.addMouseListener(this);
				this.addMouseMotionListener(this);
				this.addMouseWheelListener(this);
				CouleurUtil=new Color(0,0,0);
				fige=a.ru.getFirst();
			}
			public void mouseClicked(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				if(fig==1 && e.getButton()==1) {
					Segment w1=new Segment(new Point("","",e.getX()+8+y3.getWidth(),e.getY()+71),new Point("","",e.getX()+8+y3.getWidth(),e.getY()+71));
					w1.setCouleur1(this.CouleurUtil);
					w1.setCouleur2(this.CouleurUtil);
					a.ru.add(w1);
					a.repaint();
				}
				if(fig==2 && e.getButton()==1) {
					Cercle w3=new Cercle(new Point("","",e.getX()+8+y3.getWidth(),e.getY()+71),0);
					w3.setCouleur1(this.CouleurUtil);
					w3.setCouleur2(this.CouleurUtil);
					a.ru.add(w3);
					a.repaint();
				}
				if(fig==4 && e.getButton()==1) {
					h=e.getX()+8+y3.getWidth();
					h1=e.getY()+71;
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(fig==0 && e.getButton()==1) {
					Point y=new Point("","",e.getX()+8+y3.getWidth(),e.getY()+71);
					y.setCouleur1(this.CouleurUtil);
					y.setCouleur2(this.CouleurUtil);
					a.ru.add(y);
					a.repaint();
					}
					try {
					if(fig==3 && e.getButton()==1) {
						Point y=new Point("","",e.getX()+8+y3.getWidth(),e.getY()+71);
						Polygone w6=(Polygone)a.ru.getLast();
						w6.setCouleur1(this.CouleurUtil);
						w6.setCouleur2(this.CouleurUtil);
						w6.getE().add(y);
						a.repaint();
						}
					}
					catch(Exception m) {
						if(fig==3 && e.getButton()==1) {
							a.ru.add(new Polygone(new LinkedList<Point>()));
							Point y=new Point("","",e.getX()+8+y3.getWidth(),e.getY()+71);
							Polygone w6=(Polygone)a.ru.getLast();
							w6.setCouleur1(this.CouleurUtil);
							w6.setCouleur2(this.CouleurUtil);
							w6.getE().add(y);
							a.repaint();
							}
					}
			}
			public void mouseDragged(MouseEvent e) {
				if(fig==1 && !SwingUtilities.isRightMouseButton(e)) {
					Segment w2=(Segment)a.ru.getLast();
					w2.setB(new Point("","",e.getX()+8+y3.getWidth(),e.getY()+71));
					a.repaint();
				}
				if(fig==2 && !SwingUtilities.isRightMouseButton(e)) {
					Cercle w3=(Cercle)a.ru.getLast();
					w3.setR(w3.getCentre().distance(new Point("","",e.getX()+8+y3.getWidth(),e.getY()+71)));
					a.repaint();
				}
				if(fig==4 && SwingUtilities.isLeftMouseButton(e)) {
					if(h<e.getX()+8+y3.getWidth()) {
						fige.Translate(Math.abs(h-(e.getX()+8+y3.getWidth())), 0);
						h=(e.getX()+8+y3.getWidth());
					}
					if(h>e.getX()+8+y3.getWidth()) {
						fige.Translate(-Math.abs(h-(e.getX()+8+y3.getWidth())), 0);
						h=(e.getX()+8+y3.getWidth());
					}
					if(h1<e.getY()+71) {
						fige.Translate(0, Math.abs(h1-(e.getY()+71)));
						h1=(e.getY()+71);
					}
					if(h1>e.getY()+71) {
						fige.Translate(0, -Math.abs(h1-(e.getY()+71)));
						h1=(e.getY()+71);
					}
					a.repaint();
				}
			}
			public void mouseMoved(MouseEvent e) {
				O2.setText("X="+e.getX()+", Y = "+e.getY());
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseWheelMoved(MouseWheelEvent e) {
				int gh=e.getWheelRotation();
				try {
				fige.setCouleur1(fige.getCouleur2());
				if(gh>=0) {
				fige=a.ru.get((a.ru.indexOf(fige)+1)%(a.ru.indexOf(a.ru.getLast())+1));
				}
				if(gh<=0) {
					int ermu=0;
					if(a.ru.indexOf(fige)==0) {
						fige=a.ru.get(a.ru.indexOf(a.ru.getLast()));
						ermu=1;
						}
					if(a.ru.indexOf(fige)>0 && ermu==0) {
					fige=a.ru.get(a.ru.indexOf(fige)-1);
					}
					}
				fige.setCouleur1(new Color(255,0,0));
				}catch(Exception yui) {}
				a.repaint();
			}
			
		}
		Zone y2 = new Zone();
		y15.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {y2.setBackground(y11.getColor());a.repaint();}});
		y14.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {y2.CouleurUtil=y11.getColor();}});
		y16.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {y2.fige.setCouleur2(y11.getColor());a.repaint();}});
		y69.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			y70.removeAll();
			for(Figure tuy: a.ru) {
				JPanel incre=new JPanel();
				JPanel incre1=new JPanel();
				Bouton Cache=new Bouton("C");
				JLabel nom1=new JLabel();
				y70.setLayout(new BoxLayout(y70, BoxLayout.Y_AXIS));
				nom1.setText(tuy.getClass().getName()+" "+tuy.getNom());
				incre1.add(nom1);
				incre.add(incre1);
				incre.add(Cache);
				Cache.ar=a.ru.indexOf(tuy);
				 Cache.setMaximumSize(new Dimension(40,40));
				 Cache.setPreferredSize(new Dimension(40,40));
				 Cache.setMinimumSize(new Dimension(40,40));
				Cache.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
					int ruin=0;
					if(!a.ru.get(Cache.ar).isHided()) {
						a.ru.get(Cache.ar).setHided(true);
						ruin=1;
					}
					if(a.ru.get(Cache.ar).isHided() && ruin==0) {
						a.ru.get(Cache.ar).setHided(false);
					}
					a.repaint();
				}});
				y70.add(incre);
			}
			JScrollPane eyu=new JScrollPane(y70);
			a.repaint();
		}});
		JButton x = new JButton("Point");
		JButton x1 = new JButton("Segment");
		JButton x2 = new JButton("Cercle");
		JButton x3 = new JButton("Polygone");
		JButton x4 = new JButton("Clear");
		JButton x5 = new JButton("Init");
		JButton x10 = new Bouton("Translater");
		JButton x6 = new Bouton("Copie");
		JButton x7 = new Bouton("Supprimer");
		JButton x9 = new Bouton("Remplir");
		JButton x11 = new Bouton("Options");
		x4.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {a.ru.clear();a.repaint();}});
		x.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {y2.fig=0;}});
		x1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {y2.fig=1;}});
		x2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {y2.fig=2;}});
		x3.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {y2.fig=3;a.ru.add(new Polygone(new LinkedList<Point>()));}});
		x5.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {}});
		x8.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
			int re=0;
			if(!y2.fige.isHided()) {
			y2.fige.setHided(true);
			re=1;
			}
			if(y2.fige.isHided() && re==0) {
				y2.fige.setHided(false);
				}
			a.repaint();
			}});
		x9.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {int eryt=0;if(y2.fige.isFilled()) {y2.fige.setFilled(false); eryt=1;}if(!y2.fige.isFilled() && eryt==0)y2.fige.setFilled(true);a.repaint();}});
		x7.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {a.ru.remove(y2.fige);try{y2.fige=a.ru.getFirst();y2.fige.setCouleur1(new Color(255,0,0));}catch(Exception yu) {}a.repaint();	}});
		x6.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {Figure reu;a.ru.add(y2.fige.clone());reu=a.ru.getLast();reu.setCouleur1(reu.getCouleur2());a.repaint();}});
		x10.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {y2.fig=4;}});
		x11.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {Options.setVisible(true);}});
		y1.add(x);
		y1.add(x1);
		y1.add(x2);
		y1.add(x3);
		y1.add(x5);
		y1.add(x4);
		y3.add(x6);
		y3.add(x7);
		y3.add(x9);
		y3.add(x10);
		y3.add(x11);
		y1.setBackground(new Color(255,255,255));
		y3.setBackground(new Color(100,100,255));
		y1.setBorder(BorderFactory.createRaisedBevelBorder());
		u.add(y1,BorderLayout.NORTH);
		u.add(y2);
		u.add(y3,BorderLayout.WEST);
		u.add(y4,BorderLayout.EAST);
		u.add(y45,BorderLayout.SOUTH);
		y3.setLayout(new BoxLayout(y3, BoxLayout.Y_AXIS));
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setSize(1300,800);
		a.setVisible(true);
		a.setTitle("Editeur");
	}
}
