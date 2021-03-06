/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.activities.common.views;

import androidx.test.filters.*;
import androidx.test.runner.*;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.isoron.uhabits.*;
import org.isoron.uhabits.core.models.*;
import org.isoron.uhabits.utils.*;
import org.junit.*;
import org.junit.runner.*;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class StreakChartTest extends BaseViewTest
{
    private static final String BASE_PATH = "common/StreakChart/";

    private StreakChart view;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();

        fixtures.purgeHabits(habitList);
        Habit habit = fixtures.createLongHabit();

        view = new StreakChart(targetContext);
        view.setColor(PaletteUtils.getAndroidTestColor(habit.getColor()));
        view.setStreaks(habit.getStreaks().getBest(5));
        measureView(view, dpToPixels(300), dpToPixels(100));
    }

    @Test
    public void testRender() throws Throwable
    {
        assertRenders(view, BASE_PATH + "render.png");
    }

    @Test
    public void testRender_withSmallSize() throws Throwable
    {
        measureView(view, dpToPixels(100), dpToPixels(100));
        assertRenders(view, BASE_PATH + "renderSmallSize.png");
    }

    @Test
    public void testRender_withTransparentBackground() throws Throwable
    {
        view.setIsBackgroundTransparent(true);
        assertRenders(view, BASE_PATH + "renderTransparent.png");
    }
}
