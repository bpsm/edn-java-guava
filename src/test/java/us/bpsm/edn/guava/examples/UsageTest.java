package us.bpsm.edn.guava.examples;

import static org.junit.Assert.*;

import java.util.RandomAccess;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import us.bpsm.edn.guava.EdnJavaGuava;
import us.bpsm.edn.parser.Parseable;
import us.bpsm.edn.parser.Parser;
import us.bpsm.edn.parser.Parsers;

public class UsageTest {
    @Test
    public void test() {
        Parser p = Parsers.newParser(EdnJavaGuava.defaultConfiguration());
        Parseable r = Parsers.newParseable("{:a 1} #{0} [2] (3)");

        Object o = p.nextValue(r);
        assertTrue(o instanceof ImmutableMap);

        o = p.nextValue(r);
        assertTrue(o instanceof ImmutableSet);

        o = p.nextValue(r);
        assertTrue(o instanceof ImmutableList);
        assertTrue(o instanceof RandomAccess);

        o = p.nextValue(r);
        assertTrue(o instanceof ImmutableList);
    }
}
