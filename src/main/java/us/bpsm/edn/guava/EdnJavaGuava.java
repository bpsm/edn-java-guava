package us.bpsm.edn.guava;

import us.bpsm.edn.parser.CollectionBuilder.Factory;
import us.bpsm.edn.parser.Parser.Config.Builder;
import us.bpsm.edn.parser.Parsers;
import us.bpsm.edn.parser.Parser.Config;

public class EdnJavaGuava {

    private static final Factory GUAVA_LIST_FACTORY = new GuavaListFactory();
    private static final Factory GUAVA_SET_FACTORY = new GuavaSetFactory();
    private static final Factory GUAVA_MAP_FACTORY = new GuavaMapFactory();
    private static final Factory GUAVA_VECTOR_FACTORY = new GuavaVectorFactory();
    
    private static final Config DEFAULT_CONFIGURATION = 
        newParserConfigBuilder().build();

    /**
     * Return a Parser.Config.Builder pre-configured to build Guava collections.
     */
    public static Builder newParserConfigBuilder() {
        return Parsers.newParserConfigBuilder()
            .setListFactory(GUAVA_LIST_FACTORY)
            .setSetFactory(GUAVA_SET_FACTORY)
            .setMapFactory(GUAVA_MAP_FACTORY)
            .setVectorFactory(GUAVA_VECTOR_FACTORY);
    }
    
    public static Config defaultConfiguration() {
        return DEFAULT_CONFIGURATION;
    }

}
