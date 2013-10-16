
/**
 * ***************************************************************************
 * Assignment 3
 *
 * Student Name: Hernan A. Gatta Student ID:	260477492 Course: ECSE 321
 *
 * File: TemperatureTest.java Class: TemperatureTest
 *
 ****************************************************************************
 */
import org.junit.*;
import java.util.Locale;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;

/**
 * @author Aditya Mahajan <aditya.mahajan@mcgill.ca>
 * @author Hernan Gatta <hernan.gatta@mail.mcgill.ca>
 * @version 2013.10.06
 * @version 2013.10.15 Code cleanup. Unit Testing Temperature class
 */
public class TemperatureTest {
    // Constants
    /**
     * This constant specifies the maximum allowed difference between expected
     * and actual returned values.
     */
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

        assertEquals("Unit in Kelvin is registered.",
                     Temperature.Units.KELVIN,
                     kTemp.getUnits());
        assertEquals("Unit in Celsius is registered.",
                     Temperature.Units.CELSIUS,
                     cTemp.getUnits());
        assertEquals("Unit in Fahrenheit is registered.",
                     Temperature.Units.FAHRENHEIT,
                     fTemp.getUnits());

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

        assertEquals("Kelvin: Unit information was copied.",
                     kOriginal.getUnits(),
                     kCopy.getUnits());
        assertEquals("Kelvin: Value information was copied.",
                     kOriginal.getValue(),
                     kCopy.getValue(),
                     EPSILON);

        assertEquals("Celsius: Unit information was copied.",
                     cOriginal.getUnits(),
                     cCopy.getUnits());
        assertEquals("Celsius: Value information was copied.",
                     cOriginal.getValue(),
                     cCopy.getValue(),
                     EPSILON);

        assertEquals("Fahrenheit: Unit information was copied.",
                     fOriginal.getUnits(),
                     fCopy.getUnits());
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
        // This value means nothing to the converter, regardless of the unit.
        new Temperature(Double.NaN, Temperature.Units.KELVIN);
    }

    /**
     * Verifies that an exception be thrown when the constructor is called with
     * {@code Double.POSITIVE_INFINITY} as a temperature value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void verifyExceptionOnPositiveInfinity() {
        // This value means nothing to the converter, regardless of the unit.
        new Temperature(Double.POSITIVE_INFINITY, Temperature.Units.KELVIN);
    }

    /**
     * Verifies that an exception be thrown when the constructor is called with
     * {@code Double.NEGATIVE_INFINITY} as a temperature value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void verifyExceptionOnNegativeInfinity() {
        // This value means nothing to the converter, regardless of the unit.
        new Temperature(Double.NEGATIVE_INFINITY, Temperature.Units.KELVIN);
    }

    // String Tests
    /**
     * Verifies that the returned string representations match the description
     * in the documentation.
     */
    @Test
    public void verifyStringRepresentation_EN() {
        // Don't pass if this is a non-English culture.
        org.junit.Assume.assumeTrue(Locale.getDefault() == Locale.ENGLISH);
        
        // These values come from the documentation for the
        // Temperature.toString() method. They are also good measure for
        // fractional results.
        Temperature kTemperature = new Temperature(0, Temperature.Units.CELSIUS);
        Temperature cTemperature = new Temperature(0, Temperature.Units.CELSIUS);
        Temperature fTemperature = new Temperature(0, Temperature.Units.CELSIUS);

        kTemperature.changeUnits(Temperature.Units.KELVIN);
        fTemperature.changeUnits(Temperature.Units.FAHRENHEIT);

        assertEquals("0 °C", cTemperature.toString());
        assertEquals("32 °F", fTemperature.toString());
        assertEquals("273.15 K", kTemperature.toString());
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
        assertEquals("Target unit matches changed unit.",
                     targetUnit,
                     temperature.getUnits());
    }
}
