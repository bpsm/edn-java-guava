# edn-java-guava

*edn-java-guava* provides a solution for parsing edn collections as immutable [Guava](http://code.google.com/p/guava-libraries/) collections, which have a [smaller memory overhead per instance](http://code.google.com/p/memory-measurer/wiki/ElementCostInDataStructures) than the standard mutable Java collections.

## Installation

This is a Maven project with the following coordinates:

```xml
<dependency>
  <groupId>us.bpsm</groupId>
  <artifactId>edn-java-guava</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```

It depends on [edn-java](http://github.com/bpsm/edn-java).

## Usage

```java
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
```

`EdnJavaGuava.defaultConfiguration()` is a just a convenient alternative to calling `EdnJavaGuava.newParserConfigBuilder().build()`. Explicitly constructing the configuration builder gives you the option of adding further customizaitons before creating the `Parser.Config`.

## Current Limitations

- `nil` values and keys are not supported in any collection type.
- Lists will print back as vectors.
