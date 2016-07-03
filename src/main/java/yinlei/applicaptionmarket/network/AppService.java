package yinlei.applicaptionmarket.network;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import yinlei.applicaptionmarket.pojo.UserInfo;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: AppService.java
 * @author: 若兰明月
 * @date: 2016-07-03 17:59
 */

public interface AppService {


    /**
     * 登录接口
     *
     * @param phone
     * @param password
     * @return
     */
    @POST("http://112.124.22.238:8081/course_api/auth/login")
    Observable<UserInfo> login(@Query("phone") String phone,
                               @Query("password") String password);
}
