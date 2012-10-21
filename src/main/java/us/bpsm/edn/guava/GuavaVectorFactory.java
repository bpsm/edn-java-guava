package us.bpsm.edn.guava;

import com.google.common.collect.ImmutableList;

import us.bpsm.edn.parser.CollectionBuilder;
import us.bpsm.edn.parser.CollectionBuilder.Factory;

class GuavaVectorFactory implements Factory {

    @Override
    public CollectionBuilder builder() {
        return new CollectionBuilder() {
            final ImmutableList.Builder<Object> b = ImmutableList.builder();

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
