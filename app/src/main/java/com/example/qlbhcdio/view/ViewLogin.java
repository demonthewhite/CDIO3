package com.example.qlbhcdio.view;

public interface ViewLogin {
     interface setOnListenerValuesText {
        void onId(String id);
        void onPassword(String password);
    }
    interface setOnLogin{
         void onSuccess (String s );
         void onFailed (String s);
    }

}
