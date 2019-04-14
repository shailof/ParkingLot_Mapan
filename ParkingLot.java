import java.util.ArrayList;

public class ParkingLot{

	Integer nextSlot;			// Index for next parking slot, **Assumption nextSlot is always the smallest index 
	Integer numberOfSlot;     	// Number of Slot in parking Lot
	Car[] parkingSlots;			// Parking Slot to save array
	
	public ParkingLot(int numberOfSlot){
		this.numberOfSlot = numberOfSlot;
		parkingSlots = new Car[numberOfSlot];		// Initialize array Parking Slots
		nextSlot = 1;								// Set next slot to 1, since every parking slot is empty
		System.out.println("Created a parking lot with " + numberOfSlot + " slots");
	}
	
	public int getNumberOfSlot(){
		return numberOfSlot;
	}
	
	public Car[] getParkingSlots(){
		return parkingSlots;
	}
	
	public void park(String registrationNumber, String colour){
		if (nextSlot==null) {		// if next slots value is null, parking slot is full.
			System.out.println("Sorry, parking lot is full");
		} else {
			Car newCar = new Car(registrationNumber, colour);	// Create new car
			parkingSlots[nextSlot-1] = newCar;					// Set the car at nextSlot index
			System.out.println("Allocated slot number: " + nextSlot);
			
			while (parkingSlots[nextSlot-1]!=null) {			// Search for next slot, iterate until we find empty slots
				nextSlot++;
				if (nextSlot > numberOfSlot) {					// if no
					
					nextSlot = null;
					break;
				}
			}
		}
	}
	
	public void leave(int parkingSlotNumber){
		parkingSlots[parkingSlotNumber-1] = null;
		if (nextSlot==null || parkingSlotNumber < nextSlot) {
			nextSlot = parkingSlotNumber;
		} else {
			
		}
		
		System.out.println("Slot number " + parkingSlotNumber + " is free");
	}
	
	public void status() {
		String format = "%-10s%-20s%s%n";
		System.out .printf(format, "Slot No.", "Registration No", "Colour");
		for (Integer i = 0; i < numberOfSlot; i++) {
			if (parkingSlots[i]!= null) {
				System.out .printf(format, i+1, parkingSlots[i].getRegistrationNumber(), parkingSlots[i].getColour());
			}
		}
	}
	
	public void registration_numbers_for_cars_with_colour(String colour) {
		ArrayList<String> tempArrayList = new ArrayList<String>();
		for (Integer i = 0; i < numberOfSlot; i++) {
			if (parkingSlots[i].getColour().equals(colour)) {
				tempArrayList.add(parkingSlots[i].getRegistrationNumber());
			}
		}
		if (tempArrayList.isEmpty()) {
			System.out.println("Not Found");
		} else {
			String allRegistrationNumberString = String.join(", ", tempArrayList);
			System.out.println(allRegistrationNumberString);
		}
	}
	
	public void slot_numbers_for_cars_with_colour(String colour) {
		ArrayList<String> tempArrayList = new ArrayList<String>();
		for (Integer i = 0; i < numberOfSlot; i++) {
			if (parkingSlots[i].getColour().equals(colour)) {
				Integer tempInteger = i+1;
				tempArrayList.add(tempInteger.toString());
			}
		}
		if (tempArrayList.isEmpty()) {
			System.out.println("Not Found");
		} else {
			String allSlotsNumberString = String.join(", ", tempArrayList);
			System.out.println(allSlotsNumberString);
		}
	}

	public void slot_number_for_registration_number(String registrasionNumber) {
		ArrayList<String> tempArrayList = new ArrayList<String>();
		for (Integer i = 0; i < numberOfSlot; i++) {
			if (parkingSlots[i].getRegistrationNumber().equals(registrasionNumber)) {
				Integer tempInteger = i+1;
				tempArrayList.add(tempInteger.toString());
			}
		}
		if (tempArrayList.isEmpty()) {
			System.out.println("Not Found");
		} else {
			String allSlotsNumberString = String.join(", ", tempArrayList);
			System.out.println(allSlotsNumberString);
		}
	}	
	
	public static void main(String[] args) 
    { 
        ParkingLot myParkingLot = new ParkingLot(6);
		myParkingLot.park("KA-01-HH-1234", "White");
		myParkingLot.park("KA-01-HH-9999", "White");
		myParkingLot.park("KA-01-BB-0001", "Black");
		myParkingLot.park("KA-01-HH-7777", "Red");
		myParkingLot.park("KA-01-HH-2701", "Blue");
		myParkingLot.park("KA-01-HH-3141", "Black");
		myParkingLot.leave(4);
		myParkingLot.leave(3);
		myParkingLot.status();
		myParkingLot.park("KA-01-P-3343", "Grey");
		myParkingLot.park("KA-01-P-333", "White");
		myParkingLot.park("DL-12-AA-9999", "White");
		myParkingLot.registration_numbers_for_cars_with_colour("White");
		myParkingLot.slot_numbers_for_cars_with_colour("White");
		myParkingLot.slot_number_for_registration_number("KA-01-HH-3141");
		myParkingLot.slot_number_for_registration_number("MH-04-AY-1111");
    } 
}