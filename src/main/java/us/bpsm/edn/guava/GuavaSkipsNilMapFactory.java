package us.bpsm.edn.guava;

import us.bpsm.edn.EdnException;
import us.bpsm.edn.parser.CollectionBuilder;
import us.bpsm.edn.parser.CollectionBuilder.Factory;

import com.google.common.collect.ImmutableMap;

public class GuavaSkipsNilMapFactory implements Factory {

    final static Object SKIP = "nil";
    
    @Override
    public CollectionBuilder builder() {
        return new CollectionBuilder() {
            final ImmutableMap.Builder<Object,Object> b = ImmutableMap.builder();
            Object key = null;
            
            @Override
            public void add(Object o) {
                if (key == null) {
                    if (o == null) {
                        key = SKIP;
                    } else {
                        key = o;
                    }
                } else {
                    if (key != SKIP && o != null) {
                        b.put(key, o);
                    }
                    key = null;
                }
            }

            @Override
            public Object build() {
                if (key != null) {
                    throw new EdnException("The final key: '" + key + "' has no associated value.");
                }
                return b.build();
            }
        };
    }

}
