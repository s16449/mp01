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
	static List<Extension> extent = new ArrayList();

	public Extension() {

		Class theClass = this.getClass();

		if (allExtents.containsKey(theClass)) {
			this.extent = allExtents.get(theClass);
		} else {

			allExtents.put(theClass, this.extent);
		}
		extent.add(this);
	}

	public static void writeExtent(ObjectOutputStream stream) throws IOException {
		stream.writeObject(allExtents);
	}

	public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		allExtents =  (Map<Class, List<Extension>>) stream.readObject();
	}

	public static void showExtent(Class theClass) {

		if (allExtents.containsKey(theClass)) {
			extent = allExtents.get(theClass);
			for (Object obj : extent) {
				System.out.println(obj);
			}

			
		} else {
			System.out.println("Brak klasy: " + theClass.toString());
		}
	}

	public static <T> Iterable<T> getExtent(Class<T> type) throws ClassNotFoundException {
		if (allExtents.containsKey(type)) {
			return (Iterable<T>) allExtents.get(type);
		}

		throw new ClassNotFoundException(String.format("%s. Stored extents: %s", type.toString(), allExtents.keySet()));
	}
	
	

}
