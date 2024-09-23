package com.trabalho.astronauta;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.Map;

public class PlanetsFragment extends Fragment {
    private Spinner planetSpinner;
    private ImageView planetImage;
    private TextView planetInfo;
    private MediaPlayer mediaPlayer;
    private SoundUtil soundUtil;
    private Map<String, String> planetInfoMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_planets, container, false);

        planetSpinner = root.findViewById(R.id.planetSpinner);
        planetImage = root.findViewById(R.id.planetImage);
        planetInfo = root.findViewById(R.id.planetInfo);
        soundUtil = new SoundUtil();
        setupPlanetInfo();

        // Criar array de planetas a partir do arquivo strings.xml
        String[] planets = getResources().getStringArray(R.array.planets_array);

        // Configurar o adapter do Spinner com o layout personalizado
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item, planets) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView textView = view.findViewById(R.id.spinnerTextView);
                textView.setTextColor(getResources().getColor(R.color.white)); // Definindo a cor do texto
                return view;
            }
        };
        adapter.setDropDownViewResource(R.layout.spinner_item); // Para o dropdown também
        planetSpinner.setAdapter(adapter);

        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                soundUtil.playClickSound(getContext());
                updatePlanetInfo(planets[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        return root;
    }

    private void setupPlanetInfo() {
        planetInfoMap = new HashMap<>();
        planetInfoMap.put("Mercurio", getString(R.string.info_mercurio));
        planetInfoMap.put("Venus", getString(R.string.info_venus));
        planetInfoMap.put("Terra", getString(R.string.info_terra));
        planetInfoMap.put("Marte", getString(R.string.info_marte));
        planetInfoMap.put("Jupiter", getString(R.string.info_jupiter));
        planetInfoMap.put("Saturno", getString(R.string.info_saturno));
        planetInfoMap.put("Urano", getString(R.string.info_urano));
        planetInfoMap.put("Netuno", getString(R.string.info_netuno));
    }


    private void updatePlanetInfo(String planet) {
        // Atualizar imagem do planeta
        int imageResource = getResources().getIdentifier(planet.toLowerCase(), "drawable", getContext().getPackageName());
        planetImage.setImageResource(imageResource);

        // Atualizar texto de informação
        String info = planetInfoMap.get(planet);
        planetInfo.setText(info);

        // Reproduzir som do planeta
        playPlanetSound(planet);
    }

    private void playPlanetSound(String planet) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        int soundResource = getResources().getIdentifier(planet.toLowerCase(), "raw", getContext().getPackageName());
        mediaPlayer = MediaPlayer.create(getContext(), soundResource);
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
