package helloworld;

import java.lang.reflect.Field;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class HelloWorld {

    public static void main(String[] args) {
        
        // fix from http://forum.lwjgl.org/index.php?topic=5322.0
        System.setProperty("java.library.path", "natives");
        try {
            final Field sysPathsField = ClassLoader.class.getDeclaredField("sys_paths");
            sysPathsField.setAccessible(true);
            try {
                sysPathsField.set(null, null);
            } catch (IllegalAccessException e) {

            }
        } catch (NoSuchFieldException e) {

        }

        int targetWidth = 640;
        int targetHeight = 480;

        try {
            DisplayMode chosenMode = new DisplayMode(targetWidth, targetHeight);

            Display.setDisplayMode(chosenMode);
            Display.setTitle("Example Maven Natives");
            Display.setFullscreen(false);
            Display.create();
        } catch (LWJGLException e) {
            Sys.alert("Error", "Unable to create display.");
            System.exit(0);
        }

        GL11.glClearColor(0, 0, 0, 0);

        boolean gameRunning = true;
        float pos = 0;

        int FRAMERATE = 60;

        while (gameRunning) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_STENCIL_BUFFER_BIT);

            GL11.glRotatef(0.6f, 0, 0, 1);
            GL11.glBegin(GL11.GL_TRIANGLES);
            GL11.glVertex3f(-0.5f, -0.5f, 0);
            GL11.glVertex3f(0.5f, -0.5f, 0);
            GL11.glVertex3f(0, 0.5f, 0);

            GL11.glEnd();

            Display.update();
            Display.sync(FRAMERATE);

            if (Display.isCloseRequested()) {
                gameRunning = false;
                Display.destroy();
                System.exit(0);
            }
        }
    }
}
