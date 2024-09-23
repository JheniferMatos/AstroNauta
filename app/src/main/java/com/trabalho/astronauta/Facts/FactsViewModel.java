package com.trabalho.astronauta.Facts;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.trabalho.astronauta.R;

import java.util.ArrayList;
import java.util.List;

public class FactsViewModel extends AndroidViewModel {
    private final MutableLiveData<List<Fact>> facts;

    public FactsViewModel(@NonNull Application application) {
        super(application);
        facts = new MutableLiveData<>();
        loadFacts(application);
    }

    public LiveData<List<Fact>> getFacts() {
        return facts;
    }

    private void loadFacts(Context context) {
        List<Fact> factList = new ArrayList<>();

        // Sol
        factList.add(new Fact("Tamanho do Sol", context.getString(R.string.fact_sun), R.drawable.icon_sun));

        // Mercúrio
        factList.add(new Fact("Dias em Mercúrio", context.getString(R.string.fact_mercury), R.drawable.icon_mercury));
        factList.add(new Fact("Mercúrio Rápido", context.getString(R.string.fact_mercury_fastest), R.drawable.icon_mercury));

        // Vênus
        factList.add(new Fact("Rotação de Vênus", context.getString(R.string.fact_venus), R.drawable.icon_venus));
        factList.add(new Fact("Vênus Quente", context.getString(R.string.fact_venus_hottest), R.drawable.icon_venus));
        factList.add(new Fact("Dia em Vênus", context.getString(R.string.fact_venus_day), R.drawable.icon_venus));

        // Terra
        factList.add(new Fact("Lua da Terra", context.getString(R.string.fact_moon), R.drawable.icon_moon));
        factList.add(new Fact("Água na Terra", context.getString(R.string.fact_earth_water), R.drawable.icon_earth));

        // Marte
        factList.add(new Fact("Atmosfera de Marte", context.getString(R.string.fact_mars), R.drawable.icon_mars));
        factList.add(new Fact("Montanhas em Marte", context.getString(R.string.fact_mars_mountains), R.drawable.icon_mars));
        factList.add(new Fact("Estações em Marte", context.getString(R.string.fact_mars_seasons), R.drawable.icon_mars));

        // Júpiter
        factList.add(new Fact("Ano em Júpiter", context.getString(R.string.fact_jupiter), R.drawable.icon_jupiter));
        factList.add(new Fact("Tempestade em Júpiter", context.getString(R.string.fact_jupiter_storm), R.drawable.icon_jupiter));

        // Saturno
        factList.add(new Fact("Anéis de Saturno", context.getString(R.string.fact_saturn), R.drawable.icon_saturn));
        factList.add(new Fact("Densidade de Saturno", context.getString(R.string.fact_saturn_density), R.drawable.icon_saturn));

        // Urano
        factList.add(new Fact("Urano Inclinado", context.getString(R.string.fact_uranus), R.drawable.icon_uranus));
        factList.add(new Fact("Luas de Urano", context.getString(R.string.fact_uranus_moons), R.drawable.icon_uranus));

        // Netuno
        factList.add(new Fact("Netuno Ventoso", context.getString(R.string.fact_neptune), R.drawable.icon_neptune));
        factList.add(new Fact("Cor de Netuno", context.getString(R.string.fact_neptune_blue), R.drawable.icon_neptune));

        // Plutão
        factList.add(new Fact("Órbita de Plutão", context.getString(R.string.fact_pluto_orbit), R.drawable.icon_pluto));

        // Haumea
        factList.add(new Fact("Forma de Haumea", context.getString(R.string.fact_haumea_shape), R.drawable.icon_haumea));

        // Éris
        factList.add(new Fact("Tamanho de Éris", context.getString(R.string.fact_eris_size), R.drawable.icon_eris));

        // Outros
        factList.add(new Fact("Planetas Anões", context.getString(R.string.fact_dwarf_planet), R.drawable.icon_dwarf_planet));
        factList.add(new Fact("Cinturão de Kuiper", context.getString(R.string.fact_kuiper_belt), R.drawable.planet_default));
        factList.add(new Fact("Nuvem de Oort", context.getString(R.string.fact_oort_cloud), R.drawable.planet_default));
        factList.add(new Fact("Vento Solar", context.getString(R.string.fact_solar_wind), R.drawable.planet_default));

        facts.setValue(factList);
    }
}
