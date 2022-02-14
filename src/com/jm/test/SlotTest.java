package com.jm.test;

import com.jm.object.Slot;
import com.jm.object.Talk;
import com.jm.util.ConferenceUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;


public class SlotTest {

    @Test
    public void testHasRoomForTalk(){

        Calendar slotStartTime = ConferenceUtils.getCalendarTime(9, 00);
        Slot slot = new Slot(50, slotStartTime);

        Talk talk1 = new Talk("Valid Talk", 45);
        Assert.assertTrue(slot.hasRoomFor(talk1));

        Talk talk2 = new Talk("InValid Talk", 60);
        Assert.assertFalse(slot.hasRoomFor(talk2));

    }
}
