// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] companies = {
                "Apple",
                "Samsung",
                "Lenovo",
                "Nokia",
                "Oneplus",
                "Xiaomi",
                "Huawei",
                "HTC",
                "IbraPhone",
                "OPPO",
                "LG",
                "Vivo",
                "RealME",
                "HONOR",
                "Acer",
                "Asus",
                "BlackBerry",
                "BlackView",
                "BQ",
                "GOOGLE"
        };
        char[] uppercaseLetters = {
                'A','B','C','D','E','F','G','H','I','J',
                'K','L','M','N','O','P','Q','R','S','T'
        };
        String[] randomIntegers = {
                "2","3","4","5","6",
                "7","8","9","10","20",
                "30","40","50","60","70",
                "80","90","55","66","22"
        };

        String[] randomColors = {
                "Red","Blue","Green","Yellow","Purple",
                "Pink","Orange","Brown","Gray","Tiffany",
                "Lavender","Indigo","Cyan","Maroon","Burberry",
                "Peach","Plum","Gold","Silver","Turquoise"
        };

        int[] frameRates = {
                16,24,30,60,120,144,240,360,45,75,90,
                100,200,480,50,70,165,300,75,15
        };
        int[] memories = {
                8,16,24,32,64,128,256,600,1024,2048
        };

        String[] laptopProcessors = {
                "Bionic A17 Pro",
                "Dimensity 9200 Plus",
                "Snapdragon 8 Gen 2",
                "Snapdragon 7 plus",
                "Kirin 9000s",
                "AMD Ryzen 5 5600X",
                "Intel Core i9-10980HK",
                "Exynos 1330",
                "Intel Core i7-11800H",
                "AMD Ryzen 7 5700U",
                "Intel Core i5-11500",
                "Helio G99",
                "Apple M2",
                "Qualcomm Snapdragon 8cx Gen 3",
                "Intel Core i9-12900H",
                "AMD Ryzen 9 6900HX",
                "Intel Core i7-11700K",
                "Tiger T618",
                "Intel Core i5-11400F",
                "Exynos 7870"
        };

        Scanner scanner = new Scanner(System.in);

        // Step 1: Ask the user to input the number of devices they want to create.
        System.out.print("Please specify the quantity of devices you wish to generate, within the range of 1 to 20: ");
        int numberOfDevices = scanner.nextInt();

        // Validate input
        if (numberOfDevices < 1 || numberOfDevices > 20) {
            System.out.println("Please input a number within the range of 1 to 20");
            return;
        }

        // Create lists to store devices and track distinct types
        ArrayList<Device> devices = new ArrayList<>();
        ArrayList<String> distinctTypes = new ArrayList<>();

        Random rand = new Random();

        // Step 2: Generate random instances of devices with different types, prices, and weights.
        for (int i = 0; i < numberOfDevices; i++) {
            // Generate random values for device properties
            String[] possibleTypes = { "Smartphone", "Laptop", "Headphones" };
            String randomType = possibleTypes[rand.nextInt(possibleTypes.length)];
            double randomPrice = Math.round(rand.nextDouble() * 1000.0); // Random price between 0 and 1000
            double randomWeight = rand.nextDouble() * 5.0; // Random weight between 0 and 5

            // Create devices based on the random type
            if (randomType.equals("Smartphone")) {
                devices.add(new phone(randomType, randomPrice, randomWeight, companies[rand.nextInt(20)] + " " + uppercaseLetters[rand.nextInt(20)] + randomIntegers[rand.nextInt(20)], memories[rand.nextInt(11)], frameRates[rand.nextInt(20)]));
            } else if (randomType.equals("Laptop")) {
                devices.add(new Laptop(randomType, randomPrice, randomWeight, companies[rand.nextInt(20)] + " " + uppercaseLetters[rand.nextInt(20)] + randomIntegers[rand.nextInt(20)], laptopProcessors[rand.nextInt(20)], frameRates[rand.nextInt(20)]));
            } else if (randomType.equals("Headphones")) {
                devices.add(new Headphones(randomType, randomPrice, randomWeight, companies[rand.nextInt(20)] + " " + uppercaseLetters[rand.nextInt(20)] + randomIntegers[rand.nextInt(20)], randomColors[rand.nextInt(20)], rand.nextInt(10, 40)));
            }

            // Track distinct types
            if (!distinctTypes.contains(randomType)) {
                distinctTypes.add(randomType);
            }
        }

        // Step 3: Calculate and display the information
        double totalPrice = 0;
        double totalWeight = 0;

        for (Device device : devices) {
            totalPrice += device.getPrice();
            totalWeight += device.getWeight();
        }

        // Step 4: Display the calculated information
        System.out.println("Device types created: " + distinctTypes.size());
        System.out.println("Total price : $" + totalPrice);
        System.out.println("Total weight : " + totalWeight + " kg");

        for (Device device : devices) {
            System.out.println("Device Type: " + device.getType());

            // Check the type of device and cast accordingly to access specific properties
            if (device instanceof phone) {
                phone phone = (phone) device;
                System.out.println("Device Name: " + phone.getName());
                System.out.println("Memory: " + phone.getMemory() + " GB");
                System.out.println("FPS: " + phone.getFps() + " fps");
            } else if (device instanceof Laptop) {
                Laptop laptop = (Laptop) device;
                System.out.println("Device Name: " + laptop.getName());
                System.out.println("Processor: " + laptop.getProcessor());
                System.out.println("FPS: " + laptop.getFps() + " fps");
            } else if (device instanceof Headphones) {
                Headphones headphones = (Headphones) device;
                System.out.println("Device Name: " + headphones.getName());
                System.out.println("Color: " + headphones.getColor());
                System.out.println("Durability: " + headphones.getDurability() + " hours");
            }

            System.out.println("Device Price: $" + device.getPrice());
            System.out.println("Device Weight: " + device.getWeight() + " kg");
            System.out.println(); // Add a line break between devices
        }

        // Close the scanner
        scanner.close();



    }
}