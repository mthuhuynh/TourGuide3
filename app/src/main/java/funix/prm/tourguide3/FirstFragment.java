package funix.prm.tourguide3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstFragment extends Fragment {

    private OnFirstFragmentListener mListener;

    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        dataList = view.findViewById(R.id.dataList);

        titles = Arrays.asList(getResources().getStringArray(R.array.location));
        images = new ArrayList<>();

        images.add(R.drawable.ic_baseline_directions_bus_24);
        images.add(R.drawable.ic_baseline_hotel_24);
        images.add(R.drawable.ic_baseline_local_atm_24);
        images.add(R.drawable.ic_baseline_local_hospital_24);

        adapter = new Adapter(getActivity(),titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        return view;
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

