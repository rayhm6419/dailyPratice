class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour % 12) * (360.0 / 12) + minutes * ((360.0 / 12) / 60);
        double minuteAngle = minutes * (360.0 / 60);
        double angle = Math.abs(hourAngle - minuteAngle);
        return angle <= 180 ? angle : 360 - angle;
    }
}