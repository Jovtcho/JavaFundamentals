import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P12ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstStar = scanner.nextLine().split("\\s+");
        String fsName = firstStar[0];
        double fsCenterX = Double.parseDouble(firstStar[1]);
        double fsCenterY = Double.parseDouble(firstStar[2]);

        String[] secondStar = scanner.nextLine().split("\\s+");
        String ssName = secondStar[0];
        double ssCenterX = Double.parseDouble(secondStar[1]);
        double ssCenterY = Double.parseDouble(secondStar[2]);

        String[] thirdStar = scanner.nextLine().split("\\s+");
        String tsName = thirdStar[0];
        double tsCenterX = Double.parseDouble(thirdStar[1]);
        double tsCenterY = Double.parseDouble(thirdStar[2]);

        double[] spaceshipCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        double spaceshipStartX = spaceshipCoordinates[0];
        double spaceshipStartY = spaceshipCoordinates[1];
        int moveCount = Integer.parseInt(scanner.nextLine());

        List<String> locations = new ArrayList<>();

        for (int move = 0; move <= moveCount; move++) {
            boolean isInFirstStarArea = checkIfSpaceshipIsInStarArea(fsCenterX, fsCenterY, spaceshipStartX, spaceshipStartY);
            boolean isInSecondStarArea = checkIfSpaceshipIsInStarArea(ssCenterX, ssCenterY, spaceshipStartX, spaceshipStartY);
            boolean isInThirdStarArea = checkIfSpaceshipIsInStarArea(tsCenterX, tsCenterY, spaceshipStartX, spaceshipStartY);
            determineLocation(fsName, ssName, tsName, locations, isInFirstStarArea, isInSecondStarArea, isInThirdStarArea);
            spaceshipStartY++;
        }

        for (String location : locations) {
            System.out.println(location);
        }
    }

    private static void determineLocation(String fsName, String ssName, String tsName, List<String> locations,
                                          boolean isInFirstStarArea, boolean isInSecondStarArea, boolean isInThirdStarArea) {
        if (isInFirstStarArea) {
            locations.add(fsName.toLowerCase());
        } else if (isInSecondStarArea) {
            locations.add(ssName.toLowerCase());
        } else if (isInThirdStarArea) {
            locations.add(tsName.toLowerCase());
        } else {
            locations.add("space");
        }
    }

    private static boolean checkIfSpaceshipIsInStarArea(double starCenterX, double starCenterY, double spaceshipX, double spaceshipY) {
        double starAreaXmin = starCenterX - 1;
        double starAreaXmax = starCenterX + 1;
        double starAreaYmin = starCenterY - 1;
        double starAreaYmax = starCenterY + 1;

        boolean isSpaceBetweenX = starAreaXmin <= spaceshipX && spaceshipX <= starAreaXmax;
        boolean isSpaceBetweenY = starAreaYmin <= spaceshipY && spaceshipY <= starAreaYmax;

        boolean isSpaceInStarArea = isSpaceBetweenX && isSpaceBetweenY;

        return isSpaceInStarArea;
    }
}
