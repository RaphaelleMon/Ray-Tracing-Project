package sceneXN;

import java.awt.Color;
import java.awt.image.BufferedImage;

import IG.FenetrePrincipale;
import elements3D.Couleur;
import elements3D.Materiau;
import elements3D.Plan;
import elements3D.Reflectivite;
import elements3D.Refringence;
import elements3D.Sphere;
import rayTracing.Camera;
import rayTracing.Lumiere;
import rayTracing.LumierePonctuelle;
import rayTracing.ModeleEclairement;
import rayTracing.ModelePhong;
import rayTracing.RayTracing;
import rayTracing.Scene;
import utilitaire.Point;
import utilitaire.Vecteur;
/**
 * 
 * @author jaden
 *
 */
public class SceneMedium3 {
	public static void main(String args[]) {
		
	try {
		// Création de la scène
	    Scene scene = new Scene(3000);
	    scene.setAmbiante(new Couleur( Color.white));
	    
	    	// Ajout d'une sphère
	    Sphere sphere1 = new Sphere(new Point(5,0,5), 2.5, "Sphere1");
	    Materiau materiau = sphere1.getMateriau();
	    Couleur couleur1 = materiau.getCouleur();
	    couleur1.set(200, 200, 200); // Blanc
	    ModeleEclairement eclairement = materiau.getEclairement();
	    ModelePhong phong = (ModelePhong) eclairement;
	    phong.setAmbiante(false);
	    phong.setDiffuse(false);
	    phong.setSpeculaire(false);
	    Reflectivite reflectivite1 = materiau.getReflectivite();
	    reflectivite1.setOn(true);
	    reflectivite1.setIntensite(1);
	    reflectivite1.setEnergie(1);
	    Refringence refraction1 = materiau.getRefringence();
	    refraction1.setOn(true);
	    refraction1.setIntensite(1);
	    refraction1.setEnergie(1);
	    scene.addObjet3D(sphere1);
	    
	    	// Ajout d'une sphère
	    Sphere sphere2 = new Sphere(new Point(5,7,5), 2.5, "Sphere2");
	    Couleur couleur2 = (Couleur)sphere2.getMateriau().getCouleur();
	    couleur2.set(255, 0, 0); // Rouge
	    Reflectivite reflectivite2 = (Reflectivite)sphere2.getMateriau().getReflectivite();
	    reflectivite2.setOn(true);
	    reflectivite2.setIntensite(0.5);
	    reflectivite2.setEnergie(1);
	    // scene.addObjet3D(sphere2);
	    
	 		// Ajout d'une sphère
	    Sphere sphere3 = new Sphere(new Point(-5,5,5), 2.5, "Sphere3");
	    Couleur couleur3 = (Couleur)sphere3.getMateriau().getCouleur();
	    couleur3.set(0, 255, 0); // Verte
	    Reflectivite reflectivite3 = (Reflectivite)sphere3.getMateriau().getReflectivite();
	    reflectivite3.setOn(true);
	    reflectivite3.setIntensite(0.5);
	    reflectivite3.setEnergie(1);
	    sphere3.getMateriau().setEnergieReflexion(1);
	    // scene.addObjet3D(sphere3);

	    
			// Ajout d'une sphère
	    Sphere sphere4 = new Sphere(new Point(12,7,5), 2.5, "Sphere4");
	    Couleur couleur4 = (Couleur)sphere4.getMateriau().getCouleur();
	    couleur4.set(0, 0, 255); // Bleue
	    Reflectivite reflectivite4 = (Reflectivite)sphere4.getMateriau().getReflectivite();
	    reflectivite4.setOn(true);
	    reflectivite4.setIntensite(1);
	    reflectivite4.setEnergie(1);
	    // scene.addObjet3D(sphere4);
	    
	    	// Ajout d'un plan
	    Plan plan = new Plan(new Vecteur(0,0,1), new Point(0,0,0),"plan");
	    Couleur couleur5 = (Couleur)plan.getMateriau().getCouleur();
	    couleur5.set(255, 255, 255); // Blanc
	    //Reflectivite reflectivite5 = (Reflectivite)plan.getMateriau().getReflectivite();
	    //reflectivite5.setOn(true);
	    scene.addObjet3D(plan);
	    
	    	// Ajout d'une lumière
	    Lumiere lumiere1 = new LumierePonctuelle(new Point(5,10,15),new Color(255,0,0)); // Rouge
	    // scene.addLumiere(lumiere1);
	    
			// Ajout d'une lumière
	    Lumiere lumiere2 = new LumierePonctuelle(new Point(50,50,50),new Color(0,0,255)); // Bleue
	    scene.addLumiere(lumiere2);
	    
		// Ajout d'une lumière
	    Lumiere lumiere3 = new LumierePonctuelle(new Point(50,-50,50),new Color(0,255,0)); // Bleue
	    scene.addLumiere(lumiere3);
	    
		// Ajout d'une lumière
	    Lumiere lumiere4 = new LumierePonctuelle(new Point(50,0,5),new Color(255,0,0)); // Bleue
	    scene.addLumiere(lumiere4);
	    // Pour obtenir des ombres diffuses, il faut ajouter des sources de lumière proches
	    // TODO : A reprendre pour faire une source non ponctuelle
	    /* for (int i = -5; i <= 5; i += 5) {
	    	for (int j = -5; j <= 5; j += 5) {
	    		for (int k = -5; k <= 5; k += 5) {
	    			 Lumiere lumiereDiffuse = new LumierePonctuelle(new Point(-100+i,j,50+k),new Color(0,0,128)); // Bleue
	    			 scene.addLumiere(lumiereDiffuse);
	    		}
	    	}
	    } */
	    
	    // Création de la caméra
	    Camera camera = new Camera(new Point(50,0,5),new Vecteur(-10,0,0),1000,1000,new Vecteur(0,0,2)); //vHaut = (0,0,10) sur l'exemple geogebra
		
	    // Lancement du ray tracing
		RayTracing raytracing = new RayTracing(scene, camera, 10, true, true);
		camera.sauvegarderImage("test4");
		FenetrePrincipale p = new FenetrePrincipale(raytracing);
		p.lancerFenetre();
	} catch (Exception e) {
		System.out.println("Erreur dans la gestion de la scène.");
	}
	}
}
