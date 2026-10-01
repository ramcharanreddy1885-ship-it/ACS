class Solution {
    public String dayOfTheWeek(int day, int month, int year) {

        String[] week = {
            "Friday", "Saturday", "Sunday",
            "Monday", "Tuesday", "Wednesday", "Thursday"
        };

        int[] daysInMonth = {
            31,28,31,30,31,30,31,31,30,31,30,31
        };

        int days = 0;

        // Count days for complete years
        for (int y = 1971; y < year; y++) {
            days += isLeap(y) ? 366 : 365;
        }

        // Count days for complete months
        for (int m = 1; m < month; m++) {
            days += daysInMonth[m - 1];
            if (m == 2 && isLeap(year)) {
                days++;
            }
        }

        // Add current month's days
        days += day - 1;

        return week[days % 7];
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}