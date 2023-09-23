package com.rmkisancentre.rmc;

import static android.widget.Toast.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


import java.util.Calendar;

public class MainActivity extends Fragment implements View.OnClickListener {


    ImageButton trainingdata,soiltestingdata,watertestingdata,chat;
    FragmentManager fragmentManager;
    String employeeId,offline;
    SharedPreferences sp;
    View v;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =inflater.inflate(R.layout.activity_main, container, false);

        trainingdata=v.findViewById(R.id.trainingdata);

        soiltestingdata=v.findViewById(R.id.soiltestingdata);

        watertestingdata=v.findViewById(R.id.watertestingdata);

        chat=v.findViewById(R.id.chat);

        trainingdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment customerData = new TrainingData();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.fragment_container, customerData);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });

        soiltestingdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment expensesClaims = new SoilFragment();
                FragmentTransaction expensesClaimsTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                expensesClaimsTransaction.replace(R.id.fragment_container, expensesClaims);
                expensesClaimsTransaction.addToBackStack(null);
                // Commit the transaction
                expensesClaimsTransaction.commit();


            }
        });


        watertestingdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment expensesClaims = new WaterFragment();
                FragmentTransaction expensesClaimsTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                expensesClaimsTransaction.replace(R.id.fragment_container, expensesClaims);
                expensesClaimsTransaction.addToBackStack(null);
                // Commit the transaction
                expensesClaimsTransaction.commit();

            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment expensesClaims = new ChatFragment();
                FragmentTransaction expensesClaimsTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                expensesClaimsTransaction.replace(R.id.fragment_container, expensesClaims);
                expensesClaimsTransaction.addToBackStack(null);
                // Commit the transaction
                expensesClaimsTransaction.commit();

            }
        });







        return v;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {


        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View view) {

        Fragment fragment=null;
        Toast.makeText(getActivity(),"viewid"+v.getId(), Toast.LENGTH_SHORT).show();




        switch (v.getId()) {






            case R.id.trainingdata:
                // Create new fragment and transaction
                Fragment customerData1 = new TrainingData();
                FragmentTransaction transaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction2.replace(R.id.fragment_container, customerData1);
                transaction2.addToBackStack(null);
                // Commit the transaction
                transaction2.commit();
                break;


            case R.id.soiltestingdata:
                // Create new fragment and transaction
                Fragment expensesClaims = new SoilTesting();
                FragmentTransaction expensesClaimsTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                expensesClaimsTransaction.replace(R.id.fragment_container, expensesClaims);
                expensesClaimsTransaction.addToBackStack(null);
                // Commit the transaction
                expensesClaimsTransaction.commit();
                break;

            default:
                break;

        }

    }




}