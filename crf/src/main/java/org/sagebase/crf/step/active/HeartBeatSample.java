/*
 *    Copyright 2017 Sage Bionetworks
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package org.sagebase.crf.step.active;

import com.google.common.base.MoreObjects;

import java.util.Date;

/**
 * Created by TheMDP on 10/17/17.
 */

public class HeartBeatSample implements PixelSample {
    public double timestamp;
    public double uptime;
    public double red;
    public double green;
    public double blue;
    public double redLevel;
    public int bpm;
    public double confidence;
    public Date timestampDate;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timestamp", timestamp)
                .add("uptime", uptime)
                .add("red", red)
                .add("green", green)
                .add("blue", blue)
                .add("redLevel", redLevel)
                .add("bpm", bpm)
                .add("confidence", confidence)
                .toString();
    }

    // The minimum "red level"
    private static final double MIN_RED_LEVEL = 40.0;

    /// Is the user's finger covering the lens?
    public boolean isCoveringLens() {
        return (redLevel <= MIN_RED_LEVEL) || (confidence >= 0.5);
    }

    public boolean isPressureExcessive() {
        int hr = bpm;

        if(hr > 250 || hr <= 40) {
            return true;
        }

        // for testing purposes
        return false;
    }

    // Algorithm to be implemented
    public boolean abnormalHR() {
        return false;
    }

    // Algorithm to be implemented
    public boolean declineHR() {
        return false;
    }

    @Override
    public double getTimestamp() {
        return timestamp;
    }

    @Override
    public double getUptime() {
        return uptime;
    }

    @Override
    public double getRed() {
        return red;
    }

    @Override
    public double getGreen() {
        return green;
    }

    @Override
    public double getBlue() {
        return blue;
    }
}


