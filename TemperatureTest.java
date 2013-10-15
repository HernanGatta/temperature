
/**
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @author Hernan Gatta <hernan.gatta@mail.mcgill.ca>
 * @version 2013.10.06
 * @version 2013.10.15 Code cleanup. Unit Testing Temperature class
 */
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;

public class TemperatureTest {

    // Constants
    private static final double EPSILON = 1E-3;
    
    // .ctor
    public static void main(String[] args) {
        JUnitCore.main(new String[]{"TemperatureTest"});
    }

    // Constructor Tests
    @Test
    /**
     * This method asserts that upon creation of a new instance of the
     * {@code Temperature} class, the data that is fed to the constructor is the
     * same as the data we recuperate from calling
     * {@code Temperature.getValue()} and {@code Temperature.getUnits()).
     *
     * Calls {@code Temperature.ctor(double, Temperature.Units)}.
     */
    public void verifyCreateFromScratch() {
        // We choose three different temperature values (1, 2, 3) to ensure that
        // the class is storing them on a per-instance basis. The same with the
        // units.
        Temperature kTemp = new Temperature(1, Temperature.Units.KELVIN);
        Temperature cTemp = new Temperature(2, Temperature.Units.CELSIUS);
        Temperature fTemp = new Temperature(3, Temperature.Units.FAHRENHEIT);

        assertTrue("Unit in Kelvin is registered.",
                   kTemp.getUnits() == Temperature.Units.KELVIN);
        assertTrue("Unit in Celsius is registered.",
                   cTemp.getUnits() == Temperature.Units.CELSIUS);
        assertTrue("Unit in Fahrenheit is registered.",
                   fTemp.getUnits() == Temperature.Units.FAHRENHEIT);

        assertEquals("Value in Kelvins is registered.",
                     kTemp.getValue(), 1, EPSILON);
        assertEquals("Value in Celsius is registered.",
                     cTemp.getValue(), 2, EPSILON);
        assertEquals("Value in Fahrenheit is registered.",
                     fTemp.getValue(), 3, EPSILON);
    }

    /**
     * This method asserts that upon creation of a new instance of the
     * {@code Temperature} class, the data that is fed to the constructor is the
     * same as the data we recuperate from calling
     * {@code Temperature.getValue()} and {@code Temperature.getUnits()).
     *
     * Calls {@code Temperature.ctor(Temperature)}.
     */
    @Test
    public void verifyCreateFromExisisting() {
        // We create three different instances. The reasoning for (1, 2, 3) is
        // the same as for verifyCreateFromScratch.
        Temperature kOriginal = new Temperature(1, Temperature.Units.KELVIN);
        Temperature cOriginal = new Temperature(2, Temperature.Units.CELSIUS);
        Temperature fOriginal = new Temperature(3, Temperature.Units.FAHRENHEIT);

        // We then create shallow copies and check that the data was copied over
        // properly.
        Temperature kCopy = new Temperature(kOriginal);
        Temperature cCopy = new Temperature(cOriginal);
        Temperature fCopy = new Temperature(fOriginal);

        assertTrue("Kelvin: Unit information was copied.",
                   kOriginal.getUnits() == kCopy.getUnits());
        assertEquals("Kelvin: Value information was copied.",
                     kOriginal.getValue(),
                     kCopy.getValue(),
                     EPSILON);

        assertTrue("Celsius: Unit information was copied.",
                   cOriginal.getUnits() == cCopy.getUnits());
        assertEquals("Celsius: Value information was copied.",
                     cOriginal.getValue(),
                     cCopy.getValue(),
                     EPSILON);

        assertTrue("Fahrenheit: Unit information was copied.",
                   fOriginal.getUnits() == fCopy.getUnits());
        assertEquals("Fahrenheit: Value information was copied.",
                     fOriginal.getValue(),
                     fCopy.getValue(),
                     EPSILON);
    }

    // Base-case Conversion Tests (Kelvin to X)
    /**
     * Performs a base-case conversion from Kelvin to Kelvin and verifies that
     * the conversion math be correct.
     */
    @Test
    public void verifyKelvinToKelvin() {
        // Normal Case
        final double original = 100;
        final double expected = 100;

        verifyXtoY(Temperature.Units.KELVIN,
                   Temperature.Units.KELVIN,
                   original,
                   expected);
    }

    /**
     * Performs a base-case conversion from Kelvin to Celsius and verifies that
     * the conversion math be correct.
     */
    @Test
    public void verifyKelvinToCelsius() {
        // Normal Case
        final double original = 100;
        final double expected = -173.15;

        verifyXtoY(Temperature.Units.KELVIN,
                   Temperature.Units.CELSIUS,
                   original,
                   expected);
    }

    /**
     * Performs a base-case conversion from Kelvin to Fahrenheit and verifies
     * that the conversion math be correct.
     */
    @Test
    public void verifyKelvinToFahrenheit() {
        // Normal Case
        final double original = 100;
        final double expected = -279.67;

        verifyXtoY(Temperature.Units.KELVIN,
                   Temperature.Units.FAHRENHEIT,
                   original,
                   expected);
    }

    // Conversion Tests (Celsius to X)
    /**
     * Performs a base-case conversion from Celsius to Celsius and verifies that
     * the conversion math be correct.
     */
    @Test
    public void verifyCelsiusToCelsius() {
        // Normal Case
        final double original = 100;
        final double expected = 100;

        verifyXtoY(Temperature.Units.CELSIUS,
                   Temperature.Units.CELSIUS,
                   original,
                   expected);
    }

    /**
     * Performs a base-case conversion from Celsius to Kelvin and verifies that
     * the conversion math be correct.
     */
    @Test
    public void verifyCelsiusToKelvin() {
        // Normal Case
        final double original = 100;
        final double expected = 373.15;

        verifyXtoY(Temperature.Units.CELSIUS,
                   Temperature.Units.KELVIN,
                   original,
                   expected);
    }

    /**
     * Performs a base-case conversion from Celsius to Fahrenheit and verifies
     * that the conversion math be correct.
     */
    @Test
    public void verifyCelsiusToFahrenheit() {
        // Normal Case
        final double original = 100;
        final double expected = 212;

        verifyXtoY(Temperature.Units.CELSIUS,
                   Temperature.Units.FAHRENHEIT,
                   original,
                   expected);
    }

    // Conversion Tests (Fahrenheit to X)
    /**
     * Performs a base-case conversion from Fahrenheit to Fahrenheit and
     * verifies that the conversion math be correct.
     */
    @Test
    public void verifyFahrenheitToFahrenheit() {
        // Normal Case
        final double original = 100;
        final double expected = 100;

        verifyXtoY(Temperature.Units.FAHRENHEIT,
                   Temperature.Units.FAHRENHEIT,
                   original,
                   expected);
    }

    /**
     * Performs a base-case conversion from Fahrenheit to Celsius and verifies
     * that the conversion math be correct.
     */
    @Test
    public void verifyFahrenheitToCelsius() {
        // Normal Case
        final double original = 100;
        final double expected = 37.778;

        verifyXtoY(Temperature.Units.FAHRENHEIT,
                   Temperature.Units.CELSIUS,
                   original,
                   expected);
    }

    /**
     * Performs a base-case conversion from Fahrenheit to Kelvin and verifies
     * that the conversion math be correct.
     */
    @Test
    public void verifyFahrenheitToKelvin() {
        // Normal Case
        final double original = 100;
        final double expected = 310.928;

        verifyXtoY(Temperature.Units.FAHRENHEIT,
                   Temperature.Units.KELVIN,
                   original,
                   expected);
    }

    // Invalid Cases
    /**
     * Verifies that an exception be thrown when the constructor is called with
     * {@code Double.NaN} as a temperature value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void verifyExceptionOnNaN() {
        new Temperature(Double.NaN, Temperature.Units.KELVIN);
    }

    /**
     * Verifies that an exception be thrown when the constructor is called with
     * {@code Double.POSITIVE_INFINITY} as a temperature value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void verifyExceptionOnPositiveInfinity() {
        new Temperature(Double.POSITIVE_INFINITY, Temperature.Units.KELVIN);
    }

    /**
     * Verifies that an exception be thrown when the constructor is called with
     * {@code Double.NEGATIVE_INFINITY} as a temperature value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void verifyExceptionOnNegativeInfinity() {
        new Temperature(Double.NEGATIVE_INFINITY, Temperature.Units.KELVIN);
    }

    // Private Helper Methods
    /**
     * Creates a new instance of the {@code Temperature} class with the given
     * {@code originalValue} value, converts it to the given {@code targetUnit}
     * unit and asserts that the result be equal to the given
     * {@code expectedValue} value.
     */
    private void verifyXtoY(final Temperature.Units baseUnit, final Temperature.Units targetUnit,
                            final double originalValue, final double expectedValue) {
        double returned;

        Temperature temperature = new Temperature(originalValue, baseUnit);
        temperature.changeUnits(targetUnit);
        returned = temperature.getValue();

        assertEquals(String.format("Conversion from %s to %s.", baseUnit, targetUnit),
                     expectedValue,
                     returned,
                     EPSILON);
    }

}
