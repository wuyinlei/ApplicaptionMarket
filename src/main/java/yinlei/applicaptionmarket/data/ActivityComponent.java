package yinlei.applicaptionmarket.data;

import dagger.Component;
import yinlei.applicaptionmarket.ui.fragment.DiscoverFragment;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: ActivityComponent.java
 * @author: 若兰明月
 * @date: 2016-06-25 21:49
 */
//消费依赖的组件
@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DiscoverFragment discoverFragment);
}
