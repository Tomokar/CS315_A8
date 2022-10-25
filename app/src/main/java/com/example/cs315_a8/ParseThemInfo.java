package com.example.cs315_a8;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseThemInfo
{
    Resources appRes = App.getContext().getResources();

    String url = appRes.getString(R.string.api_url);

    public void ParseIt(Activity activity)
    {
        RequestQueue mQueue = Volley.newRequestQueue(activity);

        ImageRequest mRequest = new ImageRequest(url,
                new Response.Listener<Bitmap>()
                {
                    @Override
                    public void onResponse(Bitmap response)
                    {
                        ImageView mImageView = activity.findViewById(R.id.monsterImageView);
                        mImageView.setImageBitmap(response);
                    }
                }, 1024, 1024, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.RGB_565,
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        error.printStackTrace();
                    }
                });

        mQueue.add(mRequest);
    }
}
/*
        JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response ->
                {
                    try
                    {
                        JSONObject object = response.getJSONObject("record");
                        JSONArray jsonArray = object.getJSONArray("Words");

                        ITEMS.clear();
                        ITEM_MAP.clear();

                        for (int i = 0; i < jsonArray.length(); i++)
                        {
                            JSONObject wordsBundle = jsonArray.getJSONObject(i);
                            String json = String.valueOf(wordsBundle);

//                            String wordsWord = wordsBundle.getString("word");
//                            String wordsType = wordsBundle.getString("type");
//                            String wordsDefinition = wordsBundle.getString("definition") + "\n\n" + "Etymology" + "\n - \n" + wordsBundle.getString("etymology");
//                            String wordsEtymology = wordsBundle.getString("etymology");

                            Gson gson = new Gson();

//                            ModelBoy modelB = new ModelBoy(wordsWord, wordsType, wordsDefinition, wordsEtymology);

                            ModelBoy modelB = gson.fromJson(json, ModelBoy.class);

                            ITEMS.add(modelB);
//                            ITEM_MAP.put(wordsWord, modelB);
                            ITEM_MAP.put(modelB.wordsWord, modelB);
                        }

//                        activity.recreate();
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                },
                Throwable::printStackTrace);
*/

//        mQueue.add(mRequest);
//    }
//}
