import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class ConditionalTests {

    @Test
    @Disabled("Don't run this test until we fix #123 bug")
    void basicTest(){
        // execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly(){

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly(){

    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly(){

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void testForWindowsAndLinux(){

    }

    @Test
    @EnabledIfEnvironmentVariable(
            named = "LUV2CODE_ENV",
            matches = "DEV"
    )
    void testOnlyForDevEnvironment(){

    }

    @Test
    @EnabledIfSystemProperty(
            named = "LUV2CODE_SYS_PROP",
            matches = "CI_CD_DEPLOY"
    )
    void testOnlyForSystemProperty(){

    }
}
