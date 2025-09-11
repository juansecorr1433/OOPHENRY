package carros;


public class Main {

    public static void main(String[] args) {
        
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        
        car1.setCompany_name("Chevrolet");
        car1.setModel_name("Cruze");
        car1.setYear(2009);
        car1.setMileage(84000);
        
        car2.setCompany_name("Kia");
        car2.setModel_name("Fiesta");
        car2.setYear(2014);
        car2.setMileage(54000);
        
        car3.setCompany_name("Ferrari");
        car3.setModel_name("LaFerrari");
        car3.setYear(2017);
        car3.setMileage(37000);
        
        System.out.println("---Carro 1 ---");
        System.out.println("Company name: " + car1.getCompany_name());
        System.out.println("Model name: " + car1.getModel_name());
        System.out.println("Year: " + car1.getYear());
        System.out.println("Mileage: " + car1.getMileage());
        
        System.out.println("---Carro 2 ---");
        System.out.println("Company name: " + car2.getCompany_name());
        System.out.println("Model name: " + car2.getModel_name());
        System.out.println("Year: " + car2.getYear());
        System.out.println("Mileage: " + car2.getMileage());
        
        System.out.println("---Carro 3 ---");
        System.out.println("Company name: " + car3.getCompany_name());
        System.out.println("Model name: " + car3.getModel_name());
        System.out.println("Year: " + car3.getYear());
        System.out.println("Mileage: " + car3.getMileage());
    }
    
}
