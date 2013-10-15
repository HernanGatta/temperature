
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
    private static final double EPSILON = 1E-6;

    // .ctor
    public static void main(String[] args) {
        JUnitCore.main(new String[]{"TemperatureTest"});
    }

    // Tests
    // Constructor Tests
    @Test
    public void verifyCreateFromScratch() {
        // We expect that what we put in is what comes out.
        Temperature kTemp = new Temperature(1, Temperature.Units.KELVIN);
        Temperature cTemp = new Temperature(2, Temperature.Units.CELSIUS);
        Temperature fTemp = new Temperature(3, Temperature.Units.FAHRENHEIT);

        assertTrue("Unit in Kelvin is registered.", kTemp.getUnits() == Temperature.Units.KELVIN);
        assertTrue("Unit in Celsius is registered.", cTemp.getUnits() == Temperature.Units.CELSIUS);
        assertTrue("Unit in Fahrenheit is registered.", fTemp.getUnits() == Temperature.Units.FAHRENHEIT);

        assertEquals("Value in Kelvins is registered.", kTemp.getValue(), 1, EPSILON);
        assertEquals("Value in Celsius is registered.", cTemp.getValue(), 2, EPSILON);
        assertEquals("Value in Fahrenheit is registered.", fTemp.getValue(), 3, EPSILON);
    }

    @Test
    public void verifyCreateFromExisisting() {
        // We expect that what we put in is what comes out.
        Temperature kOriginal = new Temperature(1, Temperature.Units.KELVIN);
        Temperature cOriginal = new Temperature(2, Temperature.Units.CELSIUS);
        Temperature fOriginal = new Temperature(3, Temperature.Units.FAHRENHEIT);

        Temperature kCopy = new Temperature(kOriginal);
        Temperature cCopy = new Temperature(cOriginal);
        Temperature fCopy = new Temperature(fOriginal);

        assertTrue("Kelvin: Unit information was copied.", kOriginal.getUnits() == kCopy.getUnits());
        assertEquals("Kelvin: Value information was copied.", kOriginal.getValue(), kCopy.getValue(), EPSILON);

        assertTrue("Celsius: Unit information was copied.", cOriginal.getUnits() == cCopy.getUnits());
        assertEquals("Celsius: Value information was copied.", cOriginal.getValue(), cCopy.getValue(), EPSILON);

        assertTrue("Fahrenheit: Unit information was copied.", fOriginal.getUnits() == fCopy.getUnits());
        assertEquals("Fahrenheit: Value information was copied.", fOriginal.getValue(), fCopy.getValue(), EPSILON);
    }

    // Conversion Tests
    @Test
    public void verifyKelvinToKelvin() {
        // Normal Case
        final double original = 100;
        final double expected = 100;
        double returned;

        Temperature temperature = new Temperature(original, Temperature.Units.KELVIN);
        temperature.changeUnits(Temperature.Units.KELVIN);
        returned = temperature.getValue();

        assertEquals(expected, returned, EPSILON);
    }

    @Test
    public void verifyKelvinToCelsius() {
        // Normal Case
        final double original = 100;
        final double expected = -173.15;
        double returned;

        Temperature temperature = new Temperature(original, Temperature.Units.KELVIN);
        temperature.changeUnits(Temperature.Units.CELSIUS);
        returned = temperature.getValue();

        assertEquals(expected, returned, EPSILON);
    }

    @Test
    public void verifyKelvinToFahrenheit() {
        // Normal Case
        final double original = 100;
        final double expected = -279.67;
        double returned;

        Temperature temperature = new Temperature(original, Temperature.Units.KELVIN);
        temperature.changeUnits(Temperature.Units.FAHRENHEIT);
        returned = temperature.getValue();

        assertEquals(expected, returned, EPSILON);
    }
}
