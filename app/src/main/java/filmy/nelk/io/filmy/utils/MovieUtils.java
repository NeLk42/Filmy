package filmy.nelk.io.filmy.utils;

import android.net.Uri;

import filmy.nelk.io.filmy.retrofit.APIConfig;

public class MovieUtils {

    public static String buildImagePath(String path, String size) {
        return Uri.parse(APIConfig.MDB_BASE_IMAGE_URL)
                .buildUpon()
                .appendPath(size)
                .appendEncodedPath(path)
                .build()
                .toString();
    }

}
