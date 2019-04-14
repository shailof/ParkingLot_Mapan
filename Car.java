public class Car{
	
	String registrationNumber;
	String colour;
	
	public Car(String registrationNumber, String colour){
		this.registrationNumber = registrationNumber;
		this.colour = colour;
	}
	
	public String getRegistrationNumber(){
		return registrationNumber;
	}
	
	public String getColour(){
		return colour;
	}
	
}