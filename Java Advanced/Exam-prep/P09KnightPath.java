import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class P09KnightPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] board = new int[8];
        board[0] = 1;
        int numIndex = 0;
        int bitIndex = 0;
        int currentNum;
        int mask;

        while (true) {
            String line = br.readLine();
            if ("stop".equalsIgnoreCase(line)) {
                break;
            }

            //"left up", "left down", "right up", "right down", "up left", "up right", "down left", "down right"

            switch (line) {
                case "left up":
                    numIndex -= 1;
                    if (numIndex < 0) {
                        numIndex += 1;
                        continue;
                    }
                    bitIndex += 2;
                    if (bitIndex > 7) {
                        numIndex += 1;
                        bitIndex -= 2;
                        continue;
                    }
                    currentNum = board[numIndex];
                    mask = 1 << bitIndex;
                    board[numIndex] = currentNum ^ mask;
                    break;
                case "left down":
                    numIndex += 1;
                    if (numIndex > 7) {
                        numIndex -= 1;
                        continue;
                    }
                    bitIndex += 2;
                    if (bitIndex > 7) {
                        numIndex -= 1;
                        bitIndex -= 2;
                        continue;
                    }
                    currentNum = board[numIndex];
                    mask = 1 << bitIndex;
                    board[numIndex] = currentNum ^ mask;
                    break;
                case "right up":
                    numIndex -= 1;
                    if (numIndex < 0) {
                        numIndex += 1;
                        continue;
                    }
                    bitIndex -= 2;
                    if (bitIndex < 0) {
                        numIndex += 1;
                        bitIndex += 2;
                        continue;
                    }
                    currentNum = board[numIndex];
                    mask = 1 << bitIndex;
                    board[numIndex] = currentNum ^ mask;
                    break;
                case "right down":
                    numIndex += 1;
                    if (numIndex > 7) {
                        numIndex -= 1;
                        continue;
                    }
                    bitIndex -= 2;
                    if (bitIndex < 0) {
                        numIndex -= 1;
                        bitIndex += 2;
                        continue;
                    }
                    currentNum = board[numIndex];
                    mask = 1 << bitIndex;
                    board[numIndex] = currentNum ^ mask;
                    break;
                case "up left":
                    numIndex -= 2;
                    if (numIndex < 0) {
                        numIndex += 2;
                        continue;
                    }
                    bitIndex += 1;
                    if (bitIndex > 7) {
                        numIndex += 2;
                        bitIndex -= 1;
                        continue;
                    }
                    currentNum = board[numIndex];
                    mask = 1 << bitIndex;
                    board[numIndex] = currentNum ^ mask;
                    break;
                case "up right":
                    numIndex -= 2;
                    if (numIndex < 0) {
                        numIndex += 2;
                        continue;
                    }
                    bitIndex -= 1;
                    if (bitIndex < 0) {
                        numIndex += 2;
                        bitIndex += 1;
                        continue;
                    }
                    currentNum = board[numIndex];
                    mask = 1 << bitIndex;
                    board[numIndex] = currentNum ^ mask;
                    break;
                case "down left":
                    numIndex += 2;
                    if (numIndex > 7) {
                        numIndex -= 2;
                        continue;
                    }
                    bitIndex += 1;
                    if (bitIndex > 7) {
                        numIndex -= 2;
                        bitIndex -= 1;
                        continue;
                    }
                    currentNum = board[numIndex];
                    mask = 1 << bitIndex;
                    board[numIndex] = currentNum ^ mask;
                    break;
                case "down right":
                    numIndex += 2;
                    if (numIndex > 7) {
                        numIndex -= 2;
                        continue;
                    }
                    bitIndex -= 1;
                    if (bitIndex < 0) {
                        numIndex -= 2;
                        bitIndex += 1;
                        continue;
                    }
                    currentNum = board[numIndex];
                    mask = 1 << bitIndex;
                    board[numIndex] = currentNum ^ mask;
                    break;
                default:
                    break;
            }
        }

        int sum = 0;
        for (int num : board) {
            sum += num;
        }

        if (sum == 0) {
            System.out.println("[Board is empty]");
            return;
        }

        for (int num : board) {
            if (num > 0) {
                System.out.println(num);
            }
        }
    }
}
