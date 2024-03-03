package com.example.a3pract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView3);
        textView1.setText("java");
        textView1.setTextSize(15);

        ConstraintLayout constraintLayout = new ConstraintLayout(this);
        TextView textView = new TextView(this);
        textView.setText("course: mobile development");
        textView.setTextSize(20);


        //Программная установка ширины и высоты
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

//        layoutParams.setMargins(60, 50, 60, 50); //Программная установка отступов
//        textView.setPadding(40, 40, 40, 40);

        layoutParams.leftToLeft = ViewGroup.LayoutParams.WRAP_CONTENT;
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        textView.setLayoutParams(layoutParams);
        constraintLayout.addView(textView);

        setContentView(constraintLayout);

        //Получение размеров экрана
        DisplayMetrics displayMetrics = new DisplayMetrics();
        // Получить экземпляр WindowManager
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        // Назначить значения DisplayMetrics экрану
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        // Получить ширину и высоту экрана
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        //Установка размера
        textView.setWidth(screenWidth / 2);
        textView.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

        // Пример применения constraint layout

//Создаем кнопку 1
        Button button1 = new Button(this);
        button1.setId(View.generateViewId());
        button1.setText("Button 1");

// Создаем объект LayoutParams, который будет использоваться для установки параметров макета кнопки 1
        ConstraintLayout.LayoutParams paramsButton1 = new ConstraintLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

// Устанавливаем, что левая сторона кнопки (start) будет прикреплена к левой стороне родительского элемента
        paramsButton1.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;

// Устанавливаем, что верхняя сторона кнопки (top) будет прикреплена к верхней стороне родительского элемента
        paramsButton1.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;

// Устанавливаем параметры макета для кнопки 1
        button1.setLayoutParams(paramsButton1);

//Создаем кнопку 2
        Button button2 = new Button(this);
        button2.setId(View.generateViewId());
        button2.setText("Button 2");

// Создаем объект LayoutParams, который будет использоваться для установки параметров макета кнопки 1
        ConstraintLayout.LayoutParams paramsButton2 = new ConstraintLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);

// Устанавливаем, что левая сторона кнопки (start) будет прикреплена к правой стороне кнопки 1
        paramsButton2.startToEnd = button1.getId();

// Устанавливаем, что правая сторона кнопки (end) будет прикреплена к правой стороне родительского элемента
        paramsButton2.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;

// Устанавливаем, что верхняя сторона кнопки (top) будет прикреплена к верхней стороне родительского элемента
        paramsButton2.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;

        button2.setLayoutParams(paramsButton2);

        constraintLayout.addView(button1);
        constraintLayout.addView(button2);

        setContentView(constraintLayout);
    }
}