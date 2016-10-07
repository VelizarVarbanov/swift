import java.util.ArrayList;
import java.util.Scanner;

public class VehicleMonito {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double F = sc.nextDouble();
        String strBul = sc.nextLine();
        String str = sc.nextLine();
        String[][] carInfo = new String[N][];
        String[] split = null;
        int[] licenseNo = new int[N];
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                str = sc.nextLine();
            }
            split = str.trim().split("\\s*,\\s*");
            carInfo[i] = new String[split.length];
            for (int j = 0; j < split.length; j++) {
                carInfo[i][j] = split[j];
            }
            licenseNo[i] = i;
        }
        for (int i = 0; i < N; i++) {
            if (carInfo[i].length > 6) {
                System.out.printf("%04d-%s, %d, %s", licenseNo[i], carInfo[i][1], Integer.parseInt(carInfo[i][4]), carInfo[i][7]);
                Vehicle vehicle = new Vehicle(carInfo[i][0], carInfo[i][1], Integer.parseInt(carInfo[i][2]), Double.parseDouble(carInfo[i][3]), Integer.parseInt(carInfo[i][4]));
                System.out.println();
                System.out.printf("Insurance cost: %.2f - Тravel cost: %.2f", vehicle.getInsurancePrice(), Vehicle.calculateTripPrice(F, Double.parseDouble(carInfo[i][5])));
                System.out.println();
            }
            else if (carInfo[i].length <= 6) {
                System.out.printf("%04d-%s, %d,  N/A", licenseNo[i], carInfo[i][1], Integer.parseInt(carInfo[i][4]));
                Vehicle vehicle = new Vehicle(carInfo[i][0], carInfo[i][1], Integer.parseInt(carInfo[i][2]), Double.parseDouble(carInfo[i][3]), Integer.parseInt(carInfo[i][4]));
                System.out.println();
                System.out.printf("Insurance cost: %.2f - Тravel cost: %.2f", vehicle.getInsurancePrice(), Vehicle.calculateTripPrice(F, Double.parseDouble(carInfo[i][5])));
                System.out.println();
            }
        }
    }

    public static class Vehicle {
        String type;
        String model;
        int power;
        double fuelConsumption;
        int yearProduced;
        long licenseNo;
        int weight;
        String color;

        public Vehicle(String type, String model, int power, double fuelConsumption, int yearProduced) {
            this.type = type;
            this.model = model;
            this.power = power;
            this.fuelConsumption = fuelConsumption;
            this.yearProduced = yearProduced;
        }

        public static double calculateTripPrice(double fuelPrice, double distance) {
            return fuelPrice * distance;
        }

        public double getInsurancePrice() {
            double insurance = 0.0;
            if (this.type.equals("car")) {
                insurance = (0.16 * this.power * 1.25 * (2016 - this.yearProduced) * (0.05 * this.fuelConsumption) * 1.00);
            } else if (this.type.equals("suv")) {
                insurance = (0.16 * this.power * 1.25 * (2016 - this.yearProduced) * (0.05 * this.fuelConsumption) * 1.12);
            } else if (this.type.equals("truck")) {
                insurance = (0.16 * this.power * 1.25 * (2016 - this.yearProduced) * (0.05 * this.fuelConsumption) * 1.2);
            } else if (this.type.equals("motorcycle")) {
                insurance = (0.16 * this.power * 1.25 * (2016 - this.yearProduced) * (0.05 * this.fuelConsumption) * 1.5);
            }
            return insurance;
        }
    }

}

