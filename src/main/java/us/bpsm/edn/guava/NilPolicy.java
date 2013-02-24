package us.bpsm.edn.guava;

import us.bpsm.edn.parser.Parser.Config.Builder;
import us.bpsm.edn.parser.Parser.Config;
import us.bpsm.edn.parser.Parsers;

public enum NilPolicy {

    FAILS_ON_NIL() {
        @Override
        Builder newParserConfigBuilder() {
            return Parsers.newParserConfigBuilder()
                .setListFactory(new GuavaFailsOnNilListFactory())
                .setSetFactory(new GuavaFailsOnNilSetFactory())
                .setMapFactory(new GuavaFailsOnNilMapFactory())
                .setVectorFactory(new GuavaFailsOnNilVectorFactory());
        }
    },

    SKIPS_NIL() {
        @Override
        Builder newParserConfigBuilder() {
            return Parsers.newParserConfigBuilder()
                .setListFactory(new GuavaSkipsNilListFactory())
                .setSetFactory(new GuavaSkipsNilSetFactory())
                .setMapFactory(new GuavaSkipsNilMapFactory())
                .setVectorFactory(new GuavaSkipsNilVectorFactory());
        }
    };
    
    abstract Builder newParserConfigBuilder();

}
