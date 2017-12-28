package com.example.user.main;

/**
 * Created by user on 2017-12-29.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;



public class ImageGridActivity extends Activity {

    //------------------------------------------------------------
    // imageIDs 배열은 GridView 뷰를 구성하는 이미지 파일들의 리소스 ID들을 담습니다.

    private int[] imageIDs = new int[] {
            R.drawable.gallery_image_01,
            R.drawable.gallery_image_02,
            R.drawable.gallery_image_03,
            R.drawable.gallery_image_04,
            R.drawable.gallery_image_05,
            R.drawable.gallery_image_06,
            R.drawable.gallery_image_07,
            R.drawable.gallery_image_08,
            R.drawable.gallery_image_09,
            R.drawable.gallery_image_10,
            R.drawable.gallery_image_11,
            R.drawable.gallery_image_12,
            R.drawable.gallery_image_13,
            R.drawable.gallery_image_14,
            R.drawable.gallery_image_15,
            R.drawable.gallery_image_16,
            R.drawable.gallery_image_17,
            R.drawable.gallery_image_18,
            R.drawable.gallery_image_19,
            R.drawable.gallery_image_20,
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smain);

        //-----------------------------------------------------------------------
        // 사진들을 보여줄 GridView 뷰의 어댑터 객체를 정의하고 그것을 이 뷰의 어댑터로 설정합니다.

        GridView gridViewImages = (GridView)findViewById(R.id.gridViewImages);
        ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this, imageIDs);
        gridViewImages.setAdapter(imageGridAdapter);
    }
}
