package carros;


public class Main {

    public static void main(String[] args) {
        
        Car car = new Car();
        
        car.setCompany_name("Chevrolet");
        car.setModel_name("Cruze");
        car.setYear(2009);
        
        
        
        String nombre_empresa = car.getCompany_name();
        String modelo = car.getModel_name();
        int year = car.getYear();
        double mileage = car.getMileage();
        
        
        System.out.println("Company name: " + nombre_empresa);
        System.out.println("Model name: " + modelo);
        System.out.println("Year: " + year);
        System.out.println("Mileage: " + mileage);
    }
    
}
