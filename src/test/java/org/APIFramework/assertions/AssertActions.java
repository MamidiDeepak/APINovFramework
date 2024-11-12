package org.APIFramework.assertions;

import org.testng.Assert;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertActions {

    public static void validateResponseData(String expected, String actual){
        Assert.assertEquals(actual,expected);
    }

    public static void validateResponseDataUsingAssertJ(String actual,String expected){
        assertThat(actual).isEqualTo(expected);
    }
}
