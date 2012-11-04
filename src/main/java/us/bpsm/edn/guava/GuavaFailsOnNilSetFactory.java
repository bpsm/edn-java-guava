package us.bpsm.edn.guava;

import us.bpsm.edn.parser.CollectionBuilder;
import us.bpsm.edn.parser.CollectionBuilder.Factory;

import com.google.common.collect.ImmutableSet;

public class GuavaFailsOnNilSetFactory implements Factory {

    @Override
    public CollectionBuilder builder() {
        return new CollectionBuilder() {
            final ImmutableSet.Builder<Object> b = ImmutableSet.builder();

            @Override
            public void add(Object o) {
                b.add(o);
            }

            @Override
            public Object build() {
                return b.build();
            }
        };
    }

}
