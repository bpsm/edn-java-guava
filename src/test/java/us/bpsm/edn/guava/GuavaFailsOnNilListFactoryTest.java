package us.bpsm.edn.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static us.bpsm.edn.guava.NilPolicy.FAILS_ON_NIL;

import java.util.Arrays;

import org.junit.Test;

import us.bpsm.edn.parser.Parsers;

import com.google.common.collect.ImmutableList;

public class GuavaFailsOnNilListFactoryTest {

    static Object parse(String ednText) {
        return Parsers.newParser(EdnJavaGuava.defaultConfiguration(FAILS_ON_NIL))
                .nextValue(Parsers.newParseable(ednText));
    }

    @Test
    public void resultIsImmutable() {
        assertTrue(parse("(1 2 3)") instanceof ImmutableList);
    }

    @Test
    public void resultContainsExpectedElements() {
        assertEquals(Arrays.asList(1L, 2L, 3L), parse("(1 2 3)"));
        assertEquals(Arrays.asList(1L), parse("(1)"));
        assertEquals(Arrays.asList(), parse("()"));
    }

    @Test(expected=NullPointerException.class)
    public void nilResultsInException() {
        parse("(nil)");
    }

}
