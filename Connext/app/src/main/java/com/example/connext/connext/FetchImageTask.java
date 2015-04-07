package com.example.connext.connext;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by raahulbiswas on 15-03-25.
 */
public class FetchImageTask extends AsyncTask<String, Void, Bitmap> {

    public static final String TAG = FetchImageTask.class.getCanonicalName();
    RoundedImageView userImageView;

    public FetchImageTask(RoundedImageView imageView) {
        super();
        userImageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        Bitmap bm = null;
        try {
            URL imageURL = new URL(urls[0]);
            HttpURLConnection connection = (HttpURLConnection) imageURL.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream is = connection.getInputStream();
            bm = BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            Log.e(TAG, "Malformed image URL : " + urls[0], e);
        } catch (IOException e) {
            Log.e(TAG, "Error fetching image from URL : " + urls[0], e);
        }
        return bm;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        userImageView.setImageBitmap(bitmap);
    }
}