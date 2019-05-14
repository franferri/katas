package coup.actions;

import coup.Action;
import coup.Game;

public class Coup7 extends Action {

    // Action: Pay 7 cons, choose the player to lose Influence
    // Action cannot be challenged

    // Block: Cannot be blocked
    // -

    // Setup
    public boolean canThisActionBeChallenged() {
        return false;
    }
    public boolean canThisBlockActionBeChallenged() {
        return false;
    }

    // Action
    public void doActionInternal(Game game) throws Exception {
        returnCoinsToTreasury(game, 7);
        game.assassinatePlayer();
    }

    // Block Action
    public void doBlockAction(Game game) throws Exception {
        throw new Exception("This action can't be blocked");
    }

    public void doBlockActionInternal(Game game) throws Exception {
        //
    }

}
