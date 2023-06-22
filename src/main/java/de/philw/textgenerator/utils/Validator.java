package de.philw.textgenerator.utils;

import de.philw.textgenerator.ui.value.Block;
import de.philw.textgenerator.ui.value.FontSize;
import de.philw.textgenerator.ui.value.LineSpacing;
import de.philw.textgenerator.ui.value.PlaceRange;

import java.awt.*;

public class Validator {

    public static boolean isValidFont(String font) {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = graphicsEnvironment.getAvailableFontFamilyNames();
        for (String string : fonts) {
            if (string.equals(font)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidBlock(String block) {
        try {
            Block.valueOf(block.toUpperCase());
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidFontSize(String size) {
        if (isNoInteger(size)) return false;
        int integer = Integer.parseInt(size);
        return integer >= FontSize.getMinFontSize() && integer <= FontSize.getMaxFontSize();
    }

    public static boolean isNoInteger(String integer) {
        try {
            Integer.parseInt(integer);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static boolean isValidFontStyle(String fontStyle) {
        return fontStyle.equalsIgnoreCase("Bold") || fontStyle.equalsIgnoreCase("Italic")
                || fontStyle.equalsIgnoreCase("BoldItalic") || fontStyle.equalsIgnoreCase("Plain");
    }

    public static boolean isValidBoolean(String bool) {
        return bool.equalsIgnoreCase("true") || bool.equalsIgnoreCase("false");
    }

    public static boolean isValidLineSpacing(String lineSpacing) {
        if (isNoInteger(lineSpacing)) return false;
        int number = Integer.parseInt(lineSpacing);
        return number >= LineSpacing.getMinLineSpacing() && number <= LineSpacing.getMaxLineSpacing();
    }

    public static boolean isValidPlaceRange(String placeRange) {
        if (isNoInteger(placeRange)) return false;
        int number = Integer.parseInt(placeRange);
        return Integer.parseInt(placeRange) >= PlaceRange.getMinPlaceRange() && number <= PlaceRange.getMaxPlaceRange();
    }
}
