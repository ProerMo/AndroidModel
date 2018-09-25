package com.ygsoft.utilslib;

import com.ygsoft.utilslib.utils.NumberFormatter;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

    }

    @Test
    public void moneyFormatTest() {
        assertEquals("0.2320", new NumberFormatter.Builder()
                .setMaximumFractionDigits(2)
                .build()
                .format(695412224.233333));
    }
}