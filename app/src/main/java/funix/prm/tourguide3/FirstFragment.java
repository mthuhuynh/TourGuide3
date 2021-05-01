package funix.prm.tourguide3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private OnFirstFragmentListener mListener;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        img1 = view.findViewById(R.id.icon1);
        img2 = view.findViewById(R.id.icon2);
        img3 = view.findViewById(R.id.icon3);
        img4 = view.findViewById(R.id.icon4);

        img1.setOnClickListener(this::onClick);
        img2.setOnClickListener(this::onClick);
        img3.setOnClickListener(this::onClick);
        img4.setOnClickListener(this::onClick);
//        img1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mListener != null) {
//                    mListener.onItemPressed(1);
//                }
//            }
//        });
//
//        img2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mListener != null) {
//                    mListener.onItemPressed(1);
//                }
//            }
//        });
//
//        img3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mListener != null) {
//                    mListener.onItemPressed(1);
//                }
//            }
//        });
//
//        img4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mListener != null) {
//                    mListener.onItemPressed(1);
//                }
//            }
//        });

        return view;
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.icon1:
                if (mListener != null) {
                   mListener.onItemPressed(1); }
                break;
            case R.id.icon2:
                if (mListener != null) {
                mListener.onItemPressed(1); }
                break;
            case R.id.icon3:
                if (mListener != null) {
                    mListener.onItemPressed(1); }
                break;
            case R.id.icon4:
                if (mListener != null) {
                    mListener.onItemPressed(1); }
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFirstFragmentListener) {
            mListener = (OnFirstFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFirstFragmentListener {
        void onItemPressed(int content);
    }
}

