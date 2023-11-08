package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WtrFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WtrFragment extends Fragment {
    private EditText etLogA,etLogB;
    private Button btnCalculate;
    private ImageView imImg;
    private FirebaseServices fbs;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WtrFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TendonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WtrFragment newInstance(String param1, String param2) {
        WtrFragment fragment = new WtrFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tendon, container, false);
    }
    public void onStart() {
        super.onStart();
        fbs = FirebaseServices.getInstance();
        etLogB = getView().findViewById(R.id.etLegBWtr);
        etLogA = getView().findViewById(R.id.etLegAWtr);
        btnCalculate = getView().findViewById(R.id.btnCalculateWtr);
        imImg=getView().findViewById(R.id.ivImgWtr);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String LogA=etLogA.getText().toString();
                String LogB=etLogB.getText().toString();
                if (LogB.trim().isEmpty()||LogA.trim().isEmpty()){
                    Toast.makeText(getActivity(), "Some fields are empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    int n= (int) Math.sqrt(Math.pow(Double.parseDouble(LogA), 2)+Math.pow(Double.parseDouble(LogB),2));
                    Toast.makeText(getActivity(), "result"+n, Toast.LENGTH_SHORT).show();
                }


            }
        });
        imImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,3);

            }
        });



    }

}