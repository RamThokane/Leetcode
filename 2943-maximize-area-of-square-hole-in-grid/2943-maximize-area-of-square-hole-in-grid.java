import java.util.*;

class Solution {

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxContinuousGap(hBars);
        int maxV = maxContinuousGap(vBars);

        int gap = Math.min(maxH, maxV);
        return gap * gap;
    }

    private int maxContinuousGap(int[] bars) {
        if (bars.length == 0) return 1;

        Arrays.sort(bars);

        int maxGap = 2;
        int currentGap = 2;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentGap++;
            } else {
                currentGap = 2;
            }
            maxGap = Math.max(maxGap, currentGap);
        }

        return maxGap;
    }
}
