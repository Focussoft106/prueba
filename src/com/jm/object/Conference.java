package com.jm.object;

import java.util.List;
import java.util.ArrayList;

public class Conference {
    List<Track> tracks;

    public List<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
    }

    public Conference(){
        this.tracks = new ArrayList();
    }
}


