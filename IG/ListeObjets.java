package IG;

import java.util.ArrayList;
import java.util.List;

import elements3D.*;
import rayTracing.Lumiere;

import javax.swing.AbstractListModel;

import IG.Objet;

public class ListeObjets extends AbstractListModel<Objet> {
	
	private ArrayList<Objet> objets;
	
	public ListeObjets() {
		this.objets = new ArrayList<Objet>();
	}
	
	public ArrayList<Objet> getObjets(){
		return this.objets;
	}
	

	
	public void addElement(Objet o){
		objets.add(o);
		fireContentsChanged(o, getSize() - 1, getSize() - 1);
	}
	
	public void reinitialiser(List<Objet3D> o) {
		if (o!=null) {
			
			this.objets.clear();
				
			for (int i = 0; i < o.size(); i++) {
				this.objets.add(new Objet(o.get(i)));
			}
		}
	}
	
	public void initialiser(List<Objet3D> o) {	
		if (o!=null) {
			for (int i = 0; i < o.size(); i++) {
				this.objets.add(new Objet(o.get(i)));
			}
		}
	}
	
	@Override
	public Objet getElementAt(int index){
		return objets.get(index);
	}
	
	@Override
	public int getSize(){
		return objets.size();
	}

}
