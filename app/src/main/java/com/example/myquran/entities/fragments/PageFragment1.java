package com.example.myquran.entities.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myquran.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PageFragment1 extends Fragment {

    String json;
    int cptShow=2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle =getArguments();
         json = bundle.getString("json");//lire le paramtre li jaz men SlidePageAdapter li howa text li kayn f la page smito berk hakka json
         String titrePage=bundle.getString("titre");//titre ta3 la page

        final ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.page_1,container,false);

        TextView pageTitle=rootView.findViewById(R.id.surahName);
        final TextView surhText = rootView.findViewById(R.id.surahText);
        ImageButton hideBtn=rootView.findViewById(R.id.hideBtn);//button li nkhebbi bih
        ImageButton showBtn=rootView.findViewById(R.id.showBtn);//button li n affichi bih

        surhText.setText(json);
       /* surhText.setText(Html.fromHtml(
                json
        ));*/
        pageTitle.setText(titrePage);
        final List<String> subStringList=new ArrayList<>();
        final ForegroundColorSpan fcsWhite=new ForegroundColorSpan(Color.WHITE);
        final ForegroundColorSpan fcsBlack=new ForegroundColorSpan(Color.BLACK);
        /*ForegroundColorSpan fcsgrreen=new ForegroundColorSpan(Color.GREEN);*/
        //hado les Strig pour les affichier tjr dans la page
        subStringList.add("سورة الملك");
        subStringList.add("بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ");
        subStringList.add("(1)");
        subStringList.add("(2)");
        subStringList.add("(3)");
        subStringList.add("(4)");
        subStringList.add("(5)");
        subStringList.add("(6)");
        subStringList.add("(7)");
        subStringList.add("(8)");
        subStringList.add("(9)");
        subStringList.add("(10)");
        subStringList.add("(11)");
        subStringList.add("(12)");

        final String fullText=surhText.getText().toString();//all the page text



        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//when we click on hide brn
                SpannableString fullSpanneble=new SpannableString(fullText);//SpannableString pour pouvez changez la couleur
                /*String subString="سورة الملك";*/
                /*Toast.makeText(rootView.getContext(),"cliicked",Toast.LENGTH_SHORT).show();*/

                fullSpanneble.setSpan(fcsWhite,0,fullSpanneble.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//hada bach nkhebi kolch w naffichi ghir wach lazem

                for (int i = 0; i <subStringList.size() ; i++) {
                    ForegroundColorSpan fcsblack=new ForegroundColorSpan(Color.BLACK);
                    int startIndex =fullText.indexOf(subStringList.get(i));
                    fullSpanneble.setSpan(fcsblack,startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }






                cptShow=0;
                surhText.setText(fullSpanneble);


            }
        });


        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//show btn
                String fullText=surhText.getText().toString();
                SpannableString fullSpanneble=new SpannableString(fullText);
             //   cptShow=2;
                fullSpanneble.setSpan(fcsWhite,0,fullSpanneble.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                switch (cptShow){

                    case 0:
                        cptShow++;
                        for (int i = 0; i <subStringList.size()-1 ; i++) {
                            ForegroundColorSpan fcsblack=new ForegroundColorSpan(Color.BLACK);
                            int startIndex =fullText.indexOf(subStringList.get(i));
                            fullSpanneble.setSpan(fcsblack,startIndex,startIndex+subStringList.get(i).length()+10,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        }
                        ForegroundColorSpan fcsblack1=new ForegroundColorSpan(Color.BLACK);
                        int startIndex1 =fullText.indexOf(subStringList.get(subStringList.size()-1));//nafiichi numero laakher
                        fullSpanneble.setSpan(fcsblack1,startIndex1,startIndex1+subStringList.get(subStringList.size()-1).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        break;
                    case 1:
                        cptShow++;
                        for (int i = 1; i <subStringList.size()-1 ; i++) {
                            ForegroundColorSpan fcsblack=new ForegroundColorSpan(Color.BLACK);
                            int startIndex =fullText.indexOf(subStringList.get(i));
                            fullSpanneble.setSpan(fcsblack,startIndex-10,startIndex+subStringList.get(i).length()+15,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        }
                        ForegroundColorSpan fcsblack=new ForegroundColorSpan(Color.BLACK);
                        int startIndex =fullText.indexOf(subStringList.get(subStringList.size()-1));
                        fullSpanneble.setSpan(fcsblack,startIndex-10,startIndex+subStringList.get(subStringList.size()-1).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        break;
                    case 2:
                        fullSpanneble.setSpan(fcsBlack,0,fullSpanneble.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        Toast.makeText(rootView.getContext(),String.valueOf(cptShow),Toast.LENGTH_SHORT).show();

                   //     cptShow=0;

                }





                surhText.setText(fullSpanneble);
            }
        });
        return rootView;
    }





}