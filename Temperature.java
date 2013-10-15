
/**
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @author Hernan Gatta <hernan.gatta@mail.mcgill.ca>
 * @version 2013.10.06 Program for ECSE 321, Assignment 2, Fall 2013
 * @version 2013.10.15 Code cleanup.
 */
/**
 * The {@code Temperature} class allows a user to convert temperature from on
 * unit to another.
 *
 * Sample usage
 * <pre><code>
 *    Temperature averageHighInOctober = new Temperature (15, Temperature.CELSIUS);
 *    Temperature converted = new Temperature(averageHighInOctober);
 *    converted.changeUnits(Temperature.FAHRENHEIT);
 *    System.out.println(
 *          String.format(
 *              "The average temperature of Montreal in October 2012 was %s (%s)",
 *              averageHighInOctober.toString(),
 *              converted.toString()));
 * </code></pre>
 */
public final class Temperature {

    /**
     * Enumeration for different temperature units
     */
    public static enum Units {

        FAHRENHEIT,
        CELSIUS,
        KELVIN
    }
    // Data
    private final double mValueInKelvins;
    private Units mUnit;

    //.ctors
    /**
     * Create a new {@code Temperature} with given attributes
     *
     * @param value numerical value of {@code Temperature}
     * @param units {@code Units} of {@code Temperature}
     */
    public Temperature(double value, Temperature.Units unit) {
        mUnit = unit;
        mValueInKelvins = convertToKelvin(value);
    }

    /**
     * Create a copy of existing {@code Temperature} object
     *
     * @param temperature an existing {@code Temperature} object
     */
    public Temperature(Temperature temperature) {
        mValueInKelvins = temperature.mValueInKelvins;
        mUnit = temperature.mUnit;
    }

    // Private Methods
    /**
     * Convert a {@code Temperature} value from {@code Units} to Kelvin
     *
     * @param value numerical value of Temperature
     */
    private double convertToKelvin(double value) {
        switch (mUnit) {
            case KELVIN:
                return value;
            case CELSIUS:
                return value + 273.15;
            case FAHRENHEIT:
                return (value + 459.67) * 5.0 / 9.0;

            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Convert a {@code Temperature} value from Kelvin to {@code Units}
     *
     * @param value numerical value of Temperature
     */
    private double convertFromKelvin(double value) {
        switch (mUnit) {
            case KELVIN:
                return value;
            case CELSIUS:
                return value - 273.15;
            case FAHRENHEIT:
                return value * 9.0 / 5.0 - 459.67;

            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Format {@code Units}
     */
    private String unitsToString() {
        switch (mUnit) {
            case KELVIN:
                return "K";
            case CELSIUS:
                return "°C";
            case FAHRENHEIT:
                return "°F";

            default:
                throw new IllegalArgumentException();
        }
    }

    // Public Methods
    /**
     * Get the value of the {@code Temperature}
     *
     * @return numerical value of the {@code Temperature} in the current
     * {@code Units}
     */
    public double getValue() {
        return convertFromKelvin(mValueInKelvins);
    }

    /**
     * Get the current {@code Units} of the {@code Temperature}
     *
     * @return current {@code Units} of {@code Temperature}
     */
    public Units getUnits() {
        return mUnit;
    }

    /**
     * Change the current {@code Units} of the {@code Temperature}. Changing the
     * {@code Units} also changes the numerical value in a consistent manner.
     *
     * @param units the new {@code Units}
     */
    public void changeUnits(Units units) {
        mUnit = units;
    }

    /**
     * Convert the {@code Temperature} to {@code String}. The output is as
     * follows
     * <pre><code>
     *    Temperature temperature = new Temperature(0, Temperature.Units.CELSIUS);
     *    System.out.println(temperature.toString()); // prints "0 °C"
     *    temperature.changeUnits(Temperature.Units.FAHRENHEIT);
     *    System.out.println(temperature.toString()); // prints "32 °F"
     *    temperature.changeUnits(Temperature.Units.KELVIN);
     *    System.out.println(temperature.toString()); // prints "273.15 K"
     * </code></pre>
     */
    @Override
    public String toString() {
        return getValue() + " " + unitsToString();
    }
}
