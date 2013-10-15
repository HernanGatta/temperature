
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
    public void VerifyCreateFromScratch() {
        // We expect that what we put in is what comes out.
        Temperature kTemp = new Temperature(1, Temperature.Units.KELVIN);
        Temperature cTemp = new Temperature(2, Temperature.Units.CELSIUS);
        Temperature fTemp = new Temperature(3, Temperature.Units.FAHRENHEIT);

        assertTrue("Unit in Kelvin is registered.", kTemp.getUnits() == Temperature.Units.KELVIN);
        assertTrue("Unit in Celsius is registered.", cTemp.getUnits() == Temperature.Units.CELSIUS);
        assertTrue("Unit in Fahrenheit is registered.", fTemp.getUnits() == Temperature.Units.FAHRENHEIT);

        assertTrue("Value in Kelvins is registered.", areEqual(kTemp.getValue(), 1));
        assertTrue("Value in Celsius is registered.", areEqual(cTemp.getValue(), 2));
        assertTrue("Value in Fahrenheit is registered.", areEqual(fTemp.getValue(), 3));
    }
    @Test
    public void VerifyCreateFromExisisting() {
        // We expect that what we put in is what comes out.
        Temperature kOriginal = new Temperature(1, Temperature.Units.KELVIN);
        Temperature cOriginal = new Temperature(2, Temperature.Units.CELSIUS);
        Temperature fOriginal = new Temperature(3, Temperature.Units.FAHRENHEIT);

        Temperature kCopy = new Temperature(kOriginal);
        Temperature cCopy = new Temperature(cOriginal);
        Temperature fCopy = new Temperature(fOriginal);
        
        assertTrue("Kelvin: Unit information was copied.", kOriginal.getUnits() == kCopy.getUnits());
        assertTrue("Kelvin: Value information was copied.", areEqual(kOriginal.getValue(), kCopy.getValue()));
        
        assertTrue("Celsius: Unit information was copied.", cOriginal.getUnits() == cCopy.getUnits());
        assertTrue("Celsius: Value information was copied.", areEqual(cOriginal.getValue(), cCopy.getValue()));
        
        assertTrue("Fahrenheit: Unit information was copied.", fOriginal.getUnits() == fCopy.getUnits());
        assertTrue("Fahrenheit: Value information was copied.", areEqual(fOriginal.getValue(), fCopy.getValue()));
    }

    // Helper Methods
    private static Boolean areEqual(double a, double b) {
        return (Math.abs(a - b) <= EPSILON);
    }
}
