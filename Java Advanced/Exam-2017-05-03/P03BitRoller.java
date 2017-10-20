import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03BitRoller {
    final static int BITS = 19;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int pillarPosition = Integer.parseInt(br.readLine());
        int rolls = Integer.parseInt(br.readLine());

        //Console.WriteLine(Convert.ToString(n, 2).PadLeft(SIZE, '0'));

        for (int i = 0; i < rolls; i++)
        {
            n = RollBitsRight(n, pillarPosition);
            //Console.WriteLine(Convert.ToString(n, 2).PadLeft(SIZE, '0'));
        }

        System.out.println(n);
    }

    private static int RollBitsRight(int n, int pillarPosition)
    {
        int result = 0;
        for (int pos = 0; pos < BITS; pos++)
        {
            int bit = (n >> pos) & 1;
            if (pos == pillarPosition)
            {
                //newBits[pos] = bits[pos];
                result = result | (bit << pos);
            }
            else
            {
                int newPos = RightPosition(pos);
                if (newPos == pillarPosition)
                {
                    newPos = RightPosition(newPos);
                }
                //newBits[newPos] = bits[pos];
                result = result | (bit << newPos);
            }
        }

        return result;
    }

    private static int RightPosition(int pos)
    {
        int newPos = pos - 1;
        if (newPos < 0)
        {
            newPos = BITS - 1;
        }
        return newPos;
    }
}
