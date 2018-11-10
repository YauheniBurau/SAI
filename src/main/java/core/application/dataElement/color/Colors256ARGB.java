package core.application.dataElement.color;

import core.application.helper.ArgbToIntegerArgb;
import javafx.scene.paint.Color;

import java.util.HashMap;

import static javafx.scene.paint.Color.*;

/**
 * Created by anonymous on 10.11.2018.
 */
public class Colors256ARGB {
    private HashMap<String, Color> mapColors;
    private Color[] listColors;

    public Colors256ARGB(){
        this.mapColors = this.createNamedColors();
    }

    private HashMap<String, Color> createNamedColors() {
        this.mapColors = new HashMap<String,Color>(256);
        mapColors.put("aliceblue",            ALICEBLUE);
        mapColors.put("antiquewhite",         ANTIQUEWHITE);
        mapColors.put("aqua",                 AQUA);
        mapColors.put("aquamarine",           AQUAMARINE);
        mapColors.put("azure",                AZURE);
        mapColors.put("beige",                BEIGE);
        mapColors.put("bisque",               BISQUE);
        mapColors.put("black",                BLACK);
        mapColors.put("blanchedalmond",       BLANCHEDALMOND);
        mapColors.put("blue",                 BLUE);
        mapColors.put("blueviolet",           BLUEVIOLET);
        mapColors.put("brown",                BROWN);
        mapColors.put("burlywood",            BURLYWOOD);
        mapColors.put("cadetblue",            CADETBLUE);
        mapColors.put("chartreuse",           CHARTREUSE);
        mapColors.put("chocolate",            CHOCOLATE);
        mapColors.put("coral",                CORAL);
        mapColors.put("cornflowerblue",       CORNFLOWERBLUE);
        mapColors.put("cornsilk",             CORNSILK);
        mapColors.put("crimson",              CRIMSON);
        mapColors.put("cyan",                 CYAN);
        mapColors.put("darkblue",             DARKBLUE);
        mapColors.put("darkcyan",             DARKCYAN);
        mapColors.put("darkgoldenrod",        DARKGOLDENROD);
        mapColors.put("darkgray",             DARKGRAY);
        mapColors.put("darkgreen",            DARKGREEN);
        mapColors.put("darkgrey",             DARKGREY);
        mapColors.put("darkkhaki",            DARKKHAKI);
        mapColors.put("darkmagenta",          DARKMAGENTA);
        mapColors.put("darkolivegreen",       DARKOLIVEGREEN);
        mapColors.put("darkorange",           DARKORANGE);
        mapColors.put("darkorchid",           DARKORCHID);
        mapColors.put("darkred",              DARKRED);
        mapColors.put("darksalmon",           DARKSALMON);
        mapColors.put("darkseagreen",         DARKSEAGREEN);
        mapColors.put("darkslateblue",        DARKSLATEBLUE);
        mapColors.put("darkslategray",        DARKSLATEGRAY);
        mapColors.put("darkslategrey",        DARKSLATEGREY);
        mapColors.put("darkturquoise",        DARKTURQUOISE);
        mapColors.put("darkviolet",           DARKVIOLET);
        mapColors.put("deeppink",             DEEPPINK);
        mapColors.put("deepskyblue",          DEEPSKYBLUE);
        mapColors.put("dimgray",              DIMGRAY);
        mapColors.put("dimgrey",              DIMGREY);
        mapColors.put("dodgerblue",           DODGERBLUE);
        mapColors.put("firebrick",            FIREBRICK);
        mapColors.put("floralwhite",          FLORALWHITE);
        mapColors.put("forestgreen",          FORESTGREEN);
        mapColors.put("fuchsia",              FUCHSIA);
        mapColors.put("gainsboro",            GAINSBORO);
        mapColors.put("ghostwhite",           GHOSTWHITE);
        mapColors.put("gold",                 GOLD);
        mapColors.put("goldenrod",            GOLDENROD);
        mapColors.put("gray",                 GRAY);
        mapColors.put("green",                GREEN);
        mapColors.put("greenyellow",          GREENYELLOW);
        mapColors.put("grey",                 GREY);
        mapColors.put("honeydew",             HONEYDEW);
        mapColors.put("hotpink",              HOTPINK);
        mapColors.put("indianred",            INDIANRED);
        mapColors.put("indigo",               INDIGO);
        mapColors.put("ivory",                IVORY);
        mapColors.put("khaki",                KHAKI);
        mapColors.put("lavender",             LAVENDER);
        mapColors.put("lavenderblush",        LAVENDERBLUSH);
        mapColors.put("lawngreen",            LAWNGREEN);
        mapColors.put("lemonchiffon",         LEMONCHIFFON);
        mapColors.put("lightblue",            LIGHTBLUE);
        mapColors.put("lightcoral",           LIGHTCORAL);
        mapColors.put("lightcyan",            LIGHTCYAN);
        mapColors.put("lightgoldenrodyellow", LIGHTGOLDENRODYELLOW);
        mapColors.put("lightgray",            LIGHTGRAY);
        mapColors.put("lightgreen",           LIGHTGREEN);
        mapColors.put("lightgrey",            LIGHTGREY);
        mapColors.put("lightpink",            LIGHTPINK);
        mapColors.put("lightsalmon",          LIGHTSALMON);
        mapColors.put("lightseagreen",        LIGHTSEAGREEN);
        mapColors.put("lightskyblue",         LIGHTSKYBLUE);
        mapColors.put("lightslategray",       LIGHTSLATEGRAY);
        mapColors.put("lightslategrey",       LIGHTSLATEGREY);
        mapColors.put("lightsteelblue",       LIGHTSTEELBLUE);
        mapColors.put("lightyellow",          LIGHTYELLOW);
        mapColors.put("lime",                 LIME);
        mapColors.put("limegreen",            LIMEGREEN);
        mapColors.put("linen",                LINEN);
        mapColors.put("magenta",              MAGENTA);
        mapColors.put("maroon",               MAROON);
        mapColors.put("mediumaquamarine",     MEDIUMAQUAMARINE);
        mapColors.put("mediumblue",           MEDIUMBLUE);
        mapColors.put("mediumorchid",         MEDIUMORCHID);
        mapColors.put("mediumpurple",         MEDIUMPURPLE);
        mapColors.put("mediumseagreen",       MEDIUMSEAGREEN);
        mapColors.put("mediumslateblue",      MEDIUMSLATEBLUE);
        mapColors.put("mediumspringgreen",    MEDIUMSPRINGGREEN);
        mapColors.put("mediumturquoise",      MEDIUMTURQUOISE);
        mapColors.put("mediumvioletred",      MEDIUMVIOLETRED);
        mapColors.put("midnightblue",         MIDNIGHTBLUE);
        mapColors.put("mintcream",            MINTCREAM);
        mapColors.put("mistyrose",            MISTYROSE);
        mapColors.put("moccasin",             MOCCASIN);
        mapColors.put("navajowhite",          NAVAJOWHITE);
        mapColors.put("navy",                 NAVY);
        mapColors.put("oldlace",              OLDLACE);
        mapColors.put("olive",                OLIVE);
        mapColors.put("olivedrab",            OLIVEDRAB);
        mapColors.put("orange",               ORANGE);
        mapColors.put("orangered",            ORANGERED);
        mapColors.put("orchid",               ORCHID);
        mapColors.put("palegoldenrod",        PALEGOLDENROD);
        mapColors.put("palegreen",            PALEGREEN);
        mapColors.put("paleturquoise",        PALETURQUOISE);
        mapColors.put("palevioletred",        PALEVIOLETRED);
        mapColors.put("papayawhip",           PAPAYAWHIP);
        mapColors.put("peachpuff",            PEACHPUFF);
        mapColors.put("peru",                 PERU);
        mapColors.put("pink",                 PINK);
        mapColors.put("plum",                 PLUM);
        mapColors.put("powderblue",           POWDERBLUE);
        mapColors.put("purple",               PURPLE);
        mapColors.put("red",                  RED);
        mapColors.put("rosybrown",            ROSYBROWN);
        mapColors.put("royalblue",            ROYALBLUE);
        mapColors.put("saddlebrown",          SADDLEBROWN);
        mapColors.put("salmon",               SALMON);
        mapColors.put("sandybrown",           SANDYBROWN);
        mapColors.put("seagreen",             SEAGREEN);
        mapColors.put("seashell",             SEASHELL);
        mapColors.put("sienna",               SIENNA);
        mapColors.put("silver",               SILVER);
        mapColors.put("skyblue",              SKYBLUE);
        mapColors.put("slateblue",            SLATEBLUE);
        mapColors.put("slategray",            SLATEGRAY);
        mapColors.put("slategrey",            SLATEGREY);
        mapColors.put("snow",                 SNOW);
        mapColors.put("springgreen",          SPRINGGREEN);
        mapColors.put("steelblue",            STEELBLUE);
        mapColors.put("tan",                  TAN);
        mapColors.put("teal",                 TEAL);
        mapColors.put("thistle",              THISTLE);
        mapColors.put("tomato",               TOMATO);
        mapColors.put("transparent",          TRANSPARENT);
        mapColors.put("turquoise",            TURQUOISE);
        mapColors.put("violet",               VIOLET);
        mapColors.put("wheat",                WHEAT);
        mapColors.put("white",                WHITE);
        mapColors.put("whitesmoke",           WHITESMOKE);
        mapColors.put("yellow",               YELLOW);
        mapColors.put("yellowgreen",          YELLOWGREEN);
        this.listColors = this.mapColors.values().toArray(new Color[256]);
        return mapColors;
    }

    public Color getColor(int index) {
        return this.listColors[index];
    }

    public int getArgbInteger(int index) {
        Color clr = this.listColors[index/2];
        ARGB argb = new ARGB(0xff, (int)clr.getRed()*255, (int)clr.getGreen()*255, (int)clr.getBlue()*255);
        return ArgbToIntegerArgb.transform(argb);
    }

}
