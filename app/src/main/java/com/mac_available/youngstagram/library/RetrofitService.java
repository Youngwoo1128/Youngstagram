package com.mac_available.youngstagram.library;

import com.mac_available.youngstagram.valueobject.UserVO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {
    @POST("/youngstagram/saveUserDataForPost.php")
    Call<UserVO> saveUserData(@Body UserVO userBaseData);

    @GET("/youngstagram/loadUserDataForGet.php")
    Call<UserVO> loadUserData(@Query("userId") String userId);

    @GET("/youngstagram/checkUserId.php")
    Call<String> checkUserId(@Query("userId") String userId);
}
