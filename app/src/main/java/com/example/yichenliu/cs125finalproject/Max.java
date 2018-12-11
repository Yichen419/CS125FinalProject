package com.example.yichenliu.cs125finalproject;

public class Max {
    private int[] values;
    public int max() {
        int l = values.length;
        int max = values[0];
        for (int i = 1; i < l; i++) {
            if (max < values[i]) {
                max = values[i];
            }
        }
        return max;
    }
    public Max(int[] setValue) {
        values = setValue;
    }
}
