package leetcode161to200;

public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) 
    {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
