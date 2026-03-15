import java.util.ArrayList;
import java.util.List;

class Fancy {
    private List<Long> nums;
    private long add = 0;
    private long mul = 1;
    private static final int MOD = 1_000_000_007;

    public Fancy() {
        nums = new ArrayList<>();
    }

    public void append(int val) {
        long transformed = (val - add + MOD) % MOD;
        transformed = (transformed * power(mul, MOD - 2)) % MOD;
        nums.add(transformed);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        add = (add * m) % MOD;
        mul = (mul * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= nums.size()) return -1;
        long res = (nums.get(idx) * mul) % MOD;
        res = (res + add) % MOD;
        return (int) res;
    }

    private long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b /= 2;
        }
        return res;
    }
}