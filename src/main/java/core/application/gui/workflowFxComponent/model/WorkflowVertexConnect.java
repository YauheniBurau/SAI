package core.application.gui.workflowFxComponent.model;

public class WorkflowVertexConnect {
    public static final String SHAPE_SVG_PATH_SQUARE = "'M 0 1 L 8 1 L 8 5 L 0 5 L 0 1'";
    public static final String SHAPE_SVG_PATH_TRIANGLE_LEFT = "'M 0 3 L 4 1 L 4 5 L 0 3'";
    public static final String SHAPE_SVG_PATH_TRIANGLE_RIGHT = "'M 4 1 L 8 3 L 4 5 L 4 1'";
    public static final String SHAPE_SVG_PATH_TRIANGLE_UP = "'M 0 5 L 2 1 L 4 5 L 0 5'";
    public static final String SHAPE_SVG_PATH_TRIANGLE_DOWN = "'M 0 1 L 4 1 L 2 5 L 0 1'";
    public static final String SHAPE_SVG_PATH_OVAL = "'M 4 1 Q 6 1 6 3 Q 6 5 4 5 Q 2 5 2 3 Q 2 1 4 1'";
    public static final String SHAPE_SVG_PATH_ROMB = "'M 4 1 L 8 3 L 4 5 L 0 3 L 4 1'";

    public static final int PLACE_LEFT_VERTICAL = 1;
    public static final int PLACE_RIGHT_VERTICAL = 2;
    public static final int PLACE_TOP_HORIZONTAL = 3;
    public static final int PLACE_BOTTOM_HORIZONTAL = 4;

    public static final int PLACE_TOP_CENTER = 5;
    public static final int PLACE_BOTTOM_CENTER = 6;
    public static final int PLACE_LEFT_CENTER = 7;
    public static final int PLACE_RIGHT_CENTER = 8;

    public static final int PLACE_CIRCLE = 9;

    private String shape_svg_path;
    private String fx_background_color;
    private String size;
    private String label;
    private String shape;
    private int place;
    private double value;


}
