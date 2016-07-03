package yinlei.applicaptionmarket.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 处理数据中转的
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: DataStoreModule.java
 * @author: myName
 * @date: 2016-07-03 18:36
 */
@Module
public final class DataStoreModule {

    @Provides
    public DataLayer.LoginStore Login(DataLayer dataLayer) {
        return dataLayer::toLogin;
    }


    @Provides
    @Singleton
    public DataLayer provideDataStoreModule(){
        return new DataLayer();
    }
}
