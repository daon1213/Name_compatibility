package org.techtown.data.remote.api


import org.techtown.data.remote.model.DataLoveResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveCalculatorApi {
    @GET("/getPercentage")
    suspend fun getPercentage(
        @Header("x-rapidapi-key") key : String,
        @Header("x-rapidapi-host") host : String,
        @Query("fname") fName : String,
        @Query("sname") sName : String,
    ) : Response<DataLoveResponse>
}