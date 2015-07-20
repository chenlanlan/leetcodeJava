public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = 0;
        area = Math.abs(C - A) * Math.abs(D - B) + Math.abs(G - E) * Math.abs(H - F);
        int[] length = commonRange(A, C, E, G);
        int[] breadth = commonRange(B, D, F, H);
        int DupAreaLength = length[1] - length[0];
        int DupAreaBreadth = breadth[1] - breadth[0];
        area -= DupAreaLength * DupAreaBreadth;
        return area;
    }

    public int[] commonRange(int Astart, int Aend, int Bstart, int Bend) {
        int[] res = new int[2];
        if (Astart >= Bend || Aend <= Bstart) {
            return res;
        }
        res[0] = Math.max(Astart, Bstart);
        res[1] = Math.min(Aend, Bend);
        return res;
    }

    public static void main(String[] args) {
        RectangleArea test = new RectangleArea();
        System.out.println(test.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}