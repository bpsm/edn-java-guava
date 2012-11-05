package us.bpsm.edn.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static us.bpsm.edn.guava.NilPolicy.SKIPS_NIL;

import java.util.Arrays;

import org.junit.Test;

import us.bpsm.edn.parser.Parsers;

import com.google.common.collect.ImmutableList;

public class GuavaSkipsNilVectorFactoryTest {

    static Object parse(String ednText) {
        return Parsers.newParser(EdnJavaGuava.defaultConfiguration(SKIPS_NIL))
                .nextValue(Parsers.newParseable(ednText));
    }

    @Test
    public void resultIsImmutable() {
        assertTrue(parse("[1 2 3]") instanceof ImmutableList);
    }

    @Test
    public void resultContainsExpectedElements() {
        assertEquals(Arrays.asList(1L, 2L, 3L), parse("[1 2 3]"));
        assertEquals(Arrays.asList(1L, 2L, 3L), parse("[1 nil 2 nil 3]"));
        assertEquals(Arrays.asList(1L), parse("[1]"));
        assertEquals(Arrays.asList(1L), parse("[nil 1 nil]"));
        assertEquals(Arrays.asList(), parse("[]"));
        assertEquals(Arrays.asList(), parse("[nil]"));
        assertEquals(Arrays.asList(), parse("[nil nil]"));
    }

}
