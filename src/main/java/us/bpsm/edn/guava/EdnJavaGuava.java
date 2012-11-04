package us.bpsm.edn.guava;

import us.bpsm.edn.parser.CollectionBuilder.Factory;
import us.bpsm.edn.parser.Parser.Config.Builder;
import us.bpsm.edn.parser.Parsers;
import us.bpsm.edn.parser.Parser.Config;

public class EdnJavaGuava {

    private static final Factory GUAVA_FAILS_ON_NIL_LIST_FACTORY = new GuavaFailsOnNilListFactory();
    private static final Factory GUAVA_FAILS_ON_NIL_SET_FACTORY = new GuavaFailsOnNilSetFactory();
    private static final Factory GUAVA_FAILS_ON_NIL_MAP_FACTORY = new GuavaFailsOnNilMapFactory();
    private static final Factory GUAVA_FAILS_ON_NIL_VECTOR_FACTORY = new GuavaFailsOnNilVectorFactory();

    private static final Factory GUAVA_SKIPS_NIL_LIST_FACTORY = new GuavaSkipsNilListFactory();
    private static final Factory GUAVA_SKIPS_NIL_SET_FACTORY = new GuavaSkipsNilSetFactory();
    private static final Factory GUAVA_SKIPS_NIL_MAP_FACTORY = new GuavaSkipsNilMapFactory();
    private static final Factory GUAVA_SKIPS_NIL_VECTOR_FACTORY = new GuavaSkipsNilVectorFactory();

    private static final Config GUAVA_FAILS_ON_NIL_CONFIGURATION = newParserConfigBuilder(
            NilPolicy.FAILS_ON_NIL).build();

    private static final Config GUAVA_SKIPS_NIL_CONFIGURATION = newParserConfigBuilder(
            NilPolicy.SKIPS_NIL).build();

    /**
     * Return a Parser.Config.Builder pre-configured to build Guava collections.
     */
    public static Builder newParserConfigBuilder(NilPolicy policy) {
        switch (policy) {
        case FAILS_ON_NIL:
            return Parsers.newParserConfigBuilder()
                    .setListFactory(GUAVA_FAILS_ON_NIL_LIST_FACTORY)
                    .setSetFactory(GUAVA_FAILS_ON_NIL_SET_FACTORY)
                    .setMapFactory(GUAVA_FAILS_ON_NIL_MAP_FACTORY)
                    .setVectorFactory(GUAVA_FAILS_ON_NIL_VECTOR_FACTORY);
        case SKIPS_NIL:
            return Parsers.newParserConfigBuilder()
                    .setListFactory(GUAVA_SKIPS_NIL_LIST_FACTORY)
                    .setSetFactory(GUAVA_SKIPS_NIL_SET_FACTORY)
                    .setMapFactory(GUAVA_SKIPS_NIL_MAP_FACTORY)
                    .setVectorFactory(GUAVA_SKIPS_NIL_VECTOR_FACTORY);
        }
        throw new IllegalArgumentException("policy = " + policy);
    }

    public static Config defaultConfiguration() {
        return GUAVA_FAILS_ON_NIL_CONFIGURATION;
    }

    public static Config defaultConfiguration(NilPolicy policy) {
        switch (policy) {
        case FAILS_ON_NIL:
            return GUAVA_FAILS_ON_NIL_CONFIGURATION;
        case SKIPS_NIL:
            return GUAVA_SKIPS_NIL_CONFIGURATION;
        }
        throw new IllegalArgumentException("policy = " + policy);
    }

}
