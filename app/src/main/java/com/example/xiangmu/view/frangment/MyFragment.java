package com.example.xiangmu.view.frangment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiangmu.R;
import com.example.xiangmu.view.activity.AddressActivity;
import com.example.xiangmu.view.activity.CircleActivity;
import com.example.xiangmu.view.activity.FootActivity;
import com.example.xiangmu.view.activity.PersonalActivity;
import com.example.xiangmu.view.activity.WalletActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyFragment extends Fragment {

    @BindView(R.id.my_image_header)
    SimpleDraweeView myImageHeader;
    @BindView(R.id.my_text_name)
    TextView myTextName;
    @BindView(R.id.my_text_personal)
    TextView myTextPersonal;
    @BindView(R.id.my_text_circle)
    TextView myTextCircle;
    @BindView(R.id.my_text_foot)
    TextView myTextFoot;
    @BindView(R.id.my_text_wallet)
    TextView myTextWallet;
    @BindView(R.id.my_text_address)
    TextView myTextAddress;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.myfragment, container, false);
        initData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.my_text_personal, R.id.my_text_circle, R.id.my_text_foot, R.id.my_text_wallet, R.id.my_text_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_text_personal:
                startActivity(new Intent(getActivity(),PersonalActivity.class));
                break;
            case R.id.my_text_circle:
                startActivity(new Intent(getActivity(),CircleActivity.class));
                break;
            case R.id.my_text_foot:
                startActivity(new Intent(getActivity(),FootActivity.class));
                break;
            case R.id.my_text_wallet:
                startActivity(new Intent(getActivity(),WalletActivity.class));
                break;
            case R.id.my_text_address:
                startActivity(new Intent(getActivity(),AddressActivity.class));
                break;
        }
    }
}
