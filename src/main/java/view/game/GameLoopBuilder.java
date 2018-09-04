package main.java.view.game;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameLoopBuilder {

    private GameLoopCapsule capsule = new GameLoopCapsule();

    public GameLoopBuilder havingGameBoard(Pane gameBoard) {
        capsule.gameBoard = gameBoard;
        capsule.gameBoardSet = true;
        return this;
    }

    public GameLoopBuilder havingRestartButton(Button restartButton) {
        capsule.restartButton = restartButton;
        capsule.restartButtonSet = true;
        return this;
    }

    public GameLoopBuilder havingStartButton(Button startButton) {
        capsule.startButton = startButton;
        capsule.startButtonSet = true;
        return this;
    }

    public GameLoopBuilder havingScore(Label score) {
        capsule.score = score;
        capsule.scoreSet = true;
        return this;
    }

    public GameLoopBuilder havingHiScore(Label hiScore) {
        capsule.hiScore = hiScore;
        capsule.hiScoreSet = true;
        return this;
    }

    public GameLoopBuilder havingNameField(TextField nameField) {
        capsule.nameField = nameField;
        capsule.nameFieldSet = true;
        return this;
    }

    private boolean canBuild() {
        boolean canBuild = false;
        if(capsule.allSet()) {
            canBuild = true;
        }
        return canBuild;
    }

    public GameLoopCapsule build() {
        if (canBuild()) {
            return capsule;
        }
        else {
            throw new IllegalArgumentException("Cannot build capsule for GameLoopCapsule! missing values!");
        }
    }


    public class GameLoopCapsule {

        public Pane gameBoard;
        public boolean gameBoardSet;
        public Button restartButton;
        public boolean restartButtonSet;
        public Button startButton;
        public boolean startButtonSet;
        public Label score;
        public boolean scoreSet;
        public TextField nameField;
        public boolean nameFieldSet;
        public Label hiScore;
        public boolean hiScoreSet;
        public Set<Boolean> values;

        /**
         * Checks whether all fields are set - notice that id isn't considered
         * here, there is high chance that at the time of creation ID won't be known
         * it should be added when item is added to the list!
         * @return boolean isSet
         */
        public boolean allSet() {
            boolean isAllSet = false;
            this.values = new HashSet<Boolean>(Arrays.asList(gameBoardSet,
                    restartButtonSet, startButtonSet, scoreSet, nameFieldSet,
                    hiScoreSet));
            if(!this.values.contains(false)){
                isAllSet = true;
            }
            return isAllSet;
        }
        private GameLoopCapsule() { /*intentionally left empty*/ }
    }
}
