package us.bpsm.edn.guava;

import com.google.common.collect.ImmutableList;

import us.bpsm.edn.parser.CollectionBuilder;
import us.bpsm.edn.parser.CollectionBuilder.Factory;

public class GuavaSkipsNilListFactory implements Factory {

    @Override
    public CollectionBuilder builder() {
        return new CollectionBuilder() {
            final ImmutableList.Builder<Object> b = ImmutableList.builder();

            @Override
            public void add(Object o) {
                if (o != null) {
                    b.add(o);
                }
            }

            @Override
            public Object build() {
                return b.build();
            }
        };
    }

}
