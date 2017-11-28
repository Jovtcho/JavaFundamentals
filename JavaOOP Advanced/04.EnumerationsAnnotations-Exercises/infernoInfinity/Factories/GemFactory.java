package infernoInfinity.Factories;

import infernoInfinity.enumerations.GemType;

public class GemFactory {
    public static GemType createGem(String gemType) {

        GemType gem = null;
        switch (gemType.toLowerCase()) {
            case "ruby":
                return gem = GemType.RUBY;
            case "emerald":
                return gem = GemType.EMERALD;
            case "amethyst":
                return gem = GemType.AMETHYST;
            default:
                return null;
        }
    }
}
