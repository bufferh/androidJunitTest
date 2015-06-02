package com.example.buffer.junittest;


import junit.framework.TestCase;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * Created by buffer on 15-5-19.
 *
 * 使用junit框架， 未使用android test框架
 * 方法名为test开头且打上@test注解的将会被测试
 * 执行 ./gradlew test 后， 测试结果将以html 形式存在， 路径在app/build/reports/tests/debug/index.html
 */
public class TestCaseDemo extends TestCase {

    /**
     * Email validation pattern.
     */
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    @Test
    public void testSum() {
        int a = 5;
        int b = 10;
        int result = a + b;
        assertTrue(15 == result);
    }

    @Test
    public void testEmailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(isValidEmail(EMAIL_PATTERN, "name@email.com"));
    }

    @Test
    public void testEmaillValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(isValidEmail(EMAIL_PATTERN, "name@email.co.uk"));
    }

    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(isValidEmail(EMAIL_PATTERN, "name@email"));
    }


    public static boolean isValidEmail(Pattern emailPattern, CharSequence email) {
        return email != null && emailPattern.matcher(email).matches();
    }


}
