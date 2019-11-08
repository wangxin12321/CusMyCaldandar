package wx.swpu.edu.cusmycaldandar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import wx.swpu.edu.cusmycaldandar.view.MyCalendar;

public class MainActivity extends AppCompatActivity implements MyCalendar.MyCalendarListener {
    private MyCalendar cal;
    private List<Date> dateList;
    private int size;
    private boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal = findViewById(R.id.cal);
        cal.setOnItemCliclListener(this);
        dateList=new ArrayList<>();
    }

    @Override
    public void OnItemClick(View view, Date day) {
        if(dateList.size()==0){
            dateList.add(day);
            view.setBackgroundColor(Color.RED);
        }else{
            size=dateList.size();
            for(int i=0;i<size;i++){
                if(dateList.get(i)==day){
                    flag=true;
                    view.setBackgroundColor(Color.WHITE);
                    dateList.remove(dateList.get(i));
                    size=size-1;
                }
            }
            if(flag==true){
               flag=false;
            }else {
                dateList.add(day);
                view.setBackgroundColor(Color.RED);
            }
        }
    }
}
