package com.example.myclient;

import android.os.Bundle;

import com.example.myclient.http.HttpRequest;
import com.example.myclient.tool.AES;
import com.example.myclient.tool.DH;
import com.example.myclient.tool.RSA;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjuN97tkBc0QcKGU9oXydaQN7q" +
            "wZnThxTOmdIc8O1yuA9FrDZpZ3Sz908vTqM/YPZkOUaYrGwsBO7FeQovoX7nQPKu" +
            "YQpRDqt7OKzhwPavyynH0Jz38PDyCBw45zwl4Ux8BtsggTrGVxAqNjO4KkuyL1QS" +
            "8amn4Fzl1CBre8Y0gQIDAQAB";

    private static final String URL = "http://192.168.20.59/";
    private byte[] mAesKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final HttpRequest request = new HttpRequest(URL);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if(mAesKey == null || mAesKey.length <= 0){

                    final DH dh = new DH();
                    int pubKey = dh.getPublicKey();
                    Log.d("test", "dh 公钥为：" + dh.getPublicKey());
                    try {
                        request.handshake(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                                Log.d("error", "onFailure: 握手失败");
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {

                                byte[] pubKey = response.body().bytes();
                                mAesKey = dh.getSecretKey(pubKey);
                                Log.d("success", "success: 握手成功aes密钥为：" + new String(mAesKey));
                            }
                        }, RSA.encrypt(String.valueOf(pubKey), PUB_KEY));
                    }
                    catch (UnsupportedEncodingException e) {

                        e.printStackTrace();
                    }
                }
                else {

                    request.request(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                            Log.e("error", "请求失败");
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {

                            byte[] bytes = response.body().bytes();
                            AES aes = new AES(mAesKey);
                            String content = new String(aes.decrypt(bytes));
                            Log.e("success", "请求成功：" + content);
                        }
                    });
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
