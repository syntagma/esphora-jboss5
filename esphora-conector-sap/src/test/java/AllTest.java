import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTest {
    public static Test suite() {
        TestSuite suite = new TestSuite("Test for com.chuidiang.ejemplos");
        suite.addTestSuite(testGetLastCMPLocal.class);
        return suite;
    }
}
