package com.example.dealsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;


public class F_Deal_details extends Fragment {

    TextView tv_category, tv_description;

    public F_Deal_details() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f__deal_details, container, false);
        tv_category = view.findViewById(R.id.tv_category);
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
                tv_category.setText(deal.getCategory());
            }

        }



        return view;
    }

}
