package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link F_Deal_details#newInstance} factory method to
 * create an instance of this fragment.
 */
public class F_Deal_details extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public F_Deal_details() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment F_Deal_details.
     */
    // TODO: Rename and change types and number of parameters
    public static F_Deal_details newInstance(String param1, String param2) {
        F_Deal_details fragment = new F_Deal_details();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f__deal_details, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            Deal deal = (Deal) bundle.getSerializable("deal");
            // Use the deal object to populate the UI or perform any necessary operations
            if (deal != null) {
                // Get the list of image resource IDs from the Deal object
                ArrayList<Integer> imgResource = deal.getImgResource();

                // Initialize your image list for the ImageSlider
                ArrayList<SlideModel> imageList = new ArrayList<>();
                for (Integer resourceId : imgResource) {
                    // Add each image resource ID to the image list
                    imageList.add(new SlideModel(resourceId, ScaleTypes.CENTER_CROP));
                }

                // Find the ImageSlider view by ID from the inflated layout
                ImageSlider imageSlider = view.findViewById(R.id.image_slider);

                // Set the image list to the ImageSlider
                imageSlider.setImageList(imageList);
            }
        }

        return view;
    }

}
