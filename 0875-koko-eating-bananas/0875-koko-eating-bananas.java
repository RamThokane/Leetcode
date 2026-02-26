class Solution {
  public int minEatingSpeed(int[] piles, int h) {
    int l = 1;
    int r = 0;

    for (int pile : piles) {
      if (pile > r) {
        r = pile;
      }
    }

    while (l < r) {
      int m = l + (r - l) / 2;
      int hours = 0;

      for (int pile : piles) {
        hours += (pile - 1) / m + 1;
      }

      if (hours <= h)
        r = m;
      else
        l = m + 1;
    }

    return l;
  }
}