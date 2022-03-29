package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class EndGameScreen implements Screen {
    final MyGdxGame game;
    OrthographicCamera camera;
    Texture background;
    int sarsCollected;
    EndGameScreen(final MyGdxGame fallout, int sarsCollected){
        game = fallout;
        this.sarsCollected = sarsCollected;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        if (this.sarsCollected >= 50){
            background = new Texture("pictures/goodEnd.png");
            game.batch.draw(background, 0, 0);
            game.font.draw(game.batch, "And so the Courier, who had cheated death in the cemetery outside Goodsprings,", 350, 150);
            game.font.draw(game.batch, "cheated death once again, and the Mojave Wasteland was forever changed.", 350, 100);
        } else {
            background = new Texture("pictures/badEnd.png");
            game.batch.draw(background, 0, 0);
            game.font.draw(game.batch, "It must seem like an 18-carat run of bad luck.", 350, 150);
            game.font.draw(game.batch, "Truth is the game was rigged from the start.", 350, 100);
        }
        game.batch.end();
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
    }
    @Override
    public void show(){}
    @Override
    public void resize(int width, int height){}
    @Override
    public void pause(){}
    @Override
    public void resume(){}
    @Override
    public void hide(){}
    @Override
    public void dispose(){}
}