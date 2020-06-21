package com.example.qlbhcdio.retrofit;

public class UserAPI {
         //http://10.0.2.2:1220/
        public static String baseURL = "http://10.0.2.2:1220/";

        public static DataClient getData(){
            return RetrofitData.getClient(baseURL).create(DataClient.class);
        }

}
