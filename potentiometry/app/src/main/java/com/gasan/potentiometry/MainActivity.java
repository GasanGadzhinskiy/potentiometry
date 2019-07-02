package com.gasan.potentiometry;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.WindowManager;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        //Сохранение данных об изменениях объемов
        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_volume1)).getText()))){
            outState.putDouble("delta_of_volume1", Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume1)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_volume2)).getText()))){
            outState.putDouble("delta_of_volume2", Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume2)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_volume3)).getText()))){
            outState.putDouble("delta_of_volume3", Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume3)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_volume4)).getText()))){
            outState.putDouble("delta_of_volume4", Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume4)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_volume5)).getText()))){
            outState.putDouble("delta_of_volume5", Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume5)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_volume6)).getText()))){
            outState.putDouble("delta_of_volume6", Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume6)).getText().toString()));
        }



        //Сохранение данных об изменениях ЭДС
        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_edf1)).getText()))){
            outState.putDouble("delta_of_edf1", Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf1)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_edf2)).getText()))){
            outState.putDouble("delta_of_edf2", Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf2)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_edf3)).getText()))){
            outState.putDouble("delta_of_edf3", Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf3)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_edf4)).getText()))){
            outState.putDouble("delta_of_edf4", Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf4)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_edf5)).getText()))){
            outState.putDouble("delta_of_edf5", Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf5)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.delta_of_edf6)).getText()))){
            outState.putDouble("delta_of_edf6", Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf6)).getText().toString()));
        }



        //Сохранение данных о первой производной
        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.first_production1)).getText()))){
            outState.putDouble("first_production1", Double.parseDouble(((TextView)findViewById(R.id.first_production1)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.first_production2)).getText()))){
            outState.putDouble("first_production2", Double.parseDouble(((TextView)findViewById(R.id.first_production2)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.first_production3)).getText()))){
            outState.putDouble("first_production3", Double.parseDouble(((TextView)findViewById(R.id.first_production3)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.first_production4)).getText()))){
            outState.putDouble("first_production4", Double.parseDouble(((TextView)findViewById(R.id.first_production4)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.first_production5)).getText()))){
            outState.putDouble("first_production5", Double.parseDouble(((TextView)findViewById(R.id.first_production5)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.first_production6)).getText()))){
            outState.putDouble("first_production6", Double.parseDouble(((TextView)findViewById(R.id.first_production6)).getText().toString()));
        }



        //Сохранение данных о второй производной
        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.second_production1)).getText()))){
            outState.putDouble("second_production1", Double.parseDouble(((TextView)findViewById(R.id.second_production1)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.second_production2)).getText()))){
            outState.putDouble("second_production2", Double.parseDouble(((TextView)findViewById(R.id.second_production2)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.second_production3)).getText()))){
            outState.putDouble("second_production3", Double.parseDouble(((TextView)findViewById(R.id.second_production3)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.second_production4)).getText()))){
            outState.putDouble("second_production4", Double.parseDouble(((TextView)findViewById(R.id.second_production4)).getText().toString()));
        }

        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.second_production5)).getText()))){
            outState.putDouble("second_production5", Double.parseDouble(((TextView)findViewById(R.id.second_production5)).getText().toString()));
        }

        //Эквивалентный объем
        if (!(TextUtils.isEmpty(( (TextView) findViewById(R.id.equivalent_volume)).getText()))){
            outState.putString("equivalent_volume", ((TextView)findViewById(R.id.equivalent_volume)).getText().toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);

        if (Metods.isCalculate){
            //Если все поля заполнены, то просто заново пересчитываем результаты
            if (!TextUtils.isEmpty(( (EditText) findViewById(R.id.volume1)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.volume2)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.volume3)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.volume4)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.volume5)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.volume6)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.volume7)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.edf1)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.edf2)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.edf3)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.edf4)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.edf5)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.edf6)).getText()) &&
                    !TextUtils.isEmpty(( (EditText) findViewById(R.id.edf7)).getText())){
                getWindow().getDecorView().requestFocus();
                this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                Button calculate_button = findViewById(R.id.calculate_button);
                calculate_button.performClick();
            }

            //Если пользователя стер одно или несколько значений, то пересчитать их заново невозможно, поэтому просто заносим те, что были сохранены
            else{
                //Данные об изменениях оюъемов
                ((TextView) findViewById(R.id.delta_of_volume1)).setText(String.valueOf(BigDecimal.valueOf(savedInstanceState.getDouble("delta_of_volume1")).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
                ((TextView) findViewById(R.id.delta_of_volume2)).setText(String.valueOf(BigDecimal.valueOf(savedInstanceState.getDouble("delta_of_volume2")).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
                ((TextView) findViewById(R.id.delta_of_volume3)).setText(String.valueOf(BigDecimal.valueOf(savedInstanceState.getDouble("delta_of_volume3")).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
                ((TextView) findViewById(R.id.delta_of_volume4)).setText(String.valueOf(BigDecimal.valueOf(savedInstanceState.getDouble("delta_of_volume4")).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
                ((TextView) findViewById(R.id.delta_of_volume5)).setText(String.valueOf(BigDecimal.valueOf(savedInstanceState.getDouble("delta_of_volume5")).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
                ((TextView) findViewById(R.id.delta_of_volume6)).setText(String.valueOf(BigDecimal.valueOf(savedInstanceState.getDouble("delta_of_volume6")).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));

                //Данные об изменениях ЭДС
                ((TextView) findViewById(R.id.delta_of_edf1)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("delta_of_edf1"))));
                ((TextView) findViewById(R.id.delta_of_edf2)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("delta_of_edf2"))));
                ((TextView) findViewById(R.id.delta_of_edf3)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("delta_of_edf3"))));
                ((TextView) findViewById(R.id.delta_of_edf4)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("delta_of_edf4"))));
                ((TextView) findViewById(R.id.delta_of_edf5)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("delta_of_edf5"))));
                ((TextView) findViewById(R.id.delta_of_edf6)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("delta_of_edf6"))));

                //Данные о первых производных
                ((TextView) findViewById(R.id.first_production1)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("first_production1"))));
                ((TextView) findViewById(R.id.first_production2)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("first_production2"))));
                ((TextView) findViewById(R.id.first_production3)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("first_production3"))));
                ((TextView) findViewById(R.id.first_production4)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("first_production4"))));
                ((TextView) findViewById(R.id.first_production5)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("first_production5"))));
                ((TextView) findViewById(R.id.first_production6)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("first_production6"))));

                //Данные о вторых производных
                ((TextView) findViewById(R.id.second_production1)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("second_production1"))));
                ((TextView) findViewById(R.id.second_production2)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("second_production2"))));
                ((TextView) findViewById(R.id.second_production3)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("second_production3"))));
                ((TextView) findViewById(R.id.second_production4)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("second_production4"))));
                ((TextView) findViewById(R.id.second_production5)).setText(String.valueOf(Math.round(savedInstanceState.getDouble("second_production5"))));

                //Данные об эквивалентном объеме
                ((TextView)findViewById(R.id.equivalent_volume)).setText(savedInstanceState.getString("equivalent_volume"));
                if ((TextUtils.equals((((TextView)findViewById(R.id.equivalent_volume)).getText().toString()), "Введены не все значения"))){
                    ((TextView)findViewById(R.id.equivalent_volume)).setTextColor(getResources().getColor(R.color.errorColor, getResources().newTheme()));
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        return false;
    }

    public void calculate_button_Click(View view){



        //Очистка поля результата
        ((TextView)findViewById(R.id.equivalent_volume)).setText("");

        //Объемы
        //Проверка наличия значений
        //Счетчик количества объемов
        int countOfVolume = 0;
        double volume1 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.volume1)).getText()))){
            volume1 = Double.parseDouble(((EditText)findViewById(R.id.volume1)).getText().toString());
            countOfVolume++;
        }

        double volume2 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.volume2)).getText()))){
            volume2 = Double.parseDouble(((EditText)findViewById(R.id.volume2)).getText().toString());
            countOfVolume++;
        }

        double volume3 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.volume3)).getText()))){
            volume3 = Double.parseDouble(((EditText)findViewById(R.id.volume3)).getText().toString());
            countOfVolume++;
        }

        double volume4 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.volume4)).getText()))){
            volume4 = Double.parseDouble(((EditText)findViewById(R.id.volume4)).getText().toString());
            countOfVolume++;
        }

        double volume5 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.volume5)).getText()))){
            volume5 = Double.parseDouble(((EditText)findViewById(R.id.volume5)).getText().toString());
            countOfVolume++;
        }

        double volume6 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.volume6)).getText()))){
            volume6 = Double.parseDouble(((EditText)findViewById(R.id.volume6)).getText().toString());
            countOfVolume++;
        }

        double volume7 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.volume7)).getText()))){
            volume7 = Double.parseDouble(((EditText)findViewById(R.id.volume7)).getText().toString());
            countOfVolume++;
        }

        //ЭДС
        //Проверка наличия значений
        //Счетчик количества ЭДС
        int countOfEdf = 0;
        double edf1 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.edf1)).getText()))){
            edf1 = Double.parseDouble(((EditText)findViewById(R.id.edf1)).getText().toString());
            countOfEdf++;
        }

        double edf2 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.edf2)).getText()))){
            edf2 = Double.parseDouble(((EditText)findViewById(R.id.edf2)).getText().toString());
            countOfEdf++;
        }

        double edf3 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.edf3)).getText()))){
            edf3 = Double.parseDouble(((EditText)findViewById(R.id.edf3)).getText().toString());
            countOfEdf++;
        }

        double edf4 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.edf4)).getText()))){
            edf4 = Double.parseDouble(((EditText)findViewById(R.id.edf4)).getText().toString());
            countOfEdf++;
        }

        double edf5 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.edf5)).getText()))){
            edf5 = Double.parseDouble(((EditText)findViewById(R.id.edf5)).getText().toString());
            countOfEdf++;
        }

        double edf6 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.edf6)).getText()))){
            edf6 = Double.parseDouble(((EditText)findViewById(R.id.edf6)).getText().toString());
            countOfEdf++;
        }

        double edf7 = 0;
        if (!(TextUtils.isEmpty(( (EditText) findViewById(R.id.edf7)).getText()))){
            edf7 = Double.parseDouble(((EditText)findViewById(R.id.edf7)).getText().toString());
            countOfEdf++;
        }

        //Если введен хотя бы один объем
        if (countOfVolume == 7 && countOfEdf == 7){

            //Прячем клавиатуру от пользователя
            getWindow().getDecorView().requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(findViewById(R.id.calculate_button).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

            //Значения подсчитаны
            Metods.isCalculate = true;

            //Изменение объема
            ((TextView)findViewById(R.id.delta_of_volume1)).setText(String.valueOf(BigDecimal.valueOf(delta_calculate(volume1, volume2)).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
            ((TextView)findViewById(R.id.delta_of_volume2)).setText(String.valueOf(BigDecimal.valueOf(delta_calculate(volume2, volume3)).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
            ((TextView)findViewById(R.id.delta_of_volume3)).setText(String.valueOf(BigDecimal.valueOf(delta_calculate(volume3, volume4)).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
            ((TextView)findViewById(R.id.delta_of_volume4)).setText(String.valueOf(BigDecimal.valueOf(delta_calculate(volume4, volume5)).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
            ((TextView)findViewById(R.id.delta_of_volume5)).setText(String.valueOf(BigDecimal.valueOf(delta_calculate(volume5, volume6)).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
            ((TextView)findViewById(R.id.delta_of_volume6)).setText(String.valueOf(BigDecimal.valueOf(delta_calculate(volume6, volume7)).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue()));
            double delta_of_volume1 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume1)).getText().toString());
            double delta_of_volume2 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume2)).getText().toString());
            double delta_of_volume3 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume3)).getText().toString());
            double delta_of_volume4 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume4)).getText().toString());
            double delta_of_volume5 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume5)).getText().toString());
            double delta_of_volume6 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_volume6)).getText().toString());

            //Изменение ЭДС
            ((TextView)findViewById(R.id.delta_of_edf1)).setText(String.valueOf(Math.round(delta_calculate(edf1, edf2))));
            ((TextView)findViewById(R.id.delta_of_edf2)).setText(String.valueOf(Math.round(delta_calculate(edf2, edf3))));
            ((TextView)findViewById(R.id.delta_of_edf3)).setText(String.valueOf(Math.round(delta_calculate(edf3, edf4))));
            ((TextView)findViewById(R.id.delta_of_edf4)).setText(String.valueOf(Math.round(delta_calculate(edf4, edf5))));
            ((TextView)findViewById(R.id.delta_of_edf5)).setText(String.valueOf(Math.round(delta_calculate(edf5, edf6))));
            ((TextView)findViewById(R.id.delta_of_edf6)).setText(String.valueOf(Math.round(delta_calculate(edf6, edf7))));
            double delta_of_edf1 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf1)).getText().toString());
            double delta_of_edf2 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf2)).getText().toString());
            double delta_of_edf3 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf3)).getText().toString());
            double delta_of_edf4 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf4)).getText().toString());
            double delta_of_edf5 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf5)).getText().toString());
            double delta_of_edf6 = Double.parseDouble(((TextView)findViewById(R.id.delta_of_edf6)).getText().toString());

            //Первая производная
            ((TextView)findViewById(R.id.first_production1)).setText(String.valueOf(Math.round(delta_of_edf1/delta_of_volume1)));
            ((TextView)findViewById(R.id.first_production2)).setText(String.valueOf(Math.round(delta_of_edf2/delta_of_volume2)));
            ((TextView)findViewById(R.id.first_production3)).setText(String.valueOf(Math.round(delta_of_edf3/delta_of_volume3)));
            ((TextView)findViewById(R.id.first_production4)).setText(String.valueOf(Math.round(delta_of_edf4/delta_of_volume4)));
            ((TextView)findViewById(R.id.first_production5)).setText(String.valueOf(Math.round(delta_of_edf5/delta_of_volume5)));
            ((TextView)findViewById(R.id.first_production6)).setText(String.valueOf(Math.round(delta_of_edf6/delta_of_volume6)));
            double first_production1 = Double.parseDouble(((TextView)findViewById(R.id.first_production1)).getText().toString());
            double first_production2 = Double.parseDouble(((TextView)findViewById(R.id.first_production2)).getText().toString());
            double first_production3 = Double.parseDouble(((TextView)findViewById(R.id.first_production3)).getText().toString());
            double first_production4 = Double.parseDouble(((TextView)findViewById(R.id.first_production4)).getText().toString());
            double first_production5 = Double.parseDouble(((TextView)findViewById(R.id.first_production5)).getText().toString());
            double first_production6 = Double.parseDouble(((TextView)findViewById(R.id.first_production6)).getText().toString());

            //Вторая производная
            ((TextView)findViewById(R.id.second_production1)).setText(String.valueOf(Math.round(delta_calculate(first_production1, first_production2))));
            ((TextView)findViewById(R.id.second_production2)).setText(String.valueOf(Math.round(delta_calculate(first_production2, first_production3))));
            ((TextView)findViewById(R.id.second_production3)).setText(String.valueOf(Math.round(delta_calculate(first_production3, first_production4))));
            ((TextView)findViewById(R.id.second_production4)).setText(String.valueOf(Math.round(delta_calculate(first_production4, first_production5))));
            ((TextView)findViewById(R.id.second_production5)).setText(String.valueOf(Math.round(delta_calculate(first_production5, first_production6))));
            double second_production1 = Double.parseDouble(((TextView)findViewById(R.id.second_production1)).getText().toString());
            double second_production2 = Double.parseDouble(((TextView)findViewById(R.id.second_production2)).getText().toString());
            double second_production3 = Double.parseDouble(((TextView)findViewById(R.id.second_production3)).getText().toString());
            double second_production4 = Double.parseDouble(((TextView)findViewById(R.id.second_production4)).getText().toString());
            double second_production5 = Double.parseDouble(((TextView)findViewById(R.id.second_production5)).getText().toString());

            //Занесение значений в матрицу
            double[][] matrix = new double[7][2];

            //Первый столбец
            matrix[0][0] = volume1;
            matrix[1][0] = volume2;
            matrix[2][0] = volume3;
            matrix[3][0] = volume4;
            matrix[4][0] = volume5;
            matrix[5][0] = volume6;
            matrix[6][0] = volume7;

            //Второй столбец
            matrix[0][1] = 0;
            matrix[1][1] = 0;
            matrix[2][1] = second_production1;
            matrix[3][1] = second_production2;
            matrix[4][1] = second_production3;
            matrix[5][1] = second_production4;
            matrix[6][1] = second_production5;

            //Значения для выбранных ячеек
            int firstIndex = 0;
            int secondIndex = 0;
            for (int i = 0; i < 6; i++)
            {
                if ((matrix[i][1] > 0 && matrix[i + 1][1] < 0) || (matrix[i][1] < 0 && matrix[i + 1][1] > 0)){
                    firstIndex = i;
                    secondIndex = i + 1;
                }
            }
            double first_volume = matrix[firstIndex - 1][0];
            double second_volume = matrix[secondIndex - 1][0];
            double first_value_of_production = matrix[firstIndex][1];
            double second_value_of_production = matrix[secondIndex][1];

            //Нахождение эквивалентного объема
            double equivalent_volume = first_volume + (second_volume - first_volume) * (first_value_of_production / (first_value_of_production - (second_value_of_production)));
            ((TextView)findViewById(R.id.equivalent_volume)).setTextColor(getResources().getColor(R.color.colorText, getResources().newTheme()));
            ((TextView)findViewById(R.id.equivalent_volume)).append("V(эквл) = ");
            ((TextView)findViewById(R.id.equivalent_volume)).append((String.valueOf(BigDecimal.valueOf(equivalent_volume).setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue())));
        }

        boolean isAllNull = false;
        if (countOfVolume == 0 && countOfEdf == 0){
            isAllNull = true;
            ((TextView)findViewById(R.id.equivalent_volume)).append("Введите значения");
            ((TextView)findViewById(R.id.equivalent_volume)).setTextColor(getResources().getColor(R.color.errorColor, getResources().newTheme()));
        }

        //Если значения не введены или введены, но не все
        if ((countOfVolume != 7 || countOfEdf != 7) && !isAllNull){
            ((TextView)findViewById(R.id.equivalent_volume)).append("Введены не все значения");
            ((TextView)findViewById(R.id.equivalent_volume)).setTextColor(getResources().getColor(R.color.errorColor, getResources().newTheme()));
        }


    }

    private  double delta_calculate(double valueX, double valueY){
        double delta = valueY - valueX;
        return delta;
    }
}
