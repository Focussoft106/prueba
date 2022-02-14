package com.jm.object;

import java.util.ArrayList;
import java.util.List;


public class Track {
    private List<Slot> slots;
    private int trackId;

    public Track(int trackId) {
        this.trackId = trackId;
        slots = new ArrayList<>();
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void addSlot(Slot slot) {
        this.slots.add(slot);
    }

    public int getTrackId() {
        return trackId;
    }

}
