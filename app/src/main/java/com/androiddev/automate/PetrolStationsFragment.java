package com.androiddev.automate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PetrolStationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PetrolStationsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PetrolStationsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PetrolStationsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PetrolStationsFragment newInstance(String param1, String param2) {
        PetrolStationsFragment fragment = new PetrolStationsFragment();
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

    RecyclerView recview;
    PetrolPumpsAdapter PetrolAdapter;
    LinearLayoutManager nestedLayoutManager;
    FirebaseRecyclerOptions<PumpsModel> options;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_petrol_stations, container, false);
        recview = (RecyclerView)view.findViewById(R.id.rec_view);
        nestedLayoutManager = new LinearLayoutManager(getActivity());
        nestedLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recview.setLayoutManager(nestedLayoutManager);
        options =
                new FirebaseRecyclerOptions.Builder<PumpsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("PetrolBunks"), PumpsModel.class)
                        .build();
        PetrolAdapter = new PetrolPumpsAdapter(options);
        recview.setAdapter(PetrolAdapter);
        PetrolAdapter.notifyDataSetChanged();
//        recview.setNestedScrollingEnabled(false);
        recview.setItemAnimator(null);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        PetrolAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        PetrolAdapter.stopListening();
    }
}