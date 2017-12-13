package com.example.root.MM;

import android.icu.lang.UCharacterEnums;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.root.MM.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shannon extends AppCompatActivity {
    EditText et;
    Button bt;
    EditText t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shannon);
        et = (EditText) findViewById(R.id.editText);
        bt = (Button) findViewById(R.id.button);
        t = (EditText) findViewById(R.id.editText2);
        t.setKeyListener(null);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String msg = et.getText().toString();
                String text = msg;
                int chars[] = new int[26];
                HashMap<Character, Integer> charsMap = new HashMap<>();
                for (int i = 0; i < text.length(); i++) {
                    ++chars[text.charAt(i) - 'a'];
                }
                for (int i = 0; i < chars.length; i++) {
                    int aChar = chars[i];
                    if (aChar > 0) {
                        charsMap.put(java.lang.Character.valueOf((char) ('a' + i)), aChar);
                    }
                }
                HashMap<Character, Integer> res = new HashMap<>();
                res = ShannonFano.compress(charsMap);
                System.out.println("ss");
                String s = "";

                List<Character> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                for (Map.Entry<Character, Integer> entry : res.entrySet()) {
                    //System.out.println(entry.getKey() + " : " + entry.getValue());
                    l1.add(entry.getKey());
                    l2.add(entry.getValue());

                }
                t.setText("");
                Collections.sort(l1);
                for(int i = 0 ; i < l1.size();i++){
                    System.out.print(l1.get(i)+"  "+l2.get(i));
                    s+=l1.get(i)+"  "+l2.get(i)+"\n";
                    t.append(l1.get(i)+"  "+l2.get(i));
                    t.append(System.getProperty("line.separator"));


                }


              //  t.setText(s);


            }
        });
    }
}
