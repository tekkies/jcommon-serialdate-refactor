/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2016, by Andy Joiner.
 *
 * Project Info:  https://github.com/tekkies/jcommon-serialdate-refactor
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * --------------------
 * ExtraSerialDateTests.java
 * --------------------
 * (C) Copyright 2016, by Andy Joiner
 *
  *
 */

package org.jfree.date.junit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.jfree.date.SerialDate;

import java.text.SimpleDateFormat;

public class ExtraSerialDateTests extends TestCase {

    public static final int ILLEGAL_MONTH = -1;
    public static final boolean originalBehaviour = true;

    public ExtraSerialDateTests(final String name) {
        super(name);
    }

    public static Test suite() {
        return new TestSuite(ExtraSerialDateTests.class);
    }

    public void testIsValidWeekdayCode() {
        assertEquals(true, SerialDate.isValidWeekdayCode(org.jfree.date.SerialDate.SUNDAY));
        assertEquals(true, SerialDate.isValidWeekdayCode(org.jfree.date.SerialDate.MONDAY));
        assertEquals(true, SerialDate.isValidWeekdayCode(org.jfree.date.SerialDate.TUESDAY));
        assertEquals(true, SerialDate.isValidWeekdayCode(org.jfree.date.SerialDate.WEDNESDAY));
        assertEquals(true, SerialDate.isValidWeekdayCode(org.jfree.date.SerialDate.THURSDAY));
        assertEquals(true, SerialDate.isValidWeekdayCode(org.jfree.date.SerialDate.FRIDAY));
        assertEquals(true, SerialDate.isValidWeekdayCode(org.jfree.date.SerialDate.SATURDAY));
        assertEquals(false, SerialDate.isValidWeekdayCode(0));
    }

    public void testMonthCodeToQuarter() {
        assertEquals(1, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.JANUARY));
        assertEquals(1, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.FEBRUARY));
        assertEquals(1, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.MARCH));
        assertEquals(2, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.APRIL));
        assertEquals(2, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.MAY));
        assertEquals(2, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.JUNE));
        assertEquals(3, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.JULY));
        assertEquals(3, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.AUGUST));
        assertEquals(3, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.SEPTEMBER));
        assertEquals(4, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.OCTOBER));
        assertEquals(4, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.NOVEMBER));
        assertEquals(4, SerialDate.monthCodeToQuarter(org.jfree.date.SerialDate.DECEMBER));
        try {
            SerialDate.monthCodeToQuarter(ILLEGAL_MONTH);
            fail();
        } catch (IllegalArgumentException expectedException) {
        }
    }

    public void testGetMonths()
    {
        String[] months = SerialDate.getMonths();
        assertEquals(13, months.length);
        assertEquals("January", months[0].toString());
    }

    public void testIsValidMonthCode() {
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.JANUARY));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.FEBRUARY));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.MARCH));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.APRIL));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.MAY));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.JUNE));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.JULY));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.AUGUST));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.SEPTEMBER));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.OCTOBER));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.NOVEMBER));
        assertEquals(true, SerialDate.isValidMonthCode(org.jfree.date.SerialDate.DECEMBER));
        assertEquals(false, SerialDate.isValidMonthCode(ILLEGAL_MONTH));
    }

    public void testMonthCodeToString() {
        assertEquals(new SimpleDateFormat().getDateFormatSymbols().getShortMonths()[0],
                SerialDate.monthCodeToString(org.jfree.date.SerialDate.JANUARY, true));
        try {
            SerialDate.monthCodeToString(ILLEGAL_MONTH);
        } catch (IllegalArgumentException expectedException) {
        }
    }

    public void testIsValidWeekInMonthCode() {
        assertEquals(true, SerialDate.isValidWeekInMonthCode(org.jfree.date.SerialDate.FIRST_WEEK_IN_MONTH));
        assertEquals(true, SerialDate.isValidWeekInMonthCode(org.jfree.date.SerialDate.SECOND_WEEK_IN_MONTH));
        assertEquals(true, SerialDate.isValidWeekInMonthCode(org.jfree.date.SerialDate.THIRD_WEEK_IN_MONTH));
        assertEquals(true, SerialDate.isValidWeekInMonthCode(org.jfree.date.SerialDate.FOURTH_WEEK_IN_MONTH));
        assertEquals(true, SerialDate.isValidWeekInMonthCode(org.jfree.date.SerialDate.LAST_WEEK_IN_MONTH));
        assertEquals(false, SerialDate.isValidWeekInMonthCode(-1));
    }

    public void testGetPreviousDayOfWeek() {
        try {
            SerialDate.getPreviousDayOfWeek(-1, SerialDate.createInstance(26,10,1985));
            fail();
        } catch (IllegalArgumentException expectedException) {
        }
        SerialDate sunday21Aug2016 = SerialDate.createInstance(21, 8, 2016);
        assertEquals(SerialDate.createInstance(14,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.SUNDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(15,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.MONDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(16,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.TUESDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(17,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.WEDNESDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(18,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.THURSDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(19,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.FRIDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(20,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.SATURDAY, sunday21Aug2016));

        SerialDate saturday20Aug2016 = SerialDate.createInstance(20, 8, 2016);
        assertEquals(SerialDate.createInstance(14, 8, 2016), SerialDate.getPreviousDayOfWeek(SerialDate.SUNDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(15,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.MONDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(16,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.TUESDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(17,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.WEDNESDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(18,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.THURSDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(19,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.FRIDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(13,8,2016),  SerialDate.getPreviousDayOfWeek(SerialDate.SATURDAY, saturday20Aug2016));
    }

    public void testGetFollowingDayOfWeek() {
        try {
            SerialDate.getFollowingDayOfWeek(-1, SerialDate.createInstance(26,10,1985));
            fail();
        } catch (IllegalArgumentException expectedException) {
        }
        SerialDate sunday21Aug2016 = SerialDate.createInstance(21, 8, 2016);
        if(originalBehaviour) {
            assertEquals(SerialDate.createInstance(21, 8, 2016), SerialDate.getFollowingDayOfWeek(SerialDate.SUNDAY, sunday21Aug2016));
        } else {
            assertEquals(SerialDate.createInstance(28, 8, 2016), SerialDate.getFollowingDayOfWeek(SerialDate.SUNDAY, sunday21Aug2016));
        }
        assertEquals(SerialDate.createInstance(22,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.MONDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(23,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.TUESDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(24,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.WEDNESDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(25,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.THURSDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(26,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.FRIDAY, sunday21Aug2016));
        assertEquals(SerialDate.createInstance(27,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.SATURDAY, sunday21Aug2016));

        SerialDate saturday20Aug2016 = SerialDate.createInstance(20, 8, 2016);
        assertEquals(SerialDate.createInstance(21,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.SUNDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(22,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.MONDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(23,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.TUESDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(24,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.WEDNESDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(25,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.THURSDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(26,8,2016),  SerialDate.getFollowingDayOfWeek(SerialDate.FRIDAY, saturday20Aug2016));
        if(originalBehaviour) {
            assertEquals(SerialDate.createInstance(20, 8, 2016), SerialDate.getFollowingDayOfWeek(SerialDate.SATURDAY, saturday20Aug2016));
        } else {
            assertEquals(SerialDate.createInstance(27, 8, 2016), SerialDate.getFollowingDayOfWeek(SerialDate.SATURDAY, saturday20Aug2016));
        }
    }

    public void testGetNearestDayOfWeek() {
        try {
            SerialDate.getNearestDayOfWeek(-1, SerialDate.createInstance(26,10,1985));
            fail();
        } catch (IllegalArgumentException expectedException) {
        }
        SerialDate sunday21Aug2016 = SerialDate.createInstance(21,8,2016);
        assertEquals(SerialDate.createInstance(21,8,2016), SerialDate.getNearestDayOfWeek(SerialDate.SUNDAY, sunday21Aug2016));
        if(originalBehaviour) {
            assertEquals(SerialDate.createInstance(20,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.MONDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(19,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.TUESDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(18,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.WEDNESDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(24,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.THURSDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(23,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.FRIDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(22,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.SATURDAY, sunday21Aug2016));
        } else {
            assertEquals(SerialDate.createInstance(22,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.MONDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(23,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.TUESDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(24,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.WEDNESDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(18,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.THURSDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(19,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.FRIDAY, sunday21Aug2016));
            assertEquals(SerialDate.createInstance(20,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.SATURDAY, sunday21Aug2016));
        }

        SerialDate saturday20Aug2016 = SerialDate.createInstance(20, 8, 2016);
        assertEquals(SerialDate.createInstance(21,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.SUNDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(22,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.MONDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(23,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.TUESDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(17,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.WEDNESDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(18,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.THURSDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(19,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.FRIDAY, saturday20Aug2016));
        assertEquals(SerialDate.createInstance(20,8,2016),  getNearestDayOfWeekWithDowCheck(SerialDate.SATURDAY, saturday20Aug2016));
    }

    private SerialDate getNearestDayOfWeekWithDowCheck(final int targetDOW,
                                                       final SerialDate base) {
        SerialDate nearestDayOfWeek = SerialDate.getNearestDayOfWeek(targetDOW, base);
        if(!originalBehaviour) {
            int resultDow = nearestDayOfWeek.getDayOfWeek();
            junit.framework.Assert.assertEquals(targetDOW, resultDow);
        }
        return nearestDayOfWeek;
    }

    public void testGetEndOfCurrentMonth() {
        SerialDate saturday20Aug2016 = SerialDate.createInstance(20, 8, 2016);
        SerialDate endOfMonth = saturday20Aug2016.getEndOfCurrentMonth(saturday20Aug2016);
        assertEquals(SerialDate.createInstance(31,8,2016), endOfMonth);
    }

    public void testWeekInMonthToString()
    {
        assertEquals("First"     , SerialDate.weekInMonthToString(SerialDate.FIRST_WEEK_IN_MONTH ));
        assertEquals("Second"     , SerialDate.weekInMonthToString(SerialDate.SECOND_WEEK_IN_MONTH));
        assertEquals("Third"     , SerialDate.weekInMonthToString(SerialDate.THIRD_WEEK_IN_MONTH ));
        assertEquals("Fourth"     , SerialDate.weekInMonthToString(SerialDate.FOURTH_WEEK_IN_MONTH));
        assertEquals("Last"     , SerialDate.weekInMonthToString(SerialDate.LAST_WEEK_IN_MONTH));
        assertEquals("SerialDate.weekInMonthToString(): invalid code.", SerialDate.weekInMonthToString(-1));
    }

    public void testRelativeToString() {
        assertEquals("Preceding", SerialDate.relativeToString(SerialDate.PRECEDING));
        assertEquals("Nearest", SerialDate.relativeToString(SerialDate.NEAREST));
        assertEquals("Following", SerialDate.relativeToString(SerialDate.FOLLOWING));
        assertEquals("ERROR : Relative To String", SerialDate.relativeToString(-2));
    }
}