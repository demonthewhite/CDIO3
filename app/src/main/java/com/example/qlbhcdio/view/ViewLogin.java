package com.example.qlbhcdio.view;

import com.example.qlbhcdio.model.User;

public interface ViewLogin {
     interface setOnListenerValuesText {
        void onId(String id);
        void onPassword(String password);
    }
    interface setOnLogin{
         void onSuccess (User user);
         void onFailed (String s);
    }

}
