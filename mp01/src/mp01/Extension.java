package mp01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public abstract class Extension implements Serializable {

private static Map<Class, List<Extension>> allExtents = new Hashtable<>();
	
	public Extension() {
		List<Extension> extent = null;
		Class theClass = this.getClass();
		
		if (allExtents.containsKey(theClass)) {
			extent = allExtents.get(theClass);
		}
		else {
			extent = new ArrayList();
			allExtents.put(theClass, extent);
		}
		extent.add(this); 
	}
	
	
	public static void writeExtent(ObjectOutputStream stream) throws IOException {
		stream.writeObject(allExtents);
	}
	
	
	public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		allExtents = (Hashtable) stream.readObject();
	}
	
	
	public String toString() {
		return "Uzupe³niæ metodê toString"; 
	}
	
	public static void showExtent(Class theClass) {
		List<Extension> extent = null;
		if (allExtents.containsKey(theClass)) {
			extent = allExtents.get(theClass);
			for (Object obj : extent) {
				System.out.println(obj);
			}
		}
		else {
			System.out.println("Brak klasy: "+theClass.toString());
		}
	}
	
	public static <T> List<T> getExtent(Class theClass) {
		List<Extension> extent = null;
		if (allExtents.containsKey(theClass)) {
			extent = allExtents.get(theClass);
			for(Extension cl:extent) {
			System.out.println(theClass.toString() + " " + cl);
			}
		}
		else {
			System.out.println("Brak klasy: "+theClass.toString());
		}
		return (List<T>) extent;
	}
}