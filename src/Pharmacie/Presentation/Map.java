/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacie.Presentation;
/**
 *
 * @author Ben Salem
 */
import Pharmacie.Entite.Gouvernorat;
import Pharmacie.Entite.Pharmacie;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import org.jdesktop.swingx.JXMapKit;
import org.jdesktop.swingx.input.CenterMapListener;
import org.jdesktop.swingx.input.PanKeyListener;
import org.jdesktop.swingx.input.PanMouseInputListener;
import org.jdesktop.swingx.input.ZoomMouseWheelListenerCenter;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.mapviewer.Waypoint;
import org.jdesktop.swingx.mapviewer.WaypointPainter;

/**
 *
 * @author Ben Salem
 */
public class Map extends javax.swing.JFrame {

    /**
     * Creates new form mapp
     */
    static Gouvernorat g=new Gouvernorat();
    static ArrayList<Pharmacie> selection=new ArrayList<Pharmacie>();
    static boolean visi;
    static boolean acti;
                
    public Map() {
        
        visi=true;
        initComponents();
       
        
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
       
    }   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
   //static JPanel frame = new JPanel();
   static JFrame f = new JFrame();
   static final JXMapKit jx = new JXMapKit();
    public  void lancer(){
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                
                f.setSize(600, 460);Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
                f.setTitle("Localisation");
                f.addWindowListener(new java.awt.event.WindowAdapter() {
                    
               @Override
               public void windowActivated(java.awt.event.WindowEvent evt) {
                acti = true;
                }
                @Override
                public void windowClosing(java.awt.event.WindowEvent evt) {
                                                   
                    formWindowClosing(evt);
                     visi=false;
                     acti = false;
                     
                     }  
                
            
              });
                
                
                jx.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
                if(selection.size()==1){
                    genererMarker(selection.get(0).getAltitude(), selection.get(0).getLongitude(), 4);
                }else{
               
                if(g.getLatitude_gouv()==0.0 && g.getLongitude_gouv()== 0.0 )
                {
                    genererMarker(36,10,13);
                }
                else
                {
                    genererMarker(g.getLatitude_gouv(),g.getLongitude_gouv(),8);
                    
                }
           
                }
            f.add(jx);
            f.setVisible(true);
               
            
        }});
        
    }
                                 

   private static void genererMarker(double x, double y,int z )
   {
       //Position de map lat et long
                    jx.setCenterPosition(new GeoPosition(x, y));
        
                    jx.setZoom(z);
                
                    Set<Waypoint> waypoints = new HashSet<Waypoint>();
                    
                    for (final Pharmacie p : selection)
                    {
                        waypoints.add(new Waypoint() {
                           
                            public GeoPosition getPosition() {
                            GeoPosition g = new GeoPosition(p.getAltitude(),p.getLongitude() );
                            return g;
                            }
                        } );
                    }
                   
                     //crate a WaypointPainter to draw the points
                     final WaypointPainter painter = new WaypointPainter();
                     painter.setWaypoints(waypoints);
                     painter.setVisible(true);
                     jx.getMainMap().setOverlayPainter(painter);
                    //ajouter listener souris sur map pour le zoom et déplacement ...
                    MouseInputListener mia = new PanMouseInputListener(jx.getMainMap());
                    jx.getMainMap().addMouseListener(mia);
                    jx.getMainMap().addMouseMotionListener(mia);
                    jx.getMainMap().addMouseListener(new CenterMapListener(jx.getMainMap()));
                    jx.getMainMap().addMouseListener(new CenterMapListener(jx.getMainMap())
                     {
                           public void mousePressed(MouseEvent evt)
                           {
                              if(jx.getMainMap().getZoom()>13)
                              {
                     
                                      painter.setVisible(false);
                                      jx.getMainMap().setOverlayPainter(painter);
                                }
                              else
                              {
                                      painter.setVisible(true);
                                      jx.getMainMap().setOverlayPainter(painter);
             
                                }
                           }
                    });
        
                jx.getMainMap().addMouseWheelListener(new ZoomMouseWheelListenerCenter(jx.getMainMap()));
                jx.getMainMap().addMouseWheelListener(new ZoomMouseWheelListenerCenter(jx.getMainMap()){
                 public void mouseWheelMoved(MouseWheelEvent e)
                 {
                         if(jx.getMainMap().getZoom()>13)
                        {
                     
                            painter.setVisible(false);
                            jx.getMainMap().setOverlayPainter(painter);
                        }
                     else
                    {
                            painter.setVisible(true);
                            jx.getMainMap().setOverlayPainter(painter);
             
                    }
                }
            });
            jx.getMainMap().addKeyListener(new PanKeyListener(jx.getMainMap()));
   }
   
    // Variables declaration - do not modify                     
    // End of variables declaration                   
}