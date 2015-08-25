package com.example.bahadir.grafikproje;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    ListView list1;
    View view;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1, container, false);
        adapterkur();
        return view;
    }

    private void adapterkur() {
        Insan[] insan_data = new Insan[]
                {
                        new Insan(R.mipmap.apoprof, "Apo"),
                        new Insan(R.mipmap.baranprof, "Showers"),
                        new Insan(R.mipmap.kursatprof, "Snow"),
                        new Insan(R.mipmap.ozerprof , "Ben Delay Remix"),
                        new Insan(R.mipmap.taylanprof , "Sis Atma Och"),
                        new Insan(R.mipmap.aliprof , "BigFoot"),
                        new Insan(R.mipmap.hasanprof , "Marlboro Light"),
                        new Insan(R.mipmap.bengisuprof , "Operation"),
                        new Insan(R.mipmap.beyzaprof, "Bana yok mu"),
                        new Insan(R.mipmap.seloprof , "mega")
                };

        InsanAdapter adapter = new InsanAdapter(getActivity(), R.layout.listview_item, insan_data);
        list1 = (ListView) view.findViewById(R.id.listView);
        View header = getActivity().getLayoutInflater().inflate(R.layout.listview_header, null);
        list1.addHeaderView(header);
        list1.setAdapter(adapter);
    }
}