package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {
    final MyGdxGame game;
    OrthographicCamera camera;
    Texture background;

    public MainMenuScreen(final MyGdxGame fallout) {
        game = fallout;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        background = new Texture("pictures/mojave.png");
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0,0 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.font.draw(game.batch, "Welcome back, Courier.", 350,  300);
        game.font.draw(game.batch, "Try to catch all the bottles.", 350, 250);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }
    @Override
    public void resize(int width, int height){}
    @Override
    public void show(){}
    @Override
    public void hide(){}
    @Override
    public void pause(){}
    @Override
    public void resume(){}
    @Override
    public void dispose(){}
}
