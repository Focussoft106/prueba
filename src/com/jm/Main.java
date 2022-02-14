package com.jm;

import com.jm.object.Conference;
import com.jm.object.Talk;
import com.jm.enums.DataOutputEnum;
import com.jm.enums.DataSourceEnum;
import com.jm.exceptions.UnsupportedDestinationException;
import com.jm.exceptions.UnsupportedSourceException;
import com.jm.util.ConferenceUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ConferenceManager conferenceManager = new ConferenceManager();
        List<Talk> talkList = null;
        try {
            talkList = conferenceManager.fetchTalksListFromSource(DataSourceEnum.FILE);
        } catch (UnsupportedSourceException e){
            System.err.println(e.getMessage());
        }

        if(talkList == null || talkList.size() == 0)
            return;

        ConferenceUtils.printTalks(talkList);

        Conference conference = conferenceManager.processAndScheduleTalks(talkList);

        try {
            conferenceManager.outputConferenceSchedule(conference, DataOutputEnum.CONSOLE);
        } catch (UnsupportedDestinationException e){
            System.err.println(e.getMessage());
        }
    }
}
