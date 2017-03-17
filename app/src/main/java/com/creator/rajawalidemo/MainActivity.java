package com.creator.rajawalidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import org.rajawali3d.cameras.Camera;
import org.rajawali3d.renderer.Renderer;
import org.rajawali3d.view.ISurface;
import org.rajawali3d.view.SurfaceView;

import java.lang.reflect.Field;

public class MainActivity extends Activity {

    private FrameLayout         mLayout;
    private SurfaceView         mRajawaliSurface;
    private Renderer            mRenderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRajawaliSurface = createSurfaceView();
        mRenderer = createRenderer();
        applyRenderer();

        mLayout = new FrameLayout(this);
        FrameLayout.LayoutParams childParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mLayout.addView(mRajawaliSurface, childParams);
        setContentView(mLayout);
    }

    protected SurfaceView createSurfaceView() {
        SurfaceView view = new SurfaceView(this);
        view.setFrameRate(60);
        view.setRenderMode(ISurface.RENDERMODE_WHEN_DIRTY);
        return view;
    }

    protected Renderer createRenderer() {
        return new EarthRenderer(this);
    }

    protected void applyRenderer() {
        mRajawaliSurface.setSurfaceRenderer(mRenderer);
    }

//    private void testReflection() {
//        Camera camera = mRenderer.getCurrentCamera();
//        try {
//            Class<?> clazz = Class.forName("org.rajawali3d.cameras.Camera");
//            Field[] f = clazz.getDeclaredFields();
//            for(Field field : f){
//                field.setAccessible(true);
//                field.get()
//                System.out.println(field.getName()+":"+field.get(obj.newInstance()));
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
