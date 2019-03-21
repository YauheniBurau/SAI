package core.TAS.asserts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

/**
 * Created by yauheniburau on 4/15/16.
 */

public class AssertUtility {

    /**
     * Проверить, что ссылка на объект не равна null, иначе выдать сообщение об ошибке
     * @param reason
     * @param actual
     */
    public <T> void assertThatNotNullValue(String reason, T actual) {
        assertThat(reason, actual, notNullValue() );
    }

    /**
     * Проверить, что ссылка на объект равна null, иначе выдать сообщение об ошибке
     * @param reason
     * @param actual
     */
    public <T> void assertThatNullValue(String reason, T actual) {
        assertThat(reason, actual, nullValue() );
    }

    /**
     * Проверить, что результат выражения или переменной равен true, иначе выдать сообщение об ошибке
     * @param reason
     * @param actual
     */
    public <T> void assertThatTrue(String reason, T actual) {
        assertThat(reason, actual, is(true) );
    }

    /**
     * Проверить, что результат выражения или переменной равен false, иначе выдать сообщение об ошибке
     * @param reason
     * @param actual
     */
    public <T> void assertThatFalse(String reason, T actual) {
        assertThat(reason, actual, is(false) );
    }

    /**
     * Проверить, что результат выражения или переменной равен: {2}, иначе выдать сообщение об ошибке
     * @param reason
     * @param actual
     */
    public <T> void assertThatIs(String reason, T actual, boolean mustBoolean) {
        assertThat(reason, actual, is(mustBoolean) );
    }

}
