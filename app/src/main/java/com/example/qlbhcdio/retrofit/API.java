package com.example.qlbhcdio.retrofit;

public class API {
         //http://10.0.2.2:1220/
            //http://192.168.1.5:1220/
        public static String baseURL = "http://10.0.2.2:1220/";

        public static DataClient getData(){
            return RetrofitData.getClient(baseURL).create(DataClient.class);
        }

}
