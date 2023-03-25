package ir.ac.kntu;

public class DateAndTime {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public DateAndTime(int year, int month, int day,int hour, int minute) {
        if (checkDate(year, month, day)) {
            setDate(year, month, day);
        } else {
            this.year = 0;
            this.month = 1;
            this.day = 1;
        }
        if (checkTime(hour, minute)) {
            setTime(hour, minute);
        } else {
            this.hour = 0;
            this.minute = 0;
        }
    }

    public static boolean compareDates(DateAndTime first, DateAndTime second) {
        if (first.getYear() != second.getYear()) {
            return first.getYear() < second.getYear();
        }
        if (first.getMonth() != second.getMonth()) {
            return first.getMonth() < second.getMonth();
        }
        if (first.getDay() != second.getDay()) {
            return first.getDay() < second.getDay();
        }
        if (first.getHour() != second.getHour()) {
            return first.getHour() < second.getHour();
        }
        if (first.getMinute() != second.getMinute()) {
            return first.getMinute() < second.getMinute();
        }
        return true;
    }
    public static boolean checkDate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (month >= 6 && month != 12) {
            if (day < 1 || day > 30) {
                return false;
            }
        } else if (month < 6) {
            if (day < 1 || day > 31) {
                return false;
            }
        } else {
            if (!leapYear(year) && day == 30) {
                return false;
            }
            if (day > 30) {
                return false;
            }
        }
        return true;
    }

    private static boolean leapYear(int year) {
        if ((year % 4 == 0) && year % 100 != 0) {
            return true;
        } else if ((year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static boolean checkTime(int hour, int minute) {
        if (hour > 24) {
            return false;
        }
        if (minute > 59) {
            return false;
        }
        return true;
    }

    public void setTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String toStringTime() {
        return this.hour + ":" + this.minute;
    }

    public String toStringDate() {
        return this.year + "-" + this.month + "-" + this.day;
    }

}
