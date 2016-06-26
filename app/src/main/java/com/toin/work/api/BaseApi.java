package com.toin.work.api;

import com.squareup.okhttp.RequestBody;
import com.toin.work.models.FlagModel;
import com.toin.work.models.ImgEntitys;
import com.toin.work.models.ResultJson;
import com.toin.work.models.UserModel;

import java.util.Map;

import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import rx.Observable;

/**
 * Created by hb on 16/3/8.
 */
public interface BaseApi {

    /**
     *
     /** 登陆
     * 
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(ApiName.LOGIN)
    Observable<ResultJson<UserModel>> login(@FieldMap Map<String, Object> params);

    /**
     * 登出
     *
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST(ApiName.OUT)
    Observable<ResultJson<FlagModel>> lagout(@FieldMap Map<String, Object> params);

    /**
     * 上传图片
     * 
     * @param path
     * @param fileRequest
     * @param token
     * @return
     */
    @Multipart
    @POST(ApiName.LOAD)
    Observable<ResultJson<ImgEntitys>> sendPic(@Part("key") RequestBody path,
                                               @Part("file\"; filename=\"cropped.png") RequestBody fileRequest,
                                               @Part("token") RequestBody token);

}
