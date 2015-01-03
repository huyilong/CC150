//maybe we need multiple files with public class and then compile together
//and after javac *.java we only need to type in java file(with the main function linked with all files)

public enum VehicleSize { Motorcycle, Compact, Large}

//abstract does not necessarily have abstract methods
//but it is cannot be instantiated unless being extended and overrided
public abstract class Vehicle{
	//declared as protected so that it could be seen only in the inherited classes
	protected ArrayList<ParkingSpot> ParkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;//plate 

}