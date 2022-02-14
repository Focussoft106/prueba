package com.jm.io;

import com.jm.ConferenceManagementConfig;
import com.jm.object.Conference;
import com.jm.object.Event;
import com.jm.object.Slot;
import com.jm.object.Track;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConsoleOutputManager {

    public void printSchedule (Conference conference) {

        SimpleDateFormat sdf = ConferenceManagementConfig.DATE_FORMAT;
        System.out.println("Output: Conference Schedule :");
        System.out.println("*********************************************************");
        for(Track track : conference.getTracks()){
            System.out.println("Track " + track.getTrackId());
            List<Slot> slots = track.getSlots();
            System.out.println("");

            for (Slot slot : slots) {

                for (Event event : slot.getEvents()) {
                    System.out.println(sdf.format(event.getStartTime().getTime()) + " " + event.getTitle()
                            + " " + event.getDurationInMinutes());
                }
            }
            System.out.println("*********************************************************");
        }
    }

}
