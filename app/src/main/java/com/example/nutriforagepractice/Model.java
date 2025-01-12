package com.example.nutriforagepractice;

import android.content.Context;

import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

public class Model {
    String id, tile, description;
    private Context applicationContext;

    public Model() {
    }

    public Model(String id, String tile, String description) {
        this.id = id;
        this.tile = tile;
        this.description = description;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
