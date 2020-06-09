package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OrdersTesting.class, UserTesting.class, VehicleTesting.class })
public class AllTests {

}
