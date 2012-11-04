package us.bpsm.edn.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static us.bpsm.edn.guava.NilPolicy.SKIPS_NIL;

import org.junit.Test;

import us.bpsm.edn.parser.Parsers;

import com.google.common.collect.ImmutableMap;

public class GuavaSkipsNilMapFactoryTest {

    static Object parse(String ednText) {
        return Parsers.newParser(EdnJavaGuava.defaultConfiguration(SKIPS_NIL))
                .nextValue(Parsers.newParseable(ednText));
    }

    @Test
    public void resultIsImmutable() {
        assertTrue(parse("{1 2 3 4}") instanceof ImmutableMap);
    }

    @Test
    public void resultContainsExpectedElements() {
        assertEquals(ImmutableMap.of(1L, 2L, 3L, 4L), parse("{1 2 3 4}"));
        assertEquals(ImmutableMap.of(1L, 2L), parse("{1 2}"));
        assertEquals(ImmutableMap.of(), parse("{}"));
    }

    @Test
    public void nilKeyResultsInSkippedEntry() {
        assertEquals(ImmutableMap.of(), parse("{nil 1}"));
    }
    
    @Test
    public void nilValueResultsInSkippedEntry() {
        assertEquals(ImmutableMap.of(), parse("{1 nil}"));
    }

}
