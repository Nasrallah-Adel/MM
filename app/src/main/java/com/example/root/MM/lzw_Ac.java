package com.example.root.MM;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class lzw_Ac extends AppCompatActivity {
    EditText et;
    Button bt;
    Button de;
    EditText t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lzw_);
        et = (EditText) findViewById(R.id.editText1111);

        bt = (Button) findViewById(R.id.button1111);
        de = (Button) findViewById(R.id.button21);
        t = (EditText) findViewById(R.id.editText21111);
        t.setKeyListener(null);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = et.getText().toString();
                et.setText("");

                String text = msg;
                t.setText("");
                List<Integer> l = LZW.compress(text);
                for (int m : l) {
                    t.append("" + m + "");
                    t.append(System.getProperty("line.separator"));
                }

            }
        });
        de.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String msg = t.getText().toString();
                t.setText("");

                String text = msg;
                Pattern pattern = Pattern.compile(System.getProperty("line.separator"));
                List<Integer> list = pattern.splitAsStream(text)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
                et.setText(LZW.decompress(list));
            }
        });
    }

    public static String encode(String source) {
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i + 1 < source.length()
                    && source.charAt(i) == source.charAt(i + 1)) {
                runLength++;
                i++;
            }
            dest.append(runLength);
            dest.append(source.charAt(i));
        }
        return dest.toString();
    }

    public static String decode(String source) {
        StringBuffer dest = new StringBuffer();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            matcher.find();
            while (number-- != 0) {
                dest.append(matcher.group());
            }
        }
        return dest.toString();
    }

}
