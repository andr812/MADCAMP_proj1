package com.example.user.main;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by user on 2017-12-28.
 */

public class ContentProviderActivity extends Activity implements View.OnClickListener{
    private ArrayList<Map<String, String>> dataList;
    private ListView mListview;
    private Button mBtnAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        mListview = (ListView) findViewById(R.id.listview);
        mBtnAddress = (Button) findViewById(R.id.btnAddress);
        mBtnAddress.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddress:

                dataList = new ArrayList<Map<String, String>>();
                Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                        null, null, null,
                        ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " asc");


                while (c.moveToNext()) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    // 연락처 id 값
                    String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                    // 연락처 대표 이름
                    String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
                    map.put("name", name);

                    // ID로 전화 정보 조회
                    Cursor phoneCursor = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null, null);

                    // 데이터가 있는 경우
                    if (phoneCursor.moveToFirst()) {
                        String number = phoneCursor.getString(phoneCursor.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        map.put("phone", number);
                    }

                    phoneCursor.close();
                    dataList.add(map);
                }// end while
                c.close();

                SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                        dataList,
                        android.R.layout.simple_list_item_2,
                        new String[]{"name", "phone"},
                        new int[]{android.R.id.text1, android.R.id.text2});
                mListview.setAdapter(adapter);
        }
    }
}