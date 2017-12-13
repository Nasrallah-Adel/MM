package com.example.root.MM;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class huffman_activity extends AppCompatActivity {
    EditText et;
    Button bt;
    EditText t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huffman_activity);
        et = (EditText) findViewById(R.id.editText1);

        bt = (Button) findViewById(R.id.button1);
        t = (EditText) findViewById(R.id.editText21);
        t.setKeyListener(null);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Huffman h = new Huffman();

                String msg = et.getText().toString();
                et.setText("");
                t.setText("");
                String text = msg;
                int[] charFreqs = new int[256];
                for (char c : text.toCharArray())
                    charFreqs[c]++;

                // build tree
                HuffmanTree tree = h.buildTree(charFreqs);

                // print out results
                // System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
                HashMap<Character, String> Map = new HashMap<>();
                Map = h.printCodes(tree, new StringBuffer());
                List<Character> l1 = new ArrayList<>();
                List<String> l2 = new ArrayList<>();
                for (Map.Entry<Character, String> entry : Map.entrySet()) {
                    //System.out.println(entry.getKey() + " : " + entry.getValue());
                    l1.add(entry.getKey());
                    l2.add(entry.getValue().toString());

                }
                t.setText("");
                Collections.sort(l1);
                Collections.sort(l2);
                for (int i = 0; i < l1.size(); i++) {
                    System.out.print(l1.get(i) + "  " + l2.get(i));

                    t.append(l1.get(i) + "  " + l2.get(i));
                    t.append(System.getProperty("line.separator"));


                }
            }
        });
    }
}
