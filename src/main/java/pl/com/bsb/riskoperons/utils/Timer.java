/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bsb.riskoperons.utils;

/**
 *
 * @author Grzegorz
 */
public class Timer {

    public enum Precision {

        SECOND, NANOSECOND, MICROSECOND, MILLISECOND
    }
    private long startTime = 0L;
    private long stopTime = 0L;
    private long memStart = 0L;
    private long memEnd = 0L;
    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;
    private int microseconds;
    private int nanoseconds;
    
    //sekundy do odliczania
    private int countdown;

    public void start() {
        startTime = System.nanoTime();
        stopTime = 0L;
        memStart = Runtime.getRuntime().freeMemory();
    }

    public void stop() {
        stopTime = System.nanoTime();
        memEnd = Runtime.getRuntime().freeMemory();
    }
    
    public void setCountdown(int countdown)
    {
        this.countdown=countdown;
    }
    
    public boolean isCountdownFinished()
    {        
        long duration = System.nanoTime() - startTime;
        calculate(duration, Precision.NANOSECOND);
        return seconds >= countdown;
    }

    public String getDuration() {
        return getDuration(Precision.MILLISECOND);
    }

    /**
     * Metoda zwraca sformatowany czas o okreslonej precyzji
     *
     * @param precision
     * @return
     */
    public String getDuration(Precision precision) {
        long duration = stopTime - startTime;
        calculate(duration, Precision.NANOSECOND);
        return format(precision);
    }

    /**
     * Metoda zwraca wielkmość wykorzystanej pamięci
     *
     * @return
     */
    public String getMemUsing() {
        long duration = memEnd - memStart;
        return "" + duration;
    }

    private void calculate(long duration, Precision precision) {
        switch (precision) {
            case SECOND:
                calculate(duration * 1000 * 1000 * 1000, Precision.NANOSECOND);
                break;
            case MILLISECOND:
                calculate(duration * 1000 * 1000, Precision.NANOSECOND);
                break;
            case MICROSECOND:
                calculate(duration * 1000, Precision.NANOSECOND);
                break;
            case NANOSECOND:
                nanoseconds = (int) duration % 1000;
                duration = (duration - nanoseconds) / 1000;
                microseconds = (int) duration % 1000;
                duration = (duration - microseconds) / 1000;
                milliseconds = (int) duration % 1000;
                duration = (duration - milliseconds) / 1000;
                seconds = (int) duration % 60;
                duration = (duration - seconds) / 60;
                minutes = (int) duration % 60;
                duration = (duration - minutes) / 60;
                hours = (int) duration % 60;
                break;
        }
    }

    private String format(Precision precision) {

        StringBuilder resultBuf = new StringBuilder();
        resultBuf.append(hours);
        resultBuf.append(':');
        resultBuf.append(String.format("%02d", minutes));
        if (precision.equals(Precision.SECOND) || precision.equals(Precision.MILLISECOND) || precision.equals(Precision.MICROSECOND) || precision.equals(Precision.NANOSECOND)) {
            resultBuf.append(':');
            resultBuf.append(String.format("%02d", seconds));
        }
        if (precision.equals(Precision.MILLISECOND) || precision.equals(Precision.MICROSECOND) || precision.equals(Precision.NANOSECOND)) {
            resultBuf.append('.');
            resultBuf.append(String.format("%03d", milliseconds));
        }
        if (precision.equals(Precision.MICROSECOND) || precision.equals(Precision.NANOSECOND)) {
            resultBuf.append('.');
            resultBuf.append(String.format("%03d", microseconds));
        }
        if (precision.equals(Precision.NANOSECOND)) {
            resultBuf.append('.');
            resultBuf.append(String.format("%03d", nanoseconds));
        }
        return resultBuf.toString();
    }

}
