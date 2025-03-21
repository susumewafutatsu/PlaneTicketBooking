package com.example.plane_ticket_booking.Activiy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.plane_ticket_booking.Model.Location;
import com.example.plane_ticket_booking.R;
import com.example.plane_ticket_booking.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends BaseActivity {
    TextView textView;
    private ActivityMainBinding binding;
    private int adultPassenger=1,childPassenger=1;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM, yyyy", Locale.ENGLISH);
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        textView = (TextView) findViewById(R.id.textView9);
        initLocations();
        initPassengers();
        initClassSeat();
        initDatePickup();
        setVariable();
    }

    private void setVariable() {
        binding.searchBtn.setOnClickListener(v-> {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                intent.putExtra("from",((Location)binding.fromSp.getSelectedItem()).getName());
                intent.putExtra("to",((Location)binding.toSp.getSelectedItem()).getName());
                intent.putExtra("date",binding.departureDateTxt.getText().toString());
                intent.putExtra("numPassenger",((Location)binding.fromSp.getSelectedItem()).getName());
                startActivity(intent);
        });
    }

    private void initDatePickup() {
        Calendar calendarToday = Calendar.getInstance();
        String currentDate = dateFormat.format(calendarToday.getTime());
        binding.departureDateTxt.setText(currentDate);

        Calendar calendarTommorow = Calendar.getInstance();
        calendarTommorow.add(Calendar.DAY_OF_YEAR,1);
        String tommorowDate = dateFormat.format(calendarTommorow.getTime());
        binding.returnDateTxt.setText(tommorowDate);

        binding.departureDateTxt.setOnClickListener(v -> showDatePickerDiolog(binding.departureDateTxt));
        binding.returnDateTxt.setOnClickListener(v -> showDatePickerDiolog(binding.returnDateTxt));
    }

    private void initClassSeat() {
        binding.progressBarClass.setVisibility(View.VISIBLE);
        ArrayList<String> list = new ArrayList<>();
        list.add("Bussiness Class");
        list.add("Fisrt Class");
        list.add("Economy Class");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.sp_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.classSp.setAdapter(adapter);
        binding.progressBarClass.setVisibility(View.GONE);
    }

    private void initPassengers() {
        binding.plusAdultBtn.setOnClickListener(v ->{
            adultPassenger++;
            binding.AdultTxt.setText(adultPassenger+" Adult");
        });
        binding.minusAdultBtn.setOnClickListener(v ->{
            if(adultPassenger>1){
                adultPassenger--;
                binding.AdultTxt.setText(adultPassenger+" Adult");
            }
        });
        binding.plusChildBtn.setOnClickListener(v ->{
            childPassenger++;
            binding.childTxt.setText(childPassenger+" Adult");
        });
        binding.minusChildBtn.setOnClickListener(v ->{
            if (childPassenger>1){
                childPassenger--;
                binding.childTxt.setText(childPassenger+" Adult");
            }
        });
    }

    private void initLocations(){
        binding.progressBarFrom.setVisibility(View.VISIBLE);
        binding.progressBarTo.setVisibility(View.VISIBLE);
        DatabaseReference myRef = database.getReference("Locations");
        ArrayList<Location> list = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for(DataSnapshot issue:snapshot.getChildren()){
                        list.add(issue.getValue(Location.class));
                    }
                    ArrayAdapter<Location> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.sp_item,list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.fromSp.setAdapter(adapter);
                    binding.toSp.setAdapter(adapter);
                    binding.fromSp.setSelection(1);
                    binding.progressBarFrom.setVisibility(View.GONE);
                    binding.progressBarTo.setVisibility(View.GONE);
                }
                else{
                    textView.setText("Hello");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void showDatePickerDiolog(TextView textView){
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, (view,selectedYear,selectedMonth,selectedDay)->{
            calendar.set(selectedYear,selectedMonth,selectedDay);
            String formattedDate = dateFormat.format(calendar.getTime());
            textView.setText(formattedDate);
        },year,month,day);
        datePickerDialog.show();
    }
}