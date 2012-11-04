package us.bpsm.edn.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static us.bpsm.edn.guava.NilPolicy.FAILS_ON_NIL;

import org.junit.Test;

import us.bpsm.edn.parser.Parsers;

import com.google.common.collect.ImmutableSet;

public class GuavaFailsOnNilSetFactoryTest {

    static Object parse(String ednText) {
        return Parsers.newParser(EdnJavaGuava.defaultConfiguration(FAILS_ON_NIL))
                .nextValue(Parsers.newParseable(ednText));
    }

    @Test
    public void resultIsImmutable() {
        assertTrue(parse("#{1 2 3}") instanceof ImmutableSet);
    }

    @Test
    public void resultContainsExpectedElements() {
        assertEquals(ImmutableSet.of(1L, 2L, 3L), parse("#{1 2 3}"));
        assertEquals(ImmutableSet.of(1L), parse("#{1}"));
        assertEquals(ImmutableSet.of(), parse("#{}"));
    }

    @Test(expected=NullPointerException.class)
    public void nilResultsInException() {
        parse("#{nil}");
    }

}
