package com.example.beethoven.siteadmin.webserveces;

import com.example.beethoven.siteadmin.component.SendInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by beethoven on 16.07.2017.
 */

public interface ImplEditProduct {
    @GET("webserveses26.php")
    Call<SendInfo> editDataProduct(@Query("id") int id,@Query("nameProduct") String nameProduct,@Query("typeProduct") String typeProduct,@Query("content") String content,
                                   @Query("titleImage") String titleImage,@Query("image1") String image1,@Query("image2") String image2,
                                   @Query("image3") String image3,@Query("image4") String image4,@Query("price") int price,@Query("availability") String availability,
                                   @Query("countP") int countP);
}
