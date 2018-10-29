package core.old;

/**
 * Created by anonymous on 28.10.2018.
 */
public class MVQ2 {

    private int[] palette = new int[256];
    private Group[] map = new Group[4096];
    private int min_size = 0x7fffffff;
    private int colors = 0;

    public MVQ2() {
        for (int i = 0; i < map.length; i++) {
            map[i] = new Group();
        }
    }

    public int[] to_256_color_paletted_image(int[] image) {
        for (int i = 0; i < map.length; i++) {
            map[i].clear();
        }
        group(image);
        do {
            prune(min_size);
        } while (colors > 256);
        create_palette();
        index(image);
        return palette;
    }

    private void create_palette() {
        int idx = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i].n != 0) {
                palette[idx++] = map[i].avg();
            }
        }
    }

    private void index(int[] image) {
        for (int i = 0; i < image.length; i++) {
            image[i] = nearest_entry(palette, image[i]);
        }
    }

    private void group(int[] image) {
        for (int i = 0; i < image.length; i++) {
            map[downsample444(image[i])].add(image[i]);
        }
    }

    private void prune(int min) {
        boolean stop_pruning = false;
        min_size = 0x7fffffff;
        int c = colors;
        colors = 0;
        for (int i = 0; i < map.length; i++) {
            int size = map[i].n;
            if (size != 0) {
                if (size < min_size) {
                    min_size = size;
                }
                if (size <= min) {
                    if (!stop_pruning) {
                        if (i > 0) {
                            map[i - 1].add(map[i]);
                        }
                        c--;
                        map[i].clear();
                    }
                    if (c < 256) {
                        stop_pruning = true;
                    }
                }
                colors++;
            }
        }
    }

    private int downsample444(int c) {
        return (((c >> 20 & 0xf) << 8) | ((c >> 12 & 0xf) << 4) | ((c >> 4 & 0xf))) & 0xfff;
    }

    public int nearest_entry(int[] pal, int c) {
        int index = 0;
        float min = dist(c, pal[0]);
        for (int i = 1; i < pal.length; i++) {
            float d = dist(c, pal[i]);
            if (d < min) {
                min = d;
                index = i;
            }
        }
        return index;
    }

    private float dist(int a, int b) {
        float rbar = ((a >> 16 & 0xff) + (b >> 16 & 0xff)) / 2.0f;
        int dr = (a >> 16 & 0xff) - (b >> 16 & 0xff);
        int dg = (a >> 8 & 0xff) - (b >> 8 & 0xff);
        int db = (a & 0xff) - (b & 0xff);
        return (2.0f + rbar / 256.0f) * (dr * dr) + ((dg * dg) << 2) + (2.0f + (255.0f - rbar) / 256.0f) * (db * db);
    }

    private class Group {
        private int r, g, b, n;

        void add(int c) {
            r += c >> 16 & 0xff;
            g += c >> 8 & 0xff;
            b += c & 0xff;
            n++;
        }

        void add(Group o) {
            r += o.r;
            g += o.g;
            b += o.b;
            n += o.n;
        }

        int avg() {
            if (n == 0) {
                return 0;
            }
            int hn = n >> 1;
            return ((((r + hn) / n) & 0xff) << 16 | (((g + hn) / n) & 0xff) << 8 | (((b + hn) / n) & 0xff)) & 0xffffff;
        }

        void clear() {
            r = g = b = n = 0;
        }
    }

}