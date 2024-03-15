public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        maxArea(height);
    }

    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Minimum Height
            int currentArea = Math.min(height[left], height[right]);

            // Maxmum Area
            maxArea = Math.max(maxArea, currentArea * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
