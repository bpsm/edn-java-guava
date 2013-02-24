package us.bpsm.edn.guava;

import us.bpsm.edn.parser.CollectionBuilder.Factory;
import us.bpsm.edn.parser.Parser.Config.Builder;
import us.bpsm.edn.parser.Parsers;
import us.bpsm.edn.parser.Parser.Config;

public class EdnJavaGuava {

    public static final NilPolicy DEFAULT_NIL_POLICY = NilPolicy.FAILS_ON_NIL;

    /**
     * Return a Parser.Config.Builder pre-configured to build Guava collections.
     */
    public static Builder newParserConfigBuilder(NilPolicy policy) {
		return policy.newParserConfigBuilder();
    }

    public static Config defaultConfiguration() {
		return DEFAULT_NIL_POLICY.newParserConfigBuilder().build();
    }

    public static Config defaultConfiguration(NilPolicy policy) {
		return policy.newParserConfigBuilder().build();
    }

}
