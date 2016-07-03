package yinlei.applicaptionmarket.common;

import javax.inject.Singleton;

import dagger.Component;
import yinlei.applicaptionmarket.data.DataStoreModule;
import yinlei.applicaptionmarket.viewModels.UserViewModel;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: Graph.java
 * @author: myName
 * @date: 2016-07-03 18:44
 */

@Singleton
@Component(modules = {DataStoreModule.class})
public interface Graph {

    void inject(UserViewModel userViewModel);

    public final static class Initializer {
        public static Graph init() {
            return DaggerGraph.builder()
                    .build();
        }
    }
}
