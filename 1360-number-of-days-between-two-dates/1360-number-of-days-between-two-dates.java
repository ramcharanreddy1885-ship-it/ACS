class Solution {

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1971(date1) - daysFrom1971(date2));
    }

    private int daysFrom1971(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int days = 0;

        // Add days for complete years
        for (int y = 1971; y < year; y++) {
            days += isLeap(y) ? 366 : 365;
        }

        // Days in each month
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        // Add days for complete months
        for (int m = 1; m < month; m++) {
            days += monthDays[m - 1];
            if (m == 2 && isLeap(year)) {
                days++;
            }
        }

        // Add current month's days
        days += day;

        return days;
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}