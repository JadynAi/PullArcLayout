package demo.jadyn.cm.pullarclayout;

import android.graphics.Path;

class PathProvider {

    static Path getClipPath(int width, int height, int orignalHeight) {

        Path path = new Path();

        path.moveTo(0, orignalHeight);
        path.cubicTo(0, orignalHeight, width / 2, orignalHeight + 2.2f * (height - orignalHeight), width, orignalHeight);
        path.lineTo(width, height);
        path.lineTo(0, height);
        path.close();

        return path;
    }

}
