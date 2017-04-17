package filmy.nelk.io.filmy.utils;

import android.net.Uri;

import filmy.nelk.io.filmy.retrofit.APIConfig;

public class MovieUtils {

    public static String buildPosterPath(String path) {
        return Uri.parse(APIConfig.MDB_BASE_IMAGE_URL)
                .buildUpon()
                .appendPath(APIConfig.MDB_IMAGE_SIZE_S)
                .appendEncodedPath(path)
                .build()
                .toString();
    }
}
