package yinlei.applicaptionmarket.data;

import dagger.Module;
import dagger.Provides;
import yinlei.applicaptionmarket.pojo.UserInfo;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: ActivityModule.java
 * @author: 若兰明月
 * @date: 2016-06-25 21:49
 */
@Module  //标识module类型
public class ActivityModule {
    @Provides  //标识提供依赖的方法
    UserInfo provideUserInfo() {
        return new UserInfo();
    }
}
