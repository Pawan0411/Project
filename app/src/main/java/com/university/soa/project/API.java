package com.university.soa.project;
import android.content.Context;
import android.os.AsyncTask;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by pkumar on 5/3/18.
 */


    /**
     * @author Mohit agarwal
     * @version 1.2
     * @since  03-05-2018.
     */



    public class API extends AsyncTask<String, Void, String> {


        protected void onPreExecute() {
        }

        protected String doInBackground(String... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .cookieJar(new cookie())
                        .build();
                String url = "http://111.93.164.90:8282/CampusPortalSOA";
                MediaType json = MediaType.parse("application/json");

                String login = "{\"username\":\""+params[0]+"\",\"password\":\""+params[1]+ "\",\"MemberType\":\"S\"}";

                Request request = new Request.Builder()
                        .url(url + "/login")
                        .post(RequestBody.create(json, login))
                        .build();

                String loginJson = okHttpClient.newCall(request)
                        .execute().body().string();
                if(loginJson.equals("{}"))
                    return new String("user not found!!!");
                String name = new JSONObject(loginJson).getString("name");
                return name;

            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String s) {
            return;
        }

        public class cookie implements CookieJar {

            private List<Cookie> cookies;

            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                this.cookies =  cookies;
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                if (cookies != null)
                    return cookies;
                return new ArrayList<Cookie>();

            }
        }

    }




