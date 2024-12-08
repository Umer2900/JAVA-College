import java.util.Scanner;

class TemperatureConverter 
{
    // Method to convert Celsius to Fahrenheit and Kelvin
    public static void convertFromCelsius(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        double kelvin = celsius + 273.15;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        System.out.println(celsius + "°C = " + kelvin + "K");
    }

    // Method to convert Fahrenheit to Celsius and Kelvin
    public static void convertFromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        double kelvin = celsius + 273.15;
        System.out.println(fahrenheit + "°F = " + celsius + "°C");
        System.out.println(fahrenheit + "°F = " + kelvin + "K");
    }

    // Method to convert Kelvin to Celsius and Fahrenheit
    public static void convertFromKelvin(double kelvin) {
        if (kelvin < 0) {
            System.out.println("Kelvin cannot be negative.");
            return;
        }
        double celsius = kelvin - 273.15;
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(kelvin + "K = " + celsius + "°C");
        System.out.println(kelvin + "K = " + fahrenheit + "°F");
    }
}


class TemperatureConverterProgram 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("Select the input temperature scale:");
        System.out.println("1. Celsius");
        System.out.println("2. Fahrenheit");
        System.out.println("3. Kelvin");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();

        switch (choice) {
            case 1: // Celsius
                TemperatureConverter.convertFromCelsius(temperature);
                break;
            case 2: // Fahrenheit
                TemperatureConverter.convertFromFahrenheit(temperature);
                break;
            case 3: // Kelvin
                TemperatureConverter.convertFromKelvin(temperature);
                break;
            default:
                System.out.println("Invalid choice! Please select a valid scale.");
        }

        scanner.close();
    }
}
