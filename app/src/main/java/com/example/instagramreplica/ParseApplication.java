package com.example.instagramreplica;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Register your parse models

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("P2dNDqsbPEX4uUBC4rMz3dmuBJVGtHGqo7ztA2is")
                .clientKey("KvV98HSFMgzmV160hRk8jQt0qxKIhP4tZgkUdvJe")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}


