package com.wh.utilsapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wh.utilsapp.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.nio.ByteBuffer;

public class SocketActivity extends AppCompatActivity {

    private TextView mTextView;

    private static final String HOST = "192.168.1.164";//"192.168.1.164";
    private static final int PORT = 502;
    private PrintWriter printWriter;
    private BufferedReader in;
    private ExecutorService mExecutorService = null;
    private String receiveMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
        mTextView = findViewById(R.id.reviceTcp);
        mExecutorService = Executors.newCachedThreadPool();
    }

    //打开链接
    public void connectTcp(View view) {
        Log.i("success", "xxx   " + "connect  ");
        mExecutorService.execute(new connectService());
    }

    //发送文本
    public void sendToTcp(View view) {
        Log.i("success", "xxx   " + "send    ");
        //byte[] bytes={0x00,0x01,0x00,0x00,0x00,0x06, (byte) 0xff,0x01,0x00,0x64,0x00,0x04};
        //String sendMsg = "00 01 00 00 00 06 ff 01 00 64 00 04";
        String sendMsg = "000100000006ff0100640004";
        mExecutorService.execute(new sendService(sendMsg));
    }

    //关闭链接
    public void disconnectTcp(View view) {
        Log.i("success", "xxx   " + "dis  connect  ");
        mExecutorService.execute(new sendService("0"));
    }

    private class sendService implements Runnable {
        private String msg;

        sendService(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
           char[] chars={0x00,0x01,0x00,0x00,0x00,0x06,0xff>>1,0x01,0x00,0x64,0x00,0x04};
            printWriter.print(chars);
            printWriter.flush();
        }
    }

    private class connectService implements Runnable {
        @Override
        public void run() {
            try {
                Socket socket = new Socket(HOST, PORT);
                socket.setSoTimeout(60000);
                Log.i("success", "xxx     is connected   " + socket.isConnected());
                printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                        socket.getOutputStream(), "UTF-8")), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                receiveMsg();
            } catch (Exception e) {
                Log.i("success", ("connectService:" + e.getMessage()));
            }
        }
    }

    private void receiveMsg() {
        Log.i("success", "xxxx   in receive");
        try {
            while (true) {
                if ((receiveMsg = in.readLine()) != null) {
                    Log.i("success", "receiveMsg:" + receiveMsg);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextView.setText(receiveMsg + "\n\n" + mTextView.getText());
                        }
                    });
                }
            }
        } catch (IOException e) {
            Log.i("success", "receiveMsg: ");
            e.printStackTrace();
        }
    }
}
