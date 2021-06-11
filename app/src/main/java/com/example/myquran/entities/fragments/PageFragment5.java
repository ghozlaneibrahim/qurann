package com.example.myquran.entities.fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myquran.MyQuranApp;
import com.example.myquran.R;
import com.example.myquran.entities.model.Functions;

import java.util.ArrayList;
import java.util.List;

public class PageFragment5 extends Fragment {
    String json;
    int cptShow=2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        json = bundle.getString("json");
        String pagetitre = bundle.getString("titre");
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.page_5, container, false);
        TextView pageTitle=rootView.findViewById(R.id.surahName);
        final TextView surhText = rootView.findViewById(R.id.surahText);
        TextView pageNum=rootView.findViewById(R.id.pageNum);
        pageNum.setText("566");
        int BissmilahPos = json.indexOf("بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيم");
        SpannableString s1= new SpannableString(json);
        s1.setSpan(new RelativeSizeSpan(1.4f),BissmilahPos,BissmilahPos+"بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيم".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(new ForegroundColorSpan(Color.BLACK),BissmilahPos,BissmilahPos+"بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيم".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        BissmilahPos = json.indexOf("سورة الحاقة");

        s1.setSpan(new RelativeSizeSpan(1.9f),BissmilahPos,BissmilahPos+"سورة الحاقة".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(new ForegroundColorSpan(Color.BLACK),BissmilahPos,BissmilahPos+"سورة الحاقة".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(new StyleSpan(Typeface.BOLD),BissmilahPos,BissmilahPos+"سورة الحاقة".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        for (int i :Functions.GetPosAyah(json)){
            s1.setSpan(new StyleSpan(Typeface.BOLD),i-1,i+2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        surhText.setText(s1);
        pageTitle.setText(pagetitre);

        ImageButton hideBtn=rootView.findViewById(R.id.hideBtn);//button li nkhebbi bih
        ImageButton showBtn=rootView.findViewById(R.id.showBtn);//button li n affichi bih


        final List<String> subStringList=new ArrayList<>();
        final ForegroundColorSpan fcsWhite=new ForegroundColorSpan(Color.WHITE);
        final ForegroundColorSpan fcsBlack=new ForegroundColorSpan(Color.BLACK);

        for (int i=43;i<53;i++){
            subStringList.add(Functions.ChangetoArabic(i));

        }
        subStringList.add("سورة الحاقة");
        subStringList.add("بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ");
        for (int i=1;i<9;i++){
            subStringList.add(Functions.ChangetoArabic(i));

        }


        final String fullText=surhText.getText().toString();//all the page text

        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//when we click on hide brn
                SpannableString fullSpanneble=new SpannableString(fullText);//SpannableString pour pouvez changez la couleur
                /*String subString="سورة الملك";*/
                /*Toast.makeText(rootView.getContext(),"cliicked",Toast.LENGTH_SHORT).show();*/

                fullSpanneble.setSpan(fcsWhite,0,fullSpanneble.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//hada bach nkhebi kolch w naffichi ghir wach lazem
                for (int i :Functions.GetPosAyah(json)){
                    fullSpanneble.setSpan(new StyleSpan(Typeface.BOLD),i-1,i+2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                for (int i :Functions.GetPosAyah(json)){
                    fullSpanneble.setSpan(new StyleSpan(Typeface.BOLD),i-1,i+2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                for (int i = 0; i <subStringList.size() ; i++) {
                    ForegroundColorSpan fcsblack=new ForegroundColorSpan(Color.BLACK);
                    int startIndex =fullText.indexOf(subStringList.get(i));
                    fullSpanneble.setSpan(fcsblack,startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    fullSpanneble.setSpan(fcsblack,startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    if (i==11)
                        fullSpanneble.setSpan(new RelativeSizeSpan(1.4f),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    if (i==10)

                        fullSpanneble.setSpan(new RelativeSizeSpan(1.9f),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    if (i==10)
                        fullSpanneble.setSpan(new StyleSpan(Typeface.BOLD),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }






                cptShow=0;
                surhText.setText(fullSpanneble);

                ((MyQuranApp) getActivity().getApplication()).setSurahText(surhText);

            }
        });


        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//show btn
                String fullText=surhText.getText().toString();
                SpannableString fullSpanneble=new SpannableString(fullText);
                //   cptShow=2;
                fullSpanneble.setSpan(fcsWhite,0,fullSpanneble.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                for (int i :Functions.GetPosAyah(json)){
                    fullSpanneble.setSpan(new StyleSpan(Typeface.BOLD),i-1,i+2,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
                switch (cptShow){

                    case 0:
                        cptShow++;
                        for (int i = 0; i <subStringList.size()-1 ; i++) {
                            ForegroundColorSpan fcsblack=new ForegroundColorSpan(Color.BLACK);
                            int startIndex =fullText.indexOf(subStringList.get(i));
                            fullSpanneble.setSpan(fcsblack,startIndex,startIndex+subStringList.get(i).length()+10,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            if(i==11)
                                fullSpanneble.setSpan(new RelativeSizeSpan(1.4f),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            if (i==10)

                                fullSpanneble.setSpan(new RelativeSizeSpan(1.9f),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            if (i==10)
                                fullSpanneble.setSpan(new StyleSpan(Typeface.BOLD),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        }
                        ForegroundColorSpan fcsblack1=new ForegroundColorSpan(Color.BLACK);
                        int startIndex1 =fullText.indexOf(subStringList.get(subStringList.size()-1));//nafiichi numero laakher
                        fullSpanneble.setSpan(fcsblack1,startIndex1,startIndex1+subStringList.get(subStringList.size()-1).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        break;
                    case 1:
                        cptShow++;
                        for (int i = 0; i <subStringList.size()-1 ; i++) {
                            ForegroundColorSpan fcsblack=new ForegroundColorSpan(Color.BLACK);
                            int startIndex =fullText.indexOf(subStringList.get(i));
                            fullSpanneble.setSpan(fcsblack,startIndex-10,startIndex+subStringList.get(i).length()+15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            if(i==11)
                                fullSpanneble.setSpan(new RelativeSizeSpan(1.4f),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            if (i==10)

                                fullSpanneble.setSpan(new RelativeSizeSpan(1.9f),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                            if (i==10)
                                fullSpanneble.setSpan(new StyleSpan(Typeface.BOLD),startIndex,startIndex+subStringList.get(i).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                        ForegroundColorSpan fcsblack=new ForegroundColorSpan(Color.BLACK);
                        ForegroundColorSpan fcsblack2=new ForegroundColorSpan(Color.BLACK);
                        fullSpanneble.setSpan(fcsblack2,0,15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        int startIndex =fullText.indexOf(subStringList.get(subStringList.size()-1));
                        fullSpanneble.setSpan(fcsblack,startIndex-10,startIndex+subStringList.get(subStringList.size()-1).length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        break;
                    case 2:
                        fullSpanneble.setSpan(fcsBlack,0,fullSpanneble.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        Toast.makeText(rootView.getContext(),String.valueOf(cptShow),Toast.LENGTH_SHORT).show();
                        int BissmilahPos = json.indexOf("بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيم");
                        fullSpanneble.setSpan(new RelativeSizeSpan(1.4f),BissmilahPos,BissmilahPos+"بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيم".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        fullSpanneble.setSpan(new ForegroundColorSpan(Color.BLACK),BissmilahPos,BissmilahPos+"بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيم".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        BissmilahPos = json.indexOf("سورة الحاقة");

                        fullSpanneble.setSpan(new RelativeSizeSpan(1.9f),BissmilahPos,BissmilahPos+"سورة الحاقة".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        fullSpanneble.setSpan(new ForegroundColorSpan(Color.BLACK),BissmilahPos,BissmilahPos+"سورة الحاقة".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        fullSpanneble.setSpan(new StyleSpan(Typeface.BOLD),BissmilahPos,BissmilahPos+"سورة الحاقة".length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                        //     cptShow=0;

                }





                surhText.setText(fullSpanneble);


            }
        });



        return rootView;
    }



}