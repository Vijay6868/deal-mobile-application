package com.example.dealsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class User_details extends Fragment {

    UserManager userManager;

    String _usertype, _fname, _lname, _uname, _email, _bname, _jobcode;
    TextView usertype, name, lname, uname, email, bname, jobcode, cperson;
    View view;
    ImageView ic_usertype, ic_jobcode;
    RelativeLayout RlContactPerson;
    Activity context;

    public User_details() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();

        // Inflate the layout for this fragment
        //userManager = UserManager.getInstance();
        User user = UserManager.getInstance().getCurrentUser();

        view =inflater.inflate(R.layout.fragment_user_details, container, false);

        usertype = view.findViewById(R.id.lb_userType);
        name = view.findViewById(R.id.lb_full_name);
        email = view.findViewById(R.id.lb_email);
        ic_usertype = view.findViewById(R.id.ic_user_type);
        uname = view.findViewById(R.id.lb_address);
        jobcode = view.findViewById(R.id.lb_mybookings);

        RlContactPerson = view.findViewById(R.id.rl_contact_person);

        _usertype = user.getUserType();
        _email = user.getEmail();
        _fname = user.getFname();
        _lname = user.getLname();
        _uname = user.getUsername();


        String full_name = _fname+" "+_lname;

        usertype.setText(_usertype);

        if(_usertype.equals("supplier")){
            _bname = ((Supplier) user).getBname();
            full_name = _bname;
            RlContactPerson.setVisibility(View.VISIBLE);
            cperson = view.findViewById(R.id.lb_contact_person);
            String c_name = _fname+" "+_lname;
            cperson.setText(c_name);
            ic_usertype.setImageResource(R.drawable.mdi__partnership_outline_2);
        } else if (_usertype.equals("admin")) {
            ic_usertype.setImageResource(R.drawable.eos_icons__admin_outlined);
            ic_jobcode = view.findViewById(R.id.ic_bookings);
            ic_jobcode.setImageResource(R.drawable.ic__baseline_perm_contact_calendar);
            _jobcode = ((Admin) user).getJobcode();
            jobcode.setText(_jobcode);

        }
        email.setText(_email);
        name.setText(full_name);
        uname.setText(_uname);

        return view;
    }

    public void onStart(){
        super.onStart();
        TextView logout = (TextView) context.findViewById(R.id.lb_logOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}